package hash;

import javax.swing.JOptionPane;

class Lista{
    No primeiro,ultimo;
    int totalNos;

    public Lista(){
        primeiro = ultimo = null;
        totalNos = 0;
    }

    public int getTotalNos(){
        return totalNos;
    }

    public boolean checkIfListaVazia(){
        if (getTotalNos() == 0){
            return true;
       }
       return false;
    }

    public void inserirNoInicio(No n) {
        if ( checkIfListaVazia() ){
            primeiro = ultimo = n;
        }
        else{
            n.prox = primeiro;
            primeiro = n;
        }
        totalNos++;
    }

    public void inserirNoFim(No n){
        // caso n�o existam n�s inseridos,
        // insere o primeiro n� (n) na lista
        if ( checkIfListaVazia() ){
            primeiro = ultimo = n;
        }
        else{
            ultimo.prox = n;
            ultimo = n;
       }
       totalNos++;
    }

    public void excluirNo(No n){
        No noAtual;
        No noAnterior;
        noAtual = noAnterior = primeiro;
        int contador = 1;

        if (checkIfListaVazia() == false){
            while (contador <= getTotalNos() &&
                     noAtual.valor != n.valor){
                noAnterior = noAtual;
                noAtual = noAtual.prox;
                contador++;
            } 

	        if(noAtual.valor == n.valor){
	            if ( getTotalNos() == 1){
	                primeiro = ultimo = null;
	           }
	           else{
	               if (noAtual == primeiro){
	                   primeiro = noAtual.prox;
	               }
	               else{
	                   noAnterior.prox = noAtual.prox;
	               }
	           }
	           totalNos--;
	        }
	    }
	}
	
	public void exibirLista(){
	    No temp = primeiro;
	    String valores = "";
	    int contador = 1;
	    if ( checkIfListaVazia() == false ){
	        while (contador <= getTotalNos()){
	            valores += Integer.toString(temp.valor)+"-";
	            temp = temp.prox;
	            contador++;
	        }
	    }
	    JOptionPane.showMessageDialog(null, valores);
	 }

	public No buscaElemento(int elemento,int tamByte,byte[] bt){
		No aux = primeiro;
		while(aux != null){
			if(aux.valor == elemento && aux.tamByte == tamByte && aux.b.equals(bt)){
				return aux;
			}
			aux = aux.prox;
		}
		return null;
	}
	//[48, 102, 53, 54, 98, 99, 55, 54, 45, 55, 48, 50, 48, 45, 52, 53, 51, 100, 45, 97, 56, 55, 100, 45, 55, 99, 99, 48, 98, 55, 48, 51, 100, 48, 52, 57]
	//[48, 102, 53, 54, 98, 99, 55, 54, 45, 55, 48, 50, 48, 45, 52, 53, 51, 100, 45, 97, 56, 55, 100, 45, 55, 99, 99, 48, 98, 55, 48, 51, 100, 48, 52, 57]
	
	public No buscaElementoFK(byte[] bt){
		No aux = primeiro;
		while(aux != null){
			if(buscaBooleana(aux.b, bt)){
				return aux;
			}
			aux = aux.prox;
		}
		return null;
	}
	
	public boolean buscaBooleana(byte[]b1 , byte[]b2){
		
		int tam1 = b1.length;
		int tam2 = b2.length;
		
		if(tam1 != tam2){
			return false;
		}
		for(int j = 0; j < tam1; j++){
			if(b1[j]!=b2[j]){
				return false;
			}
		}
		return true;
		
	}

/*
	 public static void main(String[] args) {
	 Lista l = new Lista();

	 l.inserirNoFim(new No(2));
	 l.inserirNoFim(new No(12));
	 l.inserirNoInicio(new No(22));
	 l.inserirNoFim(new No(32));
	 l.inserirNoFim(new No(2));

	 l.exibirLista();

	 l.excluirNo(new No(12));
	 l.exibirLista();
	 }*/
}
