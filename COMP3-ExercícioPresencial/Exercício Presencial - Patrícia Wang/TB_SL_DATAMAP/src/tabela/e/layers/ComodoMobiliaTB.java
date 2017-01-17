package tabela.e.layers;

import java.sql.SQLException;

import data.mapper.MobiliaMapper;
import entidades.Mobilia;

public class ComodoMobiliaTB {
	
	public void associarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		int idComodo = 0;
		MobiliaMapper mapperMobilia = new MobiliaMapper();
    	int idMobilia = mapperMobilia.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		mapperMobilia.associarComodoMobilia(idMobilia,idComodo);
    	}
	}
	
	public void alterarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		MobiliaMapper mapperMobilia = new MobiliaMapper();
		int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
    		mapperMobilia.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
    	}
	}
	

}
