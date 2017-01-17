package tabela.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Cozinha;
import entidades.Quarto;
import entidades.Sala;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;
import exceptions.ExceptionEditarOuDeletarComodo;

public class ComodoTB {

     public void criarComodo(String desc, String tipo,List<Comodo>comodos) throws SQLException, ExceptionCampoVazio {
    	
		if(desc != null && !desc.isEmpty()){
			
			
			if(tipo.equals(TipoComodo.COZINHA.toString())){
				Cozinha coz = new Cozinha();
				coz.setDescricao(desc);
				coz.setTipoComodo(TipoComodo.COZINHA.toString());
				Comodo.inserirComodo(coz);
			}else if(tipo.equals(TipoComodo.SALA.toString())){
				Sala sala = new Sala();
				sala.setDescricao(desc);
				sala.setTipoComodo(TipoComodo.SALA.toString());
				Comodo.inserirComodo(sala);
			}else if(tipo.equals(TipoComodo.QUARTO.toString())){
				Quarto quarto = new Quarto();
	    		quarto.setDescricao(desc);
	    		quarto.setTipoComodo(TipoComodo.QUARTO.toString());
	    		Comodo.inserirComodo(quarto);
			}else{
				if(comodos != null){
					ComodoComposto composto = new ComodoComposto();
					ComodoCompostoTB tbComposto = new ComodoCompostoTB();
					composto.setDescricao(desc);
					composto.setTipoComodo(TipoComodo.COMODO_COMPOSTO.toString());
					composto.setComodos(comodos);
					Comodo.inserirComodo(composto);
					tbComposto.associarListaComodoComComposto(composto);
					
				}else{
					throw new ExceptionCampoVazio("A LISTA DE CÔMODOS ESTÁ VAZIA!");
				}
			}
			
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	}
     
     public List<Comodo> listarComodo(String tipo) throws SQLException{
   	  
	    	List<Comodo> listaComodo = Comodo.listarComodo(tipo);
	    	return listaComodo;
	 }
     
     public void deletarComodo(int id) throws  IOException, SQLException, ExceptionEditarOuDeletarComodo {
     	
    	ComodoComposto actRecComposto = new ComodoComposto();
     	Boolean naoComposto = actRecComposto.verificarComodoEmComposto(id);
     	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(id);
     	
     	if(naoComposto && naoMobilia){
     		Comodo.deletarComodo(id);
     	}else{
     		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
     	}
 	}
     
     public void editarComodo(int id, String descNova,String tipo,List<Comodo> comodosLista) throws ExceptionCampoVazio, SQLException, ExceptionEditarOuDeletarComodo{
    	 
    	 if(descNova != null && !descNova.isEmpty()){
    		 
    		 ComodoComposto actRecComposto = new ComodoComposto();
 	    	 Boolean naoComposto = actRecComposto.verificarComodoEmComposto(id);
 	    	 Boolean naoMobilia = Comodo.verificarComodoEmMobilia(id);
 	    	 
 	    	if(naoComposto && naoMobilia){
 	    		
 	    		if(tipo.equals(TipoComodo.COZINHA)){
 	    			
 	    			Cozinha cozinha = new Cozinha();
 	    			cozinha.setDescricao(descNova);
 	    			cozinha.setIdComodo(id);
 	    			Comodo.editarComodo(cozinha);
 	    			
 	    		}else if(tipo.equals(TipoComodo.SALA)){
 	    			
 	    			Sala sala = new Sala();
 	    			sala.setId(id);
 	    			sala.setDescricao(descNova);
 	    			Comodo.editarComodo(sala);
 	    			
 	    		}else if((tipo.equals(TipoComodo.QUARTO))){
 	    			
 	    			Quarto quarto = new Quarto();
 	    			quarto.setIdComodo(id);
 	    			quarto.setDescricao(descNova);
 	    			Comodo.editarComodo(quarto);
 	    			
 	    		}else{
 	    			ComodoCompostoTB tbComposto = new ComodoCompostoTB();
 	    			ComodoComposto composto = new ComodoComposto();
 	    			composto.setIdComodo(id);
 	    			composto.setDescricao(descNova);
 	    			composto.setComodos(comodosLista);
 	    			Comodo.editarComodo(composto);
 	    			actRecComposto.deletarComodoComposto(composto.getIdComodo());
 	    			tbComposto.alterarListaComodoComComposto(composto);
 	    		}
 	    		
	    	}else{
	    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
	    	}
 	    	 
 	    	 
    	 }else{
   		  		throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
   	     }
     }
     
     public static List<Comodo> recuperarComodos(String[] comodos) throws SQLException{
     	
     	List<Comodo> listaComodos = new ArrayList<Comodo>();
     	
     	for (int i = 0; i < comodos.length; i++){
     		int idComodo = Integer.parseInt(comodos[i]);
     		listaComodos.add(Comodo.recuperarComodoPorId(idComodo));
     	}
     	return listaComodos;
     }
}
