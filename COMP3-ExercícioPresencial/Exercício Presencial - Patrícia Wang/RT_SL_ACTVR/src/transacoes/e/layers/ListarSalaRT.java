package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;

	public class ListarSalaRT {
		
	public List<Comodo> listarSala(String tipo) throws SQLException{
		
	    	List<Comodo>listaSala  = Comodo.listarComodo(tipo);
	    	return listaSala;
	 }
}
