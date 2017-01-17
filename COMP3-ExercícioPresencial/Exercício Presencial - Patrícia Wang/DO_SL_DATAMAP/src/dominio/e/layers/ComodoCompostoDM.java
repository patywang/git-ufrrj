package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;
import entidades.ComodoComposto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class ComodoCompostoDM {

	public void inserirComodoComposto(ComodoComposto comodoC) throws SQLException{
    	
    	if(comodoC != null && !comodoC.getDescricao().isEmpty() &&comodoC.getComodos() != null){
    		int idTodo = 0;
    		ComodoMapper comodoMapper = new ComodoMapper();
    		comodoMapper.inserirComodo(comodoC);
			idTodo = comodoMapper.recuperaPai();
			for(int i = 0; i < comodoC.getComodos().size(); i++){
				int idComodo = comodoC.getComodos().get(i).getIdComodo();
				comodoMapper.associarComodoParaComodoComposto(idComodo,idTodo);
			}
    	}
    }
	
	public void editarComodoComposto(ComodoComposto composto) throws SQLException, ExceptionEditarOuDeletarComodo{
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(composto.getIdComodo());
    	
    	if( naoMobilia){
    		comodoMapper.editarComodo(composto);
    		comodoMapper.deletarComodoComposto(composto.getIdComodo());
    		int tam = composto.getComodos().size();
    		for(int j = 0; j < tam; j ++){
    			int idComodo = composto.getComodos().get(j).getIdComodo();
    			comodoMapper.associarComodoParaComodoComposto(idComodo, composto.getIdComodo());												
    		}
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UMA MOBÍLIA");
    	}
    }
	
	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
		 	ComodoMapper comodoMapper = new ComodoMapper();
	    	List<Comodo>listaComodoComposto = comodoMapper.listarComodo(tipo);
	    	return listaComodoComposto;
	  }
	 
	 public List<Comodo> recuperarComodos(String[] comodos) throws SQLException{
	    	
	    	List<Comodo> listaComodos = new ArrayList<Comodo>();
	    	ComodoMapper comodoMapper = new ComodoMapper();
	    	for (int i = 0; i < comodos.length; i++){
	    		int idComodo = Integer.parseInt(comodos[i]);
	    		listaComodos.add(comodoMapper.recuperarComodoPorId(idComodo));
	    	}
	    	return listaComodos;
	  }
}
