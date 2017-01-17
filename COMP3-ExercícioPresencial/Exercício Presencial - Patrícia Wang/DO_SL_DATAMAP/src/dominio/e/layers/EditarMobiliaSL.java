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

import entidades.Comodo;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;


@WebServlet("/EditarMobilia")
public class EditarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobiliaDM dm;

    public EditarMobiliaSL() {
       dm = new MobiliaDM();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	path = "/formEditarMobilia.jsp";
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = new String();
		RequestDispatcher rd = null;
		
		String descNova = request.getParameter("novaDescricao").toLowerCase().trim();
		String id = request.getParameter("id");
		String custo = request.getParameter("novoCusto");
		String tempo = request.getParameter("novoTempoEntrega");
		String[] comodos = request.getParameterValues("comodoSelect");
		List<Comodo> comodosMobilia = null;
		
		try {
			
			if(comodos != null){
				
				comodosMobilia = dm.recuperarComodos(comodos);
				Mobilia mob = new Mobilia();
				mob.setDescricao(descNova);
				mob.setCusto(Float.valueOf(custo));
				mob.setTempoEntrega(Integer.parseInt(tempo));
				mob.setComodo(comodosMobilia);
				mob.setIdMobilia(Integer.parseInt(id));
				
				dm.editarMobilia(mob);
				path = "/ListarMobilia";
				
			}else{
				path = "/formPrincipal.jsp";
			}
			
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

}
