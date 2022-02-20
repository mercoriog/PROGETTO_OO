package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.ControlEmail;
import entity.Contatto;
import entity.Email;

public class InsertEmailFrame extends JFrame implements ActionListener, ListSelectionListener{

	private ControlEmail controlE;
	private Contatto contatto;
	private static final long serialVersionUID = 1L;
	private JButton backButton,insertButton;
	private JFrame back;
	private JTextField InsTxtIndirizzoEmail;
	private ArrayList<Email> listaEmail;
	private JList<String> emailList;
	
	public InsertEmailFrame(JFrame back,Point p,Contatto contatto) {
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3"); //titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165)); 
		this.back = back;
		
		this.contatto=contatto; //label titolo insert page
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Email");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		//titleLabel.setVerticalAlignment(JLabel.CENTER);
		//titleLabel
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30); //bottone per il ritorno alla home
		
		insertButton = new JButton();
		insertButton.setBounds(350, 630, 90, 30);
		insertButton.setFocusable(false);
		insertButton.setText("Aggiungi");
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		//text box per gli attributi di Email
		InsTxtIndirizzoEmail = new JTextField();
		InsTxtIndirizzoEmail.setBounds(20, 100, 420, 40);
		InsTxtIndirizzoEmail.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtIndirizzoEmail.setBackground(new Color(250, 214, 165));
		InsTxtIndirizzoEmail.setCaretColor((Color.WHITE));
		TitledBorder titleIndirizzoE = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Indirizzo");
		titleIndirizzoE.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtIndirizzoEmail.setBorder(titleIndirizzoE);
		
		
		listaEmail = new ArrayList<Email>();
		ControlEmail controlEmail = new ControlEmail();
		listaEmail= controlEmail.RecoverEmailByContatto(contatto.GetCod_Contatto());
		
		DefaultListModel<String> modelEmail = new DefaultListModel<String>();
		emailList = new JList<String>(modelEmail);
		for(Email varLoop: listaEmail) {
			modelEmail.addElement(varLoop.Indirizzo_Email);
		}
		
		emailList.setBackground(new Color(255, 254, 239));
		emailList.setFont(new Font("Courier", Font.PLAIN, 12));
		emailList.setSelectionBackground(new Color(255, 255, 255));
		emailList.setFixedCellHeight(35);
		emailList.addListSelectionListener(this);
		
		JScrollPane scrollEmailList = new JScrollPane();
	    scrollEmailList.setViewportView(emailList);
	    emailList.setLayoutOrientation(JList.VERTICAL); 
	    scrollEmailList.setBounds(20, 180, 420, 300);
	    //scrollIndList.setBorder(BorderFactory.createLoweredBevelBorder());
	    scrollEmailList.setBackground(new Color(250, 214, 165));
	    TitledBorder titleEmail =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Email");
		titleEmail.setTitlePosition(TitledBorder.ABOVE_TOP);
		scrollEmailList.setBorder(titleEmail);	 
		
		
		this.add(scrollEmailList);
		this.add(InsTxtIndirizzoEmail);
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
		
			if(InsTxtIndirizzoEmail.getText().length()<=1) {
		
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Random rand = new Random();
				int Cod_Email = rand.nextInt(10000);
				controlE = new ControlEmail();
				controlE.InsertEmail(Cod_Email,InsTxtIndirizzoEmail.getText(),contatto.GetCod_Contatto(), this.contatto);
				if (controlE.getSQLState().equals("02000")) {
					JOptionPane.showMessageDialog(null, "Inserimento avvenuto con successo", "Correct Insert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento.\nSuggerimento: Riprova cambiando i dati, possibili duplicati.", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == emailList) {
			this.setVisible(false);
			new ViewEmailDetailsFrame(this, this.getLocation(), listaEmail.get(emailList.getSelectedIndex()));
		}
		
	}
		
}
