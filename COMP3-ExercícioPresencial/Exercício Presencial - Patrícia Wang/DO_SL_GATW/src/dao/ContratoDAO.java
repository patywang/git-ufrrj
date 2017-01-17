package dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import data.gateway.ContratoGateway;
import entidades.Contrato;

public class ContratoDAO{
	
	public void inserirContrato(Contrato contrato){
		
		try {
			ContratoGateway.inserirContrato(contrato);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int recuperarContratoId() throws SQLException{
		
		ResultSet rs = ContratoGateway.recuperarContratoId();
		int idPai = 0;
		while (rs.next()){
	        	
         	String idComodo = rs.getString("id");
         	idPai = (Integer.parseInt(idComodo));

         }
		rs.close();
		return idPai;
		
	}

}
