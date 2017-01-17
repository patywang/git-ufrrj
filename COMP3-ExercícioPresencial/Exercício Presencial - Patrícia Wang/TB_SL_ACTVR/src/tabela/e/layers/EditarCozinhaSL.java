package tabela.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;


@WebServlet("/EditarCozinha")
public class EditarCozinhaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ComodoTB tb;
 
    public EditarCozinhaSL() {
        tb = new ComodoTB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	path = "/formEditarCozinha.jsp";
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
		
		String descNova = request.getParameter("novaDescricao").toLowerCase().trim();
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			tb.editarComodo(id, descNova,"COZINHA",null);
			path = "/ListarCozinha";
		} catch (SQLException | ExceptionEditarOuDeletarComodo | ExceptionCampoVazio e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp"; 
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
		
	}
	

}
