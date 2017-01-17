package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import entidades.Mobilia;

public class ListarMobiliaRT {

	public List<Mobilia>listarMobilias() throws SQLException{
    	
		Mobilia actRecMob = new Mobilia();
    	List<Mobilia>listaMobilia = actRecMob.listarMobilias();
    	return listaMobilia;
    	
    }
}
