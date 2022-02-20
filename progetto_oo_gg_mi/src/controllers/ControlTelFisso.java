package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DBConnection;
import Dao.TelefonoFissoDao;
import entity.Contatto;
import entity.TelefonoFisso;



public class ControlTelFisso {

	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;

	public ControlTelFisso() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}

	public String InsertTelFisso(int CodN_Fisso, String Numero, int Cod_Contatto, Contatto contatto) {
	
		TelefonoFisso tf = new TelefonoFisso(CodN_Fisso, Numero, Cod_Contatto);
		contatto.listTelefonoF.add(tf);
		
		try {
			TelefonoFissoDao dao = new TelefonoFissoDao(connection);
			dao.inserisciTelFisso(tf);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		
		}
	return stateSQL;
	}

	public String ModificaNumero(String Numero,TelefonoFisso telefono){
		try {
			TelefonoFissoDao dao = new TelefonoFissoDao(connection);
			dao.ModificaNumero(Numero, telefono);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	return stateSQL;
	}

	public String EliminaNumero(TelefonoFisso telefono){
		try {
			TelefonoFissoDao dao = new TelefonoFissoDao(connection);
			dao.EliminaNumero(telefono);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}

	public ArrayList<TelefonoFisso> RecoverTelefonoFisso() {

		ArrayList<TelefonoFisso> lista = new ArrayList<TelefonoFisso>();
		try {
			TelefonoFissoDao dao = new TelefonoFissoDao(connection);
			lista = dao.recuperaTelFisso();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}

		return lista;
	}

	public ArrayList<TelefonoFisso> RecoverTelefonoFissoByCodContatto(int Cod_Contatto) {
	
		ArrayList<TelefonoFisso> lista = new ArrayList<TelefonoFisso>();
		try {
			TelefonoFissoDao dao = new TelefonoFissoDao(connection);
			lista = dao.recuperaTelFissoByCodContatto(Cod_Contatto);
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