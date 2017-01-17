package main;

import hash.HashJoin;

import java.io.IOException;
import java.util.Scanner;

import conversao.BytePlus;
import algebraRelacional.Selecao;
import algebraRelacional.SortMergeJoin;
import catalogo.CatalogoAlunos;
import catalogo.CatalogoCursos;
import catalogo.CatalogoDisciplinas;
import catalogo.CatalogoDisciplinasHistoricos;

public class Principal {

	public void titulo(){

		System.out.println("*****************************************************************");
		System.out.println("*               AA de Estrutura de Dados II                     *");
		System.out.println("*  Integrantes: Patricia Castro, Wesley Muniz e Vanessa Soares  *");
		System.out.println("*****************************************************************\n");
		
	}

	public void opcoesMenu(){
		System.out.println("Escolha uma opção:");
		System.out.println("(1) Retornar os nomes e as matrículas dos alunos de um curso");
		System.out.println("(2) Retornar os nomes das disciplinas que um aluno tirou 10");
		System.out.println("(3) Retornar os nomes das disciplinas e suas respectivas notas para um aluno em um determinado ano­ período");
		System.out.println("(0) Sair.\n");
		//Scanner scan = new Scanner(System.in);
		//return scan.nextInt();
	}

	public static void pausa(){
		//System.out.println("Pressione ENTER para continuar...");
		Scanner scan = new Scanner(System.in);
		if(scan.nextLine().equals(""))
			return;
	}
	
	public String opcaoCursos(){
		
		int opcao;
		do{
		System.out.println("Escolha um curso:");
		System.out.println("(1) ADMINISTRACAO");
		System.out.println("(2) BACHARELADO EM CIENCIA DA COMPUTACAO");
		System.out.println("(3) DIREITO");
		System.out.println("(4) MATEMATICA");
		System.out.println("(5) PEDAGOGIA");
		System.out.println("(6) RELACOES INTERNACIONAIS");
		System.out.println("(7) SERVICO SOCIAL");
		Scanner scan = new Scanner(System.in);
	    opcao = scan.nextInt();
		}while(opcao > 7 || opcao < 0);
		
		switch(opcao){
		case 1: return "ADMINISTRACAO";
		        
		case 2: return "BACHARELADO EM CIENCIA DA COMPUTACAO";
		        
		case 3: return "DIREITO";
        		
		case 4: return "MATEMATICA";
        		
		case 5: return "PEDAGOGIA";
        		
		case 6: return "RELACOES INTERNACIONAIS";
        		
		case 7: return "SERVICO SOCIAL";
		
		default: return null;
		}
	}
	
	public String insereMatricula(){
		
		String palavra = new String();
		do{
		
		System.out.println("Informe uma mátricula!");
		Scanner scan = new Scanner(System.in);
	    palavra = scan.nextLine();
	    
		}while(palavra.length() != 10 && !palavra.equals("\n"));
		
		return palavra;
		
	}
	public void buscar(int opcao) throws IOException{
		
		
		CatalogoAlunos catA = new CatalogoAlunos();
		CatalogoDisciplinasHistoricos catDH = new CatalogoDisciplinasHistoricos();
		CatalogoCursos catC = new CatalogoCursos();
		Selecao sel;
		
		switch(opcao){
		 case 1: planoConsulta(opcao);
		 		 
		 		
		 		 sel = new Selecao(catC);
		         sel.select(1, BytePlus.stringToByteArray(opcaoCursos()));
		         System.out.println(catC.getArqivoDAT());
		         SortMergeJoin join = new SortMergeJoin(catA, sel);
		         		join.mergeJoin(0, 1);
		         		
		         		for(int i=0; i<join.getTabelaSize(); i++){
		         			for(int j = 0; j<join.getTabela(i).size(); j++){
		         				if(j == 3 || j == 4)
		         					System.out.print(BytePlus.byteArrayToString(join.getTabelaFinal(i,j)) + " ");
		         			}
		         			System.out.println("");
		         		}
			 break;
			 
		 case 2: planoConsulta(opcao);

				sel = new Selecao(catDH);
				sel.select(3, BytePlus.stringToByteArray("10"));
				//System.out.println("FIM");
				String mat = new String();
				
				HashJoin hj = new HashJoin(sel, catA, catDH);
				hj.juncao(1);
				sel.atualizaSelecao(hj.getHashByte());
			
				mat = insereMatricula();
				
				sel.selectDenovo(2, BytePlus.stringToByteArray(mat));
			
				CatalogoDisciplinas catD = new CatalogoDisciplinas();
			
				HashJoin hj2 = new HashJoin(sel, catD, catDH);
				hj2.juncao(2);
			
				hj2.imprime();
		}
	}
	
	public void planoConsulta(int opcao){
		
		switch(opcao){
		case 1:
			System.out.println("♣♣♣♣♣♣ Arvore 1 ♣♣♣♣♣♣\n");
			System.out.println(" Π (Aluno.nome, Aluno.matricula)");
			System.out.println("\t |");
			System.out.println(" σ(Curso.nome)");
			System.out.println("\t |");
			System.out.println("          ⋈");
			System.out.println("\t/  \\");
			System.out.println("   ALUNO    CURSO\n");
			pausa();
			System.out.println("♣♣♣♣♣♣ Arvore 2 ♣♣♣♣♣♣\n");
			System.out.println("Π (Aluno.nome, Aluno.matricula)");
			System.out.println("\t  |");
			System.out.println("          ⋈");
			System.out.println("\t/    \\");
			System.out.println("   ALUNO    σ(Curso.nome)");
			System.out.println("\t \t |");
			System.out.println("\t\tCURSO");
			pausa();
			System.out.println("Como a seleção poda a tabela e é interessante que as junções sejam feitas com a tabela no menor tamanho possível, para um melhor desempenho, as seleções devem ser feitas primeiro.");
			System.out.println("Escolha de árvore: ♣♣ Árvore 2 ♣♣");
			pausa();
			System.out.println("Escolha do Algoritmo de Junção:");
			System.out.println("Considerando que as duas relações estão ordenadas pelos atributos de junção, uma boa escolha seria o algoritmo Sort-Merge Join");
			break;
			
	   case 2:
		    System.out.println("♣♣♣♣♣♣ Arvore 1 ♣♣♣♣♣♣\n");
			System.out.println("\t Π (Disciplina.nome)");
			System.out.println("\t\t |");
			System.out.println(" \t σ (Aluno.matricula, DisciplinaHistorico.nota)");
			System.out.println("\t\t |");
			System.out.println("    \t        ⋈ ");
			System.out.println("\t      /    \\");
			System.out.println("      DISCIPLINA     ⋈ ");
			System.out.println("\t     \t   /  \\");
			System.out.println("              ALUNO    DISCIPLINAHISTORICO\n");
			pausa();
			System.out.println("♣♣♣♣♣♣ Arvore 2 ♣♣♣♣♣♣\n");
			System.out.println("\t Π (Disciplina.nome)");
			System.out.println("\t\t |");
			System.out.println(" \t σ (Aluno.matricula, DisciplinaHistorico.nota)");
			System.out.println("\t\t |");
			System.out.println("    \t        ⋈ ");
			System.out.println("\t      /    \\");
			System.out.println("          ⋈    DISCIPLINA");
			System.out.println("\t /   \\");
			System.out.println("   ALUNO    DISCIPLINAHISTORICO\n");
			pausa();
			System.out.println("♣♣♣♣♣♣ Arvore 3 ♣♣♣♣♣♣\n");
			System.out.println("\t Π (Disciplina.nome)");
			System.out.println("\t\t |");
			System.out.println("    \t        ⋈ ");
			System.out.println("\t      /    \\");
			System.out.println("      DISCIPLINA    ⋈ ");
			System.out.println("\t     \t   /  \\");
			System.out.println("             σ            σ ");
			System.out.println("           (matricula)   (nota)");
			System.out.println("                 |          |");
			System.out.println("             ALUNO    DISCIPLINAHISTORICO\n");
			pausa();
			System.out.println("♣♣♣♣♣♣ Arvore 4 ♣♣♣♣♣♣\n");
			System.out.println("\t Π (Disciplina.nome)");
			System.out.println("\t\t |");
			System.out.println("    \t         ⋈ ");
			System.out.println("\t      /    \\");
			System.out.println("           ⋈    DISCIPLINA");
			System.out.println("\t /   \\");
			System.out.println("   σ            σ ");
			System.out.println(" (matriculo)   (nota)");
			System.out.println("      |           |");
			System.out.println("   ALUNO    DISCIPLINAHISTORICO\n");
			pausa();
			System.out.println("Como a seleção reduz o tamanho da tabela é recomendável faze-las primeiro.");
			System.out.println("Para obter um bom desempenho, é recomendável  que as junções sejam realizadas com a tabela de menor tamanho.");
			System.out.println("Escolha de árvore: ♣♣ Árvore 4 ♣♣");
			pausa();

			System.out.println("Considerando que as tabelas Alunos e Disciplinas possuem um índice por Tabela Hash e que as tabelas em questão são grandes, a busca mais eficiente seria a busca pelo algoritmo de Hash Join, para ambas junções.");
			break;
		}
	}
	public static void main(String[] args) throws IOException{
		Principal principal = new Principal();
		principal.titulo();
		
		Scanner scan = new Scanner(System.in);
		
		int opcao;
		
		do{
			principal.opcoesMenu();
			
			opcao = scan.nextInt();
			
			switch(opcao){
			
			case 1: principal.buscar(opcao);
				break;
			case 2:principal.buscar(opcao);
				break;
			case 3: principal.buscar(opcao);
				break;
			case 0: System.out.println("Sistema encerrado"); break;
			default: System.out.println("Opção inválida! Escolha outra opção!");
				//break;
			}
			
			
			
		}while(opcao != 0);
		
		
  }
	
}