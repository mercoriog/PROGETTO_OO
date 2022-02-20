package entity;

public class Fornitore {
      
	private String Nome_Fornitore; 
	public String Categoria;
	public String Casa_Produttrice;
	
	public Fornitore(String Nome_Fornitore,String Categoria, String Casa_Produttrice) { 
		
		this.Nome_Fornitore= new String(Nome_Fornitore); 
		this.Categoria= new String(Categoria); 
		this.Casa_Produttrice= new String(Casa_Produttrice); 		
	}
	
	public String GetNome_Fornitore() {
		return Nome_Fornitore; 
	}
	
}
