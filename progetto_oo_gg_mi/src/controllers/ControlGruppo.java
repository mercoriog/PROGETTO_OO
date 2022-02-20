package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DBConnection;
import Dao.GruppiDao;
import entity.Gruppo;

public class ControlGruppo {
	
	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlGruppo() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String EliminaGruppo(Gruppo gruppo){
		try {
			GruppiDao dao=new GruppiDao(connection);
			dao.EliminaGruppo(gruppo);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaDescGruppo(String Descrizione, Gruppo gruppo){
		try {
			GruppiDao dao=new GruppiDao(connection);
			dao.ModificaDescGruppo(Descrizione, gruppo);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String InsertGruppo(String NomeGruppo, String Descrizione, String Categoria) {
	
		Gruppo g = new Gruppo(NomeGruppo, Descrizione, Categoria);
		
		try {
			GruppiDao dao = new GruppiDao(connection);
			dao.InserisciGruppo(g);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		
		}
		return stateSQL;
	}
	
	public ArrayList<Gruppo> RecoverGruppo() {
	
		ArrayList<Gruppo> lista = new ArrayList<Gruppo>();
		try {
			GruppiDao dao = new GruppiDao(connection);
			lista = dao.RecuperoGruppo();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public Gruppo RecoverGruppoByNome(String nomeGruppo) {
		Gruppo g = null;
		try {
			GruppiDao dao = new GruppiDao(connection);
			g = dao.RecuperoByNome(nomeGruppo);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return g;
	}
	
	public String getSQLState() {
		return stateSQL;
	}
}