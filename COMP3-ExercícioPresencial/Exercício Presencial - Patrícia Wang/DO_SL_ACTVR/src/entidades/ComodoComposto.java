package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import active.records.ActiveRecordsComodoComposto;
import dao.DAO;
import enums.TipoComodo;

public class ComodoComposto extends Comodo implements ActiveRecordsComodoComposto{
	
	private List<Comodo>comodos;
	
	public ComodoComposto(){super();};
	
	public ComodoComposto(String desc, String tipo){
		super(desc,tipo);
	}
	
	public List<Comodo> getComodos() {
		return comodos;
	}

	public void setComodos(List<Comodo> comodos) {
		this.comodos = comodos;
	}

	@Override
	public Map<Integer,String> listaMobiliaDisponivel() {
		Mobilia activeRecordMobilia = new Mobilia();
		Map<Integer, String> mapMobilia = activeRecordMobilia.listarMobiliasDisponiveisTotal(TipoComodo.COMODO_COMPOSTO.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
	}
	
	
	public static List<Mobilia> listarMobilias(int id){
		
		Mobilia activeRecordMobilia = new Mobilia();
		ComodoComposto activeRecordComodoComposto = new ComodoComposto();
		List<Mobilia>mob = new ArrayList<Mobilia>();
		try {
			List<Comodo>lista = activeRecordComodoComposto.recuperarComodoComposto(id);
			if(lista != null && !lista.isEmpty()){
				for (Comodo comodo2 : lista) {
					mob.addAll(listarMobilias(comodo2.getIdComodo()));
					System.out.println(comodo2.getIdComodo());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mob.addAll(activeRecordMobilia.listarMobiliasPorComodo(id));
		return mob;
	}

	public boolean verificarComodoEmComposto(int idComodo) throws SQLException{

		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        String id = "";
        
        try{
            conexao = DAO.getConnection();
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

	public void associarComodoParaComodoComposto(int idComodo, int idTodo) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;  
		try{
				conexao = DAO.getConnection();
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

    public void deletarComodoComposto(int id) throws SQLException{
		
		PreparedStatement ps = null;
		Connection conexao = null;
		try{
				conexao = DAO.getConnection();
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
        	conexao = DAO.getConnection();
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
