#include <iostream>
#include <stdlib.h>
#include "TMatTriangSup.h"
using namespace std;

TMatTriangSup::TMatTriangSup(int ordemMatriz)
{
	n = ordemMatriz;
	int m = n*(n+1)/2;
	vet = new float[m];
}

bool TMatTriangSup::Verifica(int i,int j)
{
	if( (i>=0 && i<n) && (j>=0 &&j<n)){
		return true;
	}else{
		return false;
	}
}

float TMatTriangSup::Consulta(int i, int j)
{
	if(Verifica(i,j)){
		if(i<=j){
			int k = i*(i+1)/2+j;
			return vet[k];
		}else{
			return 0.0;
		}
	}else{
		cout <<"nao consulta: indice invalido"<<endl;
	}
	exit(1);	
}

void TMatTriangSup::Atribui(int i,int j, float valor)
{
	if(Verifica(i,j)){
		
		if(i<=j){
			int k = i*(i+1)/2+j;
			vet[k] = valor;
		}else{
			if(valor != 0.0){
				cout<<"Não atribui: elemento ["<<i<<","<<j<<"] fora do triangulo inferior"<<endl;
			}
		}
	}else{
		cout <<"nao consulta: indice invalido"<<endl;
	}
	
}

void TMatTriangSup::Imprime()
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

TMatTriangSup::~TMatTriangSup()
{
	delete [] vet;
}