package entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.mapper.ComodoMapper;
import data.mapper.MobiliaMapper;
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
		MobiliaMapper dao = new MobiliaMapper(); 
		Map<Integer, String> mapMobilia = dao.listarMobiliasDisponiveisTotal(TipoComodo.COMODO_COMPOSTO.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
	}


	
	public static List<Mobilia> listarMobilias(int id){
		MobiliaMapper mapperMob = new MobiliaMapper();
		ComodoMapper mapperComodo = new ComodoMapper();
		List<Mobilia>mob = new ArrayList<Mobilia>();
		try {
			List<Comodo>lista = mapperComodo.recuperarComodoComposto(id);
			if(lista != null && !lista.isEmpty()){
				for (Comodo comodo2 : lista) {
					mob.addAll(listarMobilias(comodo2.getIdComodo()));
					System.out.println(comodo2.getIdComodo());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mob.addAll(mapperMob.listarMobiliasPorComodo(id));
		return mob;
	}


	

}
