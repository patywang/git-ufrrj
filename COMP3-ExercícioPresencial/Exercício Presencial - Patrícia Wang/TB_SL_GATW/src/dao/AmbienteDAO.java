package dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import data.gateway.AmbienteGateway;
import entidades.Ambiente;
import entidades.ItemVenda;

public class AmbienteDAO {
	
	public void inserirAmbiente(Ambiente ambiente){
		
		try {
			AmbienteGateway.inserirAmbiente(ambiente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int recuperarAmbiente() throws SQLException{
		
        ResultSet rs = AmbienteGateway.recuperarAmbiente();
        int idAmbiente = 0;
        try{

            while (rs.next()){
        	
            	String id = rs.getString("id");
            	idAmbiente = (Integer.parseInt(id));

            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        rs.close();
        return idAmbiente;
	}
	
	
	public void associarItemVenda(int idAmbiente, ItemVenda item){
		
		try {
			AmbienteGateway.associarItemVenda(idAmbiente, item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarAmbienteComContrato(int idAmbiente, int idContrato) {
		
		try {
			AmbienteGateway.atualizarAmbienteComContrato(idAmbiente, idContrato);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
