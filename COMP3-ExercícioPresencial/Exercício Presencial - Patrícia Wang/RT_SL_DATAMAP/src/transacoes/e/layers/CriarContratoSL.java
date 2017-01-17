package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ambiente;
import entidades.Contrato;

/**
 * Servlet implementation class CriarContratoSL
 */
@WebServlet("/CriarContrato")
public class CriarContratoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CriarContratoRT rtContrato;
    private RecuperarListaAmbienteRT rtAmbiente;
    public CriarContratoSL() {
        
        rtContrato = new CriarContratoRT();
        rtAmbiente = new RecuperarListaAmbienteRT();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	
    	List<Ambiente>listaAmbiente = rtAmbiente.retornaListaAmbiente();
    	request.setAttribute("ambientes",listaAmbiente);
    	path = "/formInserirContrato.jsp";
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String path = new String();
		int somaCustoItemVenda=0;
		List<Integer>tempoEntregaAmbiente = new ArrayList<Integer>();
		float comissao = Float.valueOf(request.getParameter("comissao"));
		List<Ambiente>listaAmbiente = rtAmbiente.retornaListaAmbiente();
		
		for(Ambiente a : listaAmbiente){
			
			somaCustoItemVenda += a.getCustoItemVendaMobiliaAmbiente();
			tempoEntregaAmbiente.add(a.getTempoTotalPorAmbiente());
			
		}
		Contrato contrato = new Contrato();
		contrato.setComissao(comissao);
		contrato.setAmbiente(listaAmbiente);
		
		try {
			rtContrato.criarContrato(contrato);
			
			float valorC = contrato.valorContrato(somaCustoItemVenda, comissao);
			int prazoC = contrato.prazo(tempoEntregaAmbiente);
			request.setAttribute("valorC", valorC);
			request.setAttribute("prazoC", prazoC);
			request.setAttribute("listaAmbiente", contrato.getAmbiente());
			
			
			path = "/formContratoFinal.jsp";
			
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}
		//listaAmbiente.clear();
		rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
		
	}

}
