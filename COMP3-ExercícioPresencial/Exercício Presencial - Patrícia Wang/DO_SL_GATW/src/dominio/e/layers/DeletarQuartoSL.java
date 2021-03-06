package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;


@WebServlet("/DeletarQuarto")
public class DeletarQuartoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuartoDM dm;
	
    public DeletarQuartoSL() {
      dm = new QuartoDM();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
    	String id = request.getParameter("id");
    	
    	Quarto quarto = new Quarto();
    	quarto.setIdComodo(Integer.parseInt(id));
    	
    	try {
			dm.deletarQuarto(quarto);
			path = "/ListarQuarto";
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
