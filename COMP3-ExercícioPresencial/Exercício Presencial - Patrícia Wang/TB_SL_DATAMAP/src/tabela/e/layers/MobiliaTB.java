package tabela.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.MobiliaMapper;
import entidades.Comodo;
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
			
	    	MobiliaMapper mapperMobilia = new MobiliaMapper();
	    	mapperMobilia.inserirMobilia(mobilia);
	    	
	    	ComodoMobiliaTB tb = new ComodoMobiliaTB();
	    	tb.associarListaComodoComMobilia(mobilia);
	    	
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
			
	}
	
	public List<Mobilia>listarMobilias() throws SQLException{
    	
		MobiliaMapper mapperMobilia = new MobiliaMapper();
    	List<Mobilia>listaMobilia = mapperMobilia.listarMobilias();
    	return listaMobilia;
    	
    }
	
	public void deletarMobilia(int id) throws SQLException, ExceptionMobilias{
    	
		Mobilia mobilia = new Mobilia();
		mobilia.setIdMobilia(id);
		
		MobiliaMapper mapperMobilia = new MobiliaMapper();
    	Boolean naoItemVenda = mapperMobilia.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		mapperMobilia.deletarMobilia(mobilia);
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
			 	
			 	MobiliaMapper mapperMobilia = new MobiliaMapper();
		    	ComodoMobiliaTB tb = new ComodoMobiliaTB();
		    	Boolean naoItemVenda = mapperMobilia.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
		    	if(naoItemVenda){
		    		mapperMobilia.editarMobilia(mobilia);
		    		mapperMobilia.deletarMobiliaComodo(mobilia.getIdMobilia());
			    	tb.alterarListaComodoComMobilia(mobilia);
		    	}else{
		    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
		    	}
		 }else{
			 throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		 }
	}

}
