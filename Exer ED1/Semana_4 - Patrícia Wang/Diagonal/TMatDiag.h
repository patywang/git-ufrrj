#ifndef TMATDIAG_H
#define TMATDIAG_H
class TMatDiag
{
	private:
		int n; //numero de linhas e colunas
		float *vet;
		bool Verifica(int i,int j);
	public:
		TMatDiag(int k);
		float Consulta(int i, int j);
		void Atribui(int i, int j, float valor);
		void Imprime();
		~TMatDiag();
};
#endif // TMATDIAG_H