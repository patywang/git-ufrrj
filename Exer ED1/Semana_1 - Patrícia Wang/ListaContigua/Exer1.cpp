#include <iostream>
#include "TExer1ListCont.h"
using namespace std;

int main(){

char op;
int k;
float val;

TExer1ListCont *oi = new TExer1ListCont(20);

do{
//menu funciona apartir do inserir ultimo! (4)
cout << " 1 - consultar \n 2 - atribuir \n 3 - inserir prim \n 4 - insere ult \n 5 - elimina no k \n 6 - elimina ult \n "<< endl;
cin >> op;

	switch(op){
		
		case '1':
			cin>>k;
			cout << oi->Consulta(k) << endl;
		break;
		case '2':
		    cout << "entre com a posicao" << endl;
		    cin >> k;
		    cout << "entre com um val" <<endl;
		    cin >> val;
			oi->Atribui(k,val);
		break;
		case '3':
			cout << "entre com a posicao" << endl;
		    cin >> k;
		    cout << "entre com um val" <<endl;
		    cin >> val;
			oi->Inserek(k,val);
		break;
		case '4':
			cin>>val;
			oi->Insereult(val);
		break;
		case '5':
			cout << "elimine um valor da posicao k" << endl;
			cin >> k;
			oi->Eliminak(k);
		break;
		case '6':
			oi->Eliminault();
		break;

	}

}while(op != '0');
	oi->~TExer1ListCont();
}