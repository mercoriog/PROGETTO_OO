package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DBConnection;
import Dao.ContattoDao;
import entity.Account;
import entity.Contatto;
import entity.Email;
import entity.Gruppo;
import entity.TelefonoFisso;
import entity.TelefonoMobile;



public class ControlContatto {
	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlContatto() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String InsertAfferenza(Contatto cont,Gruppo grup) {
		try {
			ContattoDao dao = new ContattoDao(connection);
			dao.InserisciConInGruppo(cont,grup);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		
		}
		return stateSQL;
	}
	
	public String InsertContatto(Contatto contatto) {
		
		Contatto c = contatto;
		
		try {
			ContattoDao dao = new ContattoDao(connection);
			dao.InserisciContatto(c);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		
		}
		return stateSQL;
	}
	
	public String EliminaContatto(Contatto contatto) {
		
		try {
			ContattoDao Dao =new ContattoDao(connection);
			Dao.EliminaContatto(contatto);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaContatto(String Nome,String Cognome,Contatto cont) {
		try {
			ContattoDao dao= new ContattoDao(connection);
			dao.ModificaContatto(Nome, Cognome,cont);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());

		}
		return stateSQL;
	}
	
	public ArrayList<Contatto> RecoverContatto() {
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			ContattoDao dao = new ContattoDao(connection);
			lista = dao.RecuperaContatto();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public ArrayList<Contatto> RecoverContattoByNome(String nomeContatto) {
	
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			
			ContattoDao dao = new ContattoDao(connection);
			lista = dao.RecuperaContattoByNome(nomeContatto);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public ArrayList<Contatto> RecoverByEmail(Email email){
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			ContattoDao dao = new ContattoDao(connection);
			lista= dao.RicercaConEmail(email);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public ArrayList<Contatto> RecoverByAccount(Account acc){
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			ContattoDao dao = new ContattoDao(connection);
			lista=dao.RicercaConAccount(acc);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public ArrayList<Contatto> RecoverByTelefonoFisso(TelefonoFisso tel){
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			ContattoDao dao = new ContattoDao(connection);
			lista=dao.RicercaConTelFIsso(tel);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public ArrayList<Contatto> RecoverByTelefonoMobile(TelefonoMobile tel){
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		try {
			ContattoDao dao = new ContattoDao(connection);
			lista=dao.RicercaConTelMobile(tel);
		}
		catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		
		return lista;
	}
	
	public String getSQLState() {
		return stateSQL;
	}

}