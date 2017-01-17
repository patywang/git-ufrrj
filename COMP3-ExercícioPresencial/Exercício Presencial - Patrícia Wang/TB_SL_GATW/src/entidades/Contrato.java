package entidades;

import java.util.List;

public class Contrato {
	
	private float comissao;
	private List<Ambiente>ambiente;
	
	public Contrato(){};
	
	public Contrato(float comissao, List<Ambiente>ambiente){
		this.comissao = comissao;
		this.ambiente=ambiente;
	}
	
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	public List<Ambiente> getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(List<Ambiente> ambiente) {
		this.ambiente = ambiente;
	}
	
	public float valorContrato(float somaCusto, float comissao){
		return (Float)(somaCusto *(1 + comissao));
	}
	
	public int prazo(List<Integer> lista){
		int somatorio = 0;
		for (Integer i : lista) {
			somatorio += i;
		}
		return somatorio;
	}
}
