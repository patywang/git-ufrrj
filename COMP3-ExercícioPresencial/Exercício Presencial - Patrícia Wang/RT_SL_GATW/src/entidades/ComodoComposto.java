package entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import dao.ComodoDAO;
import dao.MobiliaDAO;
import enums.TipoComodo;

public class ComodoComposto extends Comodo{
	
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
	return null;
	}

	/*@Override
	public List<Mobilia> listarMobiliaDisponivel(int id) {*/
		
		/*MobiliaDAO dao = new MobiliaDAO();
		ComodoDAO comodo = new ComodoDAO();
		List<Mobilia>mob = new ArrayList<Mobilia>();
		try {
			List<Comodo>lista = comodo.recuperarComodoComposto(id);
			if(lista != null && !lista.isEmpty()){
				for (Comodo comodo2 : lista) {
					mob.addAll(listarMobiliaDisponivel(comodo2.getIdComodo()));
					System.out.println(comodo2.getIdComodo());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mob.addAll(dao.listarMobiliasPorComodo(id));
		return mob;*/
		//return null;
	//}
	
	public static List<Mobilia> listarMobilias(int id) throws SQLException{
		
		MobiliaDAO dao = new MobiliaDAO();
		ComodoDAO comodoDAO = new ComodoDAO();
		List<Mobilia>mob = new ArrayList<Mobilia>();
		try {
			List<Comodo>lista = comodoDAO.recuperarComodoComposto(id);
			if(lista != null && !lista.isEmpty()){
				for (Comodo comodo2 : lista) {
					mob.addAll(listarMobilias(comodo2.getIdComodo()));
					System.out.println(comodo2.getIdComodo());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mob.addAll(dao.listarMobiliasPorComodo(id));
		return mob;
	}


	

}
