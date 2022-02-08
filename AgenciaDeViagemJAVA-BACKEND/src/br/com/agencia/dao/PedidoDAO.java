package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Pedido;


public class PedidoDAO {
	
public void save (Pedido pedido) {
		
		String sql = "INSERT INTO pedido(tipo_pagamento, cupom_desconto, promocao) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, pedido.getTipo_pagamento());
			pstm.setString(2, pedido.getCupom_desconto());
			pstm.setInt(3, pedido.getPromocao());
			

			
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

public void update(Pedido pedido) {
		String sql = "UPDATE pedido SET tipo_pagamento = ?, cupom_desconto = ?, promocao = ?" +
	"WHERE idpedido = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pedido.getTipo_pagamento());
			pstm.setString(2, pedido.getCupom_desconto());
			pstm.setInt(3, pedido.getPromocao());
			
			pstm.setInt(4, pedido.getIdpedido());
			
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
	
public void deleteByID (int idpedido) {
	
	String sql = "DELETE FROM pedido WHERE idpedido = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idpedido);
		
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

public List<Pedido> getPedidos() {
	
	String sql = "SELECT * FROM pedido";
	
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Pedido pedido = new Pedido();
			
			pedido.setIdpedido(rset.getInt("idpedido"));
			pedido.setCupom_desconto(rset.getString("cupom_desconto"));
			pedido.setPromocao(rset.getInt("promocao"));
			pedido.setTipo_pagamento(rset.getString("tipo_pagamento"));
			
			
			pedidos.add(pedido);
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
		
	
	return pedidos;
	
	}

}


