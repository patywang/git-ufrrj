package active.records;

import java.sql.SQLException;
import java.util.List;

import entidades.Comodo;

public interface ActiveRecordsComodoComposto {
	public boolean verificarComodoEmComposto(int idComodo) throws SQLException;//cc
	public void associarComodoParaComodoComposto(int idComodo, int idTodo) throws SQLException;//cc
	public void deletarComodoComposto(int id) throws SQLException;//cc
	public List<Comodo> recuperarComodoComposto(int id) throws SQLException;//cc
}
