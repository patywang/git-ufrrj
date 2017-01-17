package tabela.e.layers;

import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.ComodoComposto;

public class ComodoCompostoTB {
	
	public void associarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoMapper mapper = new ComodoMapper();
		int idTodo = mapper.recuperaPai();
		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			mapper.associarComodoParaComodoComposto(idComodo,idTodo);
		}
	}
	
	public void alterarListaComodoComComposto(ComodoComposto composto) throws SQLException{
		ComodoMapper mapperComodo = new ComodoMapper();

		for(int i = 0; i < composto.getComodos().size(); i++){
			int idComodo = composto.getComodos().get(i).getIdComodo();
			mapperComodo.associarComodoParaComodoComposto(idComodo,composto.getIdComodo());
		}
	}
	

}
