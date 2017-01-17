package entidades;

import java.util.Map;

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

}
