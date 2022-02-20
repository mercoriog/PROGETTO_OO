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


import controllers.ControlGruppo;
import entity.Gruppo;


public class ViewGruppoDetailsFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton backButton, insertButton, updateButton, deleteButton;
	private JFrame back;
	private JTextField TxtDescrizioneGruppo;
	private Gruppo gruppo;
	private ControlGruppo ControlG;
	
	public ViewGruppoDetailsFrame(JFrame back, Point p, Gruppo selGroup) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165));
		this.gruppo = selGroup;
		this.back = back;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Gruppo");
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
		insertButton.setEnabled(false);
		
		backButton = new JButton();
		backButton.setBounds(350, 20, 90, 30);
		backButton.setText("Indietro");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBackground(new Color(250, 214, 165));
		backButton.setFont(new Font("Courier", Font.PLAIN, 12));
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		/*ControlGruppo controlG = new ControlGruppo();
		Gruppo g = controlG.RecoverGruppoByNome(selGroup);*/
		
		//text box per gli attributi di Gruppo
		JTextField TxtNomeGruppo = new JTextField();
		TxtNomeGruppo.setBounds(20, 100, 420, 40);
		TxtNomeGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtNomeGruppo.setBackground(new Color(250, 214, 165));
		TxtNomeGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleNomeG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeG.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtNomeGruppo.setBorder(titleNomeG);	
		//TxtNomeGruppo.setText(g.getNomeGruppo());
		TxtNomeGruppo.setText(selGroup.GetNomeGruppo());
		TxtNomeGruppo.setEditable(false);
		
		TxtDescrizioneGruppo = new JTextField();
		TxtDescrizioneGruppo.setBounds(20, 180, 420, 40);
		TxtDescrizioneGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtDescrizioneGruppo.setBackground(new Color(250, 214, 165));
		TxtDescrizioneGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleDescG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Descrizione");
		titleDescG.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtDescrizioneGruppo.setBorder(titleDescG);	
		//TxtDescrizioneGruppo.setText(g.getDescrizioneGruppo());
		TxtDescrizioneGruppo.setText(selGroup.Descrizione);
		TxtDescrizioneGruppo.setEditable(false);
		
		JTextField TxtCategoriaGruppo = new JTextField();
		TxtCategoriaGruppo.setBounds(20, 260, 420, 40);
		TxtCategoriaGruppo.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtCategoriaGruppo.setBackground(new Color(250, 214, 165));
		TxtCategoriaGruppo.setCaretColor((Color.WHITE));
		TitledBorder titleCateG =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Categoria");
		titleCateG.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtCategoriaGruppo.setBorder(titleCateG);
		//TxtCategoriaGruppo.setText(g.getCategoriaGruppo());
		TxtCategoriaGruppo.setText(selGroup.Categoria);
		TxtCategoriaGruppo.setEditable(false);
		
		
		//TODO Lista con i contatti del gruppo presi da selGroup.listContatti
		
		
		/*
		ArrayList<Fornitore> listaFornitore = new ArrayList<Fornitore>();
		ControlFornitore controlF = new ControlFornitore();
		listaFornitore= controlF.RecoverFornitore();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		appList = new JList<String>(model);
		for(Fornitore varLoop: listaFornitore) {
			//System.out.println(varLoop + "\n");
			model.addElement(varLoop.GetNome_Fornitore());
		}
		//homeList.setBounds(20, 100, 200, 200);
		appList.setBackground(new Color(255, 254, 239));
		appList.setFont(new Font("Courier", Font.PLAIN, 16));
		//homeList.setForeground(Color.BLACK);
		appList.setSelectionBackground(new Color(255, 255, 255));
		appList.setFixedCellHeight(35);
		//homeList.setSize(420, 550);
		
		JScrollPane scrollList = new JScrollPane();
	
	    scrollList.setViewportView(appList);
	    appList.setLayoutOrientation(JList.VERTICAL);
	    //scrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollList.setBounds(20, 100, 420, 500);
	    scrollList.setBorder(BorderFactory.createLoweredBevelBorder());
	
		this.add(scrollList);		
		*/
		
		this.add(TxtCategoriaGruppo);
		this.add(TxtDescrizioneGruppo);
		this.add(TxtNomeGruppo);
		this.add(titleLabel);
		this.add(backButton);
		this.add(insertButton);
		this.add(updateButton);
		this.add(deleteButton);
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
			ControlG = new ControlGruppo();
			ControlG.EliminaGruppo(gruppo);
			
			if (ControlG.getSQLState().equals("02000")) {
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
			ControlG = new ControlGruppo();
			String Descrizione = JOptionPane.showInputDialog("Inserisci la nuova descrizione: ");
			if(Descrizione != null) {
				if(Descrizione.length()>2) {
					ControlG.ModificaDescGruppo(Descrizione, gruppo);
					
					if (ControlG.getSQLState().equals("02000")) {
						JOptionPane.showMessageDialog(null, "Modifica avvenuta con successo", "Correct Update", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro", "Wrong Insert", JOptionPane.ERROR_MESSAGE);
					}
					TxtDescrizioneGruppo.setText(Descrizione);
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore nella modifica.\nSuggerimento: Riprova tornando indietro o modificando i valori", "Wrong Insert or Short Insert", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	}

}
