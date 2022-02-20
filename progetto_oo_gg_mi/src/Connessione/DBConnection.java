package Connessione;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnection {
		
		private static DBConnection instance;
		private Connection connection = null;
		private final String usernameDBConn = "postgres";
		private final String passwordDBConn = "superman";
		private final String ipDBConn = "localhost";
		private final String portDBConn = "5432";
		
		private String urlDBConn = "jdbc:postgresql://"+ipDBConn+":"+portDBConn+"/oo_rubrica";
		//formato seguito è 	prootocollo:sottoprotocollo:databasename
		
		private DBConnection() throws SQLException{
			try {
				Class.forName("org.postgresql.Driver");	//FORZO IL CARICAMENTO DEL DRIVER
				//esso lancia una ClassNotFoundException
				
				//mi connetto al Driver Manager per ottenere completa indipendenza dal DBMS
				connection = DriverManager.getConnection(urlDBConn, usernameDBConn, passwordDBConn);
				//L'oggetto Connection denominato connection sarà il canale di comunicazione con il DB
				//attraverso il quale istruzioni SQL vengono eseguite e processate ritornando valori
				//attraverso la connessione
			}
			catch (ClassNotFoundException ex) {
				System.out.println("Database Connection failed: " + ex.getMessage());
			}
		}
		
		public Connection getConnection() {return connection;}
		
		public static DBConnection getInstance() throws SQLException{
			if (instance == null) {
				instance = new DBConnection();
			}
			else
				if(instance.getConnection().isClosed()) {
					instance = new DBConnection();
				}
			return instance;
		}
}
