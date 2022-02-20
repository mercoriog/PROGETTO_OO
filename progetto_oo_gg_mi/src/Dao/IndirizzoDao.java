package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Indirizzi;


public class IndirizzoDao {

	
	private Connection connection;
	private PreparedStatement inserisciIndirizzoPS, recuperaIndirizzoPS, recuperaIndirizzoByCodContattoPS,ModificaIndirizzo,EliminaIndirizzo;
	
	public IndirizzoDao(Connection conn) throws SQLException{
		connection = conn;
		EliminaIndirizzo=connection.prepareStatement("DELETE FROM Indirizzo WHERE Cod_Indirizzo = ?");
		ModificaIndirizzo=connection.prepareStatement("UPDATE Indirizzo SET Via=?,CAP=?,Nazione=?,Citta=? WHERE Cod_Indirizzo=?");
		recuperaIndirizzoByCodContattoPS = connection.prepareStatement("SELECT * FROM INDIRIZZO WHERE Cod_Contatto = ?");
		recuperaIndirizzoPS = connection.prepareStatement("SELECT * FROM INDIRIZZO");
		inserisciIndirizzoPS = connection.prepareStatement("INSERT INTO INDIRIZZO VALUES(?, ?, ?, ?, ?, ?)");
	}
	
	public void EliminaIndirizzo(Indirizzi ind)throws SQLException{
		EliminaIndirizzo.setInt(1,ind.getCod_Indirizzo());
		EliminaIndirizzo.executeQuery();
	}
	
	public void ModificaIndirizzo(String Via,int CAP,String Nazione,String Citta, Indirizzi ind)throws SQLException {
		ModificaIndirizzo.setString(1,Via);
		ModificaIndirizzo.setInt(2, CAP);
		ModificaIndirizzo.setString(3, Nazione);
		ModificaIndirizzo.setString(4, Citta);
		ModificaIndirizzo.setInt(5,ind.getCod_Indirizzo());
		ModificaIndirizzo.executeQuery();
	}
	
	public void inserisciIndirizzo(Indirizzi indirizzo) throws SQLException{
	
		inserisciIndirizzoPS.setInt(1, indirizzo.getCod_Indirizzo());
		inserisciIndirizzoPS.setString(2, indirizzo.Via);
		inserisciIndirizzoPS.setInt(3, indirizzo.CAP);
		inserisciIndirizzoPS.setString(4, indirizzo.Nazione);
		inserisciIndirizzoPS.setString(5, indirizzo.Citta);
		inserisciIndirizzoPS.setInt(6, indirizzo.getCod_Contatto());
		
		inserisciIndirizzoPS.executeQuery();
	}
	
	public ArrayList<Indirizzi> recuperaIndirizzo() throws SQLException{
	
		ResultSet rs = recuperaIndirizzoPS.executeQuery();
		
		ArrayList<Indirizzi> lista = new ArrayList<Indirizzi>();
		
		while(rs.next()) {
			Indirizzi newIndirizzo = new Indirizzi(rs.getInt("Cod_Indirizzo"),rs.getString("Via"),rs.getInt("Cap"),rs.getString("Nazione"),rs.getString("Citta"),rs.getInt("Cod_Contatto"));
			lista.add(newIndirizzo);
		}
		rs.close();
		return lista;
	}
	
	public ArrayList<Indirizzi> recuperaIndirizzoByCodContatto(int codContatto) throws SQLException {
		recuperaIndirizzoByCodContattoPS.setInt(1, codContatto);
		ResultSet rs = recuperaIndirizzoByCodContattoPS.executeQuery();
		
		ArrayList<Indirizzi> lista = new ArrayList<Indirizzi>();
		
		while(rs.next()) {
			Indirizzi newIndirizzo = new Indirizzi(rs.getInt("Cod_Indirizzo"),rs.getString("Via"),rs.getInt("CAP"),rs.getString("Nazione"),rs.getString("Citta"),rs.getInt("Cod_Contatto"));
			lista.add(newIndirizzo);
		}
		rs.close();
		return lista;
	}

}