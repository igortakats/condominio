package br.com.igita.condominio.conversores.DAO;


import java.sql.Connection;
import java.sql.SQLException;

import br.com.igita.condominio.common.ConnectionFactory;

public abstract class DAO<T> {
	
	
	public static final Connection getConnection() throws Exception {
		
		return ConnectionFactory.getConnection();
		
	}

	public static void close() throws SQLException {
		ConnectionFactory.close();
	}
}
