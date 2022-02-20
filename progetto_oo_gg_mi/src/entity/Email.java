package entity;
import java.util.ArrayList;

public class Email {
	private int Cod_Email;
	public String Indirizzo_Email;
	private int Cod_Contatto;

	public Email(int Cod_Email, String Indirizzo_Email, int Cod_Contatto) {
		this.Cod_Email = Cod_Email;
		this.Indirizzo_Email = new String(Indirizzo_Email);
		this.Cod_Contatto = Cod_Contatto;
	}
	
	public int GetEmail() {
		return Cod_Email; 
	}
	
	public int GetCod_Contatto() {
		return Cod_Contatto ; 
	}
	
	public ArrayList<Account> listAccount = new ArrayList<Account>();



	public void AggiungiAccount(String Nickname, String Frase_Bnevenuto, String NomeAccount, String CognomeAccount, int Email_Appartenenza, String Nome_Fornitore){
		
	Account newAccount = new Account(Nickname, Frase_Bnevenuto, NomeAccount, CognomeAccount, Email_Appartenenza, Nome_Fornitore);
	
	listAccount.add(newAccount);
	
	}
	
}
