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

import controllers.ControlIndirizzo;
import entity.Indirizzi;

public class ViewIndirizziDetailsFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton backButton, insertButton, updateButton, deleteButton;
	private JTextField InsTxtVia,InsTxtNazione,InsTxtCitta,InsTxtCap;
	private JFrame back;
	private Indirizzi selInd;
	private ControlIndirizzo controlI;

	public ViewIndirizziDetailsFrame (JFrame back, Point p, Indirizzi selInd) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3"); //titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165)); 
		this.back = back;
		this.selInd = selInd;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Indirizzo");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 250, 30);
		
		deleteButton = new JButton();
		deleteButton.setBounds(20, 630, 90, 30);
		deleteButton.setFocusable(false);
		deleteButton.setText("Elimina");
		deleteButton.addActionListener(this);
		deleteButton.setBackground(new Color(250, 214, 165));
		deleteButton.setFont(new Font("Courier", Font.PLAIN, 12));
		deleteButton.setBorder(BorderFactory.createRaisedBevelBorder());
		deleteButton.setEnabled(true);
		
		updateButton = new JButton();
		updateButton.setBounds(180, 630, 100, 30);
		updateButton.setFocusable(false);
		updateButton.setText("Modifica");
		updateButton.addActionListener(this);
		updateButton.setBackground(new Color(250, 214, 165));
		updateButton.setFont(new Font("Courier", Font.PLAIN, 12));
		updateButton.setBorder(BorderFactory.createRaisedBevelBorder());
		updateButton.setEnabled(true);
		
		insertButton = new JButton();
		insertButton.setBounds(350, 630, 90, 30);
		insertButton.setFocusable(false);
		insertButton.setText("Aggiungi");
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
		insertButton.setEnabled(false);
		
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		InsTxtVia = new JTextField();
		InsTxtVia.setBounds(20, 100, 420, 40);
		InsTxtVia.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtVia.setBackground(new Color(250, 214, 165));
		InsTxtVia.setCaretColor((Color.WHITE));
		TitledBorder titleVia = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Via");
		titleVia.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtVia.setBorder(titleVia);
		InsTxtVia.setText(selInd.Via);
		InsTxtVia.setEditable(false);
		
		InsTxtCap = new JTextField();
		InsTxtCap.setBounds(20, 180, 420, 40);
		InsTxtCap.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtCap.setBackground(new Color(250, 214, 165));
		InsTxtCap.setCaretColor((Color.WHITE));
		TitledBorder titleCap = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Cap");
		titleCap.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtCap.setBorder(titleCap);
		InsTxtCap.setText(String.valueOf(selInd.CAP));
		InsTxtCap.setEditable(false);
		
		InsTxtNazione = new JTextField();
		InsTxtNazione.setBounds(20, 260, 420, 40);
		InsTxtNazione.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtNazione.setBackground(new Color(250, 214, 165));
		InsTxtNazione.setCaretColor((Color.WHITE));
		TitledBorder titleNazione = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nazione");
		titleNazione.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtNazione.setBorder(titleNazione);
		InsTxtNazione.setText(selInd.Nazione);
		InsTxtNazione.setEditable(false);
		
		InsTxtCitta = new JTextField();
		InsTxtCitta.setBounds(20, 340, 420, 40);
		InsTxtCitta.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtCitta.setBackground(new Color(250, 214, 165));
		InsTxtCitta.setCaretColor((Color.WHITE));
		TitledBorder titleCitta = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Citta");
		titleCitta.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtCitta.setBorder(titleCitta);
		InsTxtCitta.setText(selInd.Citta);
		InsTxtCitta.setEditable(false);
		
		this.add(deleteButton);
		this.add(updateButton);
		this.add(InsTxtVia);
		this.add(InsTxtCap);
		this.add(InsTxtNazione);
		this.add(InsTxtCitta);
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
		else if (e.getSource() == deleteButton) {
				controlI = new ControlIndirizzo();
				controlI.EliminaIndirizzo(selInd);
				
				if (controlI.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Eliminazione avvenuta con successo", "Correct Delete", JOptionPane.INFORMATION_MESSAGE);
					back.setLocation(this.getLocation());
					back.setVisible(true);
					this.setVisible(false);
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'eliminazione.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (e.getSource() == updateButton) {
				controlI = new ControlIndirizzo();
				String InsVia = JOptionPane.showInputDialog("Inserisci la Via: ");
				String InsCap = JOptionPane.showInputDialog("Inserisci il CAP: ");
				String InsNazione = JOptionPane.showInputDialog("Inserisci la Nazione: ");
				String InsCitta = JOptionPane.showInputDialog("Inserisci la Citta: ");
				if(InsVia!= null && InsCap!= null && InsNazione != null && InsCitta!= null) {
					if(InsVia.length()>2 && InsCap.length() > 2 && InsNazione.length()>2 && InsCitta.length()>2){	
						controlI.ModificaIndirizzo(InsVia,Integer.parseInt(InsCap), InsNazione, InsCitta, selInd);
						if (controlI.getSQLState().equals("02000")) {
							JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo", "Correct Update", JOptionPane.INFORMATION_MESSAGE);
					 	}
					 	else {
							JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
						}
						InsTxtVia.setText(InsVia);
						InsTxtCap.setText(InsCap);
						InsTxtNazione.setText(InsNazione);
						InsTxtCitta.setText(InsCitta);
					 }
					else
						JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro e cambando i valori", "Wrong Insert or Short Insert", JOptionPane.ERROR_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
					
			}
		}
}
