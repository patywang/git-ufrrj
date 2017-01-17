#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "ListaSEncad.h"

using namespace std;

ListaSEncad::ListaSEncad()
{
    pri = NULL;
    it = NULL;
}

float ListaSEncad::Consulta()
{
    if(it != NULL){
        return it->consultaInfo();
    }else{
        cout << "Erro: n� inv�lido!" << endl;
        exit(1);
    }
}

void ListaSEncad::Atribui(float val)
{
    if(it != NULL){
        it->atribInfo(val);
    }else{
        cout << "Erro: n� inv�lido!" << endl;
    }
}    

bool ListaSEncad::Busca(float val)
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

void ListaSEncad::Inicio()
{
    it = pri;
}
void ListaSEncad::ProximoNo()
{
    it = it->consultaProx();
}
bool ListaSEncad::FimDaLista()
{
     return (it == NULL);
}
void ListaSEncad::InserePri(float val)
{ // insere No contendo val no início da lista
    No *p = new No(); // cria No apontado por p
    p->atribInfo(val); // preenche info com val
    p->atribProx(pri); // prox recebe atual pri
    pri = p;
}

void ListaSEncad::InsereAnt(float val)
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
}

//------------------------------------INSERE ULTIMO ALTERADA PARA VALORES DIF DE -1-------------------------------------//

void ListaSEncad::InsereUlt()
{

    int val=0;

    do{

        cin>>val;

        if(val != -1){

            if(pri == NULL){  // poderia ter colocado nessa condição que a lista estaria vazia.
                No *aux = new No();
                 //inserção de um elemento para não deixá-la vazia
                aux->atribInfo(val);
                pri = aux;
                
            }
            else{

                No *p = new No();
                p->atribInfo(val);
                No *t = pri;
              
                while( t != NULL){
                    if(t->consultaProx() == NULL){
                        t->atribProx(p);
                        break;
                    }
                    t=t->consultaProx();
                }
            
            }
        }
    }while(val !=-1);
    cout<<"------------imprimindo--------"<<endl;
}
//--------------------------------------------------------------------------------------------------------------------//
void ListaSEncad::EliminaPri()
{ 
    No *p;
    if(pri != NULL){ 
        p = pri; 
        
        pri = p->consultaProx();
        if (it == p){
            it = pri;
        }
        delete p; //exclui!!
    }else{ 
    exit(1);
    }
}

void ListaSEncad::EliminaIt()
{
    No *p;
    if(pri != NULL){
         if(pri == it){
             EliminaPri();  // eliminação direta caso tenha um unico elemento
             return;
         }
         if(it == NULL){    // o iterador sendo nulo não ha motivo para exclusão
            exit(3);
         }
         p = pri; 
         while(p->consultaProx() != it){
            p=p->consultaProx();
         }
         p->atribProx(it->consultaProx()); //p atribui elemento q anteriormente era apontado pelo iterador
         delete it;
         it = p;
    }else{
        exit(2);
    }
}

void ListaSEncad::EliminaUlt()
{
    No *p;
    No *t;
    if(pri != NULL){
        p = pri;
        t = p->consultaProx();
        if (t == NULL){  // se t for null e so tiver um elemento na lista...
            delete pri;
            pri = NULL;
            return;
        }
        while(t->consultaProx() != NULL){
            p=p->consultaProx();
            t=t->consultaProx(); // ou seja o t de um elemento apontado será direcionada para outro 
            //elemento para consulta q na qual posuirá o t e assim sucessivamente durante a condição
        } 
        p->atribProx(NULL);
        if(t == it){
            it = NULL;
        }
        delete t;
    }
}

ListaSEncad::~ListaSEncad()
{
    No *p = pri;
    while(p != NULL)
    {
        No *t = p->consultaProx();
        delete p; p = t;
    }
}

