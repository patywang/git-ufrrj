package main;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import algebraRelacional.Selecao;
import algebraRelacional.SortMergeJoin;
import conversao.BytePlus;
import catalogo.CatalogoAlunos;
import catalogo.CatalogoCursos;
import catalogo.CatalogoDisciplinas;
import catalogo.CatalogoDisciplinasHistoricos;
import hash.Hash;
import hash.HashJoin;
import histograma.HistogramaAluno;
import histograma.HistogramaCurso;
import histograma.HistogramaDisciplina;
import histograma.HistogramaDisciplinaHistorico;
import arvoreB.ArvoreBDH;
import arvoreB.Chave;


		
		public class Init {

			public static void main(String[] args) throws IOException {
				
				/*HistogramaAluno catAluno = new HistogramaAluno();
				catAluno.arquivoALuno();
				
				HistogramaCurso catCurso = new HistogramaCurso();
				catCurso.arquivoCurso();
				
				HistogramaDisciplina catDisc = new HistogramaDisciplina();
				catDisc.arquivoDisciplina();
				
				HistogramaDisciplinaHistorico catHistDisc = new HistogramaDisciplinaHistorico();
				catHistDisc.arquivoDisciplinaHistorico();*/
				
				/*CatalogoDisciplinas catD = new CatalogoDisciplinas();
				Conversao.arquivoTxtParaByte(catD);
				
				CatalogoAlunos catA = new CatalogoAlunos();
				Conversao.arquivoTxtParaByte(catA);
				
				CatalogoCursos catC = new CatalogoCursos();
				Conversao.arquivoTxtParaByte(catC);
				
				CatalogoDisciplinasHistoricos catDH= new CatalogoDisciplinasHistoricos();
				Conversao.arquivoTxtParaByte(catDH);
				*/
				/*CatalogoDisciplinasHistoricos catDh = new CatalogoDisciplinasHistoricos();
				Selecao sel = new Selecao(catDh);
				sel.select(3, Conversao.converteStringParaArrayDeBytes("10"), -1, null);
				*/
				
				
			/*	Selecao sel2 = new Selecao(catA);
				sel2.select(2, BytePlus.stringToByteArray("2009113902"), -1, null);
			*/	
				/*Hash h = new Hash(catA, 2000);
				h.hashAluno(0);
				*/
				//para 1 condicao:
				//sel.select(2, Conversao.converteStringParaArrayDeBytes("1"),-1,null);
				//sel.select(1, Conversao.converteStringParaArrayDeBytes("CERIMONIAL E PROTOCOLO"),-1,null);
				//sel.select(0, Conversao.converteStringParaArrayDeBytes("303"),-1,null);
				//para 2condioes:
				//sel.select(0, Conversao.converteStringParaArrayDeBytes("244"), 1, Conversao.converteStringParaArrayDeBytes("CERIMONIAL E PROTOCOLO"));
				
				/*CatalogoAlunos catA = new CatalogoAlunos();
				Hash h = new Hash(catA, 2000);
				h.hashAluno(0);
				*/
				//HashJoin hj = new HashJoin(sel2,catA);
				//hj.juncao(1);
				
				/*CatalogoDisciplinasHistoricos catDH = new CatalogoDisciplinasHistoricos();
		        CatalogoDisciplinas catD = new CatalogoDisciplinas();
		      //  CatalogoAlunos catA = new CatalogoAlunos();
		        CatalogoCursos catC = new CatalogoCursos();
		        //Conversao.arquivoTxtParaByte(catC);
		        Selecao sel = new Selecao(catC);
		        sel.select(1, BytePlus.stringToByteArray("ADMINISTRACAO"));
		        System.out.println(catC.getArqivoDAT());
		      SortMergeJoin join = new SortMergeJoin(catA, sel);
		      		join.mergeJoin(0, 1);
		      		
		      		for(int i=0; i<join.getTabelaSize(); i++){
		      			for(int j = 0; j<join.getTabela(i).size(); j++){
		      				if(j == 3 || j == 4)
		      					System.out.print(BytePlus.byteArrayToString(join.getTabelaFinal(i,j)) + " ");
		      			}
		      			System.out.println("");
		      		}*/
				
				/*CatalogoAlunos catA = new CatalogoAlunos();
				//Hash h = new Hash(catA, 2000);
				//h.hashAluno(0);
				
				
				CatalogoDisciplinasHistoricos catDH = new CatalogoDisciplinasHistoricos();
				Selecao sel = new Selecao(catDH);
				sel.select(3, BytePlus.stringToByteArray("10"));
				System.out.println("FIM");
				
				HashJoin hj = new HashJoin(sel, catA, catDH);
				hj.juncao(1);
				//hj.imprime();
				sel.atualizaSelecao(hj.getHashByte());
				
				sel.selectDenovo(2, BytePlus.stringToByteArray("2003513902"));
				//sel.select(3, BytePlus.stringToByteArray("2003513902"));
				
				CatalogoDisciplinas catD = new CatalogoDisciplinas();
				
				HashJoin hj2 = new HashJoin(sel, catD, catDH);
				hj2.juncao(2);
				
				hj2.imprime();*/
				
						
						/*HistogramaAluno catAluno = new HistogramaAluno();
						catAluno.arquivoALuno();
						
						HistogramaCurso catCurso = new HistogramaCurso();
						catCurso.arquivoCurso();
						
						HistogramaDisciplina catDisc = new HistogramaDisciplina();
						catDisc.arquivoDisciplina();
						
						HistogramaDisciplinaHistorico catHistDisc = new HistogramaDisciplinaHistorico();
						catHistDisc.arquivoDisciplinaHistorico();*/
						
						/*CatalogoDisciplinas catD = new CatalogoDisciplinas();
						Conversao.arquivoTxtParaByte(catD);
						
						CatalogoAlunos catA = new CatalogoAlunos();
						Conversao.arquivoTxtParaByte(catA);
						
						CatalogoCursos catC = new CatalogoCursos();
						Conversao.arquivoTxtParaByte(catC);
						
						CatalogoDisciplinasHistoricos catDH= new CatalogoDisciplinasHistoricos();
						Conversao.arquivoTxtParaByte(catDH);
						*/
						/*CatalogoDisciplinasHistoricos catDh = new CatalogoDisciplinasHistoricos();
						Selecao sel = new Selecao(catDh);
						sel.select(3, Conversao.converteStringParaArrayDeBytes("10"), -1, null);
						*/
						
						
					/*	Selecao sel2 = new Selecao(catA);
						sel2.select(2, BytePlus.stringToByteArray("2009113902"), -1, null);
					*/	
						/*Hash h = new Hash(catA, 2000);
						h.hashAluno(0);
						*/
						//para 1 condicao:
						//sel.select(2, Conversao.converteStringParaArrayDeBytes("1"),-1,null);
						//sel.select(1, Conversao.converteStringParaArrayDeBytes("CERIMONIAL E PROTOCOLO"),-1,null);
						//sel.select(0, Conversao.converteStringParaArrayDeBytes("303"),-1,null);
						//para 2condiçoes:
						//sel.select(0, Conversao.converteStringParaArrayDeBytes("244"), 1, Conversao.converteStringParaArrayDeBytes("CERIMONIAL E PROTOCOLO"));
						
						/*CatalogoAlunos catA = new CatalogoAlunos();
						Hash h = new Hash(catA, 2000);
						h.hashAluno(0);
						*/
						//HashJoin hj = new HashJoin(sel2,catA);
						//hj.juncao(1);
						
						/*CatalogoDisciplinasHistoricos catDH = new CatalogoDisciplinasHistoricos();
				        CatalogoDisciplinas catD = new CatalogoDisciplinas();
				      //  CatalogoAlunos catA = new CatalogoAlunos();
				        CatalogoCursos catC = new CatalogoCursos();
				        //Conversao.arquivoTxtParaByte(catC);
				        Selecao sel = new Selecao(catC);
				        sel.select(1, BytePlus.stringToByteArray("ADMINISTRACAO"));
				        System.out.println(catC.getArqivoDAT());
				      SortMergeJoin join = new SortMergeJoin(catA, sel);
				      		join.mergeJoin(0, 1);
				      		
				      		for(int i=0; i<join.getTabelaSize(); i++){
				      			for(int j = 0; j<join.getTabela(i).size(); j++){
				      				if(j == 3 || j == 4)
				      					System.out.print(BytePlus.byteArrayToString(join.getTabelaFinal(i,j)) + " ");
				      			}
				      			System.out.println("");
				      		}*/
						
						//CatalogoAlunos catA = new CatalogoAlunos();
						//Hash h = new Hash(catA, 2000);
						//h.hashAluno(0);
						
						/*CatalogoAlunos catA = new CatalogoAlunos();
						CatalogoDisciplinasHistoricos catDH = new CatalogoDisciplinasHistoricos();
						Selecao sel = new Selecao(catDH);
						sel.select(3, BytePlus.stringToByteArray("10"));
						System.out.println("FIM");
						
						HashJoin hj = new HashJoin(sel, catA, catDH);
						hj.juncao(1);*/
						//hj.imprime();
						//sel.atualizaSelecao(hj.getHashByte());
						
						//sel.selectDenovo(2, BytePlus.stringToByteArray("2003513902"));
						//sel.select(3, BytePlus.stringToByteArray("2003513902"));
						
						/*CatalogoDisciplinas catD = new CatalogoDisciplinas();
						
						HashJoin hj2 = new HashJoin(sel, catD, catDH);
						hj2.juncao(2);
						
						hj2.imprime();*/
						
						CatalogoAlunos catA = new CatalogoAlunos();
						Selecao sel = new Selecao(catA);
						sel.select(2, BytePlus.stringToByteArray("2004113902"));
						System.out.println("Iniciando a busca...");
						ArvoreBDH tree = new ArvoreBDH(4);
						tree.insereDoArquivo();
						CatalogoDisciplinas catD = new CatalogoDisciplinas();
						HashJoin hj = new HashJoin(sel, catD, new CatalogoDisciplinas());
						//cat.getHashTable().criarTabela();
						int i =0;
						for(ArrayList<byte[]> lista : sel.linhaArray){
							//System.out.print(lista.get(0));
							i++;
							
							tree.busca(BytePlus.byteArrayToString(lista.get(0)));
							for(Chave p : tree.rBusca){
								if(BytePlus.byteArrayToString(p.getAno()).equals("2009") && BytePlus.byteArrayToString(p.getPeriodo()).equals("1")){
									//System.out.println("ta aqui");
									System.out.print(BytePlus.byteArrayToString(p.getNota())+"\t");
									RandomAccessFile r = new RandomAccessFile(new CatalogoDisciplinas().getArqivoDAT(), "r");
									r.seek(hj.getHash().getNo(p.getDisciplina_id()) );
									int lenght = r.readInt();
									byte[] temporario = new byte[lenght];
									r.read(temporario);
									//System.out.print(BytePlus.byteArrayToString(temporario)+"\n");
									r.seek(hj.getHash().getNo(temporario));
									lenght = r.readInt();
									byte[] temporario2 = new byte[lenght];
									r.read(temporario2);
									String[] str = BytePlus.byteArrayToString(temporario2).split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
									System.out.print(BytePlus.byteArrayToString(temporario2)+"\n");
									r.close();
								}
							}
					}
						}
		
		
			}


