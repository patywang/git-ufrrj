package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class ComodoCompostoDM {

	public void inserirComodoComposto(ComodoComposto comodoC) throws SQLException{
    	
    	if(comodoC != null && !comodoC.getDescricao().isEmpty() &&comodoC.getComodos() != null){
    		int idTodo = 0;
			ComodoComposto ActvRecComposto = new ComodoComposto();
			Comodo.inserirComodo(comodoC);
			idTodo = Comodo.recuperaPai();
			for(int i = 0; i < comodoC.getComodos().size(); i++){
				int idComodo = comodoC.getComodos().get(i).getIdComodo();
				ActvRecComposto.associarComodoParaComodoComposto(idComodo,idTodo);
			}
    	}
    }
	
	public void editarComodoComposto(ComodoComposto composto) throws SQLException, ExceptionEditarOuDeletarComodo{
    	
		ComodoComposto ActvRecComposto = new ComodoComposto();
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(composto.getIdComodo());
    	
    	if( naoMobilia){
    		Comodo.editarComodo(composto);
    		ActvRecComposto.deletarComodoComposto(composto.getIdComodo());
    		int tam = composto.getComodos().size();
    		for(int j = 0; j < tam; j ++){
    			int idComodo = composto.getComodos().get(j).getIdComodo();
    			ActvRecComposto.associarComodoParaComodoComposto(idComodo, composto.getIdComodo());												
    		}
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UMA MOBÍLIA");
    	}
    }
	
	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
	    	
	    	List<Comodo>listaComodoComposto = Comodo.listarComodo(tipo);
	    	return listaComodoComposto;
	  }
	 
	 public List<Comodo> recuperarComodos(String[] comodos) throws SQLException{
	    	
	    	List<Comodo> listaComodos = new ArrayList<Comodo>();

	    	for (int i = 0; i < comodos.length; i++){
	    		int idComodo = Integer.parseInt(comodos[i]);
	    		listaComodos.add(Comodo.recuperarComodoPorId(idComodo));
	    	}
	    	return listaComodos;
	  }
}
