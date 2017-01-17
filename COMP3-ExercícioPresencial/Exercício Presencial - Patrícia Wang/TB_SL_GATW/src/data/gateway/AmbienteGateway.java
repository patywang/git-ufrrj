package data.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Ambiente;
import entidades.ItemVenda;

public class AmbienteGateway {

	public static void inserirAmbiente(Ambiente ambiente) throws SQLException{
		
		PreparedStatement ps = null; 
		Connection conexao = null;   
		
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into ambiente(numparedes,numportas, metragem) values(?,?,?)");
				ps.setInt(1, ambiente.getNumParedes());
				ps.setInt(2, ambiente.getNumPortas());
				ps.setFloat(3, ambiente.getMetragem());
				
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

	public static void associarItemVenda(int idAmbiente, ItemVenda item) throws SQLException{
	
		PreparedStatement ps = null; 
		Connection conexao = null;   
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into itemvenda(id_mobilia,id_ambiente, quantidade) values(?,?,?);");
				ps.setInt(1, item.getMobilia().getIdMobilia());
				ps.setInt(2, idAmbiente); 
				ps.setInt(3, item.getQuantidade()); 
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
	
	public static void atualizarAmbienteComContrato(int idAmbiente, int idContrato) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;  
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("update ambiente c set idcontrato = ? where c.id = ?");
				ps.setInt(1, idContrato);
				ps.setInt(2, idAmbiente); 
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
	
   public static ResultSet recuperarAmbiente() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conexao = Conexao.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from ambiente order by id desc limit 1");

        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        conexao.close();
        return rs;
	}
	
}
