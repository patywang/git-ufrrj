package transacoes.e.layers;

import java.sql.SQLException;

import data.mapper.MobiliaMapper;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class DeletarMobiliaRT {

	public void deletarMobilia(int id) throws SQLException, ExceptionMobilias{
    	
		Mobilia mobilia = new Mobilia();
		mobilia.setIdMobilia(id);
		
    	MobiliaMapper mapper = new MobiliaMapper();
    	Boolean naoItemVenda = mapper.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		mapper.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
    }
}
