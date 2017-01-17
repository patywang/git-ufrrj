package histograma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HistogramaAluno {
	
	public void arquivoALuno() throws IOException{
			
			FileInputStream stream = new FileInputStream("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/Alunos.txt");
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);
			String linha ;
			//ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			int registros = 0;
			int coluna = 0;
			Map<String, Integer>quantCurso = new HashMap<String, Integer>();
			Map<String, Integer>quantMatricula = new HashMap<String, Integer>();
			Map<String, Integer>quantNome = new HashMap<String, Integer>();
			while((linha = br.readLine())!= null){
				String[] aux = linha.split("\t");
				String idAluno = aux[0];
				String idCursoAluno = aux[1];
				String matriculaAluno = aux[2];
				String nomeAluno = aux[3];
				
			//	Aluno aluno = new Aluno(idAluno,idCursoAluno, matriculaAluno,nomeAluno);
			//	alunos.add(aluno);	
				if (quantCurso.get(idCursoAluno) == null) {
					quantCurso.put(idCursoAluno, 1);
				} else {
					quantCurso.put(idCursoAluno, quantCurso.get(idCursoAluno) + 1);
				}
				
				if (quantMatricula.get(matriculaAluno) == null) {
					quantMatricula.put(matriculaAluno, 1);
				} else {
					quantMatricula.put(matriculaAluno, quantMatricula.get(matriculaAluno) + 1);
				}
				
				if (quantNome.get(nomeAluno) == null) {
					quantNome.put(nomeAluno, 1);
				} else {
					quantNome.put(nomeAluno, quantNome.get(nomeAluno) + 1);
				}
				registros ++;
			
			}
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/histograma/CatalogoAluno.txt"));
			buffWrite.append("Arquivo aluno possui " + registros + "  registros !!\n\n" );
			
			buffWrite.append("ID Curso ------> Quantidade repetida:\n");
			for(String c : quantCurso.keySet()){
				buffWrite.append(c + "---------> " +quantCurso.get(c)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			
			buffWrite.append("Matricula ------> Quantidade repetida:\n");
			for(String m : quantMatricula.keySet()){
				buffWrite.append(m + "---------> " +quantMatricula.get(m)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			
			buffWrite.append("Nome Aluno ------> Quantidade repetida:\n");
			for(String n : quantNome.keySet()){
				buffWrite.append(n + "---------> " +quantNome.get(n)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			buffWrite.close();
			System.out.println("Criado catalogo do Aluno!");
			
		}
}
