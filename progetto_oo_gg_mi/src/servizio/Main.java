package servizio;

import frames.HomeFrame;

import java.awt.Point;
/*
import java.sql.Connection;
import java.util.List;

import connection.*;
import daos.*;
import entita.Gruppo;
*/
public class Main {
	
	public static void main(String[] args) throws Exception{
		
		new HomeFrame(new Point(0,0));
		
		/*
		DBConnection dbConnection = null;
		Connection connection = null;
		DBBuilder builder = null;
		
		try {
			
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
			builder = new DBBuilder(connection);
			
			GruppoDAO dao = null;
			
			builder.CreateTableGruppo();
			dao = new GruppoDAO(connection);
			Gruppo g = new Gruppo("Calcetto", "5vs5", "Sport");
			int res = dao.inserisciGruppo(g);
			System.out.println(res);
			
			List<Gruppo> listaGruppi = dao.getGruppoByNomeGruppo(g.getNomeGruppo());
			for(Gruppo varLoop: listaGruppi) {
				System.out.println(varLoop.toString());
			}
					
		}
		catch (Exception e) {
			System.out.println("Errore nel main: "+ e.getMessage());
		}
*/
	}

}
