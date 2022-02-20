package entity;
import java.util.*;
public class Contatto {

	private int Cod_Contatto; 
	public String Nome; 
	public String Cognome; 
	
	
	public Contatto(int Cod_Contatto, String Nome, String Cognome) { 
	   this.Cod_Contatto=Cod_Contatto; 
	   this.Nome= new String(Nome); 
	   this.Cognome= new String(Cognome); 
	}
	
	public int GetCod_Contatto(){
		return Cod_Contatto; 
	}
	
	public ArrayList<Indirizzi> listIndirizzi = new ArrayList<Indirizzi>(); 
	
	public void AggiungiIndirizzo(int Cod_Indirizzo,int CAP,String Via,String citta,String Nazione) {
		
		Indirizzi I = new Indirizzi(Cod_Indirizzo,Via,CAP,citta,Nazione,this.Cod_Contatto); 
		
		listIndirizzi.add(I); 
		
	}

	
	public ArrayList<TelefonoFisso> listTelefonoF = new ArrayList<TelefonoFisso>(); 
	
	public void AggiungiTelefonoFisso(int CodN_Fisso,String numero) {
		
		TelefonoFisso T_F= new TelefonoFisso(CodN_Fisso,numero,this.Cod_Contatto); 
		
		listTelefonoF.add(T_F); 
		
	}
	
	public ArrayList<TelefonoMobile> listTelefonoM = new ArrayList<TelefonoMobile>();  
	
	public void AggiungiTelefonoMobile (int CodN_Mobile,String numero) {
		
		TelefonoMobile T_M= new TelefonoMobile(CodN_Mobile,numero,this.Cod_Contatto);
		
		listTelefonoM.add(T_M); 
	}
	
	public ArrayList<Email> listEmail = new ArrayList<Email>();  
	
	public void AggiungiEmail(int Cod_Email,String Indirizzo) {
		
		Email E = new Email(Cod_Email,Indirizzo,this.Cod_Contatto); 
		
		listEmail.add(E); 

	}
	
	public ArrayList<Gruppo> listGruppo = new ArrayList<Gruppo>();  
	
	public void AggiungiGruppo(Gruppo G) {
	
		listGruppo.add(G); 
		
		G.listContatto.add(this); 
		
	}
	
	
	
}
