package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.gateway.MobiliaGateway;
import entidades.Mobilia;

public class MobiliaDAO {
	
	public void inserirMobilia(Mobilia mobilia) {
		
		try {
			MobiliaGateway.inserirMobilia(mobilia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int recuperarPaiMobilia() throws SQLException{
	
		ResultSet rs  = MobiliaGateway.recuperarPaiMobilia();
		int idPai = 0;
		try {
			
			while (rs.next()){
	        	
            	String idComodo = rs.getString("id");
            	idPai = (Integer.parseInt(idComodo));

            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		return idPai;
	}
	
	public void associarComodoMobilia(int idMobilia, int idComodo){
		
		try {
			MobiliaGateway.associarComodoMobilia(idMobilia, idComodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Mobilia> listarMobilias() throws SQLException{
		
		
        ResultSet rs = MobiliaGateway.listarMobilias();
		List<Mobilia> listaMobilia = new ArrayList<Mobilia>();
		
		try {

            while(rs.next()){
            	String desc = rs.getString("descricao");
            	String custo = rs.getString("custo");
            	String tempo = rs.getString("tempoentrega");
            	String idMobilia = rs.getString("id");
            	Mobilia mob = new Mobilia();
            	mob.setDescricao(desc);
            	mob.setCusto(Float.valueOf(custo));
            	mob.setTempoEntrega(Integer.parseInt(tempo));
            	mob.setIdMobilia(Integer.parseInt(idMobilia));
            	listaMobilia.add(mob);
            	
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		return listaMobilia;
	}
	
	
	public void deletarMobilia(Mobilia mobilia) {
		
		try {
			MobiliaGateway.deletarMobilia(mobilia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarMobilia(Mobilia mobilia){
	
		try {
			MobiliaGateway.editarMobilia(mobilia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarMobiliaComodo(int id) {
		
		try {
			MobiliaGateway.deletarMobiliaComodo(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer,String> listarMobiliasDisponiveisTotal(String tipo) throws SQLException{
		
		
        ResultSet rs = MobiliaGateway.listarMobiliasDisponiveisTotal(tipo);
		Map<Integer,String> mapaMobilia = new HashMap<Integer,String>();
		
		try {

            while(rs.next()){
            	String desc = rs.getString("descricao");
            	String idMobilia = rs.getString("id");
            	Mobilia mob = new Mobilia();
            	mob.setDescricao(desc);
            	mob.setIdMobilia(Integer.parseInt(idMobilia));
            	mapaMobilia.put(mob.getIdMobilia(), mob.getDescricao());
            	
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapaMobilia;
	}
	
	public Mobilia recuperarMobiliaPorId(int idMobilia) throws SQLException{
		
		
        ResultSet rs = MobiliaGateway.recuperarMobiliaPorId(idMobilia);
        Mobilia mobilia = new Mobilia();
        
        try {
            
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String custo = rs.getString("custo");
            	String tempo = rs.getString("tempoentrega");
            	
            	
            	mobilia.setDescricao(desc);
            	mobilia.setIdMobilia(Integer.parseInt(id));
            	mobilia.setTempoEntrega(Integer.parseInt(tempo));
            	mobilia.setCusto(Float.valueOf(custo));
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		return mobilia;
	}
	
	public Boolean verificarMobiliaEmItemVenda(int idMobilia) throws SQLException{
		
        ResultSet rs = MobiliaGateway.verificarMobiliaEmItemVenda(idMobilia);

        String id = "";
        
        try{
                 
            while (rs.next()){
            	id = rs.getString("id_mobilia");
            }
            if (id.isEmpty()){
            	return true;
            }
    
            rs.close();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
		return false;
	}
	
	public List<Mobilia> listarMobiliasPorComodo(int id) throws SQLException{
		
		
        ResultSet rs =MobiliaGateway.listarMobiliasPorComodo(id);
		List<Mobilia> listaMobilia = new ArrayList<Mobilia>();
		
		try {
			
            while(rs.next()){
            	String desc = rs.getString("descricao");
            	String custo = rs.getString("custo");
            	String tempo = rs.getString("tempoentrega");
            	String idMobilia = rs.getString("id");
            	Mobilia mob = new Mobilia();
            	mob.setDescricao(desc);
            	mob.setCusto(Float.valueOf(custo));
            	mob.setTempoEntrega(Integer.parseInt(tempo));
            	mob.setIdMobilia(Integer.parseInt(idMobilia));
            	listaMobilia.add(mob);
            	
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		return listaMobilia;
		
	}
	
}
