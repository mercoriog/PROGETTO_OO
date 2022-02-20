package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DBConnection;
import Dao.FornitoreDao;
import entity.Fornitore;

public class ControlFornitore {
	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlFornitore() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String EliminaFornitore(Fornitore forn) {
		try {
			FornitoreDao dao = new FornitoreDao(connection);
			dao.EliminaFornitore(forn);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String InsertFornitore(String NomeFornitore, String Categoria, String Casa_Produttrice) {
	
		Fornitore g = new Fornitore(NomeFornitore, Categoria, Casa_Produttrice);
		
		try {
			FornitoreDao dao = new FornitoreDao(connection);
			dao.InserisciFornitore(g);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public ArrayList<Fornitore> RecoverFornitore() {
	
		ArrayList<Fornitore> lista = new ArrayList<Fornitore>();
		try {
			FornitoreDao dao = new FornitoreDao(connection);
			lista = dao.RicercaFornitore();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public Fornitore RecoverFornitoreByNome(String nomeFornitore) {
		Fornitore f = null;
		try {
			FornitoreDao dao = new FornitoreDao(connection);
			f = dao.RicercaFornitorebyNome(nomeFornitore);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return f;
	}
	
	public String getSQLState() {
		return stateSQL;
	}
}