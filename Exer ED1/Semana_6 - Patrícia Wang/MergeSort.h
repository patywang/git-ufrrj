class MergeSort
{
private:
	int n;
	int *vAux;	
public:
	MergeSort(int ordem);
	void mergeSort(int *V, int inicio, int fim);
	void intercala (int *V, int inicio, int meio,int fim);
	~MergeSort(); 
};