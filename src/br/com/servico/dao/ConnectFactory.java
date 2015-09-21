package br.com.servico.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectFactory {

	public Connection getConnection(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/webservice", "root", "root");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
