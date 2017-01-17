package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarCozinhaRT {

	protected void deletarCozinha(int id) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		Cozinha cozinha = new Cozinha();
		cozinha.setIdComodo(id);
		
    	ComodoComposto actRecComposto = new ComodoComposto();
    	
    	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.deletarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
