package arvoreB;

public class Chave {

	private byte[] aluno_id;
	private byte[] ano;
	private byte[] periodo;
	private byte[] nota;
	private byte[] disciplina_id;

	
	public Chave(){
		this.aluno_id = new byte[36];
		this.ano = new byte[4];
		this.periodo = new byte[1];
		this.nota = new byte[4];
		this.disciplina_id = new byte[4];
	}

	

	public byte[] getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(byte[] aluno_id) {
		this.aluno_id = aluno_id;
	}

	public byte[] getAno() {
		return ano;
	}

	public void setAno(byte[] ano) {
		this.ano = ano;
	}

	public byte[] getPeriodo() {
		return periodo;
	}

	public void setPeriodo(byte[] periodo) {
		this.periodo = periodo;
	}

	public byte[] getNota() {
		return nota;
	}

	public void setNota(byte[] nota) {
		this.nota = nota;
	}

	public byte[] getDisciplina_id() {
		return disciplina_id;
	}

	public void setDisciplina_id(byte[] disciplina_id) {
		this.disciplina_id = disciplina_id;
	}
	
	

}
