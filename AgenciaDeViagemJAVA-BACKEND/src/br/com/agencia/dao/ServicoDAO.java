package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Serviço;


public class ServicoDAO {
	
public void save (Serviço serviço) {
		
		String sql = "INSERT INTO serviço(pais, cidade, data_ida, data_volta, qtd_passageiros, preco) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, serviço.getPais());
			pstm.setString(2, serviço.getCidade());
			pstm.setDate(3, (java.sql.Date) new Date (serviço.getData_ida().getTime()));
			pstm.setDate(4, (java.sql.Date) new Date (serviço.getData_volta().getTime()));
			pstm.setInt(5, serviço.getQtd_passageiros());
			pstm.setInt(6, serviço.getPreco());
			
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm!= null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e ) {
				e.printStackTrace();
			}
		}
	}

public void update(Serviço serviço) {
	String sql = "UPDATE servico SET pais = ?, cidade = ?, data_ida = ?, data_volta = ?, qtd_passageiros = ?, preco = ?" +
"WHERE idservico = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, serviço.getPais());
		pstm.setString(2, serviço.getCidade());
		pstm.setDate(3, (java.sql.Date) new Date(serviço.getData_ida().getTime()));
		pstm.setDate(4,  (java.sql.Date) new Date(serviço.getData_volta().getTime()));
		pstm.setInt(5, serviço.getQtd_passageiros());
		pstm.setInt(6, serviço.getPreco());
		
		pstm.setInt(7, serviço.getIdservico());
		
		pstm.execute();
	} catch (Exception e) {
		e.printStackTrace();			
	} finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

public void deleteByID (int idservico) {
	
	String sql = "DELETE FROM servico WHERE idservico = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idservico);
		
		pstm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public List<Serviço> getServicos() {
	
	String sql = "SELECT * FROM servico";
	
	List<Serviço> servicos = new ArrayList<Serviço>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Serviço servico = new Serviço();
			
			servico.setCidade(rset.getString("cidade"));
			servico.setData_ida(rset.getDate("data_ida"));
			servico.setData_volta(rset.getDate("data_volta"));
			servico.setIdservico(rset.getInt("idservico"));
			servico.setPais(rset.getString("pais"));
			servico.setPreco(rset.getInt("preco"));
			servico.setQtd_passageiros(rset.getInt("qtd_passageiros"));
			
			
			servicos.add(servico);
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			if(rset!=null) {
				rset.close();
			}
			
			if (pstm!= null) {
				pstm.close();
			}
			
			if (conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	return servicos;
	
	}

}
