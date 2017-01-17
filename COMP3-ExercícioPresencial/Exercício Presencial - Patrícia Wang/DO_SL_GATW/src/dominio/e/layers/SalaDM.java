package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ComodoDAO;
import entidades.Comodo;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class SalaDM {

	public void criarSala(Sala sala) throws  IOException, SQLException {
		
		if(sala != null && !sala.getDescricao().isEmpty()){
			ComodoDAO daoComodo = new ComodoDAO();
			daoComodo.inserirComodo(sala);

		}
	}
	
	public void editarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.editarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    }
	
	public List<Comodo> listarSala(String tipo) throws SQLException{
    	ComodoDAO dao = new ComodoDAO();
    	List<Comodo>listaSala  = dao.listarComodo(tipo);
    	return listaSala;
	}
	
	public void deletarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
    	ComodoDAO daoComodo = new ComodoDAO();
    	
    	Boolean naoComposto = daoComodo.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = daoComodo.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		daoComodo.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
		
}
