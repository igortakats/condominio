package br.com.igita.condominio.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * 
 * Connection Factory
 * 
 * @author ivanoff
 *
 */
public final class ConnectionFactory {
	
	private static Connection conn = null;

	private static ConnectionFactory connectionFactory = null;
	
	private ConnectionFactory() {
		
	}
	
	public static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	public static final Connection getConnection() throws SQLException, Exception {
		
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
			conn = createConnection((String)ResourceLocator.getPropertyFromBundle("condo.properties","db.condo.jdbcDriver"), 
									(String)ResourceLocator.getPropertyFromBundle("condo.properties","db.condo.dbUrl"), 
									(String)ResourceLocator.getPropertyFromBundle("condo.properties","db.condo.dbUser"), 
									(String)ResourceLocator.getPropertyFromBundle("condo.properties","db.condo.Psw"));
		}
		
		return conn;
		
	}
	
	private static final Connection createConnection(String jdbcDriver, String dbUrl, String dbUser, String dbPsw) throws Exception, SQLException  {
		
		if (jdbcDriver == null || dbUrl == null || dbUser == null || dbPsw == null) {	
			throw new Exception("Parametros passados invalidos.");
		}
		
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPsw); 
		} catch (ClassNotFoundException e) {
			throw new Exception(e);
		} catch (SQLException e) {
			throw e;
		}

		return conn;
	}
	
	@SuppressWarnings("unused")
	private void log(String jdbcDriver, String dbUrl, String dbUser, String dbPsw, Throwable e) {

		StringBuffer msg = new StringBuffer(); 
		String newLine = new String("\n");
		
		msg.append("Houve um erro ao tentar obter a conexão com banco de dados");
		msg.append(newLine);
		msg.append("Mensagem: " + e.getMessage());
		msg.append(newLine);
		msg.append("Driver: " + jdbcDriver);
		msg.append(newLine);
		msg.append( "URL: " + dbUrl);
		msg.append(newLine);
		msg.append("User: " + dbUser);
		msg.append(newLine);
		
		logger.error(msg.toString(), e);
	}
	
	public static void close() throws SQLException {
		conn.close();
	}
}
