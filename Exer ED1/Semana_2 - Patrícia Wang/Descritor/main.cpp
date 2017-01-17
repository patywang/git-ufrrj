#include <iostream>
#include <stdio.h>
#include "TListaDesc.h"

using namespace std;


int main(){

	TListaDesc *ld = new TListaDesc();


	ld->InserePri(2.5); 
    ld->InserePri(2.9); 


	ld->Inicio(); 

	ld->InsereDir(3.4);  // insere a direita do it
	ld->InsereEsq(7.6);  // insere esquerda do it
	ld->InsereEsq(6.5);
	ld->EliminaProxDir(); //elimina a direita do it
	ld->EliminaProxEsq(); //elimina a esquerda do it
    ld->InsereDirFinal(0.5);
	ld->InsereEsqFinal(9.9);
	ld->EliminaProxEsqFinal();
	ld->EliminaProxDirFinal();
	ld->Inicio();

	while(!ld->FimDaLista()){ 
		cout << ld->Consulta() << endl;
		ld->ProximoNo(); 
	}
	delete ld;
	return 0;

};