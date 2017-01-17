package transacoes.e.layers;

import java.sql.SQLException;

import dao.MobiliaDAO;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class DeletarMobiliaRT {

	public void deletarMobilia(int id) throws SQLException, ExceptionMobilias{
    	
		Mobilia mobilia = new Mobilia();
		mobilia.setIdMobilia(id);
		
    	MobiliaDAO dao = new MobiliaDAO();
    	Boolean naoItemVenda = dao.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		dao.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
    }
}
