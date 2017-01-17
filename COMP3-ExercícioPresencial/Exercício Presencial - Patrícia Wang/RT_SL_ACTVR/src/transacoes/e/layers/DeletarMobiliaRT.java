package transacoes.e.layers;

import java.sql.SQLException;

import entidades.ItemVenda;
import entidades.Mobilia;
import exceptions.ExceptionMobilias;

public class DeletarMobiliaRT {

	public void deletarMobilia(int id) throws SQLException, ExceptionMobilias{
    	
		Mobilia mobilia = new Mobilia();
		mobilia.setIdMobilia(id);
		ItemVenda actvRecItem = new ItemVenda();
		Mobilia actRecMob = new Mobilia();
    	Boolean naoItemVenda = actvRecItem.verificarMobiliaEmItemVenda(mobilia.getIdMobilia());
    	if(naoItemVenda){
    		actRecMob.deletarMobilia(mobilia);
    	}else{
    		throw new ExceptionMobilias("MOBILIA ASSOCIADA A ITEM VENDA!");
    	}
    }
}
