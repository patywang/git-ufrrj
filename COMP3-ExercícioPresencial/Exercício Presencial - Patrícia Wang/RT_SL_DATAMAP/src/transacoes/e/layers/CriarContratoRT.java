package transacoes.e.layers;

import java.sql.SQLException;

import data.mapper.AmbienteMapper;
import data.mapper.ContratoMapper;
import entidades.Ambiente;
import entidades.Contrato;

public class CriarContratoRT {

	public void criarContrato(Contrato contrato) throws SQLException{
    	ContratoMapper mapperContrato = new ContratoMapper();
    	mapperContrato.inserirContrato(contrato);
    	int contratoId = mapperContrato.recuperarContratoId();
    	AmbienteMapper mapperAmbiente = new AmbienteMapper();
    	for(Ambiente a : contrato.getAmbiente()){
    		int idAmbiente = a.getIdAmbiente();
    		mapperAmbiente.atualizarAmbienteComContrato(idAmbiente, contratoId);
    	}
    }
}
