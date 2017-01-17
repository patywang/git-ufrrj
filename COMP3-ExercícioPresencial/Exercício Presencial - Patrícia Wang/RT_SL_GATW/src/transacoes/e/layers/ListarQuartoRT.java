package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;

public class ListarQuartoRT {

	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
    	ComodoDAO dao = new ComodoDAO();
    	List<Comodo>listaQuarto = dao.listarComodo(tipo);
    	return listaQuarto;
    }
}
