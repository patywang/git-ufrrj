package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Comodo;
import entidades.ComodoComposto;
import enums.TipoComodo;


@WebServlet("/CriarComodoComposto")
public class CriarComodoCompostoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ComodoCompostoDM dm;
   
    public CriarComodoCompostoSL() {
      
    	dm = new ComodoCompostoDM();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = null;
		String path = new String();
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String[] comodosFilhos = request.getParameterValues("comodoSelect");
		List<Comodo>comodos = new ArrayList<Comodo>();

		try {
			
			if(comodosFilhos != null){
				
				comodos = dm.recuperarComodos(comodosFilhos);
				ComodoComposto comodoComp = new ComodoComposto();
				comodoComp.setDescricao(desc);
				comodoComp.setTipoComodo(TipoComodo.COMODO_COMPOSTO.toString());
				comodoComp.setComodos(comodos);
				dm.inserirComodoComposto(comodoComp);
				path = "/ListarComodoComposto";
				
			}else{
				path = "/formPrincipal.jsp";
			}
		} catch (SQLException e) {
			path = "/formPrincipal.jsp";
			e.printStackTrace();
		}
	
		rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
