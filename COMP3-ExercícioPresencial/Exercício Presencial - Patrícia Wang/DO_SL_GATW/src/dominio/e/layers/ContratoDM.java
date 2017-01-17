package dominio.e.layers;

import java.sql.SQLException;

import dao.AmbienteDAO;
import dao.ContratoDAO;
import entidades.Ambiente;
import entidades.Contrato;

public class ContratoDM {

	public void criarContrato(Contrato contrato) throws SQLException{
    	ContratoDAO daoContrato = new ContratoDAO();
    	daoContrato.inserirContrato(contrato);
    	int contratoId = daoContrato.recuperarContratoId();
    	AmbienteDAO daoAmbiente = new AmbienteDAO();
    	for(Ambiente a : contrato.getAmbiente()){
    		int idAmbiente = a.getIdAmbiente();
    		daoAmbiente.atualizarAmbienteComContrato(idAmbiente, contratoId);
    	}
    }
}
