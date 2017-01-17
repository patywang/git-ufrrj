package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Mobilia;


@WebServlet("/ListarMobilia")
public class ListarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MobiliaDM dm;
	
    public ListarMobiliaSL() {
        dm = new MobiliaDM();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
    	String path = new String();
    	
		try {
			List<Mobilia>listMob = dm.listarMobilias();
			request.setAttribute("mobs", listMob);
	    	path = "/formListarMobilia.jsp";
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}
    	
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
