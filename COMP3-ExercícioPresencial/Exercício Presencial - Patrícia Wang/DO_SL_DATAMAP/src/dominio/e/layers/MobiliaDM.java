package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.mapper.ComodoMapper;
import data.mapper.MobiliaMapper;
import entidades.Comodo;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class MobiliaDM {

	public void inserirMobilia(Mobilia mobilia) throws SQLException{
    	
		int idComodo = 0;
    	MobiliaMapper mapper = new MobiliaMapper();
    	mapper.inserirMobilia(mobilia);
    	int idMobilia = mapper.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		mapper.associarComodoMobilia(idMobilia,idComodo);
    	}
	
	}
	
	public void editarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
 		
		MobiliaMapper mapper = new MobiliaMapper();
    	Boolean naoItemVenda = mapper.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		mapper.editarMobilia(mobilia);
    		mapper.deletarMobiliaComodo(mobilia.getIdMobilia());
	    	int tam = mobilia.getComodo().size();
	    	for(int j = 0; j < tam; j ++){
	    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
	    		mapper.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
	    	}
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
	}
	
	public List<Mobilia>listarMobilias() throws SQLException{
    	
		MobiliaMapper mapper = new MobiliaMapper();
    	List<Mobilia>listaMobilia = mapper.listarMobilias();
    	return listaMobilia;
    	
    }
	
	public void deletarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
    	
		MobiliaMapper mapper = new MobiliaMapper();
    	Boolean naoItemVenda = mapper.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		mapper.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
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
