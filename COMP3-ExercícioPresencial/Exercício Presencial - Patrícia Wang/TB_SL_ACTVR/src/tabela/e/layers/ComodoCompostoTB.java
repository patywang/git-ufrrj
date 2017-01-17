package tabela.e.layers;

import java.sql.SQLException;

import entidades.Comodo;
import entidades.ComodoComposto;

public class ComodoCompostoTB {
	
	public void associarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoComposto actRecComposto = new ComodoComposto();
		int idTodo = Comodo.recuperaPai();
		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			actRecComposto.associarComodoParaComodoComposto(idComodo,idTodo);
		}
	}
	
	public void alterarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoComposto actRecComposto = new ComodoComposto();

		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			actRecComposto.associarComodoParaComodoComposto(idComodo,composto.getIdComodo());
		}
	}
	

}
