package algebraRelacional;

 
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import conversao.BytePlus;
import catalogo.Catalogo;
 
public class Selecao {
    private Catalogo catalogo;
    //public ArrayList<byte[]>colunaArray;
    public ArrayList<byte[]>colunaArrayTemp;
    public ArrayList<ArrayList<byte[]>>linhaArray;
      
    public Selecao(Catalogo cat){
        //this.linhaArray = new ArrayList<ArrayList<byte[]>>();
        this.catalogo = cat;
    }
  
    public void select( int col1, byte[] valor)throws IOException{
        select(col1,valor,-1,null);
    }
      
    public void select(int col, byte[] valor, int col2, byte[] valor2) throws IOException{
        int cont = 0;
      
        RandomAccessFile r = new RandomAccessFile(catalogo.getArqivoDAT(), "r");
        //colunaArray = new ArrayList<byte[]>();
        linhaArray = new ArrayList<ArrayList<byte[]>>();
        colunaArrayTemp = new ArrayList<byte[]>();
          
        while(r.getFilePointer() != r.length()){
              
            int tam = 0;
            tam = r.readInt();
            byte b[] = new byte[tam];
            r.read(b);
            cont++;
            colunaArrayTemp.add(b);
              
            if(cont == catalogo.getColuna()){
              
                if(col2 == -1){
                    if(comparaArray(colunaArrayTemp.get(col), valor)){
                        linhaArray.add(colunaArrayTemp);
                          
                    }
                    cont = 0;
                    colunaArrayTemp = new ArrayList<byte[]>();
                    //colunaArray.clear();
                }else{
                              
                    if(comparaArray(colunaArrayTemp.get(col), valor) && comparaArray(colunaArrayTemp.get(col2), valor2)){    
                     
                        linhaArray.add(colunaArrayTemp);
                          
                    }
                    cont = 0;
                    colunaArrayTemp = new ArrayList<byte[]>();
                }
      
            }
                  
        }
        //r.close(); 
          
    }
    
	public void selectDenovo(int col, byte[] valor){
		for(int i=0; i<linhaArray.size(); i++){
			if(valor.length != linhaArray.get(i).get(col).length){
				linhaArray.remove(i);
			}else{
				int aux = 0;
				for(int j=0; j<valor.length; j++){
					if(valor[j] == linhaArray.get(i).get(col)[j]){
						aux++;
					}
				}
				if(aux != valor.length){
					linhaArray.remove(i);
				}
			}
		}
	
	}
    
    public void atualizaSelecao(ArrayList<ArrayList<byte[]>> b){
    	linhaArray = new ArrayList<ArrayList<byte[]>>();
    	linhaArray.addAll(b);
    }
      
    public static boolean comparaArray(byte[] a, byte[] b){      
        int tam1 = a.length;
        int tam2 = b.length;
        if(tam1==tam2){
            for(int i = 0; i < tam1;i ++ ){
                if(a[i]!=b[i]){
                    return false;
                }
            }
        } else {
            return false;
        }
          
        return true;    
    }
  
     
      
}