#include <iostream>
#include <stdio.h>
#include "TListaDEncad.h"

using namespace std;


int main(){

	TListaDEncad *ld = new TListaDEncad();


	ld->InserePri(2.5); // insere primeiro elemento
    ld->InserePri(2.9); 
    ld->Inicio();
    ld->InsereDirIt(5.1);
    ld->InsereEsqIt(7.9);
    ld->EliminaDirIt();
    ld->EliminaEsqIt();
    ld->InsereDirFinal(1.2);
    ld->InsereEsqFinal(3.7);
    ld->ELiminaEsqFinal();
    ld->ELiminaDirFinal();
	ld->Inicio();
	while(!ld->FimDaLista()){ //verifica se it chegou ao final
		cout << ld->Consulta() << endl;
		ld->ProximoNo(); 
	}
	delete ld;//desaloca a lista criada
	return 0;

};