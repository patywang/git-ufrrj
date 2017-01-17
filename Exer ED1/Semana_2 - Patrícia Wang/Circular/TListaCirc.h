#ifndef TLISTACIRC_H
#define TLISTACIRC_H
#include "No.h"

class TListaCirc
{

	private: 
    	No *pri; // ponteiro para o primeiro No da lista
        No *it; //ponteiro auxiliar para percorrer a lista
        No *ult;//ponteiro para o ultimo no da lista
        int n; // numero corrente de nos da lista.
    public:
        TListaCirc();
        float Consulta();
        void Atribui(float val);
        bool Busca(float val); // operações para percorrer a lista
        void Inicio(); // coloca o ponteiro it no início
        void ProximoNo(); // avança o ponteiro it
        void InserePri(float val);
        void InsereDirIt(float val);
        void EliminaPri();
        void EliminaEsqIt();
        void ImpressaoDaListaCircular();
        bool FimDaLista(); // verifica se it está no final
        ~TListaCirc();
};

#endif // TLISTACIRC_H