package entidades;

import java.util.Map;

import enums.TipoComodo;

public class Sala extends Comodo {
	
	private int id;
	
	public Sala(){super();}

	public Sala(String descricao,String tipo) {
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
		Map<Integer, String> mapMobilia = activeRecordMobilia.listarMobiliasDisponiveisTotal(TipoComodo.SALA.toString());
		//System.out.println(mapMobilia);
		return mapMobilia;
	}


	


}
