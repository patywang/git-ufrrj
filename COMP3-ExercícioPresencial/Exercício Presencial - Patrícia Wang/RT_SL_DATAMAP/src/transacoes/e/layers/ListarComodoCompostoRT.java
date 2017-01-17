package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;

public class ListarComodoCompostoRT {

	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
		    ComodoMapper comodoMapper = new ComodoMapper();
	    	List<Comodo>listaComodoComposto = comodoMapper.listarComodo(tipo);
	    	return listaComodoComposto;
	    }
}
