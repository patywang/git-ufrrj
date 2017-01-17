package hash;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import conversao.BytePlus;
import catalogo.Catalogo;


public class Hash {
	
	private Catalogo catalogo;
	public int m;
	
	public Lista encadeamentoExterior[];
	public ArrayList<byte[]>ByteArrayTemp;
	public ArrayList<ArrayList<byte[]>>ByteArray2;
	
	public Hash(Catalogo cat,int tamM){
		
		this.catalogo=cat;
		this.m  = tamM;
		int i = 0;
		encadeamentoExterior = new Lista[m];  
		for( i = 0 ; i < m ; i ++){
			encadeamentoExterior[i] = new Lista();
		}
		
	}
	
	public void colisao(int n, int elemento, int tamByte, byte[] b) throws IOException{
		if(encadeamentoExterior[n].checkIfListaVazia()){
			encadeamentoExterior[n].inserirNoFim(new No(elemento,tamByte,b));
			//System.out.println("linha  " + elemento + " entrou na posicao " + n);
		}else{
			
			if(encadeamentoExterior[n].buscaElemento(elemento,tamByte,b)!=null){
				//System.out.println( elemento + " ELEMENTO REPETIDO!!");
			}else{
				
				encadeamentoExterior[n].inserirNoFim(new No (elemento,tamByte,b));
				//System.out.println("_linha " + elemento + " entrou na posicao " + n);
			}
		}
		
	}
	
	public void dispersao(int elemento, int tamanhoByte, byte[] b) throws IOException{
		int mod = elemento % m;
		colisao(mod , elemento,tamanhoByte,b); 
	}
	

	public int getNo(byte []id){
		
		String str = BytePlus.byteArrayToString(id);
		int total=0;
		char[] chars = str.toCharArray();
		for(int j = 0; j < chars.length; j++){
			total +=chars[j];
		}
		int d = total % m;
		return encadeamentoExterior[d].buscaElementoFK(id).tamByte;
	
	}
	
	public void hashAluno(int col) throws IOException{
		int tamanhoByte=0;
		RandomAccessFile r = new RandomAccessFile(catalogo.getArqivoDAT(), "r");
		int cont = 0;
		ArrayList<byte[]> temp = new ArrayList<byte[]>();
		ByteArrayTemp = new ArrayList<byte[]>();
		ByteArray2= new ArrayList<ArrayList<byte[]>>();
		while(r.getFilePointer() != r.length()){
			
			int tam = 0, total = 0;;
			tam = r.readInt();
			byte b[] = new byte[tam];
			r.read(b);
			ByteArrayTemp.add(b);
			cont++;
			
			if(cont == catalogo.getColuna()){
				String str = BytePlus.byteArrayToString(ByteArrayTemp.get(col));
				
				char[] chars = str.toCharArray();
				for(int j = 0; j < chars.length; j++){
					total +=chars[j];
				}
				dispersao(total,tamanhoByte,ByteArrayTemp.get(col));
				
				/*for(int k = 0; k<catalogo.getColuna();k++){
					tamanhoByte+=ByteArrayTemp.get(k).length;
				}*/
				tamanhoByte = (int)r.getFilePointer();
				ByteArray2.add(ByteArrayTemp);
				ByteArrayTemp.clear();
				cont = 0;
			}
			
			
			//System.out.println("---- " + Conversao.converteArrayDeBytesParaString(b));
			
			
		}
		
		
	}
	

}
