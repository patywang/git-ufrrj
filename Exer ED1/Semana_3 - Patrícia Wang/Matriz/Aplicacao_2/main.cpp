#include <iostream>
#include <stdlib.h>
#include "TMatriz2D.h"
using namespace std;

int main(){
	int tam1=4,tam2=4;
	int i=0, j=0;
	TMatriz2D *m = new TMatriz2D(tam1,tam2);
	for( i = 0; i< tam1; i++){
		for (j = 0; j< tam2; j++){
			m->Atribui(i,j,i+1);
		}
	}
	for(i = 0; i<tam1;i++){
		for (j = 0; j< tam2; j++){
			float val = m->Consulta(i,j);
			cout<<val<<"\t";
		}
		cout<<endl;
	}

}