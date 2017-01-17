package entidades;

import java.util.Map;

import dao.MobiliaDAO;
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
		
		return null;
	}


	
}
