#include <stdio.h>;
#include <stdlib.h>;
#include <time.h>;

#define TRUE 1;
#define FALSE 0;


//Criação do Struct de vertices, lista de Adjacencia e Arestas;
typedef struct Vertice Vertice;
typedef struct Lista Lista;
typedef struct Aresta Aresta;

struct Vertice
{
	int nome;
	int distancia;
	int qtdeAdj;
	char cor;
	Vertice *anterior;
	Lista *Adjacencia;
};
struct Lista
{
	Vertice *pos;
	Lista *prox;
};

struct Aresta
{
	int peso;
	struct Vertice *origem;
	struct Vertice *destino;
};


/*DECLARAÇÃO DE FUNÇÕES*/
void geraGrafo(int quantVertices, int quantArestas);
int **matrizADJ(quantVertices);
void printMatrizADJ();//int quantVertices, int *matriz[quantVertices]);
void carregaGrafo();
Lista *iniciaLista();
Lista *insert(Lista *list, Vertice *vertices);
Lista* Remove(Lista* inicio, Vertice* vertice);
void Relaxa(Vertice *vertice, Aresta *ListaArestas);
void dijkstra();
int quantVertices();
int quantArestas();


int main(int argc, char const *argv[]){

	int quantV;
	int quantA;
	int opcao;
	int opcao2;
	clock_t begin, end;
	double time_espend;


	printf("O que Deseja Fazer?\n");
	printf("1: Criar um Grafo;\n");
	printf("2: Ler um Grafo do Arquivo;\n");
	scanf("%d",&opcao);

	switch(opcao){

		case 1:
			printf("Quantos Vertices deseja Criar?\n");
			scanf("%d",&quantV);
			printf("Quantos Arestas deseja Criar?\n");
			scanf("%d",&quantA);
			geraGrafo(quantV,quantA);

			printf("Oque Deseja Faze Agora?:\n");
			printf("1: Imprimir tabela de Adjacencia;\n");
			printf("2: Dijkstra;\n");
//			printf("3: Contagem Cliclo;\n");
//			printf("4: Ordenação topológica\n");
			scanf("%d",&opcao2);
				switch(opcao2){

					case 1:
						printMatrizADJ();
					break;
					case 2:
						begin = clock();
						dijkstra();
						end = clock();
						time_espend = (double) (end - begin) / CLOCKS_PER_SEC;
						printf ("O Algoritmo levou %lf segundos\n\n", time_espend);
					    system("pause");
					break;
/*					case 3:
					break;
					case 4:
					break;
*/
				}
		break;

		case 2:
			quantV = quantVertices();
			quantA = quantArestas();
			Vertice *vertices = (Vertice*)malloc(quantV * sizeof(Vertice));
			Aresta *arestas = (Aresta*)malloc(quantA * sizeof(Aresta));
			carregaGrafo(vertices,arestas);

			printf("Oque Deseja Faze Agora?:\n");
			printf("1: Imprimir tabela de Adjacencia;\n");
			printf("2: Dijkstra;\n");

			scanf("%d",&opcao2);
				switch(opcao2){

					case 1:
						printMatrizADJ();
					break;
					case 2:
						begin = clock();
						dijkstra();
						end = clock();
						time_espend = (double) (end - begin) / CLOCKS_PER_SEC;
						printf ("O Algoritmo levou %lf segundos\n\n", time_espend);
					    system("pause");
					break;

				}
		break;
		default:
			printf("Opcao nao Existente\n");
	}
	return(0);

//    printf("%d / %d", quantVertices, quantArestas);



}
//Gera Grafo Aleatório

void geraGrafo(int quantVertices, int quantArestas){
	int i, j, arestaAux = 0; //Cria variaveis auxiliares

	int **matriz = matrizADJ(quantVertices);

	FILE *file = fopen("grafo.txt", "w");   //CRIA O ARQUIVO PARA ESCRITA

	if (file == NULL){
		printf("Erro ao ler o arquivo.\n");
		exit(1);
	}

	/*ESCREVE NO ARQUIVO*/

	fprintf(file, "%d %d\n{", quantVertices, quantArestas); //escreve no arquivo quantidade de vértives e arestas

	for (i = 0; i < quantVertices; i++){  //escreve no arquivo todos os vértives
		fprintf(file, "<%d>", i);
	}
	fprintf(file, "}\n"); //Finaliza a escrita dos Vertices

	fprintf(file, "{"); //Inicia a Escrita das Arestas

	srand(time(NULL));
	for (i = 0; i < quantVertices; i++){
		for (j = 0; j < quantVertices; j++){
			int randNum1 = rand() % 10 + 1;  //gera peso aleatório entre 1 e 10
			int randNum2 = rand() % 2;       //gera um número entre 0 e 1 para que a relação seja aleatória
			if (randNum2 == 0 && arestaAux < quantArestas){
				fprintf(file, "<%d, %d, %d>", i, j, randNum1);  //escreve no arquivo Origem, Destino, peso da aresta gerada
				matriz[i][j] = randNum1;
				arestaAux++;
			}else{
				matriz[i][j] = 0;
			}
		}
	}
	fprintf(file, "}");
	fclose(file); //Fecha o Arquivo

	printf("Grafo Criado\n \n");

}

//Cria Matriz de Adjacencia
int ** matrizADJ(quantVertices){
	int **matriz = (int**)malloc(quantVertices * sizeof(int*)); //Aloca um espaço para uma matriz de
	int i, j, auxiliarAresta;
	for (i=0; i < quantVertices; i++){						   //adjacência quantVertices x quantVertices
		matriz[i] = (int*)malloc(quantVertices * sizeof(int));
	}
	return matriz;
}

//Imprime Matriz de Adjacencia
void printMatrizADJ(){//int quantVertices, int *matriz[quantVertices]){
	char caracter;
	int linha = 0;

	printf("Matriz de adjacência:\n\n");
	FILE *file = fopen("grafo.txt", "r");

	if (file == NULL){
		printf("Erro ao ler o arquivo.\n");
		exit(1);
	}
	while(fscanf(file, "%c", &caracter) != EOF){
		if(caracter == '\n'){
			linha++;
			continue;
		}
		if (linha == 2)
		{
			if (caracter == '{' || caracter == '}'){	//inicio de um bloco de Arestas
				continue;
			}
			if(caracter == '<'){ //lê cada aresta do arquivo
				int origem, destino, peso, i, j;
				fscanf(file, "%d, %d, %d>", &origem, &destino, &peso);
				printf("Origem: %d, Destino: %d,    Peso: %d \n",origem, destino, peso );
			}
		}
	}
}

void carregaGrafo(Vertice *vertices, Aresta *arestas){
	int quantV, quantA, ehVertice = TRUE;
	int aux, cont = 0, A,B;
	char caracter;

	FILE *file = fopen("grafo.txt", "r");

	if (file == NULL){
		printf("Erro ao ler o arquivo.\n");
		exit(1);
	}

	quantV = quantVertices(); //lê a quantidade de vértices e arestas na primeira linha do arquivo.
	quantA = quantArestas();

	fscanf(file, "%d %d", &A, &B); //Só para teste

	fscanf(file, "%c", &caracter); //ler o \n da primeira linha.
	printf("%c \n\n", caracter);
	//int i = 0;

//	printf("Aqui entrou 1------------------------------------------\n");
	while(fscanf(file, "%c", &caracter) != EOF){
		if (caracter == '{' || caracter == '}'){	//inicio de um bloco de Arestas ou Vertices
			continue;
		}
		if (caracter == '\n'){ //Quando chegar no final da segunda linha, passa a ler as arestas.
			ehVertice = FALSE;
			cont = 0;
			continue;
		}
		if (ehVertice && caracter == '<'){ //Para a segunda linha onde ficam os vértices, inicia cada vértice.
			int nome;
			fscanf(file, "%d>", &nome);
			vertices[cont].nome = nome;
			vertices[cont].qtdeAdj = 0;
			vertices[cont].anterior = NULL;
			vertices[cont].cor = 'B';
			if (cont != 0)
				vertices[cont].distancia = 2100000000; //atribui distância infinito ao vértice
			else
				vertices[cont].distancia = 0; //atribui distância 0 ao primeiro vértice
			vertices[cont].Adjacencia = iniciaLista();

			cont++;
			continue;
		}
		if (!ehVertice && caracter == '<'){ //lê cada aresta do arquivo
			int origem, destino, peso, i, j;
			fscanf(file, "%d, %d, %d>", &origem, &destino, &peso);
			Vertice *verticeIF;

			for (i = 0; i < quantV; i++){ //para cada aresta percorre os vertices para fazer as associções
				if (vertices[i].nome == origem){
					arestas[cont].origem = &vertices[i];
					vertices[i].qtdeAdj += 1;
					verticeIF = &vertices[i];

					for (j = 0; j < quantV; j++){ //busca o vértice vizinho para o vértice corrente
						if (vertices[j].nome == destino){
							arestas[cont].destino = &vertices[j];
							verticeIF->Adjacencia = insert(verticeIF->Adjacencia, &vertices[j]);
							break;
						}
					}
				}
			}
			arestas[cont].peso = peso; //atribiu o peso a aresta lida.
			cont++;
			continue;
		}
	//	i++;
	}

	fclose(file);
}

Lista *iniciaLista(){
	return NULL;
}

Lista *insert(Lista *list, Vertice *vertices){
	if (vertices->cor != 'B'){
		return list;
	}
	Lista* aux = list;
	while (aux != NULL){  //Verifica se o vértice já está na lista.
		if (aux->pos->nome == vertices->nome){
			return list;
		}
		aux = aux->prox;
	}
	Lista *new = (Lista*) malloc(sizeof(Lista));
	new->pos = vertices;
	new->prox = list;
	return new;
}

//Cria a busca
void visit(Lista *fila, Aresta *ListaArestas, int quantArestas){
	if (fila == NULL){
		return;
	}
	int i, j;
	Lista* filaVisitada = fila->prox;
//	printf("fila proximo %d\n",fila->prox);

	Vertice *vertice = fila->pos;

    while(filaVisitada != NULL){ //busca o vértice de menor prioridade
		if(vertice->distancia > filaVisitada->pos->distancia){
			vertice = filaVisitada->pos;
	//		printf("Entrou 001 ----------Quantidade de Arestas: %d---------\n",quantArestas);
		}
		filaVisitada = filaVisitada->prox;
	//	printf("Entrou 002 ----------: %d---------\n",filaVisitada->pos);

    }
    free(filaVisitada);

    Lista *auxList = vertice->Adjacencia;
    while(auxList != NULL){  //percorre a lista de adjacencias do vértice em questão
	    for(j = 0; j < quantArestas; j++){
			if(ListaArestas[j].destino->cor == 'B' && vertice->nome == ListaArestas[j].origem->nome &&
				auxList->pos->nome == ListaArestas[j].destino->nome && ListaArestas[j].destino != vertice){
//				printf("Entrou aqui! -----------------------\n");

				Relaxa(vertice, &ListaArestas[j]);  //relaxa o vertice adjacente caso os criterio a cima tenham sido atendidos
				fila = insert(fila, ListaArestas[j].destino);  //inserte o vértice na fila
			}
		}
		auxList = auxList->prox;
	}
	vertice->cor='C';
	fila = Remove(fila, vertice);  //revome o vértice visitado da fila

	visit(fila, ListaArestas, quantArestas); //chama o visit novamente
}

void Relaxa(Vertice *vertice, Aresta *ListaArestas){
	if(vertice->distancia + ListaArestas->peso < ListaArestas->destino->distancia){
		ListaArestas->destino->distancia = vertice->distancia + ListaArestas->peso;
		ListaArestas->destino->anterior = vertice;
    }
}

Lista* Remove(Lista* inicio, Vertice* vertice){
	Lista *proximo, *anterior;

    if (inicio == NULL){
		return inicio;  // Lista vazia !!!
	}

	proximo = inicio;
	anterior = inicio;

	while (proximo != NULL && proximo->pos->nome != vertice->nome){
		anterior = proximo;
	    proximo = proximo->prox;
	}

	if (proximo == inicio){
		inicio = inicio->prox;
	} else {
		anterior->prox = proximo->prox;
	}

	return inicio;
}

void dijkstra(){
    int quantA, quantV;
	quantV = quantVertices();
	quantA = quantArestas();
	Vertice *vertices = (Vertice*)malloc(quantV * sizeof(Vertice));
	Aresta *arestas = (Aresta*)malloc(quantA * sizeof(Aresta));
	carregaGrafo(vertices,arestas);

	Lista *fila = iniciaLista();
	int i= 0;
	Vertice *vertice = &vertices[0];

	fila = insert(fila, vertice); //insere o vértice na posição 0 na fila.


	visit(fila, arestas, quantA);  //chama o visita
    printf ("\n\n");

	printf ("Vertice: %d => Distancia: %d - Cor: %c : %d\n", vertice->nome, vertice->distancia, vertice->cor, vertice->anterior);

	 for(i = 1; i < quantV; i++){
	 	if (vertices[i].anterior != NULL){
	 		printf ("Vertice: %d => Distancia: %d - Cor: %c : %d\n", vertices[i].nome, vertices[i].distancia, vertices[i].cor, vertices[i].anterior->nome);
	 	}
	 }
	 printf ("\n\n");
}

int quantVertices(){
	int quantVertices;
	FILE *file = fopen("grafo.txt", "r");

	if (file == NULL){
		printf("Erro ao ler o arquivo.\n");
		exit(1);
	}

	fscanf(file, "%d", &quantVertices);
	close(file);
	return quantVertices;
}

int quantArestas(){
	int quantArestas, a;
	FILE *file = fopen("grafo.txt", "r");

	if (file == NULL){
		printf("Erro ao ler o arquivo.\n");
		exit(1);
	}

	fscanf(file, "%d %d", &a, &quantArestas);
	close(file);
	return quantArestas;
}
