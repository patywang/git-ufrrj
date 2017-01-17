package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;

public class ListarQuartoRT {

	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
    	List<Comodo>listaQuarto = Comodo.listarComodo(tipo);
    	return listaQuarto;
    }
}
