package tabela.e.layers;

import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.ComodoComposto;

public class ComodoCompostoTB {
	
	public void associarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoDAO dao = new ComodoDAO();
		int idTodo = dao.recuperaPai();
		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			dao.associarComodoParaComodoComposto(idComodo,idTodo);
		}
	}
	
	public void alterarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoDAO dao = new ComodoDAO();

		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			dao.associarComodoParaComodoComposto(idComodo,composto.getIdComodo());
		}
	}
	

}
