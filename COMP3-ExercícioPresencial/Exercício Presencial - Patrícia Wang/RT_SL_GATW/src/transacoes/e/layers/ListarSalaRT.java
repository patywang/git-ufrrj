package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;

	public class ListarSalaRT {
		
	public List<Comodo> listarSala(String tipo) throws SQLException{
	    	ComodoDAO dao = new ComodoDAO();
	    	List<Comodo>listaSala  = dao.listarComodo(tipo);
	    	return listaSala;
	 }
}
