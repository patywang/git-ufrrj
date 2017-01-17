package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import dao.DAO;
import active.records.ActiveRecordsAmbiente;

public class Ambiente implements ActiveRecordsAmbiente {
	
	private int numParedes;
	private int numPortas;
	private float metragem;
	private Map<Integer,Integer>mobilias;
	private float custoTotal;
	private int tempoTotalPorAmbiente;
	private int idAmbiente;
	private float custoItemVendaMobiliaAmbiente;
	
	public Ambiente(){};
	
	public Ambiente(int numParedes, int numPortas, float met,  Map<Integer,Integer>mob){
		this.numParedes = numParedes;
		this.numPortas = numPortas;
		this.metragem = met;
		this.mobilias = mob;
	}
	
	public int getNumParedes() {
		return numParedes;
	}
	public void setNumParedes(int numParedes) {
		this.numParedes = numParedes;
	}
	public int getNumPortas() {
		return numPortas;
	}
	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	public float getMetragem() {
		return metragem;
	}
	public void setMetragem(float metragem) {
		this.metragem = metragem;
	}

	public float custo(float itemQuantTotal,int numParedes,int numPortas, float metragem){
		return (float)(itemQuantTotal + 10 * numParedes + 5 * numPortas + 2.5 * metragem);
	}
	
	public int tempoEntrega(int maiorEntrega,int nParedes,int nPortas ){
		return maiorEntrega + 2*nParedes + nPortas/2;
	}

	public Map<Integer,Integer> getMobilias() {
		return mobilias;
	}

	public void setMobilias(Map<Integer,Integer> mobilias) {
		this.mobilias = mobilias;
	}

	public float getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(float custoTotal) {
		this.custoTotal = custoTotal;
	}

	public int getTempoTotalPorAmbiente() {
		return tempoTotalPorAmbiente;
	}

	public void setTempoTotalPorAmbiente(int tempoTotalPorAmbiente) {
		this.tempoTotalPorAmbiente = tempoTotalPorAmbiente;
	}

	public int getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public float getCustoItemVendaMobiliaAmbiente() {
		return custoItemVendaMobiliaAmbiente;
	}

	public void setCustoItemVendaMobiliaAmbiente(
			float custoItemVendaMobiliaAmbiente) {
		this.custoItemVendaMobiliaAmbiente = custoItemVendaMobiliaAmbiente;
	}

	@Override
	public void inserirAmbiente(Ambiente ambiente) throws SQLException{
		
		PreparedStatement ps = null; 
		Connection conexao = null;   
		
		try{
				conexao = DAO.getConnection();
				ps = conexao.prepareStatement("Insert into ambiente(numparedes,numportas, metragem) values(?,?,?)");
				ps.setInt(1, ambiente.getNumParedes());
				ps.setInt(2, ambiente.getNumPortas());
				ps.setFloat(3, ambiente.getMetragem());
				
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{

			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
		
	}

	@Override
	public int recuperarAmbiente() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        int idAmbiente = 0;
        try{
            conexao = DAO.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from ambiente order by id desc limit 1");

            while (rs.next()){
        	
            	String id = rs.getString("id");
            	idAmbiente = (Integer.parseInt(id));

            }
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
        	
        	if (st != null){
        		st.close();
        	}
        	if (conexao != null){
        		conexao.close();
        	}
        	if(rs != null){
        		rs.close();
        	}
        }
        return idAmbiente;
	}

	
	@Override
	public void atualizarAmbienteComContrato(int idAmbiente, int idContrato) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;  
		try{
				conexao = DAO.getConnection();
				ps = conexao.prepareStatement("update ambiente c set idcontrato = ? where c.id = ?");
				ps.setInt(1, idContrato);
				ps.setInt(2, idAmbiente); 
				ps.execute();
		}catch(Exception e){
			
			e.printStackTrace(); 
		
		}finally{
			
			if (ps != null){
				ps.close();
			}
			if (conexao != null){
				conexao.close();
			}
		}
	}

}
