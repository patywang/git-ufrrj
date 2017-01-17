package dominio.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class QuartoDM {

	public void criarQuarto(Quarto quarto) throws SQLException{
    	
    	if(quarto != null && !quarto.getDescricao().isEmpty()){
    		
    		ComodoMapper comodoMapper = new ComodoMapper();
    		comodoMapper.inserirComodo(quarto);
    		
    	}
    }
	
	public void editarQuarto(Quarto quarto) throws SQLException, ExceptionEditarOuDeletarComodo{
		 
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(quarto.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(quarto.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.editarComodo(quarto);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    	
    }
	
	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	List<Comodo>listaQuarto = comodoMapper.listarComodo(tipo);
    	return listaQuarto;
    }

	 public void deletarQuarto(Quarto quarto) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
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
