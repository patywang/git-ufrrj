package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DAO;
import active.records.ActiveRecordsMobilia;

public class Mobilia implements ActiveRecordsMobilia{
	
	private int idMobilia;
	private String descricao;
	private float custo;
	private int tempoEntrega;
	private List<Comodo> comodo;
	
	public Mobilia(){};
	
	public Mobilia(String desc, float cust, int tempo, List<Comodo> comd){
		this.descricao=desc;
		this.custo=cust;
		this.tempoEntrega=tempo;
		this.comodo = comd;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	public int getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(int tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public List<Comodo> getComodo() {
		return comodo;
	}

	public void setComodo(List<Comodo> comodo) {
		this.comodo = comodo;
	}

	public int getIdMobilia() {
		return idMobilia;
	}

	public void setIdMobilia(int idMobilia) {
		this.idMobilia = idMobilia;
	}

	public void inserirMobilia(Mobilia mobilia) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = DAO.getConnection();
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
	
	public int recuperarPaiMobilia() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        int idPai = 0;
        try{
            conexao = DAO.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia order by id desc limit 1");

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
	
	public void associarComodoMobilia(int idMobilia, int idComodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = DAO.getConnection();
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
	
	public List<Mobilia> listarMobilias(){
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		List<Mobilia> listaMobilia = new ArrayList<Mobilia>();
		
		try {
			conexao = DAO.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia; ");
           
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
			
		}
		
		return listaMobilia;
	}
	
	public void deletarMobilia(Mobilia mobilia) throws SQLException{
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = DAO.getConnection();
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
	
	public void editarMobilia(Mobilia mobilia) throws SQLException{
	
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = DAO.getConnection();
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
	
	public void deletarMobiliaComodo(int id) throws SQLException{
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = DAO.getConnection();
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
	
	public Map<Integer,String> listarMobiliasDisponiveisTotal(String tipo){
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		Map<Integer,String> mapaMobilia = new HashMap<Integer,String>();
		try {
			conexao = DAO.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia m join comodo_mobilia cm "
            		+ "on cm.id_mobilia = m.id join comodo c on "
            		+ "c.id = cm.id_comodo and c.tipo = '"+tipo+"'; ");
           
            while(rs.next()){
            	String desc = rs.getString("descricao");
            	String idMobilia = rs.getString("id");
            	Mobilia mob = new Mobilia();
            	mob.setDescricao(desc);
            	mob.setIdMobilia(Integer.parseInt(idMobilia));
            	mapaMobilia.put(mob.getIdMobilia(), mob.getDescricao());
            	
            }
		} catch (Exception e) {
			
		}
		
		return mapaMobilia;
	}
	
	public Mobilia recuperarMobiliaPorId(int idMobilia) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        Mobilia mobilia = new Mobilia();
        
        try {
        	conexao = DAO.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia where id  = "+idMobilia+";");
            
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
		return mobilia;
	}
	
	
	public List<Mobilia> listarMobiliasPorComodo(int id){
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
		List<Mobilia> listaMobilia = new ArrayList<Mobilia>();
		
		try {
			conexao = DAO.getConnection();
        	st = conexao.createStatement();
            rs = st.executeQuery("Select * from mobilia m "
            		+ "join comodo_mobilia cm on m.id = cm.id_mobilia "
            		+ "join comodo c on c.id = cm.id_comodo "
            		+ "and c.id ="+id+";");
           
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
		
		return listaMobilia;
		
	}
	

}
