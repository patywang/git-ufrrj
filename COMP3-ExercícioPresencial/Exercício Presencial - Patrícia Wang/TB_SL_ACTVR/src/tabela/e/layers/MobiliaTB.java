package tabela.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ItemVenda;
import entidades.Mobilia;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionMobilias;

public class MobiliaTB {
	
	public void inserirMobilia(String desc, float custo, int tempoEntrega,List<Comodo> comodosMobilia) throws SQLException, ExceptionCampoVazio{
		
		if(desc != null && !desc.isEmpty() && comodosMobilia != null){
			
			Mobilia mobilia = new Mobilia();
			mobilia.setDescricao(desc);
			mobilia.setCusto(custo);
			mobilia.setTempoEntrega(tempoEntrega);
			mobilia.setComodo(comodosMobilia);
			
			Mobilia actRecMob = new Mobilia();
			actRecMob.inserirMobilia(mobilia);
	    	
	    	ComodoMobiliaTB tb = new ComodoMobiliaTB();
	    	tb.associarListaComodoComMobilia(mobilia);
	    	
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
			
	}
	
	public List<Mobilia>listarMobilias() throws SQLException{
    	
		Mobilia actRecMob = new Mobilia();
    	List<Mobilia>listaMobilia = actRecMob.listarMobilias();
    	return listaMobilia;
    	
    }
	
	public void deletarMobilia(int id) throws SQLException, ExceptionMobilias{
    	
		Mobilia mobilia = new Mobilia();
		mobilia.setIdMobilia(id);
		
		Mobilia actRecMob = new Mobilia();
		ItemVenda actRecItem = new ItemVenda();
    	Boolean naoItemVenda = actRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		actRecMob.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
    }
	
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
		    	ComodoMobiliaTB tb = new ComodoMobiliaTB();
		    	Boolean naoItemVenda = actRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
		    	if(naoItemVenda){
		    		actRecMob.editarMobilia(mobilia);
		    		actRecMob.deletarMobiliaComodo(mobilia.getIdMobilia());
			    	tb.alterarListaComodoComMobilia(mobilia);
		    	}else{
		    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
		    	}
		 }else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		 }
	}

}
