package catalogo;

import hash.Hash;

public class Catalogo {
	
	private String nome;
	private String arquivoTxt;
	private String arqivoDAT;
	private float tamArquivoDat;
	private int linha;
	private int coluna;
	private Hash hash;
	
	
	
	public Catalogo(String nome, String arquivoTxt, String arquivoDat, float tamArquivoDat, int linha, int coluna){
		this.nome=nome;
		this.arquivoTxt=arquivoTxt;
		this.arqivoDAT=arquivoDat;
		this.tamArquivoDat=tamArquivoDat;
		this.linha=linha;
		this.coluna=coluna;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getArquivoTxt() {
		return arquivoTxt;
	}
	public void setArquivoTxt(String arquivoTxt) {
		this.arquivoTxt = arquivoTxt;
	}
	
	public String getArqivoDAT() {
		return arqivoDAT;
	}
	public void setArqivoDAT(String arqivoDAT) {
		this.arqivoDAT = arqivoDAT;
	}
	
	public float getTamArquivoDat() {
		return tamArquivoDat;
	}
	public void setTamArquivoDat(float tamArquivoDat) {
		this.tamArquivoDat = tamArquivoDat;
	}
	
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public Hash getHash() {
		return hash;
	}
	public void setHash(Hash hash) {
		this.hash = hash;
	}
	
	
	
	

}

