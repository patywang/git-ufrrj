package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarCozinhaRT {

	protected void deletarCozinha(int id) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		Cozinha cozinha = new Cozinha();
		cozinha.setIdComodo(id);
		
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.deletarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
