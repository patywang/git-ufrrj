package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Sala;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarSalaRT {

	public void editarSala(int id, String descNova) throws IOException, SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio {
	    	
		if(descNova != null && !descNova.isEmpty()){
			
			Sala sala = new Sala();
			sala.setId(id);
			sala.setDescricao(descNova);
			
			ComodoComposto actRecComposto = new ComodoComposto();
	    	
	    	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(sala.getIdComodo());
	    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(sala.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		Comodo.editarComodo(sala);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	 }
	
}
