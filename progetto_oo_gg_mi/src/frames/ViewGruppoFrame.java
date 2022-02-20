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

import controllers.ControlGruppo;
import entity.Gruppo;

public class ViewGruppoFrame extends JFrame implements ActionListener, ListSelectionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton insertButton;
	private JButton contattiButton, gruppiButton, fornitoreButton;
	private JFrame back;
	private JList<String> groupList;
	private ArrayList<Gruppo> listaGruppi;
	
	public ViewGruppoFrame(JFrame back, Point p) {
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
		titleLabel.setText("Gruppo");
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
		
		listaGruppi = new ArrayList<Gruppo>();
		ControlGruppo controlG = new ControlGruppo();
		listaGruppi = controlG.RecoverGruppo();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		groupList = new JList<String>(model);
		
		for(Gruppo varLoop: listaGruppi) {
			model.addElement(varLoop.GetNomeGruppo());
			//model.addElement(varLoop.LeggiGruppo());
		}
		
		groupList.setBackground(new Color(255, 254, 239));
		groupList.setFont(new Font("Courier", Font.PLAIN, 16));
		groupList.setSelectionBackground(new Color(255, 255, 255));
		groupList.setFixedCellHeight(35);
		groupList.addListSelectionListener(this);
		
		JScrollPane scrollList = new JScrollPane();
	
	    scrollList.setViewportView(groupList);
	    groupList.setLayoutOrientation(JList.VERTICAL); 
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
			new InsertGruppoFrame(this, this.getLocation());
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == groupList) {
			this.setVisible(false);
			new ViewGruppoDetailsFrame(this, this.getLocation(), listaGruppi.get(groupList.getSelectedIndex()));
		}
		
	}
	
}