class QuickSort
{
private:
	int n;
public:
	QuickSort(int ordem);
	int particiona(int *V,int esquerda, int direita);
	int quick(int *V,int esquerda, int direita);
	~QuickSort();
};