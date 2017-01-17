package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class CozinhaDM {

	public void criarCozinha(Cozinha coz) throws SQLException {
    	
		if(coz != null && !coz.getDescricao().isEmpty()){
			
			ComodoDAO daoComodo = new ComodoDAO();
			daoComodo.inserirComodo(coz);
			
		}
	}
	
	public void editarCozinha(Cozinha cozinha) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.editarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
	
	public List<Comodo> listarCozinha(String tipo) throws SQLException{
		  
	    ComodoDAO daoComodo = new ComodoDAO();
    	List<Comodo> listaComodoCozinha = daoComodo.listarComodo(tipo);
    	return listaComodoCozinha;
	}
	
	 void deletarCozinha(Cozinha cozinha) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
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
