package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;
import entidades.Cozinha;
import exceptions.ExceptionEditarOuDeletarComodo;

public class CozinhaDM {

	public void criarCozinha(Cozinha coz) throws SQLException {
    	
		if(coz != null && !coz.getDescricao().isEmpty()){
			
			ComodoMapper comodoMapper = new ComodoMapper();
			comodoMapper.inserirComodo(coz);
			
		}
	}
	
	public void editarCozinha(Cozinha cozinha) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.editarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
	
	public List<Comodo> listarCozinha(String tipo) throws SQLException{
		  
		ComodoMapper comodoMapper = new ComodoMapper();
    	List<Comodo> listaComodoCozinha = comodoMapper.listarComodo(tipo);
    	return listaComodoCozinha;
	}
	
	 void deletarCozinha(Cozinha cozinha) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		 ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(cozinha.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(cozinha.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.deletarComodo(cozinha);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
	
	
	
}
