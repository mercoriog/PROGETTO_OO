package Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.TelefonoFisso;

public class TelefonoFissoDao {
	private Connection connection;
	private PreparedStatement inserisciTelFissoPS, recuperaTelFissoPS, recuperaTelFissoByCodContattoPS,ModificaNumero,EliminaNumero;
	
	
	
	public TelefonoFissoDao(Connection conn) throws SQLException{
		connection = conn;
		
		recuperaTelFissoByCodContattoPS = connection.prepareStatement("SELECT * FROM TELEFONO_FISSO WHERE Cod_Contatto = ?");
		recuperaTelFissoPS = connection.prepareStatement("SELECT * FROM TELEFONO_FISSO");
		inserisciTelFissoPS = connection.prepareStatement("INSERT INTO TELEFONO_FISSO VALUES(?, ?, ?)");
		ModificaNumero=connection.prepareStatement("UPDATE Telefono_Fisso SET Numero_Fisso=? WHERE CodN_Fisso=?");
		EliminaNumero=connection.prepareStatement("DELETE FROM Telefono_FIsso WHERE CodN_Fisso=?");
	}
	
	
	
	public void EliminaNumero(TelefonoFisso telefono) throws SQLException {
		EliminaNumero.setInt(1,telefono.getCodN_Fisso());
		EliminaNumero.executeQuery();
	}
	
	public void ModificaNumero(String Numero,TelefonoFisso telefono)throws SQLException {
		ModificaNumero.setString(1, Numero);
		ModificaNumero.setInt(2,telefono.getCodN_Fisso());
		ModificaNumero.executeQuery();
	}
	
	public void inserisciTelFisso(TelefonoFisso telFisso) throws SQLException{
		inserisciTelFissoPS.setInt(1, telFisso.getCodN_Fisso());
		inserisciTelFissoPS.setString(2, telFisso.numeroTF);
		inserisciTelFissoPS.setInt(3, telFisso.getCod_Contatto());
		
		inserisciTelFissoPS.executeQuery();
	}
			
	public ArrayList<TelefonoFisso> recuperaTelFisso() throws SQLException{
	
		ResultSet rs = recuperaTelFissoPS.executeQuery();
		ArrayList<TelefonoFisso> lista = new ArrayList<TelefonoFisso>();
	
		while(rs.next()) {
			TelefonoFisso newTelFisso = new TelefonoFisso(rs.getInt("CodN_Fisso"),rs.getString("Numero_Fisso"),rs.getInt("Cod_Contatto"));
			lista.add(newTelFisso);
		}
		
		rs.close();
		return lista;
	}
		
		
		
		public ArrayList<TelefonoFisso> recuperaTelFissoByCodContatto(int codContatto) throws SQLException {
		
			recuperaTelFissoByCodContattoPS.setInt(1,codContatto);
			ResultSet rs = recuperaTelFissoByCodContattoPS.executeQuery();
			ArrayList<TelefonoFisso> lista = new ArrayList<TelefonoFisso>();
		
			while(rs.next()) {
				TelefonoFisso newTelFisso = new TelefonoFisso(rs.getInt("CodN_Fisso"),rs.getString("Numero_Fisso"),rs.getInt("Cod_Contatto"));
				lista.add(newTelFisso);
			}
			rs.close();
			return lista;
		}
	


}