package br.com.servico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.servico.modelo.Usuario;

public class LoginDAO {

	public Usuario validarLogin(String email,String senha){		
		Connection conn = null;
		Usuario u = new Usuario();
		try {
		conn = new ConnectFactory().getConnection();
			String sql = "SELECT * FROM USUARIO WHERE EMAIL=? AND SENHA=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, senha);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){				
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		return u;
	}
	
	public ArrayList<Usuario> getUsuario(){
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		Connection conn = null;
		conn = new ConnectFactory().getConnection();
		String sql = "SELECT * FROM USUARIO";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	} 
}
