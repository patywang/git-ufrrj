#ifndef NO_H
#define NO_H


class No
{
    private:
        float info; // informação real do No
        No *prox; // ponteiro para o próximo No
        No *ant; //no para o ponteiro anterior
    public:
        No();
        float consultaInfo();
        No *consultaProx();
        No *consultaAnt();
        void atribInfo(float val);
        void atribProx(No *p);
        void atribAnt(No *p);
        ~No();
};


#endif // NO_H