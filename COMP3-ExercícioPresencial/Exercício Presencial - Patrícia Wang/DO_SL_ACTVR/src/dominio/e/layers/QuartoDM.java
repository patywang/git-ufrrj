package dominio.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class QuartoDM {

	public void criarQuarto(Quarto quarto) throws SQLException{
    	
    	if(quarto != null && !quarto.getDescricao().isEmpty()){
    		
    		Comodo.inserirComodo(quarto);
    		
    	}
    }
	
	public void editarQuarto(Quarto quarto) throws SQLException, ExceptionEditarOuDeletarComodo{
		 
    
    	ComodoComposto actvRecComposto = new ComodoComposto();
    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(quarto.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(quarto.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.editarComodo(quarto);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    	
    }
	
	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
    	List<Comodo>listaQuarto = Comodo.listarComodo(tipo);
    	return listaQuarto;
    }

	 public void deletarQuarto(Quarto quarto) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
		   	ComodoComposto actvRecComposto = new ComodoComposto();
	    	
	    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		Comodo.deletarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
	    }

}
