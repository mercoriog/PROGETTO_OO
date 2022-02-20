package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DBConnection;
import Dao.IndirizzoDao;
import entity.Contatto;
import entity.Indirizzi;

public class ControlIndirizzo {

	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlIndirizzo() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String EliminaIndirizzo(Indirizzi ind) {
		try {
			IndirizzoDao dao = new IndirizzoDao(connection);
			dao.EliminaIndirizzo(ind);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaIndirizzo(String Via,int CAP,String Nazione,String Citta, Indirizzi ind){
		try {
			IndirizzoDao dao = new IndirizzoDao(connection);
			dao.ModificaIndirizzo(Via, CAP, Nazione, Citta,ind);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		
		}
		return stateSQL;
	}
	
	public String InsertIndirizzo(int Cod_Indirizzo, String Via, int Cap, String Nazione, String Citta, int Cod_Contatto, Contatto contatto) {
	
		Indirizzi ind = new Indirizzi(Cod_Indirizzo, Via, Cap, Nazione, Citta, Cod_Contatto);
		contatto.listIndirizzi.add(ind);
		
		try {
			IndirizzoDao dao = new IndirizzoDao(connection);
			dao.inserisciIndirizzo(ind);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public ArrayList<Indirizzi> RecoverIndirizzo() {
	
		ArrayList<Indirizzi> lista = new ArrayList<Indirizzi>();
		try {
			IndirizzoDao dao = new IndirizzoDao(connection);
			lista = dao.recuperaIndirizzo();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	
	return lista;
	}
	
	public ArrayList<Indirizzi> RecoverIndirizzoByCodContatto(int Cod_Contatto) {
	
		ArrayList<Indirizzi> lista = new ArrayList<Indirizzi>();
		try {
			IndirizzoDao dao = new IndirizzoDao(connection);
			lista = dao.recuperaIndirizzoByCodContatto(Cod_Contatto);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	
	
	public String getSQLState() {
		return stateSQL;
	}
}