package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Gruppo;

public class GruppiDao {

	@SuppressWarnings("unused")
	private Connection connection;
	private PreparedStatement InserisciGruppoPs,RecuperoByNome,RecuperoGruppo,ModificaDescGruppo,EliminaGruppo;
	
	public GruppiDao(Connection connection) throws SQLException {
		this.connection=connection;
		EliminaGruppo=connection.prepareStatement("DELETE FROM Gruppo WHERE Nome=?");
		ModificaDescGruppo=connection.prepareStatement("UPDATE Gruppo SET Descrizione=? WHERE Nome=?");
		InserisciGruppoPs=connection.prepareStatement("INSERT INTO Gruppo VALUES (?,?,?)");
		RecuperoGruppo=connection.prepareStatement("SELECT * FROM GRUPPO");
		RecuperoByNome=connection.prepareStatement("SELECT * FROM Gruppo Where Nome=?");
	}
	
	public void EliminaGruppo(Gruppo gruppo)throws SQLException{
		EliminaGruppo.setString(1,gruppo.GetNomeGruppo());
		EliminaGruppo.executeQuery();
	}
	
	public void ModificaDescGruppo(String Descrizione, Gruppo gruppo) throws SQLException{
		ModificaDescGruppo.setString(1, Descrizione);
		ModificaDescGruppo.setString(2,gruppo.GetNomeGruppo());
		ModificaDescGruppo.executeQuery();
	}
	
	public void InserisciGruppo(Gruppo grup)throws SQLException {
		InserisciGruppoPs.setString(1,grup.GetNomeGruppo());
		InserisciGruppoPs.setString(2,grup.Categoria);
		InserisciGruppoPs.setString(3,grup.Descrizione);
		
		InserisciGruppoPs.executeQuery();
	
	}
	
	public ArrayList<Gruppo> RecuperoGruppo() throws SQLException{
		ResultSet sr = RecuperoGruppo.executeQuery();
		ArrayList<Gruppo> list = new ArrayList<Gruppo>();
		while(sr.next()) {
			Gruppo g = new Gruppo(sr.getString("Nome"),sr.getString("Categoria"),sr.getString("Descrizione"));
			list.add(g);
		}
		sr.close();
		return list;
	}
	
	public Gruppo RecuperoByNome(String NomeGruppo) throws SQLException{
		RecuperoByNome.setString(1,NomeGruppo);
		ResultSet sr = RecuperoByNome.executeQuery();
		
		ArrayList<Gruppo> list = new ArrayList<Gruppo>();
		while(sr.next()) {
			Gruppo g = new Gruppo(sr.getString("Nome"),sr.getString("Categoria"),sr.getString("Descrizione"));
			list.add(g);
		}
		sr.close();
		return list.get(0);
	}

}