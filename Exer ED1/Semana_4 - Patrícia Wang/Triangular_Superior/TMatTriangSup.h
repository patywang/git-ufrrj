#ifndef TMATTRIANGSUP_H
#define TMATTRIANGSUP_H
class TMatTriangSup
{
	private:
		int n;
		float *vet;
		bool Verifica(int i, int j);
	public:
		TMatTriangSup(int ordemMatriz);
		float Consulta(int i,int j);
		void Atribui(int i,int j, float valor);
		void Imprime();
		~TMatTriangSup();
};
#endif // TMATTRIANGSUP_H