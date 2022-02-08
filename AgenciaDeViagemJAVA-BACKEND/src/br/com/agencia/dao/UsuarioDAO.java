package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Usuario;

public class UsuarioDAO {
	
	public void save (Usuario usuario) {
		
		String sql = "INSERT INTO usuario(cpf, nome, email, endereco) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getCpf());
			pstm.setString(2, usuario.getNome());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getEndereço());
			
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
	
	
	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, endereco = ?" +
	"WHERE idusuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getEndereço());
			
			pstm.setInt(5, usuario.getIdusuario());
			
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
	
	public void deleteByID (int idusuario) {
		
		String sql = "DELETE FROM usuario WHERE idusuario = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, idusuario);
			
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
	
	
	
	public List<Usuario> getUsuarios() {
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setIdusuario(rset.getInt("idusuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setEmail(rset.getString("email"));
				usuario.setEndereço(rset.getString("endereco"));
				
				usuarios.add(usuario);
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
			
		
		return usuarios;
		
		}
		
	}	
	



