package entity;

public class Account {
   private String NickName; 
   public String Frase_Benvenuto; 
   public String Nome_Account; 
   public String Cognome_Account; 
   private int Email_Appartenenza; 
   private String Fornitore_Appartenenza; 
  
   
   public Account(String NickName,String Frase_Benvenuto,String Nome_Account,String Cognome_Account,int Email_Appartenenza,String Fornitore_Appartenenza){
	   this.NickName=new String(NickName);
	   this.Frase_Benvenuto=new String(Frase_Benvenuto); 
	   this.Nome_Account=new String(Nome_Account); 
	   this.Cognome_Account=new String(Cognome_Account);
	   this.Email_Appartenenza=Email_Appartenenza; 
	   this.Fornitore_Appartenenza=new String(Fornitore_Appartenenza);
   }
   
   public String GetNickName(){ 
	   return NickName; 
   }
   
   public int GetEmailAppartenenza(){
	   return Email_Appartenenza;
	}
	public String GetFornitoreAppartenenza(){
	   return Fornitore_Appartenenza;
   }
   
}
