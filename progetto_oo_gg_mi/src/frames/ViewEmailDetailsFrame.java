package frames;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import controllers.ControlAccount;
import controllers.ControlEmail;
import entity.Account;
import entity.Email;


public class ViewEmailDetailsFrame extends JFrame implements ActionListener, ListSelectionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton backButton, insertButton, updateButton, deleteButton;
	private JTextField InsTxtIndirizzoEmail, insTxtNickname, insTxtNome, insTxtCognome, insTxtFornitore, insTxtFraseBen;
	private JFrame back;
	private JList<String> accList;
	private ArrayList<Account> listaAcc;
	private Email email;
	private ControlEmail controlE;
	private ControlAccount controlA;

	public ViewEmailDetailsFrame(JFrame back, Point p, Email selEmail) {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3"); //titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165)); 
		this.back = back;
		
		this.email = selEmail;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Account");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30);
		
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
		
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		//text box per gli attributi di Gruppo
		InsTxtIndirizzoEmail = new JTextField();
		InsTxtIndirizzoEmail.setBounds(20, 100, 420, 40);
		InsTxtIndirizzoEmail.setFont(new Font("Courier", Font.PLAIN, 12));
		InsTxtIndirizzoEmail.setBackground(new Color(250, 214, 165));
		InsTxtIndirizzoEmail.setCaretColor((Color.WHITE));
		TitledBorder titleIndirizzoE = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Indirizzo Email");
		titleIndirizzoE.setTitlePosition(TitledBorder.ABOVE_TOP);
		InsTxtIndirizzoEmail.setBorder(titleIndirizzoE);
		InsTxtIndirizzoEmail.setText(selEmail.Indirizzo_Email);
		InsTxtIndirizzoEmail.setEditable(false);
		
		insTxtNickname = new JTextField();
		insTxtNickname.setBounds(20, 160, 420, 40);
		insTxtNickname.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNickname.setBackground(new Color(250, 214, 165));
		insTxtNickname.setCaretColor((Color.WHITE));
		TitledBorder titleNicknameA =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nickname");
		titleNicknameA.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNickname.setBorder(titleNicknameA);
		
		insTxtNome = new JTextField();
		insTxtNome.setBounds(20, 220, 420, 40);
		insTxtNome.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtNome.setBackground(new Color(250, 214, 165));
		insTxtNome.setCaretColor((Color.WHITE));
		TitledBorder titleNomeA =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeA.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtNome.setBorder(titleNomeA);
		
		insTxtCognome = new JTextField();
		insTxtCognome.setBounds(20, 280, 420, 40);
		insTxtCognome.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtCognome.setBackground(new Color(250, 214, 165));
		insTxtCognome.setCaretColor((Color.WHITE));
		TitledBorder titleCognA =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Cognome");
		titleCognA.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtCognome.setBorder(titleCognA);	
		
		insTxtFornitore = new JTextField();
		insTxtFornitore.setBounds(20, 340, 420, 40);
		insTxtFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtFornitore.setBackground(new Color(250, 214, 165));
		insTxtFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleFornA =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "App");
		titleFornA.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtFornitore.setBorder(titleFornA);	
		
		insTxtFraseBen = new JTextField();
		insTxtFraseBen.setBounds(20, 400, 420, 40);
		insTxtFraseBen.setFont(new Font("Courier", Font.PLAIN, 12));
		insTxtFraseBen.setBackground(new Color(250, 214, 165));
		insTxtFraseBen.setCaretColor((Color.WHITE));
		TitledBorder titleFBA =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Frase Benvenuto");
		titleFBA.setTitlePosition(TitledBorder.ABOVE_TOP);
		insTxtFraseBen.setBorder(titleFBA);
		
		
		listaAcc = new ArrayList<Account>();
		ControlAccount controlAccount = new ControlAccount();
		listaAcc= controlAccount.RecoverAccountByEmail(selEmail.GetEmail());
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		accList = new JList<String>(model);
		for(Account varLoop: listaAcc) {
			//System.out.println(varLoop + "\n");
			model.addElement(varLoop.GetNickName());
		}
		//homeList.setBounds(20, 100, 200, 200);
		accList.setBackground(new Color(255, 254, 239));
		accList.setFont(new Font("Courier", Font.PLAIN, 16));
		//homeList.setForeground(Color.BLACK);
		accList.setSelectionBackground(new Color(255, 255, 255));
		accList.setFixedCellHeight(35);
		accList.addListSelectionListener(this);
		//homeList.setSize(420, 550);
		
		JScrollPane scrollList = new JScrollPane();
	
	    scrollList.setViewportView(accList);
	    accList.setLayoutOrientation(JList.VERTICAL);
	    //scrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollList.setBounds(20, 460, 420, 140);
	    scrollList.setBorder(BorderFactory.createLoweredBevelBorder());
	
		this.add(scrollList);
		
		this.add(deleteButton);
		this.add(updateButton);
		this.add(InsTxtIndirizzoEmail);
		this.add(insTxtNickname);
		this.add(insTxtNome);
		this.add(insTxtCognome);
		this.add(insTxtFornitore);
		this.add(insTxtFraseBen);
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
			controlE = new ControlEmail();
			controlE.EliminaEmail(email);
			
			if (controlE.getSQLState().equals("02000")) {
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
			controlE = new ControlEmail();
			String Indirizzo = JOptionPane.showInputDialog("Inserisci il nuovo indirizzo: ");
			if(Indirizzo != null) {
				if(Indirizzo.length()>2) {
					controlE.ModificaEmail(Indirizzo, email);
					
					if (controlE.getSQLState().equals("02000")) {
						JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo", "Correct Update", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
					}
					 InsTxtIndirizzoEmail.setText(Indirizzo);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro o modificando i valori", "Wrong Insert or Short Insert", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else if (e.getSource() == insertButton) {
		
			if(insTxtNickname.getText().length()<=1) {
		
				JOptionPane.showMessageDialog(null, "Ogni campo richiede un numero di lettere minimo pari a 2", "Short Insert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				controlA = new ControlAccount();
				controlA.InsertAccount(insTxtNickname.getText(),insTxtFraseBen.getText(), insTxtNome.getText(), insTxtCognome.getText(), email.GetEmail() ,insTxtFornitore.getText(), email);
				if (controlA.getSQLState().equals("02000")) {
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
		if(e.getSource() == accList) {
			this.setVisible(false);
			new ViewAccountDetailsFrame(this, this.getLocation(), this.email, listaAcc.get(accList.getSelectedIndex()));
		}
		
	}
}
