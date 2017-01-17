package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarSalaRT {

	public void deletarSala(int id) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
	    	
		Sala sala = new Sala();
		sala.setIdComodo(id);
		
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
