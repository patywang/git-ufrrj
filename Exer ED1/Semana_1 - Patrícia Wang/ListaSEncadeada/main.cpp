#include <iostream>
#include <stdio.h>
#include "ListaSEncad.h"

using namespace std;


int main(){
	ListaSEncad *l = new ListaSEncad();
	

    l->InserePri(2.5); // insere primeiro elemento
    l->InserePri(2.9); 

    // nova sequencia da estrutura  2.9 -> 2.5

	l->Inicio(); //coloca o ponteiro it no início da lista

	l->InsereAnt(5.0);  // insere antes do iterador it que nesse caso it==pri

	// nova sequencia da estrutura 5.0 -> 2.9 -> 2.5

	l->InsereAnt(5.7);   // insere novo elemento e it != pri 

	//nova sequencia da estrutura 5.0-> 5.7 -> 2.9 -> 2.5

	l->InsereUlt(6.4); //insere ultimo elemento na lista

	//nova sequencia da estrutura 5.0 -> 5.7 ->2.9 -> 2.5 ->6.4   t* percorrerá até p fim da lista.

	l->EliminaPri();

	// nova sequencia da estrutura 5.7 -> 2.9 -> 2.5 -> 6.4

	l->EliminaIt();  // elimina val que o it estiver apontando 

	// nova sequencia da estrutura 5.7 -> 2.5 -> 6.4

	l->EliminaUlt();  // elimina o ultimo elemento da lista fazendo o seu antecessor apontar para null

	// nova sequencia de estrutura 5.7 -> 2.5
	
	l->Inicio();
	while(!l->FimDaLista()){ //verifica se it chegou ao final
		cout << l->Consulta() << endl;
		l->ProximoNo(); 
	}
	delete l;//desaloca a lista criada
	return 0;

};