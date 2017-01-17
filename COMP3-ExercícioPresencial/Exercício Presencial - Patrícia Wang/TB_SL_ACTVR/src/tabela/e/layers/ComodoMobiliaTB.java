package tabela.e.layers;

import java.sql.SQLException;

import entidades.Mobilia;

public class ComodoMobiliaTB {
	
	public void associarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		int idComodo = 0;
		Mobilia actRecMob = new Mobilia();
    	int idMobilia = actRecMob.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		actRecMob.associarComodoMobilia(idMobilia,idComodo);
    	}
	}
	
	public void alterarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		Mobilia actRecMob = new Mobilia();
		int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
    		actRecMob.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
    	}
	}
	

}
