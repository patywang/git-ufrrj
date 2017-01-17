package transacoes.e.layers;

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
import enums.TipoComodo;


@WebServlet("/ListarComodoComposto")
public class ListarComodoCompostoSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ListarComodoCompostoRT rt;
    public ListarComodoCompostoSL() {
       rt = new ListarComodoCompostoRT();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
    	String path = new String();
    	try {
			List<Comodo>listaComodoCoposto = rt.listarComodoComposto(TipoComodo.COMODO_COMPOSTO.toString());
			request.setAttribute("comodosCompostos",listaComodoCoposto);
	    	path = "/formListarComodoComposto.jsp";
    	} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu ruim ao recuperar a lista de quarto");
			path = "/formPrincipal.jsp";
    	}
    	rd = getServletContext().getRequestDispatcher(path);
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
