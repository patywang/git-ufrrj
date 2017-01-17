package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;
import active.records.ActiveRecordsItemVenda;

public class ItemVenda implements ActiveRecordsItemVenda{
	
	private int quantidade;
	private Mobilia mobilia;
	
	public ItemVenda(){};
	
	public ItemVenda(int quant, Mobilia mob){
		this.quantidade=quant;
		this.mobilia=mob;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Mobilia getMobilia() {
		return mobilia;
	}
	public void setMobilia(Mobilia mobilia) {
		this.mobilia = mobilia;
	}

	public Boolean verificarMobiliaEmItemVenda(int idMobilia){
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        String id = "";
        
        try{
            conexao = DAO.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select id_mobilia from itemvenda where id_mobilia = "+idMobilia+"");           
            while (rs.next()){
            	id = rs.getString("id_mobilia");
            }
            if (id.isEmpty()){
            	return true;
            }
            
            st.close();
            conexao.close();
            rs.close();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
		return false;
	}
	

	
	@Override
	public void associarItemVenda(int idAmbiente, ItemVenda item) throws SQLException{
		
		PreparedStatement ps = null; 
		Connection conexao = null;   
		try{
				conexao = DAO.getConnection();
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

}
