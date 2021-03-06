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


@WebServlet("/EditarSala")
public class EditarSalaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ComodoTB tb;
	
    public EditarSalaSL() {
        tb = new ComodoTB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	path = "/formEditarSala.jsp";
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = new String();
		RequestDispatcher rd = null;
		
		String descNova = request.getParameter("novaDescricao").toLowerCase().trim();
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			tb.editarComodo(id, descNova,"SALA",null);
			path = "/ListarSala";
		} catch (SQLException e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp"; 
		} catch (ExceptionEditarOuDeletarComodo e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp";
		} catch (ExceptionCampoVazio e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
	}

}
