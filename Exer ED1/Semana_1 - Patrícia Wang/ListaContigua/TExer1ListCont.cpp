#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include "TExer1ListCont.h"
using namespace std;

TExer1ListCont::TExer1ListCont(int tam){

	m = tam;
	ultimo = -1;
	primeiro = 0;
	X = new float[m];
}

float TExer1ListCont::Consulta(int k){
	
	if(k >= primeiro && k <= ultimo){
		return X[k];
	}else{
		cout << "Indice invalido!" << endl;
		exit(1);
	}
}

void TExer1ListCont::Atribui(int k, float val){
	
	if(k >= primeiro && k <= ultimo){
		X[k] = val;
	}else{
		cout << "Indice invalido!" << endl;
		exit(2);
	}
}

void TExer1ListCont::Inserek(int k, float val){ // insere No contendo val antes do No x k
    
	if(ultimo == (m - 1)){
		cout << "Vetor Cheio!" << endl;
		exit(3);
	}

	if(k >= primeiro && k <= ultimo){

		for(int i = ultimo; i >= k; i--){
			X[i+1] = X[i];
		}	
		X[k] = val;
		ultimo = ultimo + 1;
		
		
	}else {
		cout << "Indice invalido!" << endl;
		exit(4);
	}
}

void TExer1ListCont::Insereult(float val){// insere No contendo val como ultimo No da lista
  
	if(ultimo == (m - 1)){
		cout << "Vetor Cheio!" << endl;
		exit(3);
	}
	
	ultimo = ultimo + 1;
	if(ultimo == 0){
		cout <<"entre com o primeiro nó" << endl;
		cin >> primeiro;
		ultimo = primeiro;
	}
	X[ultimo] = val;
  
}

void TExer1ListCont::Eliminak(int k){ // elimina No x k

	if(k >= primeiro && k <= ultimo){
		for(int i = k; i <= ultimo-1; i++){
			X[i] = X[i+1];
		}
	ultimo = ultimo - 1;
	}else{
		cout << "Indice invalido!" << endl;
	exit(5);
	}
}

void TExer1ListCont::Eliminault(){ // elimina o ultimo No da lista

	if(ultimo == -1){
		cout << "Lista Vazia!" << endl;
		exit(6);
	}
	ultimo = ultimo - 1;
}

TExer1ListCont::~TExer1ListCont(){
	delete [] X;
}

