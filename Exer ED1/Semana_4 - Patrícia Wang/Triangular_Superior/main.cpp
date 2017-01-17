#include <iostream>
#include <stdlib.h>
#include "TMatTriangSup.h"
using namespace std;

int main(){
	int tam = 5;
	int i=0, j=0, val=1;
	TMatTriangSup *s = new TMatTriangSup(tam);
	for( i = 0; i < tam; i++){
		for (j = 0; j< tam; j++){
			s->Atribui(i,j,val);
			val++;
		}
	}
	cout<<endl;
	s->Imprime();
}