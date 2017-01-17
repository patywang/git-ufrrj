package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class CozinhaDM {

	public void criarCozinha(Cozinha coz) throws SQLException {
    	
		if(coz != null && !coz.getDescricao().isEmpty()){
			
			Comodo.inserirComodo(coz);
			
		}
	}
	
	public void editarCozinha(Cozinha cozinha) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
    	ComodoComposto actvRecComposto = new ComodoComposto();
    	
    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.editarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
	
	public List<Comodo> listarCozinha(String tipo) throws SQLException{
		  
    	List<Comodo> listaComodoCozinha = Comodo.listarComodo(tipo);
    	return listaComodoCozinha;
	}
	
	 void deletarCozinha(Cozinha cozinha) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		 ComodoComposto actvRecComposto = new ComodoComposto();
    	
    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.deletarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
	
	
	
}
