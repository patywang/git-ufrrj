#include <iostream>
#include <stdio.h>
#include "ListaSEncad.h"

using namespace std;


int main(){
	ListaSEncad *l = new ListaSEncad();
	
  
    l->InserePri(2.5); 
    l->InserePri(2.9); 
	l->Inicio(); 
	l->InsereAnt(5.0);  
	l->InsereAnt(5.7);   
//-----------------------------------SEMANA 2----------------------------------------------------//
	l->InsereUlt(); 
//-----------------------------------SEMANA 2----------------------------------------------------//
	l->EliminaPri();
	l->EliminaIt();   
	l->Inicio();
	while(!l->FimDaLista()){ 
		cout << l->Consulta() << endl;
		l->ProximoNo(); 
	}
	delete l;
	return 0;

};