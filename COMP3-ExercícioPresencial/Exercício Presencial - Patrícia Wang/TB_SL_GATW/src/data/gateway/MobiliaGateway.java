package data.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import entidades.Mobilia;

public class MobiliaGateway {

    public static void inserirMobilia(Mobilia mobilia) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into mobilia(descricao,custo, tempoentrega) values(?,?,?)");
				ps.setString(1, mobilia.getDescricao());
				ps.setFloat(2,  mobilia.getCusto());
				ps.setInt(3, mobilia.getTempoEntrega());
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace(); //criar exceção aqui;
		
		}finally{
			
			//verificar se precisa desse finally realmente, se na exception já n encerraria toda a conexão
			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
		
	}
    
    public static ResultSet recuperarPaiMobilia() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conexao = Conexao.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia order by id desc limit 1");

           
        }catch(Exception e){
            e.printStackTrace();
            
        }
      
        conexao.close();
		return rs ;
	}
    
   public static void associarComodoMobilia(int idMobilia, int idComodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into comodo_mobilia(id_mobilia,id_comodo) values(?,?);");
				ps.setInt(1, idMobilia);
				ps.setInt(2, idComodo); //traz o id pai!
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace(); //criar exceção aqui;
		
		}finally{
			
			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
	}
   
   public static ResultSet listarMobilias() throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		
		
		try {
			conexao = Conexao.getConnection();
			st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia; ");
          
          
		} catch (Exception e) {
			e.printStackTrace();
		}
		conexao.close();
		return rs;
	}
   
   public static void deletarMobilia(Mobilia mobilia) throws SQLException{
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("DELETE from mobilia where id = ?");//ta usando cascade, nesse casoa mobilia pode ser deletada msm com comodo porem se quiser deletar comodo q tenha mobila n vai poder
				ps.setInt(1,mobilia.getIdMobilia());
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
   
   public static void editarMobilia(Mobilia mobilia) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("update mobilia set descricao = ? , custo = ? , tempoentrega = ?  where id = ?");
				ps.setString(1, mobilia.getDescricao());
				ps.setFloat(2, mobilia.getCusto());
				ps.setInt(3, mobilia.getTempoEntrega());
				ps.setInt(4, mobilia.getIdMobilia());
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace(); //criar exceção aqui;
		
		}finally{
			
			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
	}
   
   public static void deletarMobiliaComodo(int id) throws SQLException{
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("DELETE from comodo_mobilia where id_mobilia = ?");//ta usando cascade, nesse casoa mobilia pode ser deletada msm com comodo porem se quiser deletar comodo q tenha mobila n vai poder
				ps.setInt(1,id);
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
   
   public static ResultSet listarMobiliasDisponiveisTotal(String tipo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		
		try {
			conexao = Conexao.getConnection();
			st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia m join comodo_mobilia cm "
           		+ "on cm.id_mobilia = m.id join comodo c on "
           		+ "c.id = cm.id_comodo and c.tipo = '"+tipo+"'; ");
          
           
		} catch (Exception e) {
			e.printStackTrace();
		}
		conexao.close();
		return rs;
	}
   
   public static ResultSet recuperarMobiliaPorId(int idMobilia) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
		ResultSet rs = null;
      
       
       try {
       	   conexao = Conexao.getConnection();
           st = conexao.createStatement();
           rs = st.executeQuery("Select * from mobilia where id  = "+idMobilia+";");
           
           
		} catch (Exception e) {
			e.printStackTrace();
		}
       conexao.close();
		return rs;
	}
   
   public static ResultSet verificarMobiliaEmItemVenda(int idMobilia) throws SQLException{
		
       Statement st = null;
       ResultSet rs = null;
       Connection conexao = null;
       
       try{
           conexao = Conexao.getConnection();
           st = conexao.createStatement();
           rs = st.executeQuery("Select id_mobilia from itemvenda where id_mobilia = "+idMobilia+"");           
           
       
       }catch(Exception e){
           e.printStackTrace();
           
       }
       conexao.close();
		return rs;
	}
   
   public static ResultSet listarMobiliasPorComodo(int id) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		
		try {
			conexao = Conexao.getConnection();
       	    st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia m "
           		+ "join comodo_mobilia cm on m.id = cm.id_mobilia "
           		+ "join comodo c on c.id = cm.id_comodo "
           		+ "and c.id ="+id+";");
          
          
		} catch (Exception e) {
			e.printStackTrace();
		}
		conexao.close();
		return rs;
		
	}
	
   
}
