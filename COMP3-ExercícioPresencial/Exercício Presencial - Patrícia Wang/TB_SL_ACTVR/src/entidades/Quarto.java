package entidades;


import java.util.Map;

import enums.TipoComodo;

public class Quarto extends Comodo{

	private int id;
	
	public Quarto(){super();}
	
	public Quarto(String descricao, String tipo){
		super(descricao,tipo);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Map<Integer,String> listaMobiliaDisponivel() {
		
		Mobilia activeRecordMobilia = new Mobilia(); 
		Map<Integer, String> mapMobilia = activeRecordMobilia.listarMobiliasDisponiveisTotal(TipoComodo.QUARTO.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
	}


	
}
