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

import entidades.Comodo;
import exceptions.ExceptionCampoVazio;


@WebServlet("/CriarComodoComposto")
public class CriarComodoCompostoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private CriarComodoCompostoRT rtComposto;
	private RecuperarComodosRT rtRecuperar;
   
    public CriarComodoCompostoSL() {
      
    	rtComposto = new CriarComodoCompostoRT();
    	rtRecuperar = new RecuperarComodosRT();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = null;
		String path = new String();
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String[] comodosFilhos = request.getParameterValues("comodoSelect");
		List<Comodo>comodos = new ArrayList<Comodo>();

		try {
			
			if(comodosFilhos != null){
				
				comodos = rtRecuperar.recuperarComodos(comodosFilhos);

				rtComposto.inserirComodoComposto(desc,comodos);
				
				path = "/ListarComodoComposto";
				
			}else{
				path = "/formPrincipal.jsp";
			}
			
		} catch (SQLException | ExceptionCampoVazio e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}
	
		rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
