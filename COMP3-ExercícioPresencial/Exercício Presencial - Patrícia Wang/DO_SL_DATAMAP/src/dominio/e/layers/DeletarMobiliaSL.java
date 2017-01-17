package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Mobilia;
import exceptions.ExceptionMobilias;


@WebServlet("/DeletarMobilia")
public class DeletarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobiliaDM dm;
    public DeletarMobiliaSL() {
      
    	dm = new MobiliaDM();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
    	String id = request.getParameter("id");
    	
    	Mobilia mob = new Mobilia();
    	mob.setIdMobilia(Integer.parseInt(id));
    	
    	try {
			dm.deletarMobilia(mob);
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
