package tabela.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.ExceptionMobilias;


@WebServlet("/DeletarMobilia")
public class DeletarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobiliaTB tb;
    public DeletarMobiliaSL() {
      
    	tb = new MobiliaTB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	try {
			tb.deletarMobilia(id); // deleta em cascata,inclusive o comod associado a ela na tabela de comodo_mobilia
			path = "/ListarMobilia";
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		} catch (ExceptionMobilias e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
			rd.forward(request, response);
		}
    	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
