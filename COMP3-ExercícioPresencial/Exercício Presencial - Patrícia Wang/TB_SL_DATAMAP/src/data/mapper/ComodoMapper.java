package data.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Cozinha;
import entidades.Quarto;
import entidades.Sala;
import enums.TipoComodo;

public class ComodoMapper extends Conexao{
	
	public void inserirComodo(Comodo comodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = getConnection();
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

	
	public int recuperaPai() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        int idPai = 0;
        try{
            conexao = getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo order by id desc limit 1");

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
	
	public List<Comodo> listarComodo(String tipo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	conexao = getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo where tipo = '"+ tipo +"'");
            
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		listaComodo.add(coz);
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		listaComodo.add(quarto);
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		listaComodo.add(sala);
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		listaComodo.add(comodoC);
            	}

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
        
		return listaComodo;
	}
	
public List<Comodo> listarComodoTotal() throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	conexao = getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo ");
            
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		coz.setTipoComodo(tipoComodo);
            		listaComodo.add(coz);
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		quarto.setTipoComodo(tipoComodo);
            		listaComodo.add(quarto);
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		sala.setTipoComodo(tipoComodo);
            		listaComodo.add(sala);
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		comodoC.setTipoComodo(tipoComodo);
            		listaComodo.add(comodoC);
            	}

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
        
		return listaComodo;
	}
	
	
	public void deletarComodo(int id) throws SQLException{
		
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = getConnection();
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
	
	public void editarComodo(Comodo comodo) throws SQLException{
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = getConnection();
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
	
	public boolean verificarComodoEmComposto(int idComodo) throws SQLException{

		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        String id = "";
        
        try{
            conexao = getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select id_comodo from comodo_composto where id_comodo = "+idComodo+"");           
            while (rs.next()){
            	id = rs.getString("id_comodo");
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
	
	/*public void atualizarComodoParaComposto(int idComodo, int idTodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = getConnection();
				ps = conexao.prepareStatement("update comodo set idcomodocomposto = ? where id = ? and idcomodocomposto is null ");
				ps.setInt(1, idTodo);
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
	*/
	public void associarComodoParaComodoComposto(int idComodo, int idTodo) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;  
		try{
				conexao = getConnection();
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
	
public Comodo recuperarComodoPorId(int idComodo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        Comodo comodo = null;
        //List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	conexao = getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from comodo where id  = "+idComodo+";");
            
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	 
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		coz.setTipoComodo(tipoComodo);
            		//listaComodo.add(coz);
            		comodo = coz;
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		quarto.setTipoComodo(tipoComodo);
            		//listaComodo.add(quarto);
            		comodo = quarto;
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		sala.setTipoComodo(tipoComodo);
            		//listaComodo.add(sala);
            		comodo = sala;
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		comodoC.setTipoComodo(tipoComodo);
            		//listaComodo.add(comodoC);
            		comodo = comodoC;
            		
            	}

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
        
		return comodo;
	}

public boolean verificarComodoEmMobilia(int idComodo) throws SQLException{

	Connection conexao = null;
    Statement st = null;
    ResultSet rs = null;
    String id = "";
    
    try{
        conexao = getConnection();
        st = conexao.createStatement();
        rs = st.executeQuery("Select id_mobilia from comodo_mobilia where id_comodo = "+idComodo+"");           
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

	public void deletarComodoComposto(int id) throws SQLException{
		
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = getConnection();
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
	
	public List<Comodo> recuperarComodoComposto(int id) throws SQLException{
			
			Connection conexao = null;
			Statement st = null;
	        ResultSet rs = null;
	       
	        List<Comodo>listaComodos =  new ArrayList<Comodo>();
	        try{
	        	conexao = getConnection();
	        	st = conexao.createStatement();
	            rs = st.executeQuery("select c2.* from comodo c "
	            		+ "join comodo_composto cp on c.id = cp.id_composto "
	            		+ "join comodo c2 on cp.id_comodo = c2.id "
	            		+ "where c.id = "+id+";");
	            
	            while(rs.next()){
	            	String desc = rs.getString("descricao");
	            	String id2 = rs.getString("id");
	            	ComodoComposto cp = new ComodoComposto();
	            	cp.setDescricao(desc);
	            	cp.setIdComodo(Integer.parseInt(id2));
	            	listaComodos.add(cp);
	            }
	        
	        }catch(Exception e){
	        	e.printStackTrace();
	        }finally{
	        	 st.close();
		         conexao.close();
		         rs.close();
	        }
	        return listaComodos;
	}
}
