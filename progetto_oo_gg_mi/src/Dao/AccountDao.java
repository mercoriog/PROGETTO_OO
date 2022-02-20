package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;

public class AccountDao {
	private Connection connection;
	private PreparedStatement modificaAccountPS, inserisciAccountPS, recuperaAccountPS;
	private PreparedStatement eliminaAccountPS, recuperaAccountByCodEmailPS, recuperaAccountByFornitorePS;

	public AccountDao(Connection conn) throws SQLException{
		connection = conn;
		eliminaAccountPS = connection.prepareStatement("DELETE FROM ACCOUNT WHERE Nickname = ?");
		modificaAccountPS = connection.prepareStatement("UPDATE ACCOUNT SET Frase_Benvenuto = ? where Nickname = ?");
		recuperaAccountByFornitorePS = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE Nome_Fornitore = ?");
		recuperaAccountByCodEmailPS = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE Cod_Email = ?");
		recuperaAccountPS = connection.prepareStatement("SELECT * FROM ACCOUNT");
		inserisciAccountPS = connection.prepareStatement("INSERT INTO ACCOUNT VALUES(?, ?, ?, ?, ?, ?)");
	}
	
	public void eliminaAccount(Account account) throws SQLException {
		eliminaAccountPS.setString(1, account.GetNickName());
		eliminaAccountPS.executeQuery();
	}
	
	public void modificaAccount(String Frase_Benvenuto, Account account) throws SQLException{
		modificaAccountPS.setString(1, Frase_Benvenuto);
		modificaAccountPS.setString(2, account.GetNickName());
	
		modificaAccountPS.executeQuery();
	}
	public void inserisciAccount(Account account) throws SQLException{
		inserisciAccountPS.setString(1, account.GetNickName());
		inserisciAccountPS.setString(2, account.Frase_Benvenuto);
		inserisciAccountPS.setString(3, account.Nome_Account);
		inserisciAccountPS.setString(4, account.Cognome_Account);
		inserisciAccountPS.setString(5, account.GetFornitoreAppartenenza());
		inserisciAccountPS.setInt(6, account.GetEmailAppartenenza());
		inserisciAccountPS.executeQuery();
	}
	public ArrayList<Account> recuperaAccount() throws SQLException{
		ResultSet rs = recuperaAccountPS.executeQuery();
		ArrayList<Account> lista = new ArrayList<Account>();
		while(rs.next()) {
			Account newAccount = new Account(rs.getString("Nickname"), rs.getString("Frase_benvenuto"), rs.getString("Nome"), rs.getString("Cognome"),rs.getInt("Cod_Email"), rs.getString("Nome_Fornitore"));
			lista.add(newAccount);
		}
		rs.close();
		return lista;
	}
	public ArrayList<Account> recuperaAccountByCodEmail(int codEmail) throws SQLException {
		recuperaAccountByCodEmailPS.setInt(1, codEmail);
		ResultSet rs = recuperaAccountByCodEmailPS.executeQuery();
		ArrayList<Account> lista = new ArrayList<Account>();
		while(rs.next()) {
			Account newAccount = new Account(rs.getString("Nickname"), rs.getString("Frase_benvenuto"), rs.getString("Nome"), rs.getString("Cognome"),rs.getInt("Cod_Email"), rs.getString("Nome_Fornitore"));
			lista.add(newAccount);
		}
		rs.close();
		return lista;
	}
	public ArrayList<Account> recuperaAccountByFornitore(String nomeFornitore) throws SQLException {
		recuperaAccountByFornitorePS.setString(1, nomeFornitore);
		ResultSet rs = recuperaAccountByFornitorePS.executeQuery();
		ArrayList<Account> lista = new ArrayList<Account>();
			while(rs.next()) {
			Account newAccount = new Account(rs.getString("Nickname"), rs.getString("Frase_Benvenuto"), rs.getString("Nome"), rs.getString("Cognome"),rs.getInt("Cod_Email"), rs.getString("Nome_Fornitore"));
			lista.add(newAccount);
		}
			rs.close();
			return lista;
		}
}

