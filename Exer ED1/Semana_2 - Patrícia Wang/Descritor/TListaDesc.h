#ifndef TLISTADESC_H
#define TLISTADESC_H


#include "No.h"

class TListaDesc{
    private: No *pri; // ponteiro para o primeiro No da lista
    No *it; //ponteiro auxiliar para percorrer a lista
    No *ult;//ponteiro para o ultimo no da lista
    int n; // numero corrente de nos da lista.
    public:
        TListaDesc();
        float Consulta();
        void Atribui(float val);
        bool Busca(float val); // operações para percorrer a lista
        void Inicio(); // coloca o ponteiro it no início
        void ProximoNo(); // avança o ponteiro it
        void InserePri(float val);
        bool FimDaLista(); // verifica se it está no final
        void InsereDir(float val);
        void InsereEsq(float val);
        void InsereDirFinal(float val);
        void InsereEsqFinal(float val);
     //   void InsereAnt(float val);
	 //   void InsereUlt(float val);
        void EliminaPri();
        void EliminaProxDir();
        void EliminaProxEsq();
        void EliminaProxDirFinal();
        void EliminaProxEsqFinal();
      
	 //   void EliminaIt();
	 //   void EliminaUlt();

        ~TListaDesc();
};
#endif // TLISTADESC_H