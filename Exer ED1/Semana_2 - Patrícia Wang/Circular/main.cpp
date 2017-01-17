#include <iostream>
#include <stdio.h>
#include "TListaCirc.h"

using namespace std;


int main(){

	TListaCirc *c = new TListaCirc();


	c->InserePri(2.5); // insere primeiro elemento
    c->InserePri(2.9); 
    c->Inicio();
    c->InsereDirIt(9.6);
    c->EliminaEsqIt();
	c->Inicio();
	
	c->ImpressaoDaListaCircular();
	
	delete c;
	return 0;

};