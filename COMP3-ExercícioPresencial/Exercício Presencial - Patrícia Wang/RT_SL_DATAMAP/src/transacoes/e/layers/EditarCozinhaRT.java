package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import data.mapper.ComodoMapper;
import entidades.Cozinha;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarCozinhaRT {

	public void editarCozinha(int id, String descNova) throws IOException, SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio {
	    	
		if(descNova != null && !descNova.isEmpty()){
			
			Cozinha cozinha = new Cozinha();
			cozinha.setDescricao(descNova);
			cozinha.setIdComodo(id);
			
			ComodoMapper comodoMapper = new ComodoMapper();
	    	
	    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(cozinha.getIdComodo());
	    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(cozinha.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		comodoMapper.editarComodo(cozinha);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
	    	
	  }else{
		  throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
	  }
	}
	
}
