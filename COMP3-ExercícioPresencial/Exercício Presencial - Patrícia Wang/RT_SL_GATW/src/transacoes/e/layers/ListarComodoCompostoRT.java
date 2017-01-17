package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;

public class ListarComodoCompostoRT {

	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
	    	ComodoDAO dao = new ComodoDAO();
	    	List<Comodo>listaComodoComposto = dao.listarComodo(tipo);
	    	return listaComodoComposto;
	    }
}
