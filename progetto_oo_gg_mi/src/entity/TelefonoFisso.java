package entity;

public class TelefonoFisso {
private int CodN_Fisso;
public String numeroTF;
private int Cod_Contatto;

public TelefonoFisso(int CodN_Fisso, String numero, int Cod_Contatto) {
this.CodN_Fisso = CodN_Fisso;
this.numeroTF = new String(numero);
this.Cod_Contatto = Cod_Contatto;
}

public int getCodN_Fisso() {
return CodN_Fisso;
}
public int getCod_Contatto() {
return Cod_Contatto;
}
}
