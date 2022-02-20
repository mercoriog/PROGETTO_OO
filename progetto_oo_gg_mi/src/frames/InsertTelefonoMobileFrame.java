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

import entity.Contatto;
import controllers.ControlTelMobile;

public class InsertTelefonoMobileFrame extends JFrame implements ActionListener{

	private ControlTelMobile ControlT;
	private Contatto contatto;
	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JFrame back;
	private JTextField insTxtNumeroTelefono;

	public InsertTelefonoMobileFrame(JFrame back,Point p, Contatto contatto){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3"); //titolo GUI
		//this.getContentPane().setBackground(new Color(132,218,100));
		this.getContentPane().setBackground(new Color(250, 214, 165));
		this.contatto = contatto;
		this.back = back;

		//label titolo insert page
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Telefono Mobile");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		//titleLabel.setVerticalAlignment(JLabel.CENTER);
		//titleLabel
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 250, 30);

		//bottone per il ritorno alla home
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());

		//text box per gli attributi di Gruppo
		insTxtNumeroTelefono = new JTextField();
		insTxtNumeroTelefono.setBounds(20, 100, 420, 40);
		insTxtNumeroTelefono.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNumeroTelefono.setBackground(new Color(250, 214, 165));
		insTxtNumeroTelefono.setCaretColor((Color.WHITE));
		TitledBorder titleNomeF = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Numero");
		titleNomeF.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNumeroTelefono.setBorder(titleNomeF);


		//bottone per inviare i dati
		insertButton = new JButton();
		insertButton.setBounds(350, 630, 90, 30);
		insertButton.setText("Invia");
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());

		//aggiungo i componenti
		this.add(insTxtNumeroTelefono);
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
			if(insTxtNumeroTelefono.getText().length() <= 1) {
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Random rand = new Random();
				int CodN_Mobile= rand.nextInt(10000);
				ControlT=new ControlTelMobile();
				ControlT.InsertTelMobile(CodN_Mobile,insTxtNumeroTelefono.getText(),contatto.GetCod_Contatto(),this.contatto);
				if (ControlT.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: Riprova cambiando i dati, possibili duplicati.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
	}

}
