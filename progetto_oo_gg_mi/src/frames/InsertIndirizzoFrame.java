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

import controllers.ControlIndirizzo;
import entity.Contatto;



public class InsertIndirizzoFrame extends JFrame implements ActionListener {
	ControlIndirizzo ControlI;
	private Contatto contatto;
	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JFrame back;
	private JTextField InsTxtVia,InsTxtNazione,InsTxtCitta,InsTxtCap;

	public InsertIndirizzoFrame(JFrame back,Point p,Contatto contatto){
	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
	this.setResizable(false);
	this.setSize(480,720);
	this.setLayout(null);
	this.setLocation(p);
	this.setTitle("Rubrica v3"); //titolo GUI
	//this.getContentPane().setBackground(new Color(132,218,100));
	this.getContentPane().setBackground(new Color(250, 214, 165));
	
	this.contatto=contatto;
	this.back = back;
	
	//label titolo insert page
	JLabel titleLabel = new JLabel();
	titleLabel.setText("Indirizzo");
	titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
	//titleLabel.setVerticalAlignment(JLabel.CENTER);
	//titleLabel
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
	
	//text box per gli attributi dell indirizzo
	InsTxtVia = new JTextField();
	InsTxtVia.setBounds(20, 100, 420, 40);
	InsTxtVia.setFont(new Font("Courier", Font.PLAIN, 12));
	InsTxtVia.setBackground(new Color(250, 214, 165));
	InsTxtVia.setCaretColor((Color.WHITE));
	TitledBorder titleVia = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Via");
	titleVia.setTitlePosition(TitledBorder.ABOVE_TOP);
	InsTxtVia.setBorder(titleVia);
	
	InsTxtCap = new JTextField();
	InsTxtCap.setBounds(20, 180, 420, 40);
	InsTxtCap.setFont(new Font("Courier", Font.PLAIN, 12));
	InsTxtCap.setBackground(new Color(250, 214, 165));
	InsTxtCap.setCaretColor((Color.WHITE));
	TitledBorder titleCap = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Cap");
	titleCap.setTitlePosition(TitledBorder.ABOVE_TOP);
	InsTxtCap.setBorder(titleCap);
	
	InsTxtNazione = new JTextField();
	InsTxtNazione.setBounds(20, 260, 420, 40);
	InsTxtNazione.setFont(new Font("Courier", Font.PLAIN, 12));
	InsTxtNazione.setBackground(new Color(250, 214, 165));
	InsTxtNazione.setCaretColor((Color.WHITE));
	TitledBorder titleNazione = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nazione");
	titleNazione.setTitlePosition(TitledBorder.ABOVE_TOP);
	InsTxtNazione.setBorder(titleNazione);
	
	InsTxtCitta = new JTextField();
	InsTxtCitta.setBounds(20, 340, 420, 40);
	InsTxtCitta.setFont(new Font("Courier", Font.PLAIN, 12));
	InsTxtCitta.setBackground(new Color(250, 214, 165));
	InsTxtCitta.setCaretColor((Color.WHITE));
	TitledBorder titleCitta = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Citta");
	titleCitta.setTitlePosition(TitledBorder.ABOVE_TOP);
	InsTxtCitta.setBorder(titleCitta);
	
	//bottone per inviare i dati
	insertButton = new JButton();
	insertButton.setBounds(350, 630, 90, 30);
	insertButton.setText("Invia");
	insertButton.setFocusable(false);
	insertButton.addActionListener(this);
	insertButton.setBackground(new Color(250, 214, 165));
	insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
	insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
	
	this.add(InsTxtVia);
	this.add(InsTxtCap);
	this.add(InsTxtNazione);
	this.add(InsTxtCitta);
	this.add(titleLabel);
	this.add(insertButton);
	this.add(backButton);
	this.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == backButton) {
			back.setLocation(this.getLocation());
			back.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
		else if (e.getSource() == insertButton) {
			if(InsTxtVia.getText().length()<=1||InsTxtCap.getText().length()<=1||InsTxtNazione.getText().length()<=1||InsTxtCitta.getText().length()<=1)
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			
			else {
				Random rand = new Random();
				int Cod_Indirizzo = rand.nextInt(10000);
				ControlI = new ControlIndirizzo();
				ControlI.InsertIndirizzo(Cod_Indirizzo,InsTxtVia.getText(),Integer.parseInt(InsTxtCap.getText()),InsTxtNazione.getText(),InsTxtCitta.getText(),contatto.GetCod_Contatto(),contatto);
				if (ControlI.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: prova a cambiare qualche dato.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}