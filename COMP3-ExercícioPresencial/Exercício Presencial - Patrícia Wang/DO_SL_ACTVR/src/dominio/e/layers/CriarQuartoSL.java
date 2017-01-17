package dominio.e.layers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Quarto;
import enums.TipoComodo;


@WebServlet("/CriarQuarto")
public class CriarQuartoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuartoDM dm;
    public CriarQuartoSL() {
      dm = new QuartoDM();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String path = new String();
		Quarto quarto = new Quarto();
		quarto.setDescricao(desc);
		quarto.setTipoComodo(TipoComodo.QUARTO.toString());
		
		try{
			dm.criarQuarto(quarto);
			path = "/ListarQuarto";
		}catch(Exception e){
			e.printStackTrace();
			path = "/formInserirQuarto.jsp";
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
