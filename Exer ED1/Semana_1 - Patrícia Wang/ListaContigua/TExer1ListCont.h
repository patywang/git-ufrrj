
class TExer1ListCont{
	private:
		int m;         //capacidade maxima de elementos do vetor
		int ultimo;   // indice do ultimo nó da lista
		float *X;
		int primeiro;
	public:
		TExer1ListCont(int tam);
		float Consulta(int k);
		void Atribui(int k, float val);
		void Inserek(int k, float val);  //insere antes de x k
		void Insereult(float val); // insere ultimo no
		void Eliminak(int k); // elimina No x k
		void Eliminault(); // elimina ultimo No
		~TExer1ListCont();     // elimina ultimo No
};



