#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define WHITE 0
#define GRAY 1
#define BLUE 2

typedef struct VERTEX Vertex;
typedef struct EDGE Edge;
typedef struct LIST List;
typedef struct BOSS Boss;
int time_ = 0;
int compConexa = 0; 
int eCont = 0; 


//STRUCTS
typedef struct LIST
{
	Vertex *v;
	List *next;
}List;

typedef struct VERTEX
{
	int name;
	int color;
	int d;
	List *adj;
	int rank; 
	Vertex *father;
	int final_time;
	int timeDFS;
	int cycle;
}Vertex;

typedef struct EDGE
{
	Vertex *where;
	Vertex *from;
	int weight;
	int active; 
}Edge;

typedef struct BOSS
{
	int id;
	int size;
}Boss;

//-------------------------------------------------------------------------------------------

//CRIA LISTA DE VÉRTICES
List *list_create(List *l){
	l->next = NULL;
	return l;
}

//-------------------------------------------------------------------------------------------

//VERIFICA SE A LISTA ESTA VAZIA
int empty_list(List *l){
	if(l->next == NULL){
		return 1;
	}else{
		return 0;
	}
}

//-------------------------------------------------------------------------------------------

//ADICIONA ELEMENTOS A LISTA DE VÉRTICES
void list_add(List *l, Vertex *v1){
	List *new_ = (List*)malloc(sizeof(List));
	new_->next = NULL;
	new_-> v = v1;

	if(empty_list(l)){
		l->next = new_;

	}else{
		List *tmp = l->next;

		while(tmp->next != NULL){
			tmp = tmp->next;
		}
		tmp->next = new_;
	}
}

//-------------------------------------------------------------------------------------------
//RETORNA O TAMANHO DA LISTA
int list_size(List *l){
	List *tmp = l;
	int size =0 ;
	while(tmp->next != NULL){
		tmp = tmp->next;
		size++;
	}

	return size;
}

//-------------------------------------------------------------------------------------------
//INICIALIZA O VÉRTICE

Vertex *vertex_create(int n){
	//printf("create vertex\n");

	Vertex *v = (Vertex*)malloc(sizeof(Vertex));
	v->name = n;
	v->rank = n;
	v->adj = (List*)malloc(sizeof(List));
	list_create(v->adj);
	//printf("vertex name: %d\n", v->name);
	//printf("\nKISS ME, K-K-KISS ME!\n");
	return v;

}

//-------------------------------------------------------------------------------------------
//INICIALIZA UMA ARESTA

Edge *edge_create(Vertex *g[], int w, int f, int x){
	int random = 0;
	Edge *e = (Edge*)malloc(sizeof(Edge));

	e->where = g[w];
	e->from = g[f];

	if(x == 0){
		random = rand() %100;
		e->weight = random;
	}else{
		e->weight = x;

	}	

	list_add(g[w]->adj, g[f]);
	list_add(g[f]->adj, g[w]);
	return e;
}

//-------------------------------------------------------------------------------------------
//ORDENA OS VÉRTICES

void bubbleSort(Edge *e[], int eCont){

	int i, j;
	Edge *tmp;
	for(i=eCont-1; i>=1; i--){
		for (j = 0; j < i; ++j)
		{
			if(e[j]->weight > e[j+1]->weight){
				tmp = e[j];
				e[j] = e[j+1];
				e[j+1] = tmp;
			}
		}
	}
}
//-------------------------------------------------------------------------------------------
//VERIFICA SE UM DETERMINADO VÉRTICE ESTA NA LISTA DE ADJACÊNCIAS DE OUTRO VÉRTICE
int checkList(Vertex *g[], int i, int j){
	List *l = g[i]->adj;
	Vertex *v;
	int back = 0;


	while(l->next != NULL){
		l = l->next;
		v = l->v;
		if(v->name == j){
			back = 1;
			break;
		}
	}
	return back;
}
//-------------------------------------------------------------------------------------------
//INICIALIZA O GRAFO

void graph_create(Vertex *g[], Edge *e[], int t){

	int i, j;
	Edge *e1, *e2;

	for(i=0; i<t; i++){
		g[i] = vertex_create(i);
	}

	for(i=0; i<t; i++){
		for (j = 0; j < t; ++j)
		{
			if(i!=j){
				if(checkList(g, i, j) == 0){

					e1 = edge_create(g, i, j, 0); //cria a aresta
					list_add(g[i]->adj, g[j]); //adiciona o vertice da origem na lista de adjacencia do destino
					list_add(g[j]->adj, g[i]); //adiciona o vertice da destino na lista de adjacencia do origem

					e[eCont] = e1;
					eCont++;
				}
			}else{
				continue;
			}
		}
	}
}

//-------------------------------------------------------------------------------------------
//INICIALIZA O RANK E O ID DE CADA VÉRTICE
void unionInit(Vertex *v[], int vSize, Boss *b){
	int i;
	for(i=0; i<vSize; i++){
		v[i]->rank = i;
		b[i].id = i;
		b[i].size = 0;
	}
}
//-------------------------------------------------------------------------------------------
//RETORNA O RANK DO VÉRTICE

int unionFind(Vertex *v){
	return v->rank;

}
//-------------------------------------------------------------------------------------------
//VERIFICA SE A ARESTA FORMA UM CICLO

int union1(Vertex *w, Vertex *f,Vertex *g[], Boss *b, int t){
	int big, small, i;
	if(w->rank > f->rank || b[w->rank].size > b[f->rank].size ){// tamanho do rank da origem é maior que a origem ou id do rank da origem é maior que o do destino
		big = w->rank;
		small = f->rank;
	}else if(w->rank < f->rank || b[w->rank].size < b[f->rank].size ){
		big = f->rank;
		small = w->rank;
	}

	//o que tem o id menor ou o rank de tamanho menor, passa a ser do rank maior
	for (i = 0; i < t; ++i)
	{
		if(b[i].id == small){
			b[i].id = big;
			b[big].size = b[big].size + 1; //tamanho do rank maior aumenta
			g[i]->rank = big;
		}
	}
}

//-------------------------------------------------------------------------------------------
//KRUSKAL

void kruskal(Vertex *g[], Edge *e[], int total_vertex, int total_edges){


	int i, p, q, k=0;
	Boss *b = (Boss*)malloc(total_vertex*sizeof(Boss));
	//inicializa os vértices de novo
	for(i=0; i<total_vertex; i++){
		list_create(g[i]->adj);
	}

	unionInit(g, total_vertex, b);
	for (i = 0; i < total_edges; ++i)
	{	
		p = unionFind(e[i]->where);
		q = unionFind(e[i]->from);
		
		if( p != q){ //verifica se os ids são diferentes 
			//se o id for diferente, não forma ciclo
			e[i]->active = 1;
			union1(e[i]->where, e[i]->from, g, b, total_vertex);
			k++;

		}else{
			//se forma ciclo, a aresta não é 'ativada'
			e[i]->active = 0;
			k--;
		}
		
	}

}

//-------------------------------------------------------------------------------------------

//CRIA K GRUPOS DE VERTICES
void removeKEdges(int k, Vertex* g[], Edge *e[], int total_edges, int total_vertex){

	int i;
	//remove as k maiores arestas
	for (i = total_edges; i > 0; --i)
	{
		if(e[i]->active == 1){
			e[i]->active = 0;
			
			k--;
		}
		if(k==0){
			break;
		}
	}
	Vertex *w, *f;
	//adiciona as arestas ativadas às listas de adjacencias
	for (i = 0; i < total_edges; ++i)
	{	
		if(e[i]->active == 1){

			list_add(g[e[i]->where->name]->adj, g[e[i]->from->name] );
			list_add(g[e[i]->from->name]->adj, g[e[i]->where->name] );
		}
	}
}
//-------------------------------------------------------------------------------------------
//CALCULA O NÚMERO DE ARESTAS DE UM GRAFO COMPLETO

int completeGraph(int n){

	//printf("\nIF ONLY TIME COULD DISAPPEAR...!\n");
	return (n*(n-1))/2;
}

//-------------------------------------------------------------------------------------------
//IMPRIME OS VÉRTICES E ARESTAS
void printMst(Edge *e[], int total_edges, int option){
	int i;

	if(option == 1){
		for(i=0; i<total_edges; i++){
			if(e[i]->active == 1){
				printf("[%d]---- %d ----- [%d]\n", e[i]->where->name, e[i]->weight, e[i]->from->name);

			}

		}
	}else{
		for(i=0; i<total_edges; i++){
			printf("[%d]---- %d ----- [%d]\n", e[i]->where->name, e[i]->weight, e[i]->from->name);
		}
	}	
}

//--------------------------------------------------------------------------------------------
//VISITA O VÉRTICE

void visit(Vertex *g[], int u){
	g[u]->color = GRAY;
	time_++;
	g[u]->d = time_;

	int v, i;
	List *temp = g[u]->adj; 
	for (i = 0; i < list_size(g[u]->adj); ++i)
	{
		temp = temp->next; 
		if(g[temp->v->name]->color == WHITE){
			g[temp->v->name]->father = g[u];
			visit(g, temp->v->name);
		}

	}
	g[u]->color = BLUE;
	time_++;
	g[u]->final_time =time_; 
}


//--------------------------------------------------------------------------------------------
//BUSCA EM PROFUNDIDADE
void DFS(Vertex *g[], int total_vertex){
	int u = 0;
	for (u = 0; u < total_vertex; ++u)
	{
		g[u]->color = WHITE;
		g[u]->father = NULL;
		g[u]->timeDFS = 0;
		g[u]->d = 0;

	}

	for (u = 0; u < total_vertex; ++u)
	{
		if(g[u]->color == WHITE){
			time_ = 0;
			visit(g, u);
			compConexa++;
		}
	}
	printf("NUMERO DE COMPONENTES CONEXAS: %d\n", compConexa);
}

int main(int argc, char const *argv[])
{
	clock_t timer;
	timer = clock();
 	srand(time(NULL));

	int total_vertex, total_edges, k, option = 5;
	printf("QUANTOS VÉRTICES?\n"); //NUMERO DE VÉRTICES QUE O GRAFO VAI TER
	scanf("%d", &total_vertex);

	total_edges = completeGraph(total_vertex); //NUMERO DE ARESTAS QUE O GRAFO VAI TER
	Vertex *g[total_vertex];//VERTICES
	Edge *e[total_edges];//ARESTAS
	graph_create(g, e, total_vertex); //GERA O GRAFO
	
	while(option != 0){
		printf("Escolha uma opção:\n 1- Imprimir grafo original\n 2- Imprimir árvore geradora mínima\n 0- sair\n");
		scanf("%d", &option);
		switch(option){
			case 1: 
					bubbleSort(e, total_edges); //ORDENA OS VÉRTICES
					printMst(e, total_edges, 0); //IMPRIME O GRAFO GERADO 
					break;

			case 2: 
					kruskal(g, e, total_vertex, total_edges); //KRUSKAL
					printf("\n\nÁRVORE GERADORA MÍNIMA: \n\n");

					printMst(e, total_edges, 1); //IMPRIME A ÁRVORE GERADORA MINIMA GERADA PELO KRUSKAL

					printf("\n\nK: ");
					scanf("%d", &k); //K ARESTAS QUE VAO SER RETIRADAS DA ÁRVORE GERADA

					removeKEdges(k, g, e, total_edges, total_vertex); //REMOVE E SEPARA A ARVORE EM K GRUPOS
					printMst(e, total_edges, 1);
					DFS(g, total_vertex); //BUSCA EM PROFUNDIDADE
					timer = clock() - timer; //CALCULA O TEMPO TOTAL
					printf("\nTOTAL TIME:  >> %f \n\n ", ((float)timer)/CLOCKS_PER_SEC);
					break;

			case 0: 
					break;		

		}
	}	
	
/*	removeKEdges(k, e, total_edges);
	printMst(e, total_edges);*/
	


	return 0;
}
