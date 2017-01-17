package tabela.e.layers;

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
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;


@WebServlet("/CriarComodoComposto")
public class CriarComodoCompostoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ComodoTB tbComposto;
   
    public CriarComodoCompostoSL() {
      
    	tbComposto = new ComodoTB();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = null;
		String path = new String();
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String[] comodosFilhos = request.getParameterValues("comodoSelect");
		List<Comodo>comodos = new ArrayList<Comodo>();

		try {
			
			if(comodosFilhos != null){
				
				comodos = ComodoTB.recuperarComodos(comodosFilhos);

				tbComposto.criarComodo(desc, TipoComodo.COMODO_COMPOSTO.toString(), comodos);
				
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
