package tabela.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ambiente;

/**
 * Servlet implementation class CriarAmbienteSL
 */
@WebServlet("/CriarAmbiente")
public class CriarAmbienteSL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AmbienteTB tb;
	
    public CriarAmbienteSL() {
        tb = new AmbienteTB();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String path = new String();
		
		int numParedes = Integer.parseInt(request.getParameter("parede"));
		int numPortas = Integer.parseInt(request.getParameter("porta"));
		float metragem = Float.valueOf(request.getParameter("metragem"));
		String[] mobilias = request.getParameterValues("mobiliaSelect");
		String[] quant = request.getParameterValues("categoria");

		Map<Integer, Integer> mapAmbiente = AmbienteTB.retornaMapAmbiente(mobilias, quant);

		Ambiente ambiente = new Ambiente();
		ambiente.setNumPortas(numPortas);
		ambiente.setNumParedes(numParedes);
		ambiente.setMetragem(metragem);
		ambiente.setMobilias(mapAmbiente);

		try {
			
			float quantTotalPorAmbiente = tb.criarAmbiente(ambiente); //somatorio de cada mobilia por sua quantidade q esta em item venda
			int idAmbiente = tb.recuperarIdAmbiente();
			float custoAmbiente = ambiente.custo(quantTotalPorAmbiente, ambiente.getNumParedes(), ambiente.getNumPortas(), ambiente.getMetragem());
			int maiorTempoEntrega = tb.maiorTempoDeEntrega(tb.tempoEntrega);	
			int tempoPorAmbiente = ambiente.tempoEntrega(maiorTempoEntrega, ambiente.getNumParedes(), ambiente.getNumPortas());// tempo de entrega por ambiente -> maior dos tempos de entrega das mobilias do ambiente mais o restante da formula
			
			ambiente.setCustoTotal(custoAmbiente);
			ambiente.setTempoTotalPorAmbiente(tempoPorAmbiente);
			ambiente.setIdAmbiente(idAmbiente);
			ambiente.setCustoItemVendaMobiliaAmbiente(quantTotalPorAmbiente);
			
			AmbienteTB.inserirAmbienteLista(ambiente);
			List<Ambiente> listaAmbientes = AmbienteTB.retornaListaAmbiente();
			request.setAttribute("listaAmbiente", listaAmbientes);
			
			path = "/CriarContrato";
		
		} catch (SQLException e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp";
		}

		rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
