package transacoes.e.layers;

import java.sql.SQLException;

import entidades.Ambiente;
import entidades.Contrato;

public class CriarContratoRT {

	public void criarContrato(Contrato contrato) throws SQLException{
    Contrato actRecContrato = new Contrato();
    actRecContrato.inserirContrato(contrato);
    	int contratoId = actRecContrato.recuperarContratoId();
    	Ambiente actvRecAmbiente = new Ambiente();
    	for(Ambiente a : contrato.getAmbiente()){
    		int idAmbiente = a.getIdAmbiente();
    		actvRecAmbiente.atualizarAmbienteComContrato(idAmbiente, contratoId);
    	}
    }
}
