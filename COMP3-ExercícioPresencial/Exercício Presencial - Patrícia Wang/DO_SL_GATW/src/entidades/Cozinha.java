package entidades;


import java.util.Map;


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
		
		return null;
		
	}



	

}
