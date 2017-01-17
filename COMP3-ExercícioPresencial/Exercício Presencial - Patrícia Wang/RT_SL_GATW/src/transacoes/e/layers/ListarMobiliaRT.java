package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import dao.MobiliaDAO;
import entidades.Mobilia;

public class ListarMobiliaRT {

	public List<Mobilia>listarMobilias() throws SQLException{
    	
    	MobiliaDAO dao = new MobiliaDAO();
    	List<Mobilia>listaMobilia = dao.listarMobilias();
    	return listaMobilia;
    	
    }
}
