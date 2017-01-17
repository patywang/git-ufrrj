#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "TListaDEncad.h"

using namespace std;

TListaDEncad::TListaDEncad()
{
    pri = NULL;
    it = NULL;
    ult = NULL;
    n=0;
}

float TListaDEncad::Consulta()
{
    if(it != NULL){
        return it->consultaInfo();
    }else{
        cout << "Erro: n� inv�lido!" << endl;
        exit(1);
    }
}

void TListaDEncad::Atribui(float val)
{
    if(it != NULL){
        it->atribInfo(val);
    }else{
        cout << "Erro: n� inv�lido!" << endl;
    }
}    

bool TListaDEncad::Busca(float val)
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

void TListaDEncad::Inicio()
{
    it = pri;
}
void TListaDEncad::ProximoNo()
{
    it = it->consultaProx();
}
bool TListaDEncad::FimDaLista()
{
     return (it == NULL);
}
void TListaDEncad::InserePri(float val)
{ // insere No contendo val no início da lista
    No *p = new No(); // cria No apontado por p
    p->atribInfo(val); // preenche info com val
    p->atribProx(pri); // prox recebe atual pri
    p->atribAnt(NULL);
    
    if(n==0){
        ult = p;
    }else{
        pri->atribAnt(p);
    }
    pri = p;
    n++;
}
void TListaDEncad::InsereDirIt(float val)
{
  

    No *p = new No();
    p->atribInfo(val);
    
    if( it == NULL){
        exit(1);
    }else{
         No *aux = it->consultaProx();
         it->atribProx(p);
         p->atribProx(aux);
         p->atribAnt(it);
         if (aux != NULL){
             aux->atribAnt(p);
         }else{
            ult = p;
         }
    }
    n++;   

}
void TListaDEncad::InsereEsqIt(float val){

    No *p = new No();
    p->atribInfo(val);

    if(it==NULL){
        exit(1);
    }else if(it == pri){
        p->atribProx(it);
        it->atribAnt(p);
        pri = p;
        p->atribAnt(NULL);
    }else{
        No *aux = it->consultaAnt();
        aux->atribProx(p);
        p->atribAnt(aux);
        p->atribProx(it);
        it->atribAnt(p);
    }
    n++;

}


void TListaDEncad::EliminaPri()
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

void TListaDEncad::EliminaDirIt()
{

    if(it!=NULL){
        No *t = it->consultaProx();
        if(t != NULL){
            No *y = t->consultaProx();
            it->atribProx(y);
            y->atribAnt(it);
            delete t;
            n--;
            if(n==0){
                ult=NULL;
            }
        }
    }else{
        exit(1);
    }
}

void TListaDEncad::EliminaEsqIt()
{
    if(it==NULL){
        exit(1);
    }else if(it == pri){
        exit(2);
    }else{
        No *aux = it->consultaAnt();
        if(aux == pri){
            pri=it;
            delete aux;
        }else{
            No *aux2 = aux->consultaAnt();
            aux2->atribProx(it);
            it->atribAnt(aux2);
            delete aux;
        }
        n--;
        if(n==0){
            ult=NULL;
        }
    }
}

void TListaDEncad::InsereDirFinal(float val)
{
    No *u = new No();
    u->atribInfo(val);
    if(ult == NULL){
        exit(1);
    }else{
        ult->atribProx(u);
        u->atribAnt(ult);
        u->atribProx(NULL);
        ult = u;
    }
    n++;
    if(n==1){
        ult = u;
    }
}

void TListaDEncad::InsereEsqFinal(float val)
{
    No *u = new No();
    u->atribInfo(val);
    if(ult == pri){
        u->atribProx(ult);
        ult->atribAnt(u);
        ult->atribProx(NULL);
        u->atribAnt(NULL);
        pri = u;
    }else{
        No *aux = ult->consultaAnt();
        aux->atribProx(u);
        u->atribAnt(aux);
        u->atribProx(ult);
        ult->atribAnt(u);
    }
    n++;
   

}

void TListaDEncad::ELiminaDirFinal()
{
    cout<<"não dá p eliminar um elemento que é vazio!"<<endl;
}

void TListaDEncad::ELiminaEsqFinal()
{
    if(ult==pri){
        exit(1);
    }else{
        No *ant = ult->consultaAnt();
        if(ant==pri){
            pri=ult;
            delete ant;
        }else{
            No *aux2 = ant->consultaAnt();
            aux2->atribProx(ult);
            ult->atribAnt(aux2);
            ult->atribProx(NULL);
            delete ant;
        }
        n--;
        if(n == 0){
            ult = NULL;
        }
    }
}

TListaDEncad::~TListaDEncad()
{
    No *p = pri;
    while(p != NULL)
    {
        No *t = p->consultaProx();
        delete p; p = t;
    }
}

