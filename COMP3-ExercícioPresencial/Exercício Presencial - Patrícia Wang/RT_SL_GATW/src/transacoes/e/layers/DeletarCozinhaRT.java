package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;


import dao.ComodoDAO;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarCozinhaRT {

	protected void deletarCozinha(int id) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		Cozinha cozinha = new Cozinha();
		cozinha.setIdComodo(id);
		
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.deletarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
