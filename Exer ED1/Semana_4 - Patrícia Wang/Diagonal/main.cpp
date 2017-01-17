#include <iostream>
#include <stdlib.h>
#include "TMatDiag.h"
using namespace std;

int main(){
	int tam = 5;
	int i=0, j=0, val=1;
	TMatDiag *d = new TMatDiag(tam);
	for( i = 0; i< tam; i++){
		for (j = 0; j< tam; j++){
			d->Atribui(i,j,val);
			val++;
		}
	}
	cout<<endl;
	d->Imprime();

}