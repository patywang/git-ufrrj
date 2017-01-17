package hash;

class No{
    int valor;
	int tamByte;
    byte []b;
    No prox;

    public No(int v,int t, byte[] bt){
        valor = v;
        tamByte = t;
        b = bt;
        prox = null;
    }
    
    public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getTamByte() {
		return tamByte;
	}

	public void setTamByte(int tamByte) {
		this.tamByte = tamByte;
	}

	public byte[] getB() {
		return b;
	}

	public void setB(byte[] b) {
		this.b = b;
	}

}
