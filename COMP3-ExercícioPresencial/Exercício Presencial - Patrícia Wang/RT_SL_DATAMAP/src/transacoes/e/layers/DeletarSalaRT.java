package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarSalaRT {

	public void deletarSala(int id) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
	    	
		Sala sala = new Sala();
		sala.setIdComodo(id);
		
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
