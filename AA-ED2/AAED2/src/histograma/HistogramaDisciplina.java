package histograma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HistogramaDisciplina {
	
		public void arquivoDisciplina() throws IOException{
			
			FileInputStream stream = new FileInputStream("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/Disciplinas.txt");
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);
			String linha ;
			int registros = 0;
			Map<String, Integer>quantCurso = new HashMap<String, Integer>();
			Map<String, Integer>quantNomeDisc = new HashMap<String, Integer>();
			while((linha = br.readLine())!= null){
				String[] aux = linha.split("\t");
				String idDisc = aux[0];
				String nomeDisc = aux[1];
				String idCurso = aux[2];
	
				if (quantNomeDisc.get(nomeDisc) == null) {
					quantNomeDisc.put(nomeDisc, 1);
				} else {
					quantNomeDisc.put(nomeDisc, quantNomeDisc.get(nomeDisc) + 1);
				}
				
				if (quantCurso.get(idCurso) == null) {
					quantCurso.put(idCurso, 1);
				} else {
					quantCurso.put(idCurso, quantCurso.get(idCurso) + 1);
				}
				registros ++;
			
			}
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/histograma/CatalogoDisciplina.txt"));
			buffWrite.append("Arquivo aluno possui " + registros + "  registros !!\n\n" );
			
			buffWrite.append("Nome Disciplina ------> Quantidade repetida:\n");
			for(String n : quantNomeDisc.keySet()){
				buffWrite.append(n+ "---------> " +quantNomeDisc.get(n)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			buffWrite.append("ID Curso ------> Quantidade repetida:\n");
			for(String c : quantCurso.keySet()){
				buffWrite.append(c + "---------> " +quantCurso.get(c)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			
			buffWrite.close();
			System.out.println("Criado catalogo de Disciplina!");
	}

}
