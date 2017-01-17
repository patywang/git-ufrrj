package dominio.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;
import entidades.Quarto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class QuartoDM {

	public void criarQuarto(Quarto quarto) throws SQLException{
    	
    	if(quarto != null && !quarto.getDescricao().isEmpty()){
    		
    		ComodoDAO daoComodo = new ComodoDAO();
    		daoComodo.inserirComodo(quarto);
    		
    	}
    }
	
	public void editarQuarto(Quarto quarto) throws SQLException, ExceptionEditarOuDeletarComodo{
		 
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(quarto.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(quarto.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.editarComodo(quarto);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    	
    }
	
	public List<Comodo>listarQuarto(String tipo) throws SQLException{
    	
    	ComodoDAO dao = new ComodoDAO();
    	List<Comodo>listaQuarto = dao.listarComodo(tipo);
    	return listaQuarto;
    }

	 public void deletarQuarto(Quarto quarto) throws ExceptionEditarOuDeletarComodo, SQLException{
	    	
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
