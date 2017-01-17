package histograma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HistogramaCurso {
	
		public void arquivoCurso() throws IOException{
			FileInputStream stream = new FileInputStream("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/Cursos.txt");
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);
			String linha ;
			int registros = 0;
			Map<String, Integer>quantNomeCurso = new HashMap<String, Integer>();
			while((linha = br.readLine())!= null){
				String[] aux = linha.split("\t");
				String idCurso = aux[0];
				String nomeCurso = aux[1];
				
	
				if (quantNomeCurso.get(nomeCurso) == null) {
					quantNomeCurso.put(nomeCurso, 1);
				} else {
					quantNomeCurso.put(nomeCurso, quantNomeCurso.get(nomeCurso) + 1);
				}
				registros ++;
			}
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/patricia/Copy/workspace/AAED2/AAED2_FINAL/histograma/CatalogoCurso.txt"));
			buffWrite.append("Arquivo aluno possui " + registros + "  registros !!\n\n" );
			
			buffWrite.append("Nome Disciplina ------> Quantidade repetida:\n");
			for(String c : quantNomeCurso.keySet()){
				buffWrite.append(c+ "---------> " +quantNomeCurso.get(c)+"\n");
				
			}
			buffWrite.append("------------------------\n\n");
			
			
			buffWrite.close();
			System.out.println("Criado catalogo de Curso!");
		}
}
