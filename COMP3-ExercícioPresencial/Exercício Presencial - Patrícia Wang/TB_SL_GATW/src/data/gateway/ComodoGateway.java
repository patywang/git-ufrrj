package data.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Comodo;


public class ComodoGateway {

	public static void inserirComodo(Comodo comodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into comodo(descricao,tipo) values(?,?)");
				ps.setString(1, comodo.getDescricao());
				ps.setString(2, comodo.getTipoComodo());
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
	
    public static ResultSet recuperaPai() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conexao = Conexao.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo order by id desc limit 1");

            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        conexao.close();
		return rs ;
	}
    
    public static ResultSet listarComodo(String tipo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        try{
        	conexao = Conexao.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo where tipo = '"+ tipo +"'");
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        conexao.close();
		return rs;
	}
    
    public static ResultSet listarComodoTotal() throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        try{
        	conexao = Conexao.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo ");
            
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        conexao.close();
		return rs;
	}
    
    public static void deletarComodo(int id) throws SQLException{
		
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("DELETE from comodo where id = ?");
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
    
    public static void editarComodo(Comodo comodo) throws SQLException{
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("update comodo c set descricao = ? where c.id = ?");
				ps.setString(1, comodo.getDescricao());
				ps.setInt(2, comodo.getIdComodo()); //traz o id pai!
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
    
    public static ResultSet verificarComodoEmComposto(int idComodo) throws SQLException{

		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conexao = Conexao.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select id_comodo from comodo_composto where id_comodo = "+idComodo+"");           
            
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        conexao.close();
		return rs;
	}
    
    public static void associarComodoParaComodoComposto(int idComodo, int idTodo) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;  
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("Insert into comodo_composto(id_composto,id_comodo) values(?,?);");
				ps.setInt(1, idTodo);
				ps.setInt(2, idComodo); 
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
    
    public static ResultSet recuperarComodoPorId(int idComodo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
       
        try{
        	conexao = Conexao.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo where id  = "+idComodo+";");
                  
        }catch(Exception e){
        	e.printStackTrace();
        }
        conexao.close();
		return rs;
	}

    public static void deletarComodoComposto(int id) throws SQLException{
		
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = Conexao.getConnection();
				ps = conexao.prepareStatement("DELETE from comodo_composto where id_composto = ?");//ta usando cascade, nesse casoa mobilia pode ser deletada msm com comodo porem se quiser deletar comodo q tenha mobila n vai poder
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
    
    public static ResultSet recuperarComodoComposto(int id) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
       
        try{
        	conexao = Conexao.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("select c2.* from comodo c "
            		+ "join comodo_composto cp on c.id = cp.id_composto "
            		+ "join comodo c2 on cp.id_comodo = c2.id "
            		+ "where c.id = "+id+";");
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        conexao.close();
        return rs;
}
}
