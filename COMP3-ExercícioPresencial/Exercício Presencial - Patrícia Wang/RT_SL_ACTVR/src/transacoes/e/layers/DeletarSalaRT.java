package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarSalaRT {

	public void deletarSala(int id) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
	    	
		Sala sala = new Sala();
		sala.setIdComodo(id);
		
		ComodoComposto actRecComposto = new ComodoComposto();
    	
    	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
}
