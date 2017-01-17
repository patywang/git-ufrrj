package entidades;

public class ItemVenda {
	
	private int quantidade;
	private Mobilia mobilia;
	
	public ItemVenda(){};
	
	public ItemVenda(int quant, Mobilia mob){
		this.quantidade=quant;
		this.mobilia=mob;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Mobilia getMobilia() {
		return mobilia;
	}
	public void setMobilia(Mobilia mobilia) {
		this.mobilia = mobilia;
	}
}
