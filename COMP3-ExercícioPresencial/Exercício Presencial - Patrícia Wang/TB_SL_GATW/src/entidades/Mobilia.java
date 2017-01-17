package entidades;

import java.util.List;

public class Mobilia {
	
	private int idMobilia;
	private String descricao;
	private float custo;
	private int tempoEntrega;
	private List<Comodo> comodo;
	
	public Mobilia(){};
	
	public Mobilia(String desc, float cust, int tempo, List<Comodo> comd){
		this.descricao=desc;
		this.custo=cust;
		this.tempoEntrega=tempo;
		this.comodo = comd;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	public int getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(int tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public List<Comodo> getComodo() {
		return comodo;
	}

	public void setComodo(List<Comodo> comodo) {
		this.comodo = comodo;
	}

	public int getIdMobilia() {
		return idMobilia;
	}

	public void setIdMobilia(int idMobilia) {
		this.idMobilia = idMobilia;
	}

}
