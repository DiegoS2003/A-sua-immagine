
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Finestra extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel dmt;
	private JScrollPane pane;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem inserisci, salva, carica, inserisciImmagine;
	private JPanel panelIm, panelTab;
	private Array array;
	private JLabel label;
	private ImageIcon icon;
	
	public void initComp() {
		this.setLayout(new GridLayout(2,2));
		Object[][] data = {};
		String[] nomeColonne={"Nome", "Cognome", "Classe"};
		dmt = new DefaultTableModel(data, nomeColonne);
		table = new JTable(dmt);
		pane = new JScrollPane(table);
		
		bar = new JMenuBar();
		menu = new JMenu("File");
		inserisci = new JMenuItem("Inserisci");
		salva = new JMenuItem("Salva");
		carica = new JMenuItem("Carica");
		inserisciImmagine = new JMenuItem("Inserisci immagine");
		
		inserisci.addActionListener(this);
		salva.addActionListener(this);
		carica.addActionListener(this);
		inserisciImmagine.addActionListener(this);
		
		menu.add(carica);
		menu.add(salva);
		menu.add(inserisci);
		menu.add(inserisciImmagine);
		bar.add(menu);
		
		panelIm=new JPanel();
		panelTab=new JPanel();
		
		panelTab.add(pane);
		
		
		this.add(bar);
		this.add(panelTab);
		
		
		
	}
	public void insImmagine(JFrame finestra, ImageIcon im) {
		JFileChooser fileChooser = new JFileChooser(); 
		int n = fileChooser.showOpenDialog(finestra);
		if (n == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			im = new ImageIcon (f.getPath());
		}
	}
	
	public Finestra() {
		initComp();
		
		array = new Array();
	}

	public static void main(String[] args) {
		Finestra f = new Finestra();
		f.setTitle("Esercizio di recupero");
		f.setSize(800,600);
		f.setVisible(true);
	}
	
	private void updateTab() throws FileNotFoundException, IOException {
		array.leggiFile(this);
		dmt.setRowCount(0);
		for (int i = 0; i < array.size(); i++) {
			Object[] row = { array.get(i).getNome(), array.get(i).getCognome(), array.get(i).getClasse() };
			dmt.addRow(row);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(inserisci)) {
			InsertDialog id =null;
			id = new InsertDialog(this, true, array);
			id.setTitle("Elenco canzoni");
			id.setSize(800, 600);
			id.setVisible(true);
		}
		if(e.getSource().equals(carica)) {
			try {
				this.updateTab();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(salva)) {
			try {
				array.creaFile(this);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(inserisciImmagine)) {
			insImmagine(this, icon);
			label=new JLabel(icon);
			panelIm.add(label);
			this.add(panelIm);
		}
	}
	
}