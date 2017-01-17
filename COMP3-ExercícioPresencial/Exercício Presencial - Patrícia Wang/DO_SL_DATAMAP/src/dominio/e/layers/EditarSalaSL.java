package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;


@WebServlet("/EditarSala")
public class EditarSalaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private SalaDM dm;
	
    public EditarSalaSL() {
        dm = new SalaDM();
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
		String id = request.getParameter("id");

		Sala sala = new Sala();
		sala.setIdComodo(Integer.parseInt(id));
		sala.setDescricao(descNova);
		
		try {
			dm.editarSala(sala);
			path = "/ListarSala";
		} catch (SQLException e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp"; 
		} catch (ExceptionEditarOuDeletarComodo e) {
			e.printStackTrace();
			path = "/formPrincipal.jsp";
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
	}

}
