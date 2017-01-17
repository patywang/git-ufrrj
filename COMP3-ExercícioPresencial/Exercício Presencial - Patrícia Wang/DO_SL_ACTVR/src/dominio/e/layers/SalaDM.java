package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;
import entidades.ComodoComposto;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class SalaDM {

	public void criarSala(Sala sala) throws  IOException, SQLException {
		
		if(sala != null && !sala.getDescricao().isEmpty()){
			Comodo.inserirComodo(sala);

		}
	}
	
	public void editarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
    	
		ComodoComposto actvRecComposto = new ComodoComposto();
    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.editarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    }
	
	public List<Comodo> listarSala(String tipo) throws SQLException{
    	
    	List<Comodo>listaSala  = Comodo.listarComodo(tipo);
    	return listaSala;
	}
	
	public void deletarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		ComodoComposto actvRecComposto = new ComodoComposto();
    	
    	Boolean naoComposto = actvRecComposto.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = Comodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		Comodo.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
		
}
