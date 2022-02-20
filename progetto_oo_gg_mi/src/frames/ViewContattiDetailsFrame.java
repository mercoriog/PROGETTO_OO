package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controllers.ControlContatto;
import controllers.ControlIndirizzo;
import controllers.ControlTelFisso;
import controllers.ControlTelMobile;

import java.util.ArrayList;
import entity.Contatto;
import entity.Indirizzi;
import entity.TelefonoFisso;
import entity.TelefonoMobile;


public class ViewContattiDetailsFrame extends JFrame implements ActionListener, ListSelectionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton backButton, groupButton, updateButton, deleteButton;
	private Contatto contatto;
	private JButton indirizziButton, telMobiliButton, telFissiButton, emailButton;
	private JFrame back;
	private JTextField TxtNome, TxtCognome;
	private ArrayList<Indirizzi> listaInd;
	private ArrayList<TelefonoMobile> listaTM;
	private ArrayList<TelefonoFisso> listaTF;
	private JList<String> indList, telMobList, telFisList;
	private ControlContatto controlC;
	
	public ViewContattiDetailsFrame(JFrame back, Point p, Contatto selContatto) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		//this.getContentPane().setBackground(new Color(132,218,100));
		this.getContentPane().setBackground(new Color(250, 214, 165));
		this.contatto = selContatto;
		this.back = back;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Contatto");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30);
		
		
		telMobiliButton = new JButton();
		telMobiliButton.setBounds(20, 630, 90, 30);
		telMobiliButton.setFocusable(false);
		telMobiliButton.setText("+Mobile");
		telMobiliButton.addActionListener(this);
		telMobiliButton.setBackground(new Color(250, 214, 165));
		telMobiliButton.setFont(new Font("Courier", Font.PLAIN, 12));
		telMobiliButton.setBorder(BorderFactory.createRaisedBevelBorder());
		telMobiliButton.setEnabled(true);
		
		indirizziButton = new JButton();
		indirizziButton.setBounds(180, 630, 100, 30);
		indirizziButton.setFocusable(false);
		indirizziButton.setText("+Indirizzo");
		indirizziButton.addActionListener(this);
		indirizziButton.setBackground(new Color(250, 214, 165));
		indirizziButton.setFont(new Font("Courier", Font.PLAIN, 12));
		indirizziButton.setBorder(BorderFactory.createRaisedBevelBorder());
		indirizziButton.setEnabled(true);
		
		telFissiButton = new JButton();
		telFissiButton.setBounds(350, 630, 90, 30);
		telFissiButton.setFocusable(false);
		telFissiButton.setText("+Fisso");
		telFissiButton.addActionListener(this);
		telFissiButton.setBackground(new Color(250, 214, 165));
		telFissiButton.setFont(new Font("Courier", Font.PLAIN, 12));
		telFissiButton.setBorder(BorderFactory.createRaisedBevelBorder());
		telFissiButton.setEnabled(true);
		
		deleteButton = new JButton();
		deleteButton.setBounds(20, 580, 90, 30);
		deleteButton.setFocusable(false);
		deleteButton.setText("Elimina");
		deleteButton.addActionListener(this);
		deleteButton.setBackground(new Color(250, 214, 165));
		deleteButton.setFont(new Font("Courier", Font.PLAIN, 12));
		deleteButton.setBorder(BorderFactory.createRaisedBevelBorder());
		deleteButton.setEnabled(true);
		
		emailButton = new JButton();
		emailButton.setBounds(180, 580, 100, 30);
		emailButton.setFocusable(false);
		emailButton.setText("Email");
		emailButton.addActionListener(this);
		emailButton.setBackground(new Color(250, 214, 165));
		emailButton.setFont(new Font("Courier", Font.PLAIN, 12));
		emailButton.setBorder(BorderFactory.createRaisedBevelBorder());
		emailButton.setEnabled(true);
		
		updateButton = new JButton();
		updateButton.setBounds(350, 580, 90, 30);
		updateButton.setFocusable(false);
		updateButton.setText("Modifica");
		updateButton.addActionListener(this);
		updateButton.setBackground(new Color(250, 214, 165));
		updateButton.setFont(new Font("Courier", Font.PLAIN, 12));
		updateButton.setBorder(BorderFactory.createRaisedBevelBorder());
		updateButton.setEnabled(true);
		
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		groupButton = new JButton();
		groupButton.setBounds(350, 60, 90, 30);
		groupButton.setText("Gruppi");
		groupButton.setFocusable(false);
		groupButton.addActionListener(this);
		groupButton.setBackground(new Color(250, 214, 165));
		groupButton.setFont(new Font("Courier", Font.PLAIN, 12));
		groupButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		TxtNome = new JTextField();
		TxtNome.setBounds(20, 100, 420, 40);
		TxtNome.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtNome.setBackground(new Color(250, 214, 165));
		TxtNome.setCaretColor((Color.WHITE));
		TitledBorder titleNome =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNome.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtNome.setBorder(titleNome);	
		TxtNome.setText(selContatto.Nome);
		TxtNome.setEditable(false);
		
		TxtCognome = new JTextField();
		TxtCognome.setBounds(20, 150, 420, 40);
		TxtCognome.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtCognome.setBackground(new Color(250, 214, 165));
		TxtCognome.setCaretColor((Color.WHITE));
		TitledBorder titleCognC =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Cognome");
		titleCognC.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtCognome.setBorder(titleCognC);	
		TxtCognome.setText(selContatto.Cognome);
		TxtCognome.setEditable(false);
				
		listaInd = new ArrayList<Indirizzi>();
		ControlIndirizzo controlInd = new ControlIndirizzo();
		listaInd= controlInd.RecoverIndirizzoByCodContatto(selContatto.GetCod_Contatto());
		
		DefaultListModel<String> modelInd = new DefaultListModel<String>();
		indList = new JList<String>(modelInd);
		for(Indirizzi varLoop: listaInd) {
			modelInd.addElement(varLoop.Via + ", " + varLoop.CAP + ", " + varLoop.Citta + ", " + varLoop.Nazione);
		}
		
		indList.setBackground(new Color(255, 254, 239));
		indList.setFont(new Font("Courier", Font.PLAIN, 12));
		indList.setSelectionBackground(new Color(255, 255, 255));
		indList.setFixedCellHeight(35);
		indList.addListSelectionListener(this);
		
		JScrollPane scrollIndList = new JScrollPane();
	    scrollIndList.setViewportView(indList);
	    indList.setLayoutOrientation(JList.VERTICAL); 
	    scrollIndList.setBounds(20, 200, 420, 100);
	    //scrollIndList.setBorder(BorderFactory.createLoweredBevelBorder());
	    scrollIndList.setBackground(new Color(250, 214, 165));
	    TitledBorder titleInd =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Indirizzi");
		titleInd.setTitlePosition(TitledBorder.ABOVE_TOP);
		scrollIndList.setBorder(titleInd);	 
		
	    listaTM = new ArrayList<TelefonoMobile>();
		ControlTelMobile controlTelMobile = new ControlTelMobile();
		listaTM = controlTelMobile.RecoverTelefonoMobileByCodContatto(selContatto.GetCod_Contatto());
	    
	    DefaultListModel<String> modelTelMob = new DefaultListModel<String>();
		telMobList = new JList<String>(modelTelMob);
		for(TelefonoMobile varLoop: listaTM) {
			modelTelMob.addElement(varLoop.numero);
		}
		
		telMobList.setBackground(new Color(255, 254, 239));
		telMobList.setFont(new Font("Courier", Font.PLAIN, 12));
		telMobList.setSelectionBackground(new Color(255, 255, 255));
		telMobList.setFixedCellHeight(35);
		telMobList.addListSelectionListener(this);
		
		JScrollPane scrolltelMobList = new JScrollPane();
	    scrolltelMobList.setViewportView(telMobList);
	    telMobList.setLayoutOrientation(JList.VERTICAL); 
	    scrolltelMobList.setBounds(20, 320, 420, 100);
	    //scrolltelMobList.setBorder(BorderFactory.createLoweredBevelBorder());
	    scrolltelMobList.setBackground(new Color(250, 214, 165));
	    TitledBorder titleTM =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Telefono mobile");
		titleTM.setTitlePosition(TitledBorder.ABOVE_TOP);
		scrolltelMobList.setBorder(titleTM);	 
	    
	    
	    listaTF = new ArrayList<TelefonoFisso>();
		ControlTelFisso controlTF = new ControlTelFisso();
		listaTF= controlTF.RecoverTelefonoFissoByCodContatto(selContatto.GetCod_Contatto());
		
		DefaultListModel<String> modelTF = new DefaultListModel<String>();
		telFisList = new JList<String>(modelTF);
		for(TelefonoFisso varLoop: listaTF) {
			modelTF.addElement(varLoop.numeroTF);
		}
		
		telFisList.setBackground(new Color(255, 254, 239));
		telFisList.setFont(new Font("Courier", Font.PLAIN, 12));
		telFisList.setSelectionBackground(new Color(255, 255, 255));
		telFisList.setFixedCellHeight(35);
		telFisList.addListSelectionListener(this);
		
		JScrollPane scrollTFList = new JScrollPane();
	    scrollTFList.setViewportView(telFisList);
	    telFisList.setLayoutOrientation(JList.VERTICAL); 
	    scrollTFList.setBounds(20, 440, 420, 100);
	    //scrollTFList.setBorder(BorderFactory.createLoweredBevelBorder());
	    scrollTFList.setBackground(new Color(250, 214, 165));
	    TitledBorder titleTF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Telefono fisso");
		titleTF.setTitlePosition(TitledBorder.ABOVE_TOP);
		scrollTFList.setBorder(titleTF);	 
	    
		this.add(scrollIndList);
		this.add(scrolltelMobList);
		this.add(scrollTFList);
		this.add(TxtNome);
		this.add(TxtCognome);
		this.add(titleLabel);
		this.add(deleteButton);
		this.add(updateButton);
		this.add(backButton);
		this.add(groupButton);
		this.add(telFissiButton);
		this.add(indirizziButton);
		this.add(telMobiliButton);
		this.add(emailButton);
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
		else if(e.getSource() == groupButton) {
			this.setVisible(false);
			new InsertConInGruppoFrame(this, this.getLocation(), this.contatto);
		}
		else if(e.getSource() == emailButton) {
			this.setVisible(false);
			new InsertEmailFrame(this, this.getLocation(), this.contatto);
		}
		else if(e.getSource() == telFissiButton) {
			this.setVisible(false);
			new InsertTelefonoFissoFrame(this, this.getLocation(), this.contatto);
		}
		else if(e.getSource() == telMobiliButton) {
			this.setVisible(false);
			new InsertTelefonoMobileFrame(this, this.getLocation(), this.contatto);
		}
		else if(e.getSource() == indirizziButton) {
			this.setVisible(false);
			new InsertIndirizzoFrame(this, this.getLocation(), this.contatto);
		}
		else if (e.getSource() == deleteButton) {
			controlC = new ControlContatto();
			controlC.EliminaContatto(contatto);
			
			if (controlC.getSQLState().equals("02000")) {
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
			controlC = new ControlContatto();
			String Nome = JOptionPane.showInputDialog("Inserisci il nome: ");
			String Cognome = JOptionPane.showInputDialog("Inserisci il Cognome: ");
			if(Nome != null && Cognome != null){
				if(Nome.length()>2 && Cognome.length()>2){
					controlC.ModificaContatto(Nome, Cognome, contatto);
					
					if (controlC.getSQLState().equals("02000")) {
						JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo", "Correct Update", JOptionPane.INFORMATION_MESSAGE);
						TxtNome.setText(Nome);
						TxtCognome.setText(Cognome);
					}
					else {
						JOptionPane.showMessageDialog(null, "Errore nell'eliminazione.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
					}
			 
				}
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == telFisList) {
			this.setVisible(false);
			new ViewTelefonoFissoDetailsFrame(this, this.getLocation(), listaTF.get(telFisList.getSelectedIndex()));
		}
		else if(e.getSource() == telMobList) {
			this.setVisible(false);
			new ViewTelefonoMobileDetailsFrame(this, this.getLocation(), listaTM.get(telMobList.getSelectedIndex()));
		}
		else if(e.getSource() == indList) {
			this.setVisible(false);
			new ViewIndirizziDetailsFrame(this, this.getLocation(), listaInd.get(indList.getSelectedIndex()));
		}
	}
	
}
