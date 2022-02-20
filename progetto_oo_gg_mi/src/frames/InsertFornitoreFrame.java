package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controllers.ControlFornitore;

public class InsertFornitoreFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JFrame back;
	private JTextField insTxtNomeFornitore, insTxtCategoriaFornitore, insTxtCasaProdFornitore;
	
	public InsertFornitoreFrame(JFrame back, Point p) {
		
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
		titleLabel.setText("Fornitore");
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
		insTxtNomeFornitore = new JTextField();
		insTxtNomeFornitore.setBounds(20, 100, 420, 40);
		insTxtNomeFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNomeFornitore.setBackground(new Color(250, 214, 165));
		insTxtNomeFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleNomeF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeF.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNomeFornitore.setBorder(titleNomeF);	
		
		insTxtCategoriaFornitore = new JTextField();
		insTxtCategoriaFornitore.setBounds(20, 180, 420, 40);
		insTxtCategoriaFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCategoriaFornitore.setBackground(new Color(250, 214, 165));
		insTxtCategoriaFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleCateF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Categoria");
		titleCateF.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCategoriaFornitore.setBorder(titleCateF);		
		
		insTxtCasaProdFornitore= new JTextField();
		insTxtCasaProdFornitore.setBounds(20, 260, 420, 40);
		insTxtCasaProdFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCasaProdFornitore.setBackground(new Color(250, 214, 165));
		insTxtCasaProdFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleCasaProdF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Casa Produttrice");
		titleCasaProdF.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCasaProdFornitore.setBorder(titleCasaProdF);
		
		
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
		this.add(insTxtNomeFornitore);
		this.add(insTxtCategoriaFornitore);
		this.add(insTxtCasaProdFornitore);
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
			if(insTxtNomeFornitore.getText().length() <= 1 || insTxtCategoriaFornitore.getText().length() <= 1 || insTxtCasaProdFornitore.getText().length() <= 1)
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			else {
				ControlFornitore controlF = new ControlFornitore();
				controlF.InsertFornitore(insTxtNomeFornitore.getText(), insTxtCategoriaFornitore.getText(), insTxtCasaProdFornitore.getText());
				insTxtNomeFornitore.setText("");
				insTxtCategoriaFornitore.setText(""); 
				insTxtCasaProdFornitore.setText("");
				if (controlF.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: prova a cambiare nome.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}	
			
		}
		
		
	}
}
