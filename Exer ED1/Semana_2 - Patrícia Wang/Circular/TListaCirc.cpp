#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "TListaCirc.h"

using namespace std;

TListaCirc::TListaCirc()
{
    pri = NULL;
    it = NULL;
    ult = NULL;
    n=0;
}

float TListaCirc::Consulta()
{
    if(it != NULL){
        return it->consultaInfo();
    }else{
        cout << "Erro: n� inv�lido!" << endl;
        exit(1);
    }
}

void TListaCirc::Atribui(float val)
{
    if(it != NULL){
        it->atribInfo(val);
    }else{
        cout << "Erro: n� inv�lido!" << endl;
    }
}    

bool TListaCirc::Busca(float val)
{
    No *p;
    for(p = pri; p != NULL; p = p->consultaProx())
    {
        if(p->consultaInfo() == val){
            return true;
        }
    }
    return false;
}

void TListaCirc::Inicio()
{
    it = pri;
}
void TListaCirc::ProximoNo()
{
    it = it->consultaProx();
}
bool TListaCirc::FimDaLista()
{
        return (it == NULL);    
}
void TListaCirc::ImpressaoDaListaCircular(){

    No *aux = pri;
    while(aux != ult){ 
        cout <<Consulta() << endl;
        ProximoNo(); 
        aux = aux->consultaProx();     
    }
    cout <<Consulta() << endl;
    exit(1);
}

void TListaCirc::InserePri(float val)
{ // insere No contendo val no início da lista
    No *p = new No(); // cria No apontado por p
    p->atribInfo(val); // preenche info com val
    
    if(n==0){
        p->atribProx(p);
        p->atribAnt(p);
        ult = p;
    }else{
        p->atribProx(pri);
        p->atribAnt(ult);
        pri->atribAnt(p);
        ult->atribProx(p);
    }
    pri = p;
    n++;
    

}
void TListaCirc::InsereDirIt(float val)
{
   
  
    No *p = new No();
    p->atribInfo(val);
    
    if(it == NULL){
        exit(1);
    }else{
        No *aux = it->consultaProx();
        it->atribProx(p);
        p->atribProx(aux);
        p->atribAnt(it);
        if(aux != NULL){
            aux->atribAnt(p);
            if(aux==ult){
                aux->atribProx(pri);
                pri->atribAnt(aux);
            }

        }else{
            ult = p;
        }
    }
    n++;
}

void TListaCirc::EliminaPri()
{ 
    No *p;
    if(pri != NULL){ 
        p = pri; 
        
        pri = p->consultaProx();
       /* if (it == p){
            it = pri;
        }*/

        delete p; //exclui!!
        n --;
        if(n==0){
            ult=NULL;
        }else{
            pri->atribAnt(NULL);
        }
    }else{ 
    exit(1);    
    }
}

void TListaCirc::EliminaEsqIt()
{

   if(it == NULL){
        exit(1);
    }else{
        No *aux = it->consultaAnt();
        if (aux == ult){
            No *aux2 = ult->consultaAnt();
            aux2->atribProx(pri);
            pri->atribAnt(aux2);
            delete aux;
            ult  = aux2;
        }else{
            No *aux3 = aux->consultaAnt();
            aux3->atribProx(it);
            it->atribAnt(aux3);
            delete aux;
        }
        n--;
        if(n==0){
            ult=NULL;
        }
    }

}


TListaCirc::~TListaCirc()
{
    No *p = pri;
    while(p != NULL)
    {
        No *t = p->consultaProx();
        delete p;
        p = t;
    }
}

