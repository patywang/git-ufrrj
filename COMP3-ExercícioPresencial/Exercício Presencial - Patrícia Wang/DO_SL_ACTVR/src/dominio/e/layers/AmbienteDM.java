package dominio.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import singletons.SingletonAmbiente;
import entidades.Ambiente;
import entidades.ItemVenda;
import entidades.Mobilia;

public class AmbienteDM {

	List<Integer>tempoEntrega = new ArrayList<Integer>();
	
	 public int maiorTempoDeEntrega(List<Integer>tempoEntrega){
	    	
	    	int maior = 0;
	    	for(int i = 0; i < tempoEntrega.size(); i++){
				System.out.println("entrega: " + tempoEntrega.get(i));
				if(tempoEntrega.get(i) > maior ){
					maior = tempoEntrega.get(i);
				}
			}
	    	return maior;
	 } 
	 
	public int recuperarIdAmbiente() throws SQLException{
   	Ambiente activeRecordAmbiente = new Ambiente();
   	int id = activeRecordAmbiente.recuperarAmbiente();
   	return id;
   }
	
	public float criarAmbiente(Ambiente ambiente) throws SQLException{
   	float somatorioQuantidade = 0;
   	Mobilia activeRecordMobilia = new Mobilia();
	Ambiente activeRecordAmbiente = new Ambiente();
	ItemVenda actvRecordItem = new ItemVenda();
	activeRecordAmbiente.inserirAmbiente(ambiente);
   	int idAmbiente = recuperarIdAmbiente();
   	
   	for(Integer chave : ambiente.getMobilias().keySet()){
   		Integer quantidade = ambiente.getMobilias().get(chave);
   		ItemVenda item = new ItemVenda();
   		item.setQuantidade(quantidade);
   		Mobilia mobilia = activeRecordMobilia.recuperarMobiliaPorId(chave);
   		item.setMobilia(mobilia);
   		actvRecordItem.associarItemVenda(idAmbiente, item);
   		somatorioQuantidade += (item.getQuantidade()*item.getMobilia().getCusto());
   		tempoEntrega.add(item.getMobilia().getTempoEntrega());
   	}
   	
   	return somatorioQuantidade;
   }
	
	public static List<Ambiente> retornaListaAmbiente(){
		List<Ambiente> lista = SingletonAmbiente.getInstance().getAmbientes();
		return lista;
	}
	
	public static void inserirAmbienteLista(Ambiente ambiente){
		SingletonAmbiente.getInstance().insereAmbiente(ambiente);
	}
	
   public static Map<Integer, Integer> retornaMapAmbiente(String[] mobilias, String[] quant){
		
		Map<Integer, Integer> mapAmbiente = new HashMap<Integer, Integer>();
		for(int i = 0; i < quant.length; i++){
			
			if(!mapAmbiente.containsKey(Integer.parseInt(mobilias[i]))){
				mapAmbiente.put(Integer.parseInt(mobilias[i]), Integer.parseInt(quant[i]));
			}else{
				for(Iterator it = mapAmbiente.entrySet().iterator(); it.hasNext();){
					Map.Entry entry = (Map.Entry) it.next();
					if(Integer.parseInt(mobilias[i]) == (Integer)entry.getKey()){
						entry.setValue((Integer)entry.getValue() + Integer.parseInt(quant[i]));
					}
					
				}
			}

		}
		return mapAmbiente;
	}
}
