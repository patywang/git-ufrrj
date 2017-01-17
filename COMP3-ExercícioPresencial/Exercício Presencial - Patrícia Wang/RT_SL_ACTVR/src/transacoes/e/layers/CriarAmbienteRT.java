package transacoes.e.layers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Ambiente;
import entidades.ItemVenda;
import entidades.Mobilia;

public class CriarAmbienteRT {

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
    	Ambiente actvRecAmbiente = new Ambiente();
    	int id = actvRecAmbiente.recuperarAmbiente();
    	return id;
    }
	
	public float criarAmbiente(Ambiente ambiente) throws SQLException{
    	float somatorioQuantidade = 0;
    	Mobilia actvMobilia = new Mobilia();
    	Ambiente actvRecAmbiente = new Ambiente();
    	ItemVenda actvRecItem = new ItemVenda();
    	actvRecAmbiente.inserirAmbiente(ambiente);
    	int idAmbiente = recuperarIdAmbiente();
    	
    	for(Integer chave : ambiente.getMobilias().keySet()){
    		Integer quantidade = ambiente.getMobilias().get(chave);
    		ItemVenda item = new ItemVenda();
    		item.setQuantidade(quantidade);
    		Mobilia mobilia = actvMobilia.recuperarMobiliaPorId(chave);
    		item.setMobilia(mobilia);
    		actvRecItem.associarItemVenda(idAmbiente, item);
    		somatorioQuantidade += (item.getQuantidade()*item.getMobilia().getCusto());
    		tempoEntrega.add(item.getMobilia().getTempoEntrega());
    	}
    	
    	return somatorioQuantidade;
    }
}
