package dominio.e.layers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Sala;
import enums.TipoComodo;


@WebServlet("/CriarSala")
public class CriarSalaSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private SalaDM dm;
	
    public CriarSalaSL() {
       dm = new SalaDM();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String path = new String();
		Sala sala = new Sala();
		sala.setDescricao(desc);
		sala.setTipoComodo(TipoComodo.SALA.toString());
		
		try{
			dm.criarSala(sala);
			path = "/ListarSala";
		}catch(Exception e){
			e.printStackTrace();
			path = "/formInserirSala.jsp";
		}finally{
			rd = getServletContext().getRequestDispatcher(path);
		    rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
