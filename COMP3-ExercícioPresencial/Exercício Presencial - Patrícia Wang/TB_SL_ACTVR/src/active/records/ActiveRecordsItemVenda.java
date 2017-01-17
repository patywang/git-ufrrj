package active.records;

import java.sql.SQLException;

import entidades.ItemVenda;

public interface ActiveRecordsItemVenda {

	public Boolean verificarMobiliaEmItemVenda(int idMobilia);//item
	public void associarItemVenda(int idAmbiente, ItemVenda item) throws SQLException;//item
}
