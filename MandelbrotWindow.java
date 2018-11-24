import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MandelbrotWindow extends JFrame
{
	private DrawZone drawZone; // Déclaration de la zone de dessin de la fenêtre.

	public MandelbrotWindow(String title, int w, int h)
	{
		super(title); // Ajout du titre de la fenêtre.
		this.initializeMenu();
		this.initialize();
		this.setSize(w, h); // Définition de la taille de la fenêtre
		this.setLocationRelativeTo(null); // Centre la fenêtre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // Afficher la fenêtre.
		this.setResizable(false); // Interdire le redimensionnement de la fenêtre
	}
	
	/**
	 * Méthode plaçant les différents panneaux.
	 */
	private void initialize()
	{		
		Container c = this.getContentPane();
		
		JPanel pNorth = this.createNorthPanel();
		c.add(pNorth, BorderLayout.NORTH);	
		
		JPanel pDrawZone = this.createDrawZone();
		c.add(pDrawZone, BorderLayout.CENTER);
	}
	
	/**
	 * Méthode plaçant la barre de menus.
	 */
	private void initializeMenu()
	{
		// Création de la barre de menu.
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		// Création d'un menu "File"
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		// Création d'une option sauvegarde pour le menu "File"
		JMenuItem save = new JMenuItem("Save to .png");
		fileMenu.add(save);
	}
	
	/**
	 * Méthode créant la zone de dessin de la fenêtre.
	 * 
	 * @return
	 */
	private JPanel createDrawZone()
	{
		JPanel pDrawZone = new JPanel(new BorderLayout());
		
		return pDrawZone;
	}
	
	/**
	 * Méthode créant le panneau nord de la fenêtre.
	 * 
	 * @return
	 */
	private JPanel createNorthPanel()
	{
		// Création du panneau nord.
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		pNorth.setBorder(BorderFactory.createTitledBorder("Complex"));
		
		// Création du panneau pour les champs de texte.
		JPanel pTextFieds = new JPanel(new GridLayout(2, 2, 5, 5));
		pNorth.add(pTextFieds, BorderLayout.CENTER);
		
		// Création des étiquettes associées aux champs de texte.
		JLabel lR = new JLabel("Real part");
		pTextFieds.add(lR);
		
		JLabel lI = new JLabel("Imaginary part");
		pTextFieds.add(lI);
		
		// Création des champs de texte.
		JTextField tR = new JTextField();
		tR.setText("0");
		pTextFieds.add(tR);
			
		JTextField tI = new JTextField();
		tI.setText("0");
		pTextFieds.add(tI);
		
		return pNorth;
	}

	abstract class ActionL implements ActionListener
	{
		
	}
}
