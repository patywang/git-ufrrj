package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ComodoDAO;
import dao.MobiliaDAO;
import entidades.Comodo;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class MobiliaDM {

	public void inserirMobilia(Mobilia mobilia) throws SQLException{
    	
		int idComodo = 0;
    	MobiliaDAO dao = new MobiliaDAO();
    	dao.inserirMobilia(mobilia);
    	int idMobilia = dao.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		dao.associarComodoMobilia(idMobilia,idComodo);
    	}
	
	}
	
	public void editarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
 		
    	MobiliaDAO dao = new MobiliaDAO();
    	Boolean naoItemVenda = dao.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
	    	dao.editarMobilia(mobilia);
	    	dao.deletarMobiliaComodo(mobilia.getIdMobilia());
	    	int tam = mobilia.getComodo().size();
	    	for(int j = 0; j < tam; j ++){
	    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
	    		dao.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
	    	}
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
	}
	
	public List<Mobilia>listarMobilias() throws SQLException{
    	
    	MobiliaDAO dao = new MobiliaDAO();
    	List<Mobilia>listaMobilia = dao.listarMobilias();
    	return listaMobilia;
    	
    }
	
	public void deletarMobilia(Mobilia mobilia) throws SQLException, ExceptionMobilias{
    	
    	MobiliaDAO dao = new MobiliaDAO();
    	Boolean naoItemVenda = dao.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		dao.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
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
