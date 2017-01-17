package data.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Contrato;

public class ContratoGateway {

	public static void inserirContrato(Contrato contrato) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into contrato(comissao) values(?)");
				ps.setFloat(1, contrato.getComissao());
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
		
			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
	}
	
	public static ResultSet recuperarContratoId() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conexao = Conexao.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from contrato order by id desc limit 1");

        }catch(Exception e){
            e.printStackTrace();
            
        }
        conexao.close();
		return rs ;
	}
}
