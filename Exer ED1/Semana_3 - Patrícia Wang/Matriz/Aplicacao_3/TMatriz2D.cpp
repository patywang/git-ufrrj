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

void TMatriz2D::Coluna4()
{
	int i = 0;
	cout<<"coluna 4"<<endl;   
	for(i = 0; i<nl;i++){  
		float val = Consulta(i,3);
		cout<<val<<"\t";
		cout<<endl;
	}
}
void TMatriz2D::Alterar()
{
	int i=0,j=0,valor=0;
	cout<<"entre com a linha e a coluna respectivamente"<<endl;
	cin>>i>>j;
	if(Verifica(i,j)){
		cout<<"entre com um valor"<<endl;
		cin>>valor;
		mat[i][j] = valor;
	}else{
		cout<<"indice invalido - alterar"<<endl;
	}
}

void TMatriz2D::Transposta()
{
	int i,j;
	int mat2[5][5];

	cout<<"transposta"<<endl;
	for (i=0; i< nl; i ++ ){
		for (j=0; j<nc;j++){
	        mat2[j][i] = mat[i][j];
		}
	}

	for (i=0; i< nc; i ++ ){
		for (j=0; j<nl;j++){
	    cout<< mat2[i][j] <<"\t";
		}
		cout<<endl;
	}
}

void TMatriz2D::DiagSecundaria()
{
	cout<<"DiagSecundaria"<<endl;
	int i = 0,  j = nc-1;
	do{
		cout<<mat[i][j]<<endl;
		i++;
		j--;
	}while (Verifica(i,j));
}

void TMatriz2D::Imprime()
{	
	int i,j;
	float val;
	for(i = 0; i<nl;i++){
		for (j = 0; j< nc; j++){
			val = Consulta(i,j);
			cout<<val<<"\t";
		}
		cout<<endl;
	}

}

TMatriz2D::~TMatriz2D(){
	for(int i=0;i<nl;i++){
		delete [] mat [i];
	}
	delete [] mat;
}