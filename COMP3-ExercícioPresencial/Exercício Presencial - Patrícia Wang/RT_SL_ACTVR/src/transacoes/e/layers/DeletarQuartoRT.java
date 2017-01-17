package transacoes.e.layers;



import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarQuartoRT {

	 public void deletarQuarto(int id) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
		 	Quarto quarto = new Quarto();
		 	quarto.setIdComodo(id);
		 
		 	ComodoComposto actRecComposto = new ComodoComposto();
	    	
	    	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		Comodo.deletarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
	    }
}
