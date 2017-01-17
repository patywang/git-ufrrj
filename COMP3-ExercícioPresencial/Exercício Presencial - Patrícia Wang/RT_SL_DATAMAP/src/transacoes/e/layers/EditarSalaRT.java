package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Sala;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarSalaRT {

	public void editarSala(int id, String descNova) throws IOException, SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio {
	    	
		if(descNova != null && !descNova.isEmpty()){
			
			Sala sala = new Sala();
			sala.setId(id);
			sala.setDescricao(descNova);
			
			ComodoMapper comodoMapper = new ComodoMapper();
	    	
	    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(sala.getIdComodo());
	    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(sala.getIdComodo());
	    	
	    	if(naoComposto && naoMobilia){
	    		comodoMapper.editarComodo(sala);
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
		}else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	 }
	
}
