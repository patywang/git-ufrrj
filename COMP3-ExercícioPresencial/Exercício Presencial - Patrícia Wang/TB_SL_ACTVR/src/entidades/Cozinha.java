package entidades;

import java.util.Map;

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
		
		Mobilia activeRecordMobilia = new Mobilia();
		Map<Integer, String> mapMobilia = activeRecordMobilia.listarMobiliasDisponiveisTotal(TipoComodo.COZINHA.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
		
	}



	

}
