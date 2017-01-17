package catalogo;

import hash.Hash;

public class CatalogoAlunos extends Catalogo{
	
	private Hash hash;
	
	public CatalogoAlunos(){
		super("Alunos","Alunos.txt","Alunos.dat",0,2000,4) ;
	}
	
	public Hash getHash() {
		return hash;
	}
	public void setHash(Hash hash) {
		this.hash = hash;
	}
}

