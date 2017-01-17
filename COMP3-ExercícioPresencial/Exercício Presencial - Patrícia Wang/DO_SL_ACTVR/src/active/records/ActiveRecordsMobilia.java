package active.records;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import entidades.Mobilia;

public interface ActiveRecordsMobilia {

	public void inserirMobilia(Mobilia mobilia) throws SQLException;
	public int recuperarPaiMobilia() throws SQLException;
	public void associarComodoMobilia(int idMobilia, int idComodo) throws SQLException;
	public List<Mobilia> listarMobilias();
	public void deletarMobilia(Mobilia mobilia) throws SQLException;
	public void editarMobilia(Mobilia mobilia) throws SQLException;
	public void deletarMobiliaComodo(int id) throws SQLException; //acho q não uso mais ela --'
	public Map<Integer,String> listarMobiliasDisponiveisTotal(String tipo);//deu trabalho essa aqui socorro
	public Mobilia recuperarMobiliaPorId(int idMobilia) throws SQLException;
	public List<Mobilia> listarMobiliasPorComodo(int id);
}
