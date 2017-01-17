package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;

public class ListarCozinhaRT {

	  public List<Comodo> listarCozinha(String tipo) throws SQLException{
	  
		    ComodoDAO daoComodo = new ComodoDAO();
	    	List<Comodo> listaComodoCozinha = daoComodo.listarComodo(tipo);
	    	return listaComodoCozinha;
	  }
}
