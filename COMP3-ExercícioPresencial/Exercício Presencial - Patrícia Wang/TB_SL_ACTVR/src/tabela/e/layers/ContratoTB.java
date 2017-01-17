package tabela.e.layers;

import java.sql.SQLException;

import entidades.Ambiente;
import entidades.Contrato;

public class ContratoTB {

	public void criarContrato(Contrato contrato) throws SQLException{
		Contrato actRecContrato = new Contrato();
		actRecContrato.inserirContrato(contrato);
    	int contratoId = actRecContrato.recuperarContratoId();
    	Ambiente actRecAmbiente = new Ambiente();
    	for(Ambiente a : contrato.getAmbiente()){
    		int idAmbiente = a.getIdAmbiente();
    		actRecAmbiente.atualizarAmbienteComContrato(idAmbiente, contratoId);
    	}
    }
}
