package dominio.e.layers;

import java.sql.SQLException;

import entidades.Ambiente;
import entidades.Contrato;

public class ContratoDM {

	public void criarContrato(Contrato contrato) throws SQLException{
    	Contrato activeRecorContrato = new Contrato();
    	activeRecorContrato.inserirContrato(contrato);
    	int contratoId = activeRecorContrato.recuperarContratoId();
    	Ambiente activeRecordAmbiente = new Ambiente();
    	for(Ambiente a : contrato.getAmbiente()){
    		int idAmbiente = a.getIdAmbiente();
    		activeRecordAmbiente.atualizarAmbienteComContrato(idAmbiente, contratoId);
    	}
    }
}
