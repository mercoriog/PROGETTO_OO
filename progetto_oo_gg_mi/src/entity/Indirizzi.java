package entity;

public class Indirizzi {
private int Cod_Indirizzo, Cod_Contatto;
public String Via, Nazione, Citta;
public int CAP;

public Indirizzi(int Cod_Indirizzo, String Via, int CAP, String Nazione, String Citta, int Cod_Contatto) {
this.Cod_Indirizzo = Cod_Indirizzo;
this.Via = new String(Via);
this.CAP = CAP;
this.Nazione = Nazione;
this.Citta = Citta;
this.Cod_Contatto = Cod_Contatto;
}

public int getCod_Indirizzo() {
return Cod_Indirizzo;
}
public int getCod_Contatto() {
return Cod_Contatto;
}

}

