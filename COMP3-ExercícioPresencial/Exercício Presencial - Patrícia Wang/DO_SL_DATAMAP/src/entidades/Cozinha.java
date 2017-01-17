package entidades;


import java.util.Map;

import data.mapper.MobiliaMapper;
import enums.TipoComodo;

public class Cozinha extends Comodo{
	
	private int id;
	
	public Cozinha(){super();}
	
	public Cozinha(String descricao,String tipo){
		super(descricao, tipo);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Map<Integer,String> listaMobiliaDisponivel(){
		
		MobiliaMapper dao = new MobiliaMapper(); 
		Map<Integer, String> mapMobilia = dao.listarMobiliasDisponiveisTotal(TipoComodo.COZINHA.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
		
	}



	

}
