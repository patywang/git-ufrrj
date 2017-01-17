package data.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Contrato;

public class ContratoMapper extends Conexao{
	
	public void inserirContrato(Contrato contrato) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;
		try{
				conexao = getConnection();
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
	
	public int recuperarContratoId() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        int idPai = 0;
        try{
            conexao = getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from contrato order by id desc limit 1");

            while (rs.next()){
        	
            	String idComodo = rs.getString("id");
            	idPai = (Integer.parseInt(idComodo));

            }
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
        	
        	if (st != null){
        		st.close();
        	}
        	if (conexao != null){
        		conexao.close();
        	}
        	if(rs != null){
        		rs.close();
        	}
        }
        
		return idPai ;
	}
}
