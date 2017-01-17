package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.DAO;
import active.records.ActiveRecordsContrato;

public class Contrato implements ActiveRecordsContrato{
	
	private float comissao;
	private List<Ambiente>ambiente;
	
	public Contrato(){};
	
	public Contrato(float comissao, List<Ambiente>ambiente){
		this.comissao = comissao;
		this.ambiente=ambiente;
	}
	
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	public List<Ambiente> getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(List<Ambiente> ambiente) {
		this.ambiente = ambiente;
	}
	
	public float valorContrato(float somaCusto, float comissao){
		return (Float)(somaCusto *(1 + comissao));
	}
	
	public int prazo(List<Integer> lista){
		int somatorio = 0;
		for (Integer i : lista) {
			somatorio += i;
		}
		return somatorio;
	}

	@Override
	public void inserirContrato(Contrato contrato) throws SQLException{
		PreparedStatement ps = null; 
		Connection conexao = null;
		try{
				conexao = DAO.getConnection();
				ps = conexao.prepareStatement("Insert into contrato(comissao) values(?)");
				ps.setFloat(1, contrato.getComissao());
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
	public int recuperarContratoId() throws SQLException{
		
		Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        int idPai = 0;
        try{
            conexao = DAO.getConnection();
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from contrato order by id desc limit 1");

            while (rs.next()){
        	
            	String idComodo = rs.getString("id");
            	idPai = (Integer.parseInt(idComodo));

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
        
		return idPai ;
	}

}
