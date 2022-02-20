package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.ControlContatto;
import entity.Contatto;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class HomeFrame extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JButton insertButton, contattiButton, gruppiButton, fornitoreButton;
	private JList<String> homeList;
	private ArrayList<Contatto> listaContatti;
	
	public HomeFrame(Point p) {
			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //chiusura gui
		this.setResizable(false);
		this.setSize(480,720);
		this.setLayout(null);
		this.setTitle("Rubrica v3");	//titolo GUI
		this.getContentPane().setBackground(new Color(250, 214, 165));
		this.setLocation(p);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Rubrica");
		titleLabel.setFont(new Font("Courier", Font.PLAIN, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(20, 20, 150, 30);
		
		insertButton = new JButton();
		insertButton.setBounds(350, 20, 90, 30);
		insertButton.setFocusable(false);
		insertButton.setText("Aggiungi");
		insertButton.addActionListener(this);
		insertButton.setBackground(new Color(250, 214, 165));
		insertButton.setFont(new Font("Courier", Font.PLAIN, 12));
		insertButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		gruppiButton = new JButton();
		gruppiButton.setBounds(20, 630, 90, 30);
		gruppiButton.setFocusable(false);
		gruppiButton.setText("Gruppi");
		gruppiButton.addActionListener(this);
		gruppiButton.setBackground(new Color(250, 214, 165));
		gruppiButton.setFont(new Font("Courier", Font.PLAIN, 12));
		gruppiButton.setBorder(BorderFactory.createRaisedBevelBorder());
		//gruppiButton.setEnabled(false);
		
		contattiButton = new JButton();
		contattiButton.setBounds(180, 630, 100, 30);
		contattiButton.setFocusable(false);
		contattiButton.setText("Contatti");
		contattiButton.addActionListener(this);
		contattiButton.setBackground(new Color(250, 214, 165));
		contattiButton.setFont(new Font("Courier", Font.PLAIN, 12));
		contattiButton.setBorder(BorderFactory.createRaisedBevelBorder());
		contattiButton.setEnabled(false);
		
		fornitoreButton = new JButton();
		fornitoreButton.setBounds(350, 630, 90, 30);
		fornitoreButton.setFocusable(false);
		fornitoreButton.setText("App");
		fornitoreButton.addActionListener(this);
		fornitoreButton.setBackground(new Color(250, 214, 165));
		fornitoreButton.setFont(new Font("Courier", Font.PLAIN, 12));
		fornitoreButton.setBorder(BorderFactory.createRaisedBevelBorder());
		//fornitoreButton.setEnabled(false);
		
		
		//Container contList  = new Container();
		listaContatti = new ArrayList<Contatto>();
		ControlContatto controlC = new ControlContatto();
		listaContatti = controlC.RecoverContatto();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		homeList = new JList<String>(model);
		for(Contatto varLoop: listaContatti) {
			model.addElement(varLoop.Nome + " " + varLoop.Cognome);
		}

		homeList.setBackground(new Color(255, 254, 239));
		homeList.setFont(new Font("Courier", Font.PLAIN, 16));
		homeList.setSelectionBackground(new Color(255, 255, 255));
		homeList.setFixedCellHeight(35);
		homeList.addListSelectionListener(this);
		
		JScrollPane scrollList = new JScrollPane();
	
	    scrollList.setViewportView(homeList);
	    homeList.setLayoutOrientation(JList.VERTICAL);
	    scrollList.setBounds(20, 100, 420, 500);
	    scrollList.setBorder(BorderFactory.createLoweredBevelBorder());
		
	
		this.add(scrollList);		
		this.add(titleLabel);
		this.add(insertButton);
		this.add(fornitoreButton);
		this.add(contattiButton);
		this.add(gruppiButton);
		this.setVisible(true);		//rendo il frame visibile
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertButton) {
			this.setVisible(false);
			new InsertContattoFrame(this.getLocation());
			this.dispose();
		}
		else if (e.getSource() == gruppiButton) {
			this.setVisible(false);
			new ViewGruppoFrame(this, this.getLocation());
		}
		else if (e.getSource() == fornitoreButton) {
			this.setVisible(false);
			new ViewFornitoreFrame(this, this.getLocation());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.setVisible(false);
		new ViewContattiDetailsFrame(this, this.getLocation(), listaContatti.get(homeList.getSelectedIndex()));
		
	}
}
