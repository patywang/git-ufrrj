package tabela.e.layers;

import java.sql.SQLException;

import dao.MobiliaDAO;
import entidades.Mobilia;

public class ComodoMobiliaTB {
	
	public void associarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		int idComodo = 0;
		MobiliaDAO dao = new MobiliaDAO();
    	int idMobilia = dao.recuperarPaiMobilia();
    	int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		idComodo = mobilia.getComodo().get(j).getIdComodo();
    		dao.associarComodoMobilia(idMobilia,idComodo);
    	}
	}
	
	public void alterarListaComodoComMobilia(Mobilia mobilia) throws SQLException{
		
		MobiliaDAO dao = new MobiliaDAO();
		int tam = mobilia.getComodo().size();
    	for(int j = 0; j < tam; j ++){
    		int idComodo = mobilia.getComodo().get(j).getIdComodo();
    		dao.associarComodoMobilia(mobilia.getIdMobilia(),idComodo);
    	}
	}
	

}
