package arvoreB;

import java.io.RandomAccessFile;
import java.util.ArrayList;

import catalogo.Catalogo;
import catalogo.CatalogoDisciplinasHistoricos;
import conversao.BytePlus;

public class ArvoreBDH{
	
	private int d;
	private Pagina raiz;
	public ArrayList<Chave> rBusca;
	
	public ArvoreBDH(int d){
		this.d = d;
		this.raiz = null;
		this.rBusca = new ArrayList<Chave>();
	}
	
	public ArvoreBDH criaArvoreBDH(){
		return null;
	}
	
	public void percorre(){
		if(raiz == null)
			System.out.println("Arvore vazia");
		else
			raiz.percorre();
	}
    //chave k
	public void insere(byte[] aluno_id, byte[] ano, byte[] periodo, byte[] nota, byte[] disc){
		
		if(raiz == null){
			raiz = new Pagina(d, true); 
			raiz.chave[0].setAluno_id( aluno_id);
			raiz.chave[0].setAno( ano);
			raiz.chave[0].setPeriodo( periodo);
			raiz.nChaves = 1;
			//raiz.filho = null;
		}
		else{//se a raiz esta cheia
			if(raiz.nChaves == 2*d-1){
				// tmp = nova raiz
				Pagina tmp = new Pagina(d, false);
				
				//faz a raiz antiga ser filho da nova raiz
				tmp.filho[0] = raiz;
				
				//faz a cisao na antiga raiz e move um chave para a nova raiz
				tmp.cisao(0, raiz);
				
				int i = 0;
				
				//Nova raiz tem 2 filhos, logo, decidir qual dos filhos tera a chave
				if(BytePlus.byteArrayToString(tmp.chave[0].getAluno_id()).compareTo(BytePlus.byteArrayToString(aluno_id)) < 0)
					i++;
				
				tmp.filho[i].insereNaoCheio(aluno_id, ano, periodo, nota, disc);
				
				//muda a raiz
				raiz = tmp;
			}
			else{
				raiz.insereNaoCheio(aluno_id, ano, periodo, nota, disc);
			}
		}
	}
	
	public void insereDoArquivo()
	{
		Catalogo catalogo = new CatalogoDisciplinasHistoricos();
        try{
       System.out.println(catalogo.getArqivoDAT());
        RandomAccessFile r = new RandomAccessFile(catalogo.getArqivoDAT(), "r");

        while(r.getFilePointer() != r.length()){
        
        	byte b[] = new byte[1];
			ArrayList<byte[]> aux = new ArrayList<byte[]>();
			for(int i=0; i<7; i++){

			int tam = r.readInt();
			b = new byte[tam];
			r.read(b);
			aux.add(b);					
			}
			
			insere(aux.get(1), aux.get(4), aux.get(5), aux.get(3), aux.get(2));
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void testaLeitura(){
		
		try{
        RandomAccessFile leitor = new RandomAccessFile("/Users/Wesley/Documents/Workspace/AA-ED2/Arquivos/DiscHisT.dat", "r");
        int i = 1;
        while(leitor.getFilePointer() != leitor.length()){
        	
        	if(i == 3){ i = 0;
        	System.out.println(" ");
        	}
            int tam = leitor.readInt();
            byte array[] = new byte[tam];
            leitor.read(array);
            
            System.out.print(BytePlus.byteArrayToString(array) +" ");
            i++;
        }
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public boolean busca(String dado){
		System.out.println("Buscando por "+dado);
		return raiz.busca(rBusca, dado, raiz);
	}
	
	public static void main(String[] args){
		ArvoreBDH t = new ArvoreBDH(4);
		
		   t.insereDoArquivo();
		   //t.percorre();
		   
		   //t.testaLeitura();
		    
		   System.out.println(t.busca("0f56bc76-7020-453d-a87d-7cc0b703d049"));
		   
		   //System.out.println(t.rBusca.size());
		   for(int i=0; i<t.rBusca.size(); i++){
			   /*System.out.println(ByteArray.byteArrayToString(t.rBusca.get(i).getAluno_id()) + " " +
					   ByteArray.byteArrayToString(t.rBusca.get(i).getPeriodo()) + " " + 
					   ByteArray.byteArrayToString(t.rBusca.get(i).getAno()));*/
		   }
	}

}