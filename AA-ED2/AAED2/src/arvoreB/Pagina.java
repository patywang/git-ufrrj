package arvoreB;

import java.util.ArrayList;

import conversao.BytePlus;

public class Pagina{
	
	int nChaves; //Quantidade de chaves
	int d; //minimo de chaves
	Chave chave[]; //Elementos do n
	Pagina filho[];
	boolean folha;

	public Pagina(int d, boolean ehFolha){
		this.d = d;
		this.chave = new Chave[2*d-1];
		for(int i=0; i<2*d-1; i++){
			chave[i] = new Chave();
		}
		this.filho = new Pagina[2*d];
		this.folha = ehFolha;
		nChaves = 0;
		}


		public boolean busca(ArrayList<Chave> array, String aluno_id, Pagina p){
		if(p == null)
			return false;
		else{
			int i = 0;
			while((i<p.nChaves-1) && (BytePlus.byteArrayToString(p.chave[i].getAluno_id()).compareTo(aluno_id) < 0))
				i++;
			System.out.println(BytePlus.byteArrayToString(p.chave[i].getAluno_id()));
			
			if(BytePlus.byteArrayToString(p.chave[i].getAluno_id()).equals(aluno_id)){
				//array.add(p.chave[i]);
				p.percorreIgual(array, p, i, aluno_id);
					
				return true;
			}
				
			else if(BytePlus.byteArrayToString(p.chave[i].getAluno_id()).compareTo(aluno_id) > 0)
				return busca(array, aluno_id, p.filho[i]);
			else
				return busca(array, aluno_id, p.filho[i+1]);
			}  
		}
		
		public boolean menor(byte[] a, String b){
			if(BytePlus.byteArrayToString(a).compareTo(b) < 0)
				return true;
			else
				return false;
		}
		
		public boolean menor(byte[] a, byte[] b){
			if(BytePlus.byteArrayToString(a).compareTo(BytePlus.byteArrayToString(b)) < 0)
				return true;
			else
				return false;
		}
		
		public boolean maior(byte[] a, String b){
			if(BytePlus.byteArrayToString(a).compareTo(b) > 0)
				return true;
			else
				return false;
		}
		
		public boolean maior(byte[] a, byte[] b){
			if(BytePlus.byteArrayToString(a).compareTo(BytePlus.byteArrayToString(b)) > 0)
				return true;
			else
				return false;
		}
		
		public boolean igual(byte[]a , String b){
			if(BytePlus.byteArrayToString(a).equals(b))
				return true;
			else
				return false;
		}
		
	public void insereNaoCheio( byte[] aluno_id, byte[] ano, byte[] periodo, byte[] nota, byte[] disc){
		int i = nChaves-1;
		
		if(folha==true){	

			while(i >= 0 && maior(chave[i].getAluno_id(), aluno_id)){
				atribue(chave, i+1, chave, i);
				i--;
			}	
			chave[i+1].setAluno_id(aluno_id);
			chave[i+1].setAno(ano);
			chave[i+1].setPeriodo(periodo);
			chave[i+1].setNota(nota);
			chave[i+1].setDisciplina_id(disc);
			nChaves++;
		}
		else{
			 while(i>=0 && maior(chave[i].getAluno_id(), aluno_id))
				 i--;
			 
			 if(filho[i+1].nChaves == 2*d-1){
				 //Se o filho esta cheio, ciso nele
				 cisao(i+1, filho[i+1]);
				 
				// Apos a ciso, ver qual dos lados ter a Paginava chave
				 if(menor(chave[i+1].getAluno_id(), aluno_id))
					 i++;
			 }
			 
			 filho[i+1].insereNaoCheio(aluno_id, ano, periodo, nota, disc);
		}
	} 

	public void cisao(int i, Pagina PaginaCheio){
		//Cria um Paginavo Pagina para armazenar as chaves do Pagina cheio
		Pagina tmp = new Pagina(PaginaCheio.d, PaginaCheio.folha);
		tmp.nChaves = d-1;
		
		for(int j = 0; j < d-1; j++)
		 atribue(tmp.chave, j, PaginaCheio.chave, j+d);
		
		if(PaginaCheio.folha == false){
			for(int j = 0; j< d; j++)
				tmp.filho[j] = PaginaCheio.filho[j+d];
		}
		
		PaginaCheio.nChaves = d-1;
		
		for(int j = nChaves; j >=i+1; j--)
			filho[j+1] = filho[j];
		
		//Adiciona Paginavo filho para esse Pagina
		filho[i+1] = tmp;
		
		for(int j = nChaves-1; j >= i; j--)
			atribue(chave,j+1, chave, j);
		
		atribue(chave, i, PaginaCheio.chave, d-1);
		
		//Incrementa n de chaves nesse Pagina
		nChaves++;
		
	}
	
	public void atribue(Chave[] a, int i, Chave[] b, int j)
	{	
		a[i].setAluno_id(b[j].getAluno_id());
		a[i].setAno(b[j].getAno());
		a[i].setPeriodo(b[j].getPeriodo());
		a[i].setNota(b[j].getNota());
		a[i].setDisciplina_id(b[j].getDisciplina_id());
	}
	
	public void percorre(){
		int i;
		
		for(i=0; i<nChaves; i++){
			if(folha == false)
				filho[i].percorre();
			System.out.print("  " + BytePlus.byteArrayToString(chave[i].getAluno_id()) + "  " + BytePlus.byteArrayToString(chave[i].getAno()) + "  " + BytePlus.byteArrayToString(chave[i].getPeriodo()) + "\n" );
			//System.out.println(" ");
		}
		
		if(folha == false)
			filho[i].percorre();
	}

	public void percorreIgual(ArrayList<Chave> array, Pagina p,int index, String aluno_id){
		int i;
		// There are n keys and n+1 children, travers through n keys
	    // and first n children
		for(i=index; i<nChaves; i++){
			// If this is not leaf, then before printing key[i],
	        // traverse the subtree rooted with child C[i].
			if(p.folha == false){ 
				//System.out.print("Eh igual ");
				//array.add(p.chave[i]);
				p.filho[i].percorreIgual(array, p.filho[i], 0, aluno_id);
			} //else 
				//continue;
			if(igual(p.chave[i].getAluno_id(), aluno_id)){
			array.add(p.chave[i]);
			}
			System.out.print("  " + BytePlus.byteArrayToString(p.chave[i].getAluno_id()) + "  " + BytePlus.byteArrayToString(p.chave[i].getAno()) + "  " + BytePlus.byteArrayToString(p.chave[i].getPeriodo()) + "\n" );
			//System.out.println(" ");
			}
		
		// Print the subtree rooted with last child
		if(p.folha == false){
			p.filho[i].percorreIgual(array, p.filho[i], 0,  aluno_id);
		}
		
	}
}