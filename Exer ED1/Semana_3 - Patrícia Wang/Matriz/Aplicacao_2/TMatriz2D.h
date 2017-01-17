#ifndef TMATRIZ2D_H
#define TMATRIZ2D_H

class  TMatriz2D {
	private:
		int nl,nc;
		float **mat;
		bool Verifica(int i, int j);
	public:
		TMatriz2D (int nnl,int nnc);
		float Consulta (int i, int j);
		void Atribui(int i,int j,float valor);
		~TMatriz2D();
};
#endif // TMATRIZ2D_H