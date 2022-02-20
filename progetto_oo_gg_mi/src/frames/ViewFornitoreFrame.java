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
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.ControlFornitore;
import entity.Fornitore;

public class ViewFornitoreFrame extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JButton insertButton;
	private JButton contattiButton, gruppiButton, fornitoreButton;
	private JFrame back;
	private JList<String> appList;
	private ArrayList<Fornitore> listaFornitore;
	
	public ViewFornitoreFrame(JFrame back, Point p) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setLocation(p);
		this.setTitle("Rubrica v3");	//titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165));
		
		this.back = back;
		
		//label titolo insert page
		JLabel titleLabel = new JLabel();
		titleLabel.setText("App");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30);
		
		gruppiButton = new JButton();
		gruppiButton.setBounds(20, 630, 90, 30);
		gruppiButton.setFocusable(false);
		gruppiButton.setText("Gruppi");
		gruppiButton.addActionListener(this);
		gruppiButton.setBackground(new Color(250, 214, 165));
		gruppiButton.setFont(new Font("Courier", Font.PLAIN, 12));
		gruppiButton.setBorder(BorderFactory.createRaisedBevelBorder());
		gruppiButton.setEnabled(false);
		
		contattiButton = new JButton();
		contattiButton.setBounds(180, 630, 100, 30);
		contattiButton.setFocusable(false);
		contattiButton.setText("Contatti");
		contattiButton.addActionListener(this);
		contattiButton.setBackground(new Color(250, 214, 165));
		contattiButton.setFont(new Font("Courier", Font.PLAIN, 12));
		contattiButton.setBorder(BorderFactory.createRaisedBevelBorder());
		//contattiButton.setEnabled(false);
		
		fornitoreButton = new JButton();
		fornitoreButton.setBounds(350, 630, 90, 30);
		fornitoreButton.setFocusable(false);
		fornitoreButton.setText("App");
		fornitoreButton.addActionListener(this);
		fornitoreButton.setBackground(new Color(250, 214, 165));
		fornitoreButton.setFont(new Font("Courier", Font.PLAIN, 12));
		fornitoreButton.setBorder(BorderFactory.createRaisedBevelBorder());
		fornitoreButton.setEnabled(false);
		
		//bottone per inviare i dati
		insertButton = new JButton();
		insertButton.setBounds(350, 20, 90, 30);
		insertButton.setText("Aggiungi");
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		listaFornitore = new ArrayList<Fornitore>();
		ControlFornitore controlF = new ControlFornitore();
		listaFornitore= controlF.RecoverFornitore();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		appList = new JList<String>(model);
		
		for(Fornitore varLoop: listaFornitore) {
			model.addElement(varLoop.GetNome_Fornitore());
		}
		
		appList.setBackground(new Color(255, 254, 239));
		appList.setFont(new Font("Courier", Font.PLAIN, 16));
		appList.setSelectionBackground(new Color(255, 255, 255));
		appList.setFixedCellHeight(35);
		appList.addListSelectionListener(this);
		
		JScrollPane scrollList = new JScrollPane();
	
	    scrollList.setViewportView(appList);
	    appList.setLayoutOrientation(JList.VERTICAL);
	    //scrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollList.setBounds(20, 100, 420, 500);
	    scrollList.setBorder(BorderFactory.createLoweredBevelBorder());

	
		this.add(scrollList);		

		this.add(titleLabel);
		this.add(insertButton);
		this.add(fornitoreButton);
		this.add(contattiButton);
		this.add(gruppiButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == contattiButton) {
			back.setLocation(this.getLocation());
			back.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
		else if(e.getSource() == insertButton) {
			this.setVisible(false);
			new InsertFornitoreFrame(this, this.getLocation());
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == appList) {
			this.setVisible(false);
			new ViewFornitoreDetailsFrame(this, this.getLocation(), listaFornitore.get(appList.getSelectedIndex()));
		}
		
	}
	
}
