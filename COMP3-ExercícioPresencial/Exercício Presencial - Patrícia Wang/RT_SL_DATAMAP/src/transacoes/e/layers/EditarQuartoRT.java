package transacoes.e.layers;

import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Quarto;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarQuartoRT {

	public void editarQuarto(int id, String descNova) throws SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio{
		 
		
		if(descNova != null && !descNova.isEmpty()){
			
			Quarto quarto = new Quarto();
			quarto.setIdComodo(id);
			quarto.setDescricao(descNova);
			
			ComodoMapper comodoMapper = new ComodoMapper();
	    	
	    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		comodoMapper.editarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			  throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
    }
}
