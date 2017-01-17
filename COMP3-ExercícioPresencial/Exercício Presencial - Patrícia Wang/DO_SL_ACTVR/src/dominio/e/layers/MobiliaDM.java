package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Comodo;
import entidades.ItemVenda;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class MobiliaDM {

	public void inserirMobilia(Mobilia mobilia) throws SQLException{
    	
		int idComodo = 0;
		Mobilia activeRecordMobilia = new Mobilia();
		activeRecordMobilia.inserirMobilia(mobilia);
    	int idMobilia = activeRecordMobilia.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		activeRecordMobilia.associarComodoMobilia(idMobilia,idComodo);
    	}
	
	}
	
	public void editarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
 		
		Mobilia activeRecordMobilia = new Mobilia();
		ItemVenda actvRecItem = new ItemVenda();
    	Boolean naoItemVenda = actvRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		activeRecordMobilia.editarMobilia(mobilia);
    		activeRecordMobilia.deletarMobiliaComodo(mobilia.getIdMobilia());
	    	int tam = mobilia.getComodo().size();
	    	for(int j = 0; j < tam; j ++){
	    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
	    		activeRecordMobilia.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
	    	}
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
	}
	
	public List<Mobilia>listarMobilias() throws SQLException{
    	
		Mobilia activeRecordMobilia = new Mobilia();
    	List<Mobilia>listaMobilia = activeRecordMobilia.listarMobilias();
    	return listaMobilia;
    	
    }
	
	public void deletarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
    	
		Mobilia activeRecordMobilia = new Mobilia();
		ItemVenda actvRecItem = new ItemVenda();
    	Boolean naoItemVenda = actvRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		activeRecordMobilia.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
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
