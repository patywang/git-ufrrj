package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;

public class ListarComodoCompostoRT {

	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
	
	    	List<Comodo>listaComodoComposto = Comodo.listarComodo(tipo);
	    	return listaComodoComposto;
	    }
}
