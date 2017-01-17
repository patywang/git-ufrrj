package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;

public class ListarQuartoRT {

	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	List<Comodo>listaQuarto = comodoMapper.listarComodo(tipo);
    	return listaQuarto;
    }
}
