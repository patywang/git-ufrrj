package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.MobiliaMapper;
import entidades.Mobilia;

public class ListarMobiliaRT {

	public List<Mobilia>listarMobilias() throws SQLException{
    	
		MobiliaMapper mapper = new MobiliaMapper();
    	List<Mobilia>listaMobilia = mapper.listarMobilias();
    	return listaMobilia;
    	
    }
}
