package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.DAO;
import enums.TipoComodo;

public abstract class Comodo {
	
	private String descricao;
	private int idComodo;
	private String tipoComodo;
	//private ComodoComposto comodoComp;
	
	public Comodo(){};
	
	public Comodo(String desc, String tipo) {
		this.descricao = desc;
		
		if(tipo.equals(TipoComodo.SALA)){
			this.tipoComodo = TipoComodo.SALA.toString();
		}else if(tipo.equals(TipoComodo.QUARTO)){
			this.tipoComodo = TipoComodo.QUARTO.toString();
		}else if(tipo.equals(TipoComodo.COZINHA)){
			this.tipoComodo = TipoComodo.COZINHA.toString();
		}else{
			this.tipoComodo = TipoComodo.COMODO_COMPOSTO.toString();
			//comodoCompInstance(comodoComp);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdComodo() {
		return idComodo;
	}

	public void setIdComodo(int id) {
		this.idComodo = id;
	}

	public String getTipoComodo() {
		return tipoComodo;
	}

	public void setTipoComodo(String tipoComodo) {
		this.tipoComodo = tipoComodo;
	}

	public abstract Map<Integer,String> listaMobiliaDisponivel();
	
   public static void inserirComodo(Comodo comodo) throws SQLException{
		
		PreparedStatement ps = null; //consultas pré-compiladas
		Connection conexao = null;   //chamada p metodo de conxão com banco q está na classe pai DAO
		try{
				conexao = DAO.getConnection();
				ps = conexao.prepareStatement("Insert into comodo(descricao,tipo) values(?,?)");
				ps.setString(1, comodo.getDescricao());
				ps.setString(2, comodo.getTipoComodo());
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
   
   public static int recuperaPai() throws SQLException{
		
		Connection conexao = null;
       Statement st = null;
       ResultSet rs = null;
       int idPai = 0;
       try{
           conexao = DAO.getConnection();
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
	
	public static List<Comodo> listarComodo(String tipo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
       ResultSet rs = null;
       
       List<Comodo>listaComodo =  new ArrayList<Comodo>();
       try{
       	conexao = DAO.getConnection();
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
	
public static List<Comodo> listarComodoTotal() throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
       ResultSet rs = null;
       
       List<Comodo>listaComodo =  new ArrayList<Comodo>();
       try{
       	conexao = DAO.getConnection();
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
	
	
public static void deletarComodo(int id) throws SQLException{
	
	PreparedStatement ps = null;
	Connection conexao = null;
	try{
			conexao = DAO.getConnection();
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
				conexao = DAO.getConnection();
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
	
public static Comodo recuperarComodoPorId(int idComodo) throws SQLException{
		
		Connection conexao = null;
		Statement st = null;
        ResultSet rs = null;
        
        Comodo comodo = null;
        //List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	conexao = DAO.getConnection();
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

public static boolean verificarComodoEmMobilia(int idComodo) throws SQLException{

	Connection conexao = null;
    Statement st = null;
    ResultSet rs = null;
    String id = "";
    
    try{
        conexao = DAO.getConnection();
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

}
