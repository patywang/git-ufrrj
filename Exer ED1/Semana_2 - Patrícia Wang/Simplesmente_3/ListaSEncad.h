#ifndef LISTASENCAD_H
#define LISTASENCAD_H


#include "No.h"

class ListaSEncad{
    private: No *pri; // ponteiro para o primeiro No da lista
    No *it; //ponteiro auxiliar para percorrer a lista

    public:
        ListaSEncad();
        float Consulta();
        void Atribui(float val);
        bool Busca(float val); // operações para percorrer a lista
        void Inicio(); // coloca o ponteiro it no início
        void ProximoNo(); // avança o ponteiro it
        void InserePri(float val);
        bool FimDaLista(); // verifica se it está no final
        void InsereAnt(float val);
	    void InsereUlt();
        void EliminaPri();
	    void EliminaIt();
	    void EliminaUlt();
        ~ListaSEncad();
};
#endif // LISTASENCAD_H