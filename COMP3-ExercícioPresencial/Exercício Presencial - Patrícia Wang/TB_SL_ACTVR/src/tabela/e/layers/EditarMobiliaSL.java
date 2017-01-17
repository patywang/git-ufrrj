package tabela.e.layers;

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
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionMobilias;


@WebServlet("/EditarMobilia")
public class EditarMobiliaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobiliaTB tb;
	
    public EditarMobiliaSL() {
        tb = new MobiliaTB();
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
		int id = Integer.parseInt(request.getParameter("id"));
		float custo = Float.valueOf(request.getParameter("novoCusto"));
		int tempo = Integer.parseInt(request.getParameter("novoTempoEntrega"));
		String[] comodos = request.getParameterValues("comodoSelect");
		List<Comodo> comodosMobilia = null;
		
		try {
			
			if(comodos != null){
				
				comodosMobilia = ComodoTB.recuperarComodos(comodos);
				tb.editarMobilia(descNova,custo,tempo,comodosMobilia,id);
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
		} catch (ExceptionCampoVazio e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
	}

}
