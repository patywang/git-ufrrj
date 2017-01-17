package entidades;

import java.util.Map;


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
		return null;
	}


	


}
