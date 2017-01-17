package histograma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HistogramaDisciplinaHistorico {

	public void arquivoDisciplinaHistorico() throws IOException{
		
		FileInputStream stream = new FileInputStream("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/DisciplinaHistorico.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha ;
		int registros = 0;
		
		Map<String, Integer>quantIdAlunoFk = new HashMap<String, Integer>();
		Map<String, Integer>quantIdDiscFk = new HashMap<String, Integer>();
		Map<String, Integer>quantNota = new HashMap<String, Integer>();
		Map<String, Integer>quantAno = new HashMap<String, Integer>();
		Map<String, Integer>quantPeriodo = new HashMap<String, Integer>();
		Map<String, Integer>quantSituacao = new HashMap<String, Integer>();
		
		while((linha = br.readLine())!= null){
			String[] aux = linha.split("\t");
			String idDiscHist = aux[0];
			String idAluno_fk = aux[1];
			String idDisc_fk = aux[2];
			String nota = aux[3];
			String ano = aux[4];
			String periodo = aux[5];
			String situacao = aux[6];
			
			if (quantIdAlunoFk.get(idAluno_fk) == null) {
				quantIdAlunoFk.put(idAluno_fk, 1);
			} else {
				quantIdAlunoFk.put(idAluno_fk, quantIdAlunoFk.get(idAluno_fk) + 1);
			}
			
			if (quantIdDiscFk.get(idDisc_fk) == null) {
				quantIdDiscFk.put(idDisc_fk, 1);
			} else {
				quantIdDiscFk.put(idDisc_fk, quantIdDiscFk.get(idDisc_fk) + 1);
			}
			
			if (quantNota.get(nota) == null) {
				quantNota.put(nota, 1);
			} else {
				quantNota.put(nota, quantNota.get(nota) + 1);
			}
			
			if (quantAno.get(ano) == null) {
				quantAno.put(ano, 1);
			} else {
				quantAno.put(ano, quantAno.get(ano) + 1);
			}
			
			if (quantPeriodo.get(periodo) == null) {
				quantPeriodo.put(periodo, 1);
			} else {
				quantPeriodo.put(periodo, quantPeriodo.get(periodo) + 1);
			}
			
			if (quantSituacao.get(situacao) == null) {
				quantSituacao.put(situacao, 1);
			} else {
				quantSituacao.put(situacao, quantSituacao.get(situacao) + 1);
			}
			
			registros ++;
		
		}
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/histograma/CatalogoDisciplinaHistorico.txt"));
		buffWrite.append("Arquivo aluno possui " + registros + "  registros !!\n\n" );
		
		buffWrite.append("ID Aluno ------> Quantidade repetida:\n");
		for(String a : quantIdAlunoFk.keySet()){
			buffWrite.append(a + "---------> " +quantIdAlunoFk.get(a)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		
		buffWrite.append("ID Disciplina ------> Quantidade repetida:\n");
		for(String d : quantIdDiscFk.keySet()){
			buffWrite.append(d + "---------> " +quantIdDiscFk.get(d)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		
		buffWrite.append("Nota ------> Quantidade repetida:\n");
		for(String n : quantNota.keySet()){
			buffWrite.append(n + "---------> " +quantNota.get(n)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		
		buffWrite.append("Ano ------> Quantidade repetida:\n");
		for(String y : quantAno.keySet()){
			buffWrite.append(y + "---------> " +quantAno.get(y)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		
		buffWrite.append("Periodo ------> Quantidade repetida:\n");
		for(String p : quantPeriodo.keySet()){
			buffWrite.append(p + "---------> " +quantPeriodo.get(p)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		
		buffWrite.append("Situcacao ------> Quantidade repetida:\n");
		for(String s : quantSituacao.keySet()){
			buffWrite.append(s + "---------> " +quantSituacao.get(s)+"\n");
			
		}
		buffWrite.append("------------------------\n\n");
		buffWrite.close();
		System.out.println("Criado catalogo de DisciplinaHistorico !");
		
	}
}
