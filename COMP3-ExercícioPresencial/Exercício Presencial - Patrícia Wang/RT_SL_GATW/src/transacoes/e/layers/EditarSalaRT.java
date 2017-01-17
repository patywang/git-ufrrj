package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Sala;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarSalaRT {

	public void editarSala(int id, String descNova) throws IOException, SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio {
	    	
		if(descNova != null && !descNova.isEmpty()){
			
			Sala sala = new Sala();
			sala.setId(id);
			sala.setDescricao(descNova);
			
	    	ComodoDAO daoComodo = new ComodoDAO();
	    	
	    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(sala.getIdComodo());
	    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(sala.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		daoComodo.editarComodo(sala);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	 }
	
}
