package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import Connessione.DBConnection;
import Dao.EmailDao;
import entity.Contatto;
import entity.Email;

public class ControlEmail {

	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;

	public ControlEmail(){
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String EliminaEmail(Email email){
		try {
			EmailDao dao = new EmailDao(connection);
			dao.EliminaEmail(email);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaEmail(String Indirizzo,Email email){
		try {
			EmailDao dao = new EmailDao(connection);
			dao.ModificaEmail(Indirizzo, email);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String InsertEmail(int Cod_Email,String Indirizzo,int Cod_Contatto, Contatto contatto) {
		
		Email E = new Email(Cod_Email,Indirizzo,Cod_Contatto);
		contatto.listEmail.add(E);
		try {
			EmailDao dao = new EmailDao(connection);
			dao.InserisciEmail(E);
		} 
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());

		}
		return stateSQL;
	}

	public ArrayList<Email> RecoverEmail() {

		ArrayList<Email> lista = new ArrayList<Email>();
		try {
			EmailDao dao = new EmailDao(connection);
			lista = dao.RecuperaEmail();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	
		return lista;
	}
	
	
	
	public ArrayList<Email> RecoverEmailByContatto(int Cod_Contatto) {
	
		ArrayList<Email> lista = new ArrayList<Email>();
		
		try {
			EmailDao dao = new EmailDao(connection);
			lista=dao.RecuperaEmailByContatto(Cod_Contatto);
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