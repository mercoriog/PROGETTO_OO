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

import controllers.ControlTelFisso;
import entity.TelefonoFisso;

public class ViewTelefonoFissoDetailsFrame extends JFrame implements ActionListener{

	private JButton backButton, insertButton, updateButton, deleteButton;
	private JTextField insTxtNumeroTelefono;
	private JFrame back;
	private TelefonoFisso tf;
	private ControlTelFisso controlTF;
	private static final long serialVersionUID = 1L;

	public ViewTelefonoFissoDetailsFrame(JFrame back, Point p, TelefonoFisso tf) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3"); //titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165)); 
		this.back = back;
		this.tf = tf;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Telefono Fisso");
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
		
		insTxtNumeroTelefono = new JTextField();
		insTxtNumeroTelefono.setBounds(20, 100, 420, 40);
		insTxtNumeroTelefono.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNumeroTelefono.setBackground(new Color(250, 214, 165));
		insTxtNumeroTelefono.setCaretColor((Color.WHITE));
		TitledBorder titleNumF = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Numero");
		titleNumF.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNumeroTelefono.setBorder(titleNumF);
		insTxtNumeroTelefono.setText(tf.numeroTF);
		insTxtNumeroTelefono.setEditable(false);
		
		this.add(deleteButton);
		this.add(updateButton);
		this.add(insTxtNumeroTelefono);
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
			controlTF = new ControlTelFisso();
			controlTF.EliminaNumero(this.tf);
			if (controlTF.getSQLState().equals("02000")) {
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
			controlTF = new ControlTelFisso();
			String Numero = JOptionPane.showInputDialog("Inserisci il nuovo numero: ");
			if(Numero != null) {
				if(Numero.length()>2) {
					controlTF.ModificaNumero(Numero, tf);
					
					 if (controlTF.getSQLState().equals("02000")) {
						JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo", "Correct Update", JOptionPane.INFORMATION_MESSAGE);
						 insTxtNumeroTelefono.setText(Numero);
					 }
					else {
						JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro o modificando i valori", "Wrong Insert or Short Insert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
