package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ItemVenda;
import entidades.Mobilia;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionMobilias;

public class EditarMobiliaRT {

	 public void editarMobilia(String descNova,float custo,int tempo,List<Comodo>comodosMobilia,int id) throws SQLException, ExceptionMobilias, ExceptionCampoVazio{
		 
		 if(descNova != null && !descNova.isEmpty() && comodosMobilia != null){
		 	
			Mobilia mobilia = new Mobilia();
		 	mobilia.setIdMobilia(id);
		 	mobilia.setDescricao(descNova);
		 	mobilia.setCusto(custo);
		 	mobilia.setTempoEntrega(tempo);
		 	mobilia.setComodo(comodosMobilia);
		 	
	    	Mobilia actRecMob = new Mobilia();
	    	ItemVenda actRecItem = new ItemVenda();
	    	Boolean naoItemVenda = actRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
	    	if(naoItemVenda){
	    		actRecMob.editarMobilia(mobilia);
	    		actRecMob.deletarMobiliaComodo(mobilia.getIdMobilia());
		    	int tam = mobilia.getComodo().size();
		    	for(int j = 0; j < tam; j ++){
		    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
		    		actRecMob.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
		    	}
	    	}else{
	    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
	    	}
	    	
		 }else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		 }
			 
	 }
}
