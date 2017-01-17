#include <iostream>
#include <stdlib.h>
#include "MergeSort.h"
using namespace std;

MergeSort::MergeSort(int ordem){
	n = ordem;
	vAux = new int [n];
}

void MergeSort::mergeSort(int *V, int inicio, int fim){
	
	int meio;

	if (inicio<fim)
	{
		meio = (inicio+fim)/2;
		mergeSort(V,inicio,meio);
		mergeSort(V,meio+1,fim);
		intercala(V,inicio,meio,fim);
	}
}

void MergeSort::intercala(int *V, int inicio, int meio,int fim){

	int indInicio , indMeio, indAux;

	indInicio = inicio;
	indMeio = meio + 1;
	indAux = 0;

	while((indInicio < meio+1 )|| (indMeio < fim+1))
	{
		if(indInicio == meio + 1)
		{
			vAux[indAux] =V[indMeio];
			indMeio = indMeio + 1;
			indAux = indAux + 1;

		}else if (indMeio == fim+1){
			vAux[indAux] =V[indInicio];
			indInicio = indInicio + 1;
			indAux = indAux + 1;

		}else if (V[indInicio] <= V[indMeio]){
			vAux[indAux] =V[indInicio];
			indInicio = indInicio + 1;
			indAux = indAux + 1;

		}else{
			vAux[indAux] =V[indMeio];
			indMeio = indMeio + 1;
			indAux = indAux + 1;
		}

	}

	for (indInicio = inicio; indInicio <= fim ; indInicio = indInicio + 1)
	{
		V[indInicio] = vAux[indInicio - inicio];
	}
 
}

MergeSort::~MergeSort(){
	delete [] vAux;
}

int main(){  
	
	int V[] = {7, 6, 5, 4, 8, 22, 3, 55, 7, 99, 11, 3, 1, 88};
	int tam_tipo = sizeof(int);
	int tam_vet = sizeof(V)/tam_tipo;
	MergeSort *m = new MergeSort(tam_vet-1); // por alguma razão aparente se não colocasse o -1 o vetor era lido ate a posiçao 14. mas ele so vai de 0 até 13.
	m->mergeSort(V,0,tam_vet-1);
	for(int i = 0; i < tam_vet; i++){
		cout<<V[i]<<endl;
	}

}