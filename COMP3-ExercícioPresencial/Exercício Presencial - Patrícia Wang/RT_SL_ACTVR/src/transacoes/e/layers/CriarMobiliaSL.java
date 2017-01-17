package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Comodo;
import exceptions.ExceptionCampoVazio;

@WebServlet("/CriarMobilia")
public class CriarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CriarMobiliaRT rtMobilia;
	private RecuperarComodosRT rtRecuperar;
	
    public CriarMobiliaSL() {
        rtMobilia = new CriarMobiliaRT();
        rtRecuperar = new RecuperarComodosRT();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String path = new String();
		
		String desc = request.getParameter("descricao").toLowerCase().trim();
		float custo = Float.valueOf(request.getParameter("custo"));
		int tempoEntrega = Integer.parseInt(request.getParameter("tempoEntrega"));
		String[] comodos = request.getParameterValues("comodoSelect");
		List<Comodo> comodosMobilia = null;
		
		try {
			
			if(comodos != null){
				
				comodosMobilia = rtRecuperar.recuperarComodos(comodos);
				rtMobilia.inserirMobilia(desc,custo,tempoEntrega,comodosMobilia);
				path = "/ListarMobilia";
				
			}else{
				path = "/formPrincipal.jsp";
			}
			
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		} catch (ExceptionCampoVazio e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}
		
		rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
