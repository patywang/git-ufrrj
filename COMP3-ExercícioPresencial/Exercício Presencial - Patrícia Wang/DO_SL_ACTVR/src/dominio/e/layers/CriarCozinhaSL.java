package dominio.e.layers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cozinha;
import enums.TipoComodo;


@WebServlet("/CriarCozinha")
public class CriarCozinhaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private CozinhaDM dm;
    
    public CriarCozinhaSL() {
        dm = new CozinhaDM(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String path = new String();
		Cozinha coz = new Cozinha();
		coz.setDescricao(desc);
		coz.setTipoComodo(TipoComodo.COZINHA.toString());
		try{
			dm.criarCozinha(coz);
			path = "/ListarCozinha";
		}catch(Exception e){
			e.printStackTrace();
			path = "/formInserirCozinha.jsp";
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
