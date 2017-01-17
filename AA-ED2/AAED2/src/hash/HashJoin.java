package hash;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import conversao.BytePlus;
import catalogo.Catalogo;
import catalogo.CatalogoAlunos;
import algebraRelacional.Selecao;


public class HashJoin{
    
    private Hash hash;
    private Selecao selecao;
    private Catalogo catalogoH;
    private Catalogo catalogoNH;
    public ArrayList<byte[]>ByteArrayTemp;
    public ArrayList<byte[]>colunaArrayTemp;
    public ArrayList<ArrayList<byte[]>> hashByte;
     
    public HashJoin(Selecao sel, Catalogo catH, Catalogo catNH) throws IOException{
        this.selecao=sel;
        this.catalogoH=catH;
        this.catalogoNH=catNH;
        this.hash = new Hash(catH, 2000);
        hash.hashAluno(0);
        this.hashByte = new ArrayList<ArrayList<byte[]>>();
    }
     
    public void juncao(int col) throws IOException{
     
         
         
        byte []id;
 
        RandomAccessFile r = new RandomAccessFile(catalogoH.getArqivoDAT(), "r");
        for(int i = 0; i < selecao.linhaArray.size(); i ++){
             
            //int cont = 0;
            id = selecao.linhaArray.get(i).get(col);
            int tam = hash.getNo(id);
            r.seek(tam);
            colunaArrayTemp = new ArrayList<byte[]>();
            for(int j = 0; j < catalogoH.getColuna(); j++){
                 
                int tam2 = 0;
                tam2 = r.readInt();
                byte b[] = new byte[tam2];
                r.read(b);
                colunaArrayTemp.add(b);
                  
                
            }
            id = selecao.linhaArray.get(i).get(col);
            tam = hash.getNo(id);
            
            ArrayList<byte[]> auxTab = new ArrayList<byte[]>();
            for(int k = 0 ; k < catalogoNH.getColuna(); k++ ){
            	auxTab.add(selecao.linhaArray.get(i).get(k));
                //System.out.println("NAO hash - > " +  BytePlus.byteArrayToString(selecao.linhaArray.get(i).get(k)) );
            }
            for(int k = 0; k < catalogoH.getColuna(); k++){
            	if(BytePlus.byteArrayToString(selecao.linhaArray.get(i).get(col)).equals(BytePlus.byteArrayToString(colunaArrayTemp.get(k))))
            		continue;
            	else
            		auxTab.add(colunaArrayTemp.get(k));
                //System.out.println("COM hash - > " +  BytePlus.byteArrayToString(colunaArrayTemp.get(k)) );
                 
            }
            hashByte.add(auxTab);
            colunaArrayTemp.clear();
        }
        r.close();
         
    }
             
             
             
      public void imprime(){
    	  for(int i =0; i<hashByte.size(); i++){
    		  //for(int j =0; j<hashByte.get(i).size(); j++){
    			  System.out.print(BytePlus.byteArrayToString(hashByte.get(i).get(hashByte.get(i).size()-2)) + " ");
    		  //}
    		  System.out.println("");
    	  }
      }
             
             
      public ArrayList<ArrayList<byte[]>> getHashByte(){
    	  return this.hashByte;
      }
         
         
     public Hash getHash(){
    	 return hash;
     }
     
 
}