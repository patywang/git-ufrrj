package transacoes.e.layers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CriarQuarto")
public class CriarQuartoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CriarQuartoRT rt;
    public CriarQuartoSL() {
      rt = new CriarQuartoRT();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String desc = request.getParameter("descricao").toLowerCase().trim();
		String path = new String();
	
		try{
			rt.criarQuarto(desc);
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
