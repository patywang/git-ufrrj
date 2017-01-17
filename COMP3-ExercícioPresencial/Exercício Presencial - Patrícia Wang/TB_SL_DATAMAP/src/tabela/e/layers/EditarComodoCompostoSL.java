package tabela.e.layers;

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
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;


@WebServlet("/EditarComodoComposto")
public class EditarComodoCompostoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ComodoTB tbComposto;

	
	public EditarComodoCompostoSL() {
    
		tbComposto = new ComodoTB();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	path = "/formEditarComodoComposto.jsp";
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
		
		String descNova = request.getParameter("novaDescricao").toLowerCase().trim();
		int id = Integer.parseInt(request.getParameter("id"));
		String[] comodos = request.getParameterValues("comodoSelect");
		List<Comodo> comodosList = null;
		
		try {
			
			if(comodos != null){
				
				comodosList = ComodoTB.recuperarComodos(comodos);
				tbComposto.editarComodo(id,descNova,TipoComodo.COMODO_COMPOSTO.toString(),comodosList);
				path = "/ListarComodoComposto";
				
			}else{
				
				path = "/formPrincipal.jsp";
			}
			
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		} catch (ExceptionEditarOuDeletarComodo e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		} catch (ExceptionCampoVazio e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		} finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
	}

}
