package transacoes.e.layers;



import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class DeletarQuartoRT {

	 public void deletarQuarto(int id) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
		 	Quarto quarto = new Quarto();
		 	quarto.setIdComodo(id);
		 
		 	ComodoDAO daoComodo = new ComodoDAO();
	    	
	    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		daoComodo.deletarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
	    }
}
