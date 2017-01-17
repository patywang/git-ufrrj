package transacoes.e.layers;

import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Quarto;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarQuartoRT {

	public void editarQuarto(int id, String descNova) throws SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio{
		 
		
		if(descNova != null && !descNova.isEmpty()){
			
			Quarto quarto = new Quarto();
			quarto.setIdComodo(id);
			quarto.setDescricao(descNova);
			
	    	ComodoDAO daoComodo = new ComodoDAO();
	    	
	    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(quarto.getIdComodo());
	    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(quarto.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		daoComodo.editarComodo(quarto);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			  throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
    }
}
