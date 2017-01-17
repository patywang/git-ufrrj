package dominio.e.layers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;
import entidades.Sala;
import exceptions.ExceptionEditarOuDeletarComodo;

public class SalaDM {

	public void criarSala(Sala sala) throws  IOException, SQLException {
		
		if(sala != null && !sala.getDescricao().isEmpty()){
			ComodoMapper comodoMapper = new ComodoMapper();
			comodoMapper.inserirComodo(sala);

		}
	}
	
	public void editarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.editarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
    }
	
	public List<Comodo> listarSala(String tipo) throws SQLException{
		ComodoMapper comodoMapper = new ComodoMapper();
    	List<Comodo>listaSala  = comodoMapper.listarComodo(tipo);
    	return listaSala;
	}
	
	public void deletarSala(Sala sala) throws IOException, SQLException, ExceptionEditarOuDeletarComodo {
    	
		ComodoMapper comodoMapper = new ComodoMapper();
    	
    	Boolean naoComposto = comodoMapper.verificarComodoEmComposto(sala.getIdComodo());
    	Boolean naoMobilia = comodoMapper.verificarComodoEmMobilia(sala.getIdComodo());
    	
    	if(naoComposto && naoMobilia){
    		comodoMapper.deletarComodo(sala);
    	}else{
    		throw new ExceptionEditarOuDeletarComodo("COMODO ASSOCIADO A UM COMODO COMPOSTO E/OU MOBÍLIA");
    	}
	}
		
}
