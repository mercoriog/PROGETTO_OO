package Dao;
import entity.Email;



import java.sql.*;
import java.util.ArrayList;



public class EmailDao {
	@SuppressWarnings("unused")
	private Connection connection;
	private PreparedStatement InserisciEmailPs,RecuperaEmail,RecuperaEmailByContatto,ModificaEmail,EliminaEmail;
	
	public EmailDao (Connection connection)throws SQLException {
		this.connection=connection;
		EliminaEmail=connection.prepareStatement("DELETE From Email WHERE Cod_Email=?");
		ModificaEmail=connection.prepareStatement("UPDATE Email SET Indirizzo=? WHERE Cod_Email=?");
		InserisciEmailPs=connection.prepareStatement("INSERT INTO EMAIL VALUES(?,?,?)");
		RecuperaEmail=connection.prepareStatement("SELECT * FROM Email");
		RecuperaEmailByContatto=connection.prepareStatement("SELECT * From Email WHERE Cod_Contatto=?");
	}
		
	public void EliminaEmail(Email email)throws SQLException{
		EliminaEmail.setInt(1,email.GetEmail());
		EliminaEmail.executeQuery();
	}
		
	public void ModificaEmail(String Indirizzo,Email email)throws SQLException{
		ModificaEmail.setString(1, Indirizzo);
		ModificaEmail.setInt(2,email.GetEmail());
		ModificaEmail.executeQuery();
	}
		
	public void InserisciEmail(Email email)throws SQLException{
		
		InserisciEmailPs.setInt(1,email.GetEmail());
		InserisciEmailPs.setString(2,email.Indirizzo_Email);
		InserisciEmailPs.setLong(3,email. GetCod_Contatto());
		
		InserisciEmailPs.executeQuery();
		
	}
	
	public ArrayList<Email> RecuperaEmail() throws SQLException{
	
		ResultSet rs= RecuperaEmail.executeQuery();
		
		ArrayList<Email> lista = new ArrayList<Email>();
		
		while(rs.next()) {
			Email e = new Email(rs.getInt("Cod_Email"),rs.getString("Indirizzo"),rs.getInt("Cod_Contatto"));
			lista.add(e);
		}
		rs.close();
		return lista;
	}
	
	public ArrayList<Email> RecuperaEmailByContatto(int Cod_Contatto) throws SQLException{
		RecuperaEmailByContatto.setInt(1,Cod_Contatto);
		ResultSet rs= RecuperaEmailByContatto.executeQuery();
		
		ArrayList<Email> lista = new ArrayList<Email>();
		
		while(rs.next()) {
			Email e = new Email(rs.getInt("Cod_Email"),rs.getString("Indirizzo"),rs.getInt("Cod_Contatto"));
			lista.add(e);
		}
		rs.close();
		return lista;
	}

}