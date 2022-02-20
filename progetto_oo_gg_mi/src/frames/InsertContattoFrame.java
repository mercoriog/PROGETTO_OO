package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controllers.ControlContatto;
import controllers.ControlIndirizzo;
import controllers.ControlTelFisso;
import controllers.ControlTelMobile;
import entity.Contatto;

public class InsertContattoFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JTextField insTxtNome, insTxtCognome, insTxtTelFisso, insTxtTelMobile;
	private JTextField insTxtVia, insTxtCap, insTxtNazione, insTxtCitta;
	
	public InsertContattoFrame(Point p) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165));
		
		
		//label titolo insert page
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Contatto");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30);
		
		//bottone per il ritorno alla home
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		insTxtNome = new JTextField();
		insTxtNome.setBounds(20, 100, 420, 40);
		insTxtNome.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNome.setBackground(new Color(250, 214, 165));
		insTxtNome.setCaretColor((Color.WHITE));
		TitledBorder titleNomeC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNome.setBorder(titleNomeC);
		
		insTxtCognome = new JTextField();
		insTxtCognome.setBounds(20, 160, 420, 40);
		insTxtCognome.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCognome.setBackground(new Color(250, 214, 165));
		insTxtCognome.setCaretColor((Color.WHITE));
		TitledBorder titleCognC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Cognome");
		titleCognC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCognome.setBorder(titleCognC);	
		
		insTxtTelMobile = new JTextField();
		insTxtTelMobile.setBounds(20, 220, 420, 40);
		insTxtTelMobile.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtTelMobile.setBackground(new Color(250, 214, 165));
		insTxtTelMobile.setCaretColor((Color.WHITE));
		TitledBorder titleTelMobC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Telefono mobile");
		titleTelMobC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtTelMobile.setBorder(titleTelMobC);	
		
		insTxtTelFisso = new JTextField();
		insTxtTelFisso.setBounds(20, 280, 420, 40);
		insTxtTelFisso.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtTelFisso.setBackground(new Color(250, 214, 165));
		insTxtTelFisso.setCaretColor((Color.WHITE));
		TitledBorder titleTelFisC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Telefono fisso");
		titleTelFisC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtTelFisso.setBorder(titleTelFisC);
		
		insTxtVia = new JTextField();
		insTxtVia.setBounds(20, 340, 420, 40);
		insTxtVia.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtVia.setBackground(new Color(250, 214, 165));
		insTxtVia.setCaretColor((Color.WHITE));
		TitledBorder titleViaC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Via");
		titleViaC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtVia.setBorder(titleViaC);
		
		insTxtCap = new JTextField();
		insTxtCap.setBounds(20, 400, 420, 40);
		insTxtCap.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCap.setBackground(new Color(250, 214, 165));
		insTxtCap.setCaretColor((Color.WHITE));
		TitledBorder titleCapC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "CAP");
		titleCapC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCap.setBorder(titleCapC);
		
		insTxtNazione = new JTextField();
		insTxtNazione.setBounds(20, 460, 420, 40);
		insTxtNazione.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNazione.setBackground(new Color(250, 214, 165));
		insTxtNazione.setCaretColor((Color.WHITE));
		TitledBorder titleNazC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nazione");
		titleNazC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNazione.setBorder(titleNazC);
		
		insTxtCitta = new JTextField();
		insTxtCitta.setBounds(20, 520, 420, 40);
		insTxtCitta.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCitta.setBackground(new Color(250, 214, 165));
		insTxtCitta.setCaretColor((Color.WHITE));
		TitledBorder titleCitC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Città");
		titleCitC.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCitta.setBorder(titleCitC);
		
		//bottone per inviare i dati
		insertButton = new JButton();
		insertButton.setBounds(350, 630, 90, 30);
		insertButton.setText("Invia");
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.add(insTxtNome);
		this.add(insTxtCognome);
		this.add(insTxtTelMobile);
		this.add(insTxtTelFisso);
		this.add(insTxtVia);
		this.add(insTxtCap);
		this.add(insTxtNazione);
		this.add(insTxtCitta);
		this.add(titleLabel);
		this.add(insertButton);
		this.add(backButton);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			this.setVisible(false);
			new HomeFrame(this.getLocation());
			this.dispose();
		}
		
		 else if (e.getSource() == insertButton) {
			if(insTxtNome.getText().length() <= 1 || 
				insTxtCognome.getText().length() <= 1 || 
				insTxtTelMobile.getText().length() <= 1 ||
				insTxtTelFisso.getText().length() <= 1 ||
				insTxtVia.getText().length() <= 1 ||
				insTxtCap.getText().length() <= 1 ||
				insTxtNazione.getText().length() <= 1 ||
				insTxtCitta.getText().length() <= 1 )
					JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			else {
				Random rand = new Random();
				int Cod_Contatto = rand.nextInt(10000);
				Contatto contatto = new Contatto(Cod_Contatto, insTxtNome.getText(), insTxtCognome.getText());
				ControlContatto controlC = new ControlContatto();
				controlC.InsertContatto(contatto);
				
				int Cod_TM = rand.nextInt(10000);
				ControlTelMobile controlTM = new ControlTelMobile();
				controlTM.InsertTelMobile(Cod_TM, insTxtTelMobile.getText(), Cod_Contatto, contatto);
				
				int Cod_TF = rand.nextInt(10000);
				ControlTelFisso controlTF = new ControlTelFisso();
				controlTF.InsertTelFisso(Cod_TF, insTxtTelFisso.getText(), Cod_Contatto, contatto);
				
				int Cod_Ind = rand.nextInt(10000);
				ControlIndirizzo controlInd = new ControlIndirizzo();
				controlInd.InsertIndirizzo(Cod_Ind, insTxtVia.getText(), Integer.parseInt(insTxtCap.getText()), insTxtNazione.getText(), insTxtCitta.getText(), Cod_Contatto, contatto);
				
				insTxtNome.setText("");
				insTxtCognome.setText(""); 
				insTxtTelMobile.setText("");
				insTxtTelFisso.setText("");
				insTxtVia.setText("");
				insTxtCap.setText("");
				insTxtNazione.setText("");
				insTxtCitta.setText("");
				if (controlC.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: Riprova cambiando i dati, possibili duplicati.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}	
			
		}
		 
		
	}

}
