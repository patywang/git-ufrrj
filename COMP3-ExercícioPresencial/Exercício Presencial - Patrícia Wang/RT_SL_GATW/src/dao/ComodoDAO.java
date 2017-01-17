package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.gateway.ComodoGateway;
import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Cozinha;
import entidades.Quarto;
import entidades.Sala;
import enums.TipoComodo;

public class ComodoDAO{
	
	public void inserirComodo(Comodo comodo){
		
		try {
			ComodoGateway.inserirComodo(comodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public int recuperaPai() throws SQLException{
		
        ResultSet rs = ComodoGateway.recuperaPai();
        int idPai = 0;
        try{
          
            while (rs.next()){
        	
            	String idComodo = rs.getString("id");
            	idPai = (Integer.parseInt(idComodo));

            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        rs.close();
		return idPai ;
	}
	
	public List<Comodo> listarComodo(String tipo) throws SQLException{
		
        ResultSet rs = ComodoGateway.listarComodo(tipo);
        
        List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		listaComodo.add(coz);
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		listaComodo.add(quarto);
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		listaComodo.add(sala);
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		listaComodo.add(comodoC);
            	}

            }
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        rs.close();
		return listaComodo;
	}
	
     public List<Comodo> listarComodoTotal() throws SQLException{
		
		
        ResultSet rs = ComodoGateway.listarComodoTotal();
        
        List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		coz.setTipoComodo(tipoComodo);
            		listaComodo.add(coz);
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		quarto.setTipoComodo(tipoComodo);
            		listaComodo.add(quarto);
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		sala.setTipoComodo(tipoComodo);
            		listaComodo.add(sala);
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		comodoC.setTipoComodo(tipoComodo);
            		listaComodo.add(comodoC);
            	}

            }
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        rs.close();
		return listaComodo;
	}
	
	
	public void deletarComodo(Comodo comodo) {
		
		try {
			ComodoGateway.deletarComodo(comodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarComodo(Comodo comodo){
		try {
			ComodoGateway.editarComodo(comodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verificarComodoEmComposto(int idComodo) throws SQLException{

		
        ResultSet rs = ComodoGateway.verificarComodoEmComposto(idComodo);
        String id = "";
        
        try{
           
            while (rs.next()){
            	id = rs.getString("id_comodo");
            }
            if (id.isEmpty()){
            	return true;
            }
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        rs.close();
		return false;
	}
	
	public void associarComodoParaComodoComposto(int idComodo, int idTodo){
		try {
			ComodoGateway.associarComodoParaComodoComposto(idComodo, idTodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Comodo recuperarComodoPorId(int idComodo) throws SQLException{
		
		
        ResultSet rs = ComodoGateway.recuperarComodoPorId(idComodo);
        
        Comodo comodo = null;
        //List<Comodo>listaComodo =  new ArrayList<Comodo>();
        try{
        	
            while(rs.next()){
            	
            	String desc = rs.getString("descricao");
            	String id = rs.getString("id");
            	String tipoComodo = rs.getString("tipo");
            	 
            	if(tipoComodo.equals(TipoComodo.COZINHA.toString())){
            		Cozinha coz = new Cozinha();
            		coz.setIdComodo(Integer.parseInt(id));
            		coz.setDescricao(desc);
            		coz.setTipoComodo(tipoComodo);
            		//listaComodo.add(coz);
            		comodo = coz;
            	}else if(tipoComodo.equals(TipoComodo.QUARTO.toString())){
            		Quarto quarto = new Quarto();
            		quarto.setIdComodo(Integer.parseInt(id));
            		quarto.setDescricao(desc);
            		quarto.setTipoComodo(tipoComodo);
            		//listaComodo.add(quarto);
            		comodo = quarto;
            	}else if(tipoComodo.equals(TipoComodo.SALA.toString())){
            		Sala sala = new Sala();
            		sala.setIdComodo(Integer.parseInt(id));
            		sala.setDescricao(desc);
            		sala.setTipoComodo(tipoComodo);
            		//listaComodo.add(sala);
            		comodo = sala;
            	}else{
            		ComodoComposto comodoC = new ComodoComposto();
            		comodoC.setIdComodo(Integer.parseInt(id));
            		comodoC.setDescricao(desc);
            		comodoC.setTipoComodo(tipoComodo);
            		//listaComodo.add(comodoC);
            		comodo = comodoC;
            		
            	}

            }
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        rs.close();
		return comodo;
	}

	public boolean verificarComodoEmMobilia(int idComodo) throws SQLException{

	
	    ResultSet rs = ComodoGateway.verificarComodoEmComposto(idComodo);
	    String id = "";
	    
	    try{
	        
	        while (rs.next()){
	        	id = rs.getString("id_mobilia");
	        }
	        if (id.isEmpty()){
	        	return true;
	        }
	
	    }catch(Exception e){
	        e.printStackTrace();
	        
	    }
	    rs.close();
		return false;
	}

	public void deletarComodoComposto(int id){
		
		try {
			ComodoGateway.deletarComodoComposto(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public List<Comodo> recuperarComodoComposto(int id) throws SQLException{
			
	        ResultSet rs = ComodoGateway.recuperarComodoComposto(id);
	       
	        List<Comodo>listaComodos =  new ArrayList<Comodo>();
	        try{
	        	
	            while(rs.next()){
	            	String desc = rs.getString("descricao");
	            	String id2 = rs.getString("id");
	            	ComodoComposto cp = new ComodoComposto();
	            	cp.setDescricao(desc);
	            	cp.setIdComodo(Integer.parseInt(id2));
	            	listaComodos.add(cp);
	            }
	        
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        rs.close();
	        return listaComodos;
	}
}
