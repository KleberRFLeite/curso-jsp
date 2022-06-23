package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://ec2-23-23-182-238.compute-1.amazonaws.com:5432/d7otoltc8fk7fb?sslmode=require&autoReconnect=true";
	private static String password = "9ec0bd188011e2151e7e7dc5aa160b3d21606c125d6184a9b470f48458f9850f";
	private static String user = "xyptbhbzespvbn";
	private static Connection connection = null;
	
	
	/*dddfdfdd*/
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	
	public SingleConnectionBanco() {/*quando tiver um instancia vai conectar*/
		conectar();
	}
	
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de conexão do banco*/
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false); /*para nao efetuar alteracoes no banco sem nosso comando*/
				System.out.println("conectou no banco");
			}
			
		}catch (Exception e) {
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}

}
