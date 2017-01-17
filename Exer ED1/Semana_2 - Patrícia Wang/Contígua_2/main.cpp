#include <iostream>
#include "TListCont.h"
using namespace std;

int main(){

	char op;
	int k;
	//float val;

	TListCont *oi = new TListCont(20);
    // -----------------------------exer SEMANA 2-----------------------------//
	do{

	cout << " 1 - consultar \n 2 - insere ult \n 3 - Eliminar elementos \n 4 - Sair\n"<< endl;
	cin >> op;

		switch(op){
			
			case '1':
				cin>>k;
				cout << oi->Consulta(k) << endl;
			break;
			
			case '2':
				oi->Insereult();
			break;

			case '3':
				oi->EliminarNo();
			break;
		}

	}while(op != '4');
	oi->~TListCont();
}