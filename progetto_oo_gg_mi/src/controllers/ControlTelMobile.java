package controllers;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Connessione.DBConnection;
import Dao.TelefonoMobileDao;
import entity.Contatto;
import entity.TelefonoMobile;

public class ControlTelMobile {
	private String stateSQL;
	private DBConnection dbConnection = null;
	private Connection connection;
	
	public ControlTelMobile() {
		try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
	}
	
	public String InsertTelMobile(int CodN_Mobile, String Numero, int Cod_Contatto, Contatto contatto) {
		TelefonoMobile tm = new TelefonoMobile(CodN_Mobile, Numero, Cod_Contatto);
		contatto.listTelefonoM.add(tm);
		try {
			TelefonoMobileDao dao = new TelefonoMobileDao(connection);
			dao.inserisciTelMobile(tm);
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String ModificaNumeroM(String Numero,TelefonoMobile telefono){
		try {
			TelefonoMobileDao dao = new TelefonoMobileDao(connection);
			dao.ModificaNumeroM(Numero, telefono);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public String EliminaNumeroM(TelefonoMobile telefono){
		try {
			TelefonoMobileDao dao = new TelefonoMobileDao(connection);
			dao.EliminaNumeroM(telefono);
		}
		catch(SQLException e){
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return stateSQL;
	}
	
	public ArrayList<TelefonoMobile> RecoverTelefonoMobile() {
		ArrayList<TelefonoMobile> lista = new ArrayList<TelefonoMobile>();
		try {
			TelefonoMobileDao dao = new TelefonoMobileDao(connection);
			lista = dao.recuperaTelMobile();
		} catch (SQLException e) {
			stateSQL = new String(e.getSQLState());
			System.out.println("Errore nel controller: "+ e.getMessage() +"\n"+ e.getSQLState());
		}
		return lista;
	}
	
	public ArrayList<TelefonoMobile> RecoverTelefonoMobileByCodContatto(int Cod_Contatto) {
		ArrayList<TelefonoMobile> lista = new ArrayList<TelefonoMobile>();
		try {
			TelefonoMobileDao dao = new TelefonoMobileDao(connection);
			lista = dao.recuperaTelMobileByCodContatto(Cod_Contatto);
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

