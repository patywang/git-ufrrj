package transacoes.e.layers;

import java.io.IOException;
import java.sql.SQLException;

import entidades.Comodo;
import entidades.Sala;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;

public class CriarSalaRT {

	public void criarSala(String descricao) throws  IOException, SQLException, ExceptionCampoVazio {
			
			if(descricao != null && !descricao.isEmpty()){
				Sala sala = new Sala();
				sala.setDescricao(descricao);
				sala.setTipoComodo(TipoComodo.SALA.toString());
				
				Comodo.inserirComodo(sala);
	
			}else{
				throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
			}
			
	}
}
