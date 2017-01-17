package transacoes.e.layers;

import java.sql.SQLException;
import java.util.List;

import data.mapper.ComodoMapper;
import entidades.Comodo;
import entidades.ComodoComposto;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;

public class CriarComodoCompostoRT {

	public void inserirComodoComposto(String descricao, List<Comodo>comodo) throws SQLException, ExceptionCampoVazio{
    	
		if(descricao != null && !descricao.isEmpty() && comodo != null){
			
			int idTodo = 0;
			ComodoComposto composto = new ComodoComposto();
			composto.setDescricao(descricao);
			composto.setTipoComodo(TipoComodo.COMODO_COMPOSTO.toString());
			composto.setComodos(comodo);
			
			ComodoMapper comodoMapper = new ComodoMapper();
			comodoMapper.inserirComodo(composto);
			idTodo = comodoMapper.recuperaPai();
			for(int i = 0; i < composto.getComodos().size(); i++){
				int idComodo = composto.getComodos().get(i).getIdComodo();
				comodoMapper.associarComodoParaComodoComposto(idComodo,idTodo);
			}
			
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
		
    }
}
