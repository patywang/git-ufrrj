package entidades;

import java.util.Map;

public class Ambiente {
	
	private int numParedes;
	private int numPortas;
	private float metragem;
	private Map<Integer,Integer>mobilias;
	private float custoTotal;
	private int tempoTotalPorAmbiente;
	private int idAmbiente;
	private float custoItemVendaMobiliaAmbiente;
	
	public Ambiente(){};
	
	public Ambiente(int numParedes, int numPortas, float met,  Map<Integer,Integer>mob){
		this.numParedes = numParedes;
		this.numPortas = numPortas;
		this.metragem = met;
		this.mobilias = mob;
	}
	
	public int getNumParedes() {
		return numParedes;
	}
	public void setNumParedes(int numParedes) {
		this.numParedes = numParedes;
	}
	public int getNumPortas() {
		return numPortas;
	}
	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	public float getMetragem() {
		return metragem;
	}
	public void setMetragem(float metragem) {
		this.metragem = metragem;
	}

	public float custo(float itemQuantTotal,int numParedes,int numPortas, float metragem){
		return (float)(itemQuantTotal + 10 * numParedes + 5 * numPortas + 2.5 * metragem);
	}
	
	public int tempoEntrega(int maiorEntrega,int nParedes,int nPortas ){
		return maiorEntrega + 2*nParedes + nPortas/2;
	}

	public Map<Integer,Integer> getMobilias() {
		return mobilias;
	}

	public void setMobilias(Map<Integer,Integer> mobilias) {
		this.mobilias = mobilias;
	}

	public float getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(float custoTotal) {
		this.custoTotal = custoTotal;
	}

	public int getTempoTotalPorAmbiente() {
		return tempoTotalPorAmbiente;
	}

	public void setTempoTotalPorAmbiente(int tempoTotalPorAmbiente) {
		this.tempoTotalPorAmbiente = tempoTotalPorAmbiente;
	}

	public int getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public float getCustoItemVendaMobiliaAmbiente() {
		return custoItemVendaMobiliaAmbiente;
	}

	public void setCustoItemVendaMobiliaAmbiente(
			float custoItemVendaMobiliaAmbiente) {
		this.custoItemVendaMobiliaAmbiente = custoItemVendaMobiliaAmbiente;
	}

}
