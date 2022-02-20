package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Contatto;
import entity.Email;
import entity.Gruppo;
import entity.TelefonoFisso;
import entity.TelefonoMobile;

public class ContattoDao {
	@SuppressWarnings("unused")
	private Connection connection;
	private PreparedStatement InserisciContattoPS,RecuperaContattoPS,RecuperaContattoByNomePS,ModificaContatto,EliminaContatto,RicercaConEmail,RicercaConAccount,RicercaConTelFIsso,RicercaConTelMobile,InserisciConInGruppo;
	
	
	
	public ContattoDao (Connection connection)throws SQLException {
		this.connection=connection;
		InserisciConInGruppo=connection.prepareStatement("INSERT INTO AFFERENZA VALUES(?.?)");
		RicercaConTelMobile=connection.prepareStatement("SELECT * FROM Contatto AS c JOIN Telefono_Mobile AS t on c.Cod_Contatto=t.Cod_Contatto WHERE t.CodN_Mobile=?");
		RicercaConTelFIsso=connection.prepareStatement("SELECT * FROM Contatto AS c JOIN Telefono_Fisso AS t on c.Cod_Contatto=t.Cod_Contatto WHERE t.CodN_Fisso=?");
		RicercaConAccount=connection.prepareStatement("SELECT * FROM Contatto as c JOIN Email as e ON c.Cod_Contatto=e.Cod_Contatto JOIN Account as A ON e.Cod_Email=A.Cod_Email WHERE A.NickName=?");
		RicercaConEmail=connection.prepareStatement("SELECT * FROM Contatto AS c JOIN Email AS e ON c.Cod_Contatto=e.Cod_Contatto WHERE e.Cod_Email=? ");
		ModificaContatto=connection.prepareStatement("UPDATE Contatto SET Nome=?,Cognome=? WHERE Cod_Contatto=?");
		EliminaContatto=connection.prepareStatement("DELETE FROM Contatto WHERE Cod_Contatto=?");
		InserisciContattoPS=connection.prepareStatement("INSERT INTO CONTATTO VALUES(?,?,?)");
		RecuperaContattoPS=connection.prepareStatement("SELECT * FROM CONTATTO");
		RecuperaContattoByNomePS=connection.prepareStatement("SELECT * From CONTATTO WHERE Nome = ?");
	}
	
	public void ModificaContatto(String nome,String cognome,Contatto con)throws SQLException {
		ModificaContatto.setString(1,nome);
		ModificaContatto.setString(2, cognome);
		ModificaContatto.setInt(3,con.GetCod_Contatto());
		ModificaContatto.executeQuery();
	}
	
	public void EliminaContatto(Contatto con)throws SQLException {
		EliminaContatto.setInt(1,con.GetCod_Contatto());
		EliminaContatto.executeQuery();
	}
	
	public void InserisciContatto(Contatto contatto) throws SQLException {
		InserisciContattoPS.setInt(1, contatto.GetCod_Contatto());
		InserisciContattoPS.setString(2, contatto.Nome);
		InserisciContattoPS.setString(3, contatto.Cognome);
		
		InserisciContattoPS.executeQuery();
	}
	
	public void InserisciConInGruppo(Contatto cont,Gruppo grup)throws SQLException{
		InserisciConInGruppo.setInt(1,cont.GetCod_Contatto());
		InserisciConInGruppo.setString(2,grup.GetNomeGruppo());
		InserisciConInGruppo.executeQuery();
	}
	
	public ArrayList<Contatto> RecuperaContatto() throws SQLException{
	
		ResultSet rs= RecuperaContattoPS.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
		
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		
		}
		rs.close();
		return lista;
	}
	
	public ArrayList<Contatto> RecuperaContattoByNome(String nome) throws SQLException{
		RecuperaContattoByNomePS.setString(1, nome);
		ResultSet rs= RecuperaContattoByNomePS.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
		
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		
		}
		rs.close();
		return lista;
	}
	
	public ArrayList<Contatto> RicercaConEmail(Email email)throws SQLException{
		RicercaConEmail.setInt(1,email.GetEmail());
		ResultSet rs= RicercaConEmail.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		}
		rs.close();
		return lista;
	}
	
	public ArrayList<Contatto> RicercaConAccount(Account acc)throws SQLException{
	
		RicercaConAccount.setString(1,acc.GetNickName());
		ResultSet rs=RicercaConAccount.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		}
		lista.clone();
		return lista;
	}
	
	
	public ArrayList<Contatto> RicercaConTelFIsso(TelefonoFisso tel)throws SQLException{
		RicercaConTelFIsso.setInt(1,tel.getCodN_Fisso());
		ResultSet rs=RicercaConTelFIsso.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		}
		lista.clone();
		return lista;
	}
	
	public ArrayList<Contatto> RicercaConTelMobile(TelefonoMobile tel)throws SQLException{
		RicercaConTelMobile.setInt(1,tel.getCodN_Mobile());
		ResultSet rs=RicercaConTelMobile.executeQuery();
		
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		
		while(rs.next()) {
			Contatto e = new Contatto(rs.getInt("Cod_Contatto"),rs.getString("Nome"),rs.getString("Cognome"));
			lista.add(e);
		}
		lista.clone();
		return lista;
	}
	

}