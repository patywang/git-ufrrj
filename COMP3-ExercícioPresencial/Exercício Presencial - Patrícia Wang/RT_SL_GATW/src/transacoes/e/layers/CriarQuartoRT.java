package transacoes.e.layers;

import java.sql.SQLException;

import dao.ComodoDAO;
import entidades.Quarto;
import enums.TipoComodo;
import exceptions.ExceptionCampoVazio;

public class CriarQuartoRT {

	public void criarQuarto(String desc) throws SQLException, ExceptionCampoVazio{
    	
    	if(desc != null && !desc.isEmpty()){
    		Quarto quarto = new Quarto();
    		quarto.setDescricao(desc);
    		quarto.setTipoComodo(TipoComodo.QUARTO.toString());
    		ComodoDAO daoComodo = new ComodoDAO();
    		daoComodo.inserirComodo(quarto);
    		
    	}else{
			throw new ExceptionCampoVazio("HÁ CAMPO VAZIO, INSIRA NOVAMENTE.");
		}
    }
}
