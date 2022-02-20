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
import entity.Fornitore;

public class ViewFornitoreDetailsFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton backButton, insertButton, updateButton, deleteButton;
	private JFrame back;
	private ControlFornitore controlF;
	private Fornitore fornitore;
	//private JList<String> appList;
	
	public ViewFornitoreDetailsFrame(JFrame back, Point p, Fornitore selForn) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		//this.getContentPane().setBackground(new Color(132,218,100));
		this.getContentPane().setBackground(new Color(250, 214, 165));
		this.fornitore = selForn;
		this.back = back;
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("App");
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
		updateButton.setEnabled(false);
		
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
		
		/*ControlFornitore controlF = new ControlFornitore();
		Fornitore f = controlF.RecoverFornitoreByNome(selForn);*/
		
		//text box per gli attributi di Gruppo
		JTextField TxtNomeFornitore = new JTextField();
		TxtNomeFornitore.setBounds(20, 100, 420, 40);
		TxtNomeFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtNomeFornitore.setBackground(new Color(250, 214, 165));
		TxtNomeFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleNomeF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Nome");
		titleNomeF.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtNomeFornitore.setBorder(titleNomeF);	
		//TxtNomeFornitore.setText(f.GetNome_Fornitore());
		TxtNomeFornitore.setText(selForn.GetNome_Fornitore());
		TxtNomeFornitore.setEditable(false);
		
		JTextField TxtCategoriaFornitore = new JTextField();
		TxtCategoriaFornitore.setBounds(20, 180, 420, 40);
		TxtCategoriaFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtCategoriaFornitore.setBackground(new Color(250, 214, 165));
		TxtCategoriaFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleCateF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Categoria");
		titleCateF.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtCategoriaFornitore.setBorder(titleCateF);	
		//TxtCategoriaFornitore.setText(f.Categoria);
		TxtCategoriaFornitore.setText(selForn.Categoria);
		TxtCategoriaFornitore.setEditable(false);
		
		JTextField TxtCasaProdFornitore = new JTextField();
		TxtCasaProdFornitore.setBounds(20, 260, 420, 40);
		TxtCasaProdFornitore.setFont(new Font("Courier", Font.PLAIN, 12));
		TxtCasaProdFornitore.setBackground(new Color(250, 214, 165));
		TxtCasaProdFornitore.setCaretColor((Color.WHITE));
		TitledBorder titleCasaProdF =  BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Casa Produttrice");
		titleCasaProdF.setTitlePosition(TitledBorder.ABOVE_TOP);
		TxtCasaProdFornitore.setBorder(titleCasaProdF);
		//TxtCasaProdFornitore.setText(f.Casa_Produttrice);
		TxtCasaProdFornitore.setText(selForn.Casa_Produttrice);
		TxtCasaProdFornitore.setEditable(false);
		
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
		
		this.add(TxtCasaProdFornitore);
		this.add(TxtCategoriaFornitore);
		this.add(TxtNomeFornitore);
		this.add(titleLabel);
		this.add(backButton);
		this.add(deleteButton);
		this.add(updateButton);
		this.add(insertButton);
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
			controlF = new ControlFornitore();
			controlF.EliminaFornitore(fornitore);
			
			if (controlF.getSQLState().equals("02000")) {
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
	}
	

}
