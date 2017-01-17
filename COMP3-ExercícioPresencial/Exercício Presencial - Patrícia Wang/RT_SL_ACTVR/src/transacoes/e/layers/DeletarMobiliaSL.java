package transacoes.e.layers;

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
       
	private DeletarMobiliaRT rt;
    public DeletarMobiliaSL() {
      
    	rt = new DeletarMobiliaRT();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	try {
			rt.deletarMobilia(id);
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
