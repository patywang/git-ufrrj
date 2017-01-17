package transacoes.e.layers;

import java.sql.SQLException;

import data.mapper.ComodoMapper;
import entidades.Cozinha;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;

public class CriarCozinhaRT {

	public void criarCozinha(String desc) throws SQLException, ExceptionCampoVazio {
    	
		if(desc != null && !desc.isEmpty()){
			Cozinha coz = new Cozinha();
			coz.setDescricao(desc);
			coz.setTipoComodo(TipoComodo.COZINHA.toString());
			ComodoMapper comodoMapper = new ComodoMapper();
			comodoMapper.inserirComodo(coz);
			
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	
	}
}
