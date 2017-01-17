package active.records;

import java.sql.SQLException;

import entidades.Ambiente;

public interface ActiveRecordsAmbiente {
	
	//tabelas ambiente e item venda antes as implementações estavam em AmbienteDAO
	public void inserirAmbiente(Ambiente ambiente) throws SQLException;
	public int recuperarAmbiente() throws SQLException;
	public void atualizarAmbienteComContrato(int idAmbiente, int idContrato) throws SQLException;
}
