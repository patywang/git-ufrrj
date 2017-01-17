#ifndef TLISTADENCAD_H
#define TLISTADENCAD_H
#include "No.h"

class TListaDEncad
{

	private: 
    	No *pri; // ponteiro para o primeiro No da lista
        No *it; //ponteiro auxiliar para percorrer a lista
        No *ult;//ponteiro para o ultimo no da lista
        int n; // numero corrente de nos da lista.
    public:
        TListaDEncad();
        float Consulta();
        void Atribui(float val);
        bool Busca(float val); // operações para percorrer a lista
        void Inicio(); // coloca o ponteiro it no início
        void ProximoNo(); // avança o ponteiro it
        void InserePri(float val);
        void InsereDirIt(float val);
        void InsereEsqIt(float val);
        void InsereDirFinal(float val);
        void InsereEsqFinal(float val);
        void EliminaPri();
        void EliminaDirIt();
        void EliminaEsqIt();
        void ELiminaDirFinal();
        void ELiminaEsqFinal();
        bool FimDaLista(); // verifica se it está no final
		~TListaDEncad();
};

#endif // TLISTADENCAD_H