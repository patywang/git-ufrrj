package transacoes.e.layers;

import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Quarto;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarQuartoRT {

	public void editarQuarto(int id, String descNova) throws SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio{
		 
		
		if(descNova != null && !descNova.isEmpty()){
			
			Quarto quarto = new Quarto();
			quarto.setIdComodo(id);
			quarto.setDescricao(descNova);
			
			ComodoComposto actRecComposto = new ComodoComposto();
	    	
	    	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		Comodo.editarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			  throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
    }
}
