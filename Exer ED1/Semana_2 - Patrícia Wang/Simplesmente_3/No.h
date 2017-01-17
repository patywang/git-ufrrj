#ifndef NO_H
#define NO_H


class No
{
    private:
        float info; // informação real do No
        No *prox; // ponteiro para o próximo No
    public:
        No();
        float consultaInfo();
        No *consultaProx();
        void atribInfo(float val);
        void atribProx(No *p);
        ~No();
};


#endif // NO_H