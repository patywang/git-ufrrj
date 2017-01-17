#include "No.h"

No::No() {}
float No::consultaInfo(){ return info; }
No *No::consultaProx(){ return prox; }
No *No::consultaAnt() { return ant; }
void No::atribInfo(float val) { info = val; }
void No::atribProx(No *p){ prox = p; }
void No::atribAnt(No *p){ ant = p; }
No::~No() {}
