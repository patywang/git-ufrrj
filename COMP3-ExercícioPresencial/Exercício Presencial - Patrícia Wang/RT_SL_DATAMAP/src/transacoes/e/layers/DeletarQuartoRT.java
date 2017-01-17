package transacoes.e.layers;



import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarQuartoRT {

	 public void deletarQuarto(int id) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
		 	Quarto quarto = new Quarto();
		 	quarto.setIdComodo(id);
		 
		 	ComodoMapper comodoMapper = new ComodoMapper();
	    	
	    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		comodoMapper.deletarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
	    }
}
