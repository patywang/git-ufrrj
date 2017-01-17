package transacoes.e.layers;

import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Cozinha;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;

public class CriarCozinhaRT {

	public void criarCozinha(String desc) throws SQLException, ExceptionCampoVazio {
    	
		if(desc != null && !desc.isEmpty()){
			Cozinha coz = new Cozinha();
			coz.setDescricao(desc);
			coz.setTipoComodo(TipoComodo.COZINHA.toString());
			ComodoDAO daoComodo = new ComodoDAO();
			daoComodo.inserirComodo(coz);
			
		}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
	
	}
}
