#include <iostream>
#include <stdlib.h>
#include "TMatriz2D.h"
using namespace std;

TMatriz2D::TMatriz2D(int nnl,int nnc)
{
	nl = nnl;
	nc = nnc;
	mat = new float*[nl];
	for (int i = 0;i < nl; i++){
		mat[i]= new float[nc];
	}
}

bool TMatriz2D::Verifica(int i, int j)
{
	if((i>= 0 && i < nl) && (j>=0 && j < nc)){
		return true;
	}else{
		return false;
	}
}

float TMatriz2D::Consulta(int i, int j)
{
	if(Verifica(i,j)){
		return mat[i][j];
	}else{
		cout<<"indice invalido - Consulta"<<endl;
	}
	exit(1);
}

void TMatriz2D::Atribui(int i, int j , float valor)
{
	if(Verifica(i,j)){
		mat[i][j]= valor;
	}else{
		cout<<"indice invalido - atribuicao"<<endl;
	}
}


TMatriz2D::~TMatriz2D(){
	for(int i=0;i<nl;i++){
		delete [] mat [i];
	}
	delete [] mat;
}