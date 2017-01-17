#include <iostream>
#include <stdlib.h>
#include "TMatDiag.h"
using namespace std;

TMatDiag::TMatDiag(int k)
{
	n = k;
	int tam = n;
	vet = new float[tam];
}

bool TMatDiag::Verifica(int i, int j)
{
	if((i >= 0 && i < n)&&(j >= 0 && j < n)){
		return true;
	}else{
		return false;
	}
}

float TMatDiag::Consulta(int i, int j)
{
	if(Verifica(i,j)){
		return i==j ? vet[i] : 0.0;
	}else{
		cout<<"indice invalido - consulta"<<endl;
	}
	exit(1);
}

void TMatDiag::Atribui(int i, int j , float valor)
{
	if(Verifica(i,j)){
		if(i==j){
			vet[i] = valor;
		}else if(valor!=0.0){
			cout<<"Não atribui: elemento ["<<i<<","<<j<<"] fora do triangulo inferior"<<endl;
		}
	}else{
		cout<<"indice invalido - atribuicao"<<endl;
	}
}

void TMatDiag::Imprime()
{	
	int i,j;
	float val;
	for(i = 0; i<n;i++){
		for (j = 0; j< n; j++){
			val = Consulta(i,j);
			cout<<val<<"\t";
		}
		cout<<endl;
	}

}

TMatDiag::~TMatDiag()
{
	delete [] vet;
}