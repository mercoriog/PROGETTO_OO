package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.TelefonoMobile;

public class TelefonoMobileDao {
	private Connection connection;
	private PreparedStatement inserisciTelMobilePS, recuperaTelMobilePS, recuperaTelMobileByCodContattoPS,ModificaNumeroM,EliminaNumeroM;



	public TelefonoMobileDao(Connection conn) throws SQLException{
		connection = conn;
		
		EliminaNumeroM=connection.prepareStatement("DELETE FROM Telefono_Mobile WHERE CodN_Mobile=?");
		ModificaNumeroM=connection.prepareStatement("UPDATE Telefono_Mobile SET Numero_Mobile=? WHERE CodN_Mobile=?");
		recuperaTelMobileByCodContattoPS = connection.prepareStatement("SELECT * FROM TELEFONO_MOBILE WHERE Cod_Contatto = ?");
		recuperaTelMobilePS = connection.prepareStatement("SELECT * FROM TELEFONO_MOBILE");
		inserisciTelMobilePS = connection.prepareStatement("INSERT INTO TELEFONO_MOBILE VALUES(?, ?, ?)");
	}



	public void EliminaNumeroM(TelefonoMobile telefono) throws SQLException {
		EliminaNumeroM.setInt(1,telefono.getCodN_Mobile());
		EliminaNumeroM.executeQuery();
	}

	public void ModificaNumeroM(String Numero,TelefonoMobile telefono)throws SQLException {
		ModificaNumeroM.setString(1, Numero);
		ModificaNumeroM.setInt(2,telefono.getCodN_Mobile());
		ModificaNumeroM.executeQuery();
	}

	public void inserisciTelMobile(TelefonoMobile telMobile) throws SQLException{
	
		inserisciTelMobilePS.setInt(1, telMobile.getCodN_Mobile());
		inserisciTelMobilePS.setString(2, telMobile.numero);
		inserisciTelMobilePS.setInt(3,telMobile.GetCod_Contatto());
		inserisciTelMobilePS.executeQuery();
	}



	public ArrayList<TelefonoMobile> recuperaTelMobile() throws SQLException{

		ResultSet rs = recuperaTelMobilePS.executeQuery();
		
		ArrayList<TelefonoMobile> lista = new ArrayList<TelefonoMobile>();		
		
		while(rs.next()) {
			TelefonoMobile newMobile = new TelefonoMobile(rs.getInt("CodN_Mobile"),rs.getString("Numero_Mobile"),rs.getInt("Cod_Contatto"));
			lista.add(newMobile);
		}
		rs.close();
		return lista;
	}



	public ArrayList<TelefonoMobile> recuperaTelMobileByCodContatto(int codContatto) throws SQLException {

		recuperaTelMobileByCodContattoPS.setInt(1, codContatto);
		ResultSet rs = recuperaTelMobileByCodContattoPS.executeQuery();

		ArrayList<TelefonoMobile> lista = new ArrayList<TelefonoMobile>();

		while(rs.next()) {
			TelefonoMobile newTelMobile = new TelefonoMobile(rs.getInt("CodN_Mobile"),rs.getString("Numero_Mobile"),rs.getInt("Cod_Contatto"));
			lista.add(newTelMobile);
		}
		rs.close();
		return lista;
	}
}