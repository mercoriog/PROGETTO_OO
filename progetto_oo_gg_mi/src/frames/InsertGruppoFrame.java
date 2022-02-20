package frames;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controllers.ControlGruppo;

public class InsertGruppoFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JFrame back;
	private JTextField insTxtNomeGruppo, insTxtDescrizioneGruppo, insTxtCategoriaGruppo;
	
	public InsertGruppoFrame(JFrame back, Point p) {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		//this.getContentPane().setBackground(new Color(132,218,100));
		this.getContentPane().setBackground(new Color(250, 214, 165));
		
		this.back = back;
		
		//label titolo insert page
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Gruppo");
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
		
		//text box per gli attributi di Gruppo
		insTxtNomeGruppo = new JTextField();
		insTxtNomeGruppo.setBounds(20, 100, 420, 40);
		insTxtNomeGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNomeGruppo.setBackground(new Color(250, 214, 165));
		insTxtNomeGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleNomeG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeG.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNomeGruppo.setBorder(titleNomeG);
		
		insTxtDescrizioneGruppo = new JTextField();
		insTxtDescrizioneGruppo.setBounds(20, 180, 420, 40);
		insTxtDescrizioneGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtDescrizioneGruppo.setBackground(new Color(250, 214, 165));
		insTxtDescrizioneGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleDescG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Descrizione");
		titleDescG.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtDescrizioneGruppo.setBorder(titleDescG);	
		
		insTxtCategoriaGruppo = new JTextField();
		insTxtCategoriaGruppo.setBounds(20, 260, 420, 40);
		insTxtCategoriaGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCategoriaGruppo.setBackground(new Color(250, 214, 165));
		insTxtCategoriaGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleCateG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Categoria");
		titleCateG.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCategoriaGruppo.setBorder(titleCateG);		
		
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
		this.add(insTxtNomeGruppo);
		this.add(insTxtDescrizioneGruppo);
		this.add(insTxtCategoriaGruppo);
		this.add(titleLabel);
		this.add(insertButton);
		this.add(backButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			back.setLocation(this.getLocation());
			back.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}	
		else if (e.getSource() == insertButton) {
			if(insTxtNomeGruppo.getText().length() <= 1 || insTxtDescrizioneGruppo.getText().length() <= 1 || insTxtCategoriaGruppo.getText().length() <= 1)
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			else {
				ControlGruppo controlG = new ControlGruppo();
				controlG.InsertGruppo(insTxtNomeGruppo.getText(), insTxtDescrizioneGruppo.getText(), insTxtCategoriaGruppo.getText());
				insTxtNomeGruppo.setText("");
				insTxtDescrizioneGruppo.setText(""); 
				insTxtCategoriaGruppo.setText("");
				if (controlG.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: prova a cambiare nome.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}	
			
		}
	}
	
	
	
}
