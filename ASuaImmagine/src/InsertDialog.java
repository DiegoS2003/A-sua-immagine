import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InsertDialog extends JDialog implements ActionListener{
	private JLabel nome, cognome, classe;
	private JTextField insNome, insCognome, insClasse;
	private JButton inserisci;
	private Array ar;
	public void initComponents() {
		this.setLayout(new GridLayout(4,2));
		nome=new JLabel ("Nome");
		cognome=new JLabel ("Cogome");
		classe=new JLabel ("Classe");
		
		insNome=new JTextField(15);
		insCognome=new JTextField(15);
		insClasse=new JTextField(15);
		
		inserisci=new JButton("Inserisci");
		
		this.add(nome);
		this.add(cognome);
		this.add(classe);
		this.add(insNome);
		this.add(insCognome);
		this.add(insClasse);
		this.add(inserisci);
		inserisci.addActionListener(this);
		
	}
	
	public InsertDialog(JFrame f, boolean modal, Array ar) {
		super(f,modal);
		this.ar=ar;
		initComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
