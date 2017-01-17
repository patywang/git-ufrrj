#include <iostream>
#include <stdlib.h>
#include "QuickSort.h"
using namespace std;

QuickSort::QuickSort(int ordem){
	n  = ordem;
}

int QuickSort::particiona(int *V,int esquerda, int direita){
	int pivo,aux;
	int inicio = esquerda; // primeiro elemento do vetor do lado esquerdo para ser o pivo     
	pivo = V[inicio];  
	while(esquerda < direita){   
		while(V[esquerda]<=pivo){    
			esquerda ++;   //segue posição      
		}
		while (V[direita] >pivo){ 
			direita --;    //retorna posição
		}
		if(esquerda < direita){    //swap se POSIÇÃO esquerda apontada for menor q a direita apontada
			aux = V[esquerda];     // a esse ponto ele já esta alterando os valores entre maior e menor
			V[esquerda]=V[direita];
			V[direita]=aux;
		}
	}

	V[inicio] = V[direita];
	V[direita]=pivo;
	return direita;
}
int QuickSort::quick(int *V,int esquerda, int direita){
	int pivo;
	if(direita>esquerda){
		pivo = particiona(V,esquerda, direita);
		quick(V,esquerda,pivo-1);  //fazer novamente pq até antes dessa linha ele não está ordenado corretamente apenas está separado os menores dos maiores com o pivo no meio.
		quick(V,pivo+1,direita);   

	}
}
QuickSort::~QuickSort(){}

int main(){
	int  n = 8;
	QuickSort *q = new QuickSort(n);
	int V[] = {13,34,88,45,-77,6,2,100};
	q->quick(V,0,n);
	for(int i = 0; i<n;i++){
		cout<<V[i]<<endl;
	}
}
