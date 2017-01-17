package active.records;

import java.sql.SQLException;

import entidades.Contrato;

public interface ActiveRecordsContrato {

	public void inserirContrato(Contrato contrato) throws SQLException;
	public int recuperarContratoId() throws SQLException;
	
}
