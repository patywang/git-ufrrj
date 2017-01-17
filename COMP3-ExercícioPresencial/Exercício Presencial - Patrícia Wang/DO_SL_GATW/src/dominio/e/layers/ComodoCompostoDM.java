package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;
import entidades.ComodoComposto;
import exceptions.ExceptionEditarOuDeletarComodo;

public class ComodoCompostoDM {

	public void inserirComodoComposto(ComodoComposto comodoC) throws SQLException{
    	
    	if(comodoC != null && !comodoC.getDescricao().isEmpty() &&comodoC.getComodos() != null){
    		int idTodo = 0;
			ComodoDAO dao = new ComodoDAO();
			dao.inserirComodo(comodoC);
			idTodo = dao.recuperaPai();
			for(int i = 0; i < comodoC.getComodos().size(); i++){
				int idComodo = comodoC.getComodos().get(i).getIdComodo();
				dao.associarComodoParaComodoComposto(idComodo,idTodo);
			}
    	}
    }
	
	public void editarComodoComposto(ComodoComposto composto) throws SQLException, ExceptionEditarOuDeletarComodo{
    	
    	ComodoDAO daoComodo = new ComodoDAO();
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(composto.getIdComodo());
    	
    	if( naoMobilia){
    		daoComodo.editarComodo(composto);
    		daoComodo.deletarComodoComposto(composto.getIdComodo());
    		int tam = composto.getComodos().size();
    		for(int j = 0; j < tam; j ++){
    			int idComodo = composto.getComodos().get(j).getIdComodo();
    			daoComodo.associarComodoParaComodoComposto(idComodo, composto.getIdComodo());												
    		}
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UMA MOBÍLIA");
    	}
    }
	
	 public List<Comodo>listarComodoComposto(String tipo) throws SQLException{
	    	ComodoDAO dao = new ComodoDAO();
	    	List<Comodo>listaComodoComposto = dao.listarComodo(tipo);
	    	return listaComodoComposto;
	  }
	 
	 public List<Comodo> recuperarComodos(String[] comodos) throws SQLException{
	    	
	    	List<Comodo> listaComodos = new ArrayList<Comodo>();
	    	ComodoDAO dao = new ComodoDAO();
	    	for (int i = 0; i < comodos.length; i++){
	    		int idComodo = Integer.parseInt(comodos[i]);
	    		listaComodos.add(dao.recuperarComodoPorId(idComodo));
	    	}
	    	return listaComodos;
	  }
}
