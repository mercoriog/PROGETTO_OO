package entity;

public class TelefonoMobile {

	private int CodN_Mobile;
	public String numero;
	private int Cod_Contatto;

	public TelefonoMobile(int CodN_Mobile, String numero, int Cod_Contatto) {
	this.CodN_Mobile = CodN_Mobile;
	this.numero = new String(numero);
	this.Cod_Contatto = Cod_Contatto;
	}

	public int getCodN_Mobile() {
	return CodN_Mobile;
	}
	
	public int GetCod_Contatto(){
		return Cod_Contatto; 
	}
}
