#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "TListaDesc.h"

using namespace std;

TListaDesc::TListaDesc()
{
    pri = NULL;
    it = NULL;
    ult = NULL;
    it = NULL;
}

float TListaDesc::Consulta()
{
    if(it != NULL){
        return it->consultaInfo();
    }else{
        cout << "Erro: n� inv�lido!" << endl;
        exit(1);
    }
}

void TListaDesc::Atribui(float val)
{
    if(it != NULL){
        it->atribInfo(val);
    }else{
        cout << "Erro: n� inv�lido!" << endl;
    }
}    

bool TListaDesc::Busca(float val)
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

void TListaDesc::Inicio()
{
    it = pri;
}
void TListaDesc::ProximoNo()
{
    it = it->consultaProx();
}
bool TListaDesc::FimDaLista()
{
     return (it == NULL);
}
void TListaDesc::InserePri(float val)
{ // insere No contendo val no início da lista
    No *p = new No(); // cria No apontado por p
    p->atribInfo(val); // preenche info com val
    p->atribProx(pri); // prox recebe atual pri
    pri = p;
    n++;
    if(n==1){
        ult = p;
    }
}

void TListaDesc::InsereDir(float val)
{

    No *p = new No();
    p->atribInfo(val);
    No *aux = it->consultaProx();
    if( it == NULL){
        exit(1);
    }else{
        
         it->atribProx(p);
         p->atribProx(aux);
    }
    n++;
   
}

void TListaDesc::InsereEsq(float val)
{
    No *p = new No();
    p->atribInfo(val);
    No *t = pri;
        if( it == pri){
            p->atribProx(pri);
            pri = p;
        }else{
            while( t != it){
                if(t->consultaProx() == it){
                    t->atribProx(p);
                    p->atribProx(it);
                    break;
                }
            t=t->consultaProx();
            }
        }
    n++;
    
}

void TListaDesc::EliminaPri()
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
        }
    }else{ 
    exit(1);    
    }
}

void TListaDesc::EliminaProxDir()
{
   
    if(it != NULL){

        No *t = it->consultaProx();
        if(t != NULL){

            No *y = t->consultaProx();
            if(y !=NULL){ 
                it->atribProx(y);
                delete t;
                n--;
                if(n==0){
                ult=NULL;
                }

            }
        }

    }else{
        exit(2);
    }
}

void TListaDesc::EliminaProxEsq()
{
    
    if(it==NULL){
        exit(1);
    }else if(it == pri){
        exit(2);
    }else{
        No *p = pri;
        while(p != it){    
            if (p->consultaProx()==it){
                No *aux = pri;
                while(aux != p){
                    if(aux->consultaProx()==p){
                        aux->atribProx(it);
                        delete p;
                        n--;
                        if(n==0){
                            ult=NULL;
                        }
                        break;
                    }
                    aux=aux->consultaProx();
                }
                break;
            }
               
            p=p->consultaProx();
        }
    }

}

void TListaDesc::InsereDirFinal(float val){

    No *u = new No();
    u->atribInfo(val);
  //  cout<< ult->consultaInfo() <<endl;
    if(ult == NULL){
        exit(1);
    }else{
        ult->atribProx(u);
        u->atribProx(NULL);
        ult = u;
    }
    n++;
}

void TListaDesc::InsereEsqFinal(float val){

    No *u = new No();
    u->atribInfo(val);
    No *t = pri;
        if( ult == pri){
            u->atribProx(pri);
            pri = u;
        }else{
            while( t != ult){
                if(t->consultaProx() == ult){
                    t->atribProx(u);
                    u->atribProx(ult);
                    break;
                }
            t=t->consultaProx();
            }
        }
    n++;
    
}

void TListaDesc::EliminaProxDirFinal(){
    cout<<"não dá p eliminar um elemento que é NULL!"<<endl;
} 

void TListaDesc::EliminaProxEsqFinal()
{
    if(ult==NULL){
        exit(1);
    }else if(ult == pri){
        exit(2);
    }else{
        No *p = pri;
        while(p != ult){    
            if (p->consultaProx()==ult){
                No *aux = pri;
                while(aux != p){
                    if(aux->consultaProx()==p){
                        aux->atribProx(ult);
                        delete p;
                        n--;
                        if(n==0){
                            ult=NULL;
                        }
                        break;
                    }
                    aux=aux->consultaProx();
                }
                break;
            }
               
            p=p->consultaProx();
        }
    }
}


TListaDesc::~TListaDesc()
{
    No *p = pri;
    while(p != NULL)
    {
        No *t = p->consultaProx();
        delete p; p = t;
    }
}

