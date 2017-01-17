#include <iostream>
#include <cstdlib>
#include "TListCont.h"
using namespace std;

TListCont::TListCont(int tam){

	m = tam;
	ultimo = -1;
	X = new float[m];
}

float TListCont::Consulta(int k){
	
	if(k >= 0 && k <= ultimo){
		return X[k];
	}else{
		cout << "Indice invalido!" << endl;
		exit(1);
	}
}
void TListCont::Insereult(){
  
  	int val = 0;
  	do{
  		cin>>val;
	  	if(val!= -1){
			if(ultimo == (m - 1)){
				cout << "Vetor Cheio!" << endl;
				exit(3);
			}
			ultimo = ultimo + 1;
			X[ultimo] = val;
			//teste
			cout<<"posicao:"<<endl;
			cout<<ultimo<<endl;
			cout<<"val:"<<endl;
			cout<<val<<endl;
			cout<<"----------"<<endl;
		}
	}while(val != -1);
	
}

void TListCont::EliminarNo()
{
	int val=0;
	int k=0;


	cout<<"entre com o valor que vc deseja eliminar:"<<endl;
	cin>>val;

	if(k >= 0 && k <= ultimo){
		for(int i = k; i <= ultimo-1; i++){
			if(X[k]==val){
				X[i] = X[i+1];
			}
		}
	ultimo = ultimo - 1;
	}

	
}

TListCont::~TListCont(){
	delete [] X;
}

