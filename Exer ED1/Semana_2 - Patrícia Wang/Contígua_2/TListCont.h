
class TListCont{
	private:
		int m;         //capacidade maxima de elementos do vetor
		int ultimo;   // indice do ultimo nó da lista
		float *X;
		int primeiro;
	public:
		TListCont(int tam);
		float Consulta(int k);
		void Insereult(); 
		void EliminarNo();
		~TListCont();     
};



