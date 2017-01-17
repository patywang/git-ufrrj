package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.Mobilia;
import exceptions.ExceptionCampoVazio;

public class CriarMobiliaRT {
	
	public void inserirMobilia(String desc, float custo, int tempoEntrega,List<Comodo> comodosMobilia) throws SQLException, ExceptionCampoVazio{
    	
		if(desc != null && !desc.isEmpty() && comodosMobilia != null){
	
			Mobilia mobilia = new Mobilia();
			mobilia.setDescricao(desc);
			mobilia.setCusto(custo);
			mobilia.setTempoEntrega(tempoEntrega);
			mobilia.setComodo(comodosMobilia);
			
			int idComodo = 0;
	    	Mobilia actRecMobilia = new Mobilia();
	    	actRecMobilia.inserirMobilia(mobilia);
	    	int idMobilia = actRecMobilia.recuperarPaiMobilia();
	    	int tam = mobilia.getComodo().size();
	    	for(int j = 0; j < tam; j ++){
	    		idComodo = mobilia.getComodo().get(j).getIdComodo();
	    		actRecMobilia.associarComodoMobilia(idMobilia,idComodo);
	    	}
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	
	}

}
