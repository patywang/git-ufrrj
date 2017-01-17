package transacoes.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;

public class RecuperarComodosRT {

	public List<Comodo> recuperarComodos(String[] comodos) throws SQLException{
    	
    	List<Comodo> listaComodos = new ArrayList<Comodo>();
    	ComodoMapper comodoMapper = new ComodoMapper();
    	for (int i = 0; i < comodos.length; i++){
    		int idComodo = Integer.parseInt(comodos[i]);
    		listaComodos.add(comodoMapper.recuperarComodoPorId(idComodo));
    	}
    	return listaComodos;
    }
}
