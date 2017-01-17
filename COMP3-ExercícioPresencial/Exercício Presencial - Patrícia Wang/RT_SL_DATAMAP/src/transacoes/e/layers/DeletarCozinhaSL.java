package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.ExceptionEditarOuDeletarComodo;

@WebServlet("/DeletarCozinha")
public class DeletarCozinhaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DeletarCozinhaRT rt;
    public DeletarCozinhaSL() {
        rt = new DeletarCozinhaRT();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = new String();
		RequestDispatcher rd = null;
    	int id = Integer.parseInt(request.getParameter("id"));
    	
		try {
			rt.deletarCozinha(id);
			path = "/ListarCozinha";
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
