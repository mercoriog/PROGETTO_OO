package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Connessione.DBConnection;
import entity.Account;
import entity.Email;
import Dao.AccountDao;

public class ControlAccount {

	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlAccount() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String InsertAccount(String NickName,String Frase_Benvenuto,String NomeAccount,String CognomeAccount,int Email,String Fornitore, Email email){
		
		Account A = new Account(NickName,Frase_Benvenuto,NomeAccount,CognomeAccount,Email,Fornitore);
		email.listAccount.add(A);
		
		try {
			AccountDao Dao =new AccountDao(connection);
			Dao.inserisciAccount(A);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaAccount(String Frase_Benvenuto, Account account){
		
		try {
			AccountDao Dao = new AccountDao(connection);
			Dao.modificaAccount(Frase_Benvenuto, account);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String EliminaAccount(Account account){
		
		try {
			AccountDao Dao =new AccountDao(connection);
			Dao.eliminaAccount(account);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}

	
	public ArrayList<Account> RecoverAccount(){
		ArrayList<Account> list = new ArrayList<Account>();
		try {
			AccountDao Dao = new AccountDao(connection);
			list=Dao.recuperaAccount();
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return list;
	}
	
	public ArrayList<Account> RecoverAccountByEmail(int Email){
		ArrayList<Account> list = new ArrayList<Account>();
		try {
			AccountDao Dao = new AccountDao(connection);
			list=Dao.recuperaAccountByCodEmail(Email);
		}
		catch(SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return list;
	}
	
	public ArrayList<Account> RecoverAccountByFornitore(String Fornitore){
		ArrayList<Account> list = new ArrayList<Account>();
		try {
			AccountDao Dao = new AccountDao(connection);
			list=Dao.recuperaAccountByFornitore(Fornitore);
		}
		catch(SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return list;
	}
	
	public String getSQLState() {
		return stateSQL;
	}
}
