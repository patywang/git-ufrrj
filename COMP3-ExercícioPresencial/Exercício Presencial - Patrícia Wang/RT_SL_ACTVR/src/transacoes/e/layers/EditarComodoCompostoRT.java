package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class EditarComodoCompostoRT {

	public void editarComodoComposto(int id, String descNova, List<Comodo> comodosLista ) throws SQLException, ExceptionEditarOuDeletarComodo, ExceptionCampoVazio{
    	
		if(descNova!=null && !descNova.isEmpty() && comodosLista != null){
			
			ComodoComposto composto = new ComodoComposto();
			composto.setIdComodo(id);
			composto.setDescricao(descNova);
			composto.setComodos(comodosLista);
			
			ComodoComposto actRecComposto = new ComodoComposto();
	    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(composto.getIdComodo());
	    	
	    	if( naoMobilia){
	    		Comodo.editarComodo(composto);
	    		actRecComposto.deletarComodoComposto(composto.getIdComodo());
	    		int tam = composto.getComodos().size();
	    		for(int j = 0; j < tam; j ++){
	    			int idComodo = composto.getComodos().get(j).getIdComodo();
	    			actRecComposto.associarComodoParaComodoComposto(idComodo, composto.getIdComodo());												
	    		}
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UMA MOBÍLIA");
	    	}
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
    }
}
