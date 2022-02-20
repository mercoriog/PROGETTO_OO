package entity;
import java.util.*; 
public class Gruppo {
  
	private String NomeGruppo; 
	public String Descrizione; 
	public String Categoria; 
	
	public Gruppo(String NomeGruppo, String Descrizione,String Categoria) {
		this.NomeGruppo= new String(NomeGruppo); 
		this.Descrizione=new String(Descrizione); 
		this.Categoria=new String(Categoria); 
	}
	
	public String GetNomeGruppo(){ 
		return NomeGruppo; 
	}
	
	ArrayList<Contatto> listContatto = new ArrayList<Contatto>(); 
	
	public void AggiungiContatto(Contatto C) {
		
		listContatto.add(C); 
		C.listGruppo.add(this); 
		
	}
	
	public String GruppotoString() {
		return NomeGruppo + '\t' + Descrizione + '\t' + Categoria; 
	}
	
}
