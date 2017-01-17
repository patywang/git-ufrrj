package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;

public class ListarCozinhaRT {

	  public List<Comodo> listarCozinha(String tipo) throws SQLException{
	  
		    ComodoMapper comodoMapper = new ComodoMapper();
	    	List<Comodo> listaComodoCozinha = comodoMapper.listarComodo(tipo);
	    	return listaComodoCozinha;
	  }
}
