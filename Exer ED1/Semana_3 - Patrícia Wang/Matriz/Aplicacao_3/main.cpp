#include <iostream>
#include <stdlib.h>
#include "TMatriz2D.h"
using namespace std;

int main(){

	int tam1=5,tam2=5;
	int i=0, j=0, val=0;

	TMatriz2D *m = new TMatriz2D(tam1,tam2);
	for( i = 0; i< tam1; i++){
		for (j = 0; j< tam2; j++){
			m->Atribui(i,j,val);
			val++;
		}
	}
	m->Imprime(); 
	cout<<endl;
    m->Coluna4(); // imprimir coluna 4
	m->Alterar(); //alterar valor no indice 
	m->Imprime();
	m->Transposta(); //transposta da matriz
	m->DiagSecundaria(); //diagonal secundaria


}