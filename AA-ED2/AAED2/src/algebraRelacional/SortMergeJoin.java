package algebraRelacional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

import conversao.BytePlus;
import catalogo.Catalogo;

public class SortMergeJoin{
	private Catalogo catalogo;
	private Selecao selecao;
	private int campo1;
	private int campo2;
	private int size;
	
	ArrayList<ArrayList<byte[]>> tabelaFinal;
	
	public SortMergeJoin(Catalogo pCatalogo, Selecao pSelecao){
		this.catalogo = pCatalogo;
		this.selecao = pSelecao;
		this.tabelaFinal = new ArrayList<ArrayList<byte[]>>();
	}
	
	
	public void mergeJoin(int coluna1, int coluna2) throws IOException{
	 	
		int contadorBytes = 0, loop = 0, cntLinha = 0;
		
		RandomAccessFile leitor = new RandomAccessFile(catalogo.getArqivoDAT(), "r");
		System.out.println("Lendo arquivo "+catalogo.getArqivoDAT());
		ArrayList<ArrayList<byte[]>> tabela2 = new ArrayList<ArrayList<byte[]>>();
		
		while(leitor.getFilePointer() != leitor.length()){ 
			ArrayList<byte[]> auxColuna = new ArrayList<byte[]>();
            for(int i=0; i<catalogo.getColuna(); i++){
            	int m = leitor.readInt();
            	byte[] auxByte= new byte[m]; 
            	leitor.read(auxByte);
            	auxColuna.add(auxByte);
            	
            }
            
            tabela2.add(auxColuna);
            cntLinha++;
		}
		int j = 0;
		
		for(int i = 0; i<tabela2.size(); i++){
			
			System.out.println(selecao.linhaArray.size());
			
			     if(BytePlus.byteArrayToString(selecao.linhaArray.get(j).get(coluna1)).equals(BytePlus.byteArrayToString(tabela2.get(i).get(coluna2)))){
				   System.out.println("Eh igual!");
				   ArrayList<byte[]> auxTab = new ArrayList<byte[]>();
				   for(int x =0; x<selecao.linhaArray.get(j).size(); x++){
					auxTab.add(selecao.linhaArray.get(j).get(x));
					System.out.print(BytePlus.byteArrayToString(selecao.linhaArray.get(j).get(x)) +  " ");
				   }
				    System.out.println(" ");
				   for(int y = 0; y < tabela2.get(j).size(); y++){
					   if(y != coluna2) auxTab.add(tabela2.get(i).get(y));
				   }
				  System.out.println("Addeou no output!");
				   tabelaFinal.add(auxTab);
			     }
		}
		
		size = tabelaFinal.size();
	}
	
	public void imprime(){
		
		System.out.println("\n --------- Começo da impressão --------------");
		for(int i=0; i<tabelaFinal.size(); i++){ //System.out.println(tabelaFinal.size());
			for(int j=0; j<tabelaFinal.get(i).size(); j++){
				System.out.print(BytePlus.byteArrayToString(tabelaFinal.get(i).get(j)) + " ");
			}
			System.out.println(" ");
		}
	}
	
	public int getTabelaSize(){
		return tabelaFinal.size();
	}
	public ArrayList<byte[]> getTabela(int i){
		return tabelaFinal.get(i);
	}
	
	public byte[] getTabelaFinal(int i, int j){
		return tabelaFinal.get(i).get(j);
	}
	
}