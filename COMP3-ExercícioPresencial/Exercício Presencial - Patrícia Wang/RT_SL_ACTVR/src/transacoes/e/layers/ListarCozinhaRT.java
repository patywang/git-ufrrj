package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;

public class ListarCozinhaRT {

	  public List<Comodo> listarCozinha(String tipo) throws SQLException{

	    	List<Comodo> listaComodoCozinha = Comodo.listarComodo(tipo);
	    	return listaComodoCozinha;
	  }
}
