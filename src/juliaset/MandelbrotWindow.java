package juliaset;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MandelbrotWindow extends JFrame
{
	private DrawZone drawZone; // Déclaration de la zone de dessin de la fenêtre.
	
	private JTextField tReal;
	private JTextField tImaginary;
	
	private static final int ZOOM_IN = 0;
	private static final int ZOOM_OUT = 1;
	
	private static final int MOVE_LEFT = 2;
	private static final int MOVE_UP = 3;
	private static final int MOVE_RIGHT = 4;
	private static final int MOVE_DOWN = 5;
	
	private static final int CHANGE_COMPLEX = 6;
	
	private static final int SAVE_TO_FILE = 7;

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
		JMenuItem save = new JMenuItem("Save as png");
		fileMenu.add(save);
		save.addActionListener(new ActionL(SAVE_TO_FILE));
	}
	
	/**
	 * Méthode créant la zone de dessin de la fenêtre.
	 * 
	 * @return
	 */
	private JPanel createDrawZone()
	{
		// Création du panneau de la zone de dessin.
		JPanel pDrawZone = new JPanel(new BorderLayout());
		pDrawZone.setBorder(BorderFactory.createTitledBorder("Draw Zone"));

		// Création de la zone de dessin.
		drawZone = new DrawZone();
		pDrawZone.add(this.drawZone, BorderLayout.CENTER);
		
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
		
		// Création du panneau pour les champs de texte.
		JPanel pTextFields = new JPanel(new GridLayout(2, 2, 2, 2));
		pTextFields.setBorder(BorderFactory.createTitledBorder("Complex"));
		pNorth.add(pTextFields, BorderLayout.WEST);
		
		// Création des étiquettes associées aux champs de texte.
		JLabel lR = new JLabel("Real part");
		pTextFields.add(lR);
		
		JLabel lI = new JLabel("Imaginary part");
		pTextFields.add(lI);
		
		// Création des champs de texte.
		tReal = new JTextField();
		tReal.setText("0");
		pTextFields.add(tReal);
			
		tImaginary = new JTextField();
		tImaginary.setText("0");
		pTextFields.add(tImaginary);
		
		// Création du panneau pour les contrôles.
		JPanel pControls = new JPanel(new FlowLayout());
		pControls.setBorder(BorderFactory.createTitledBorder("Controls"));
		pNorth.add(pControls, BorderLayout.CENTER);
		
		// Création des boutons
		for(int i = 0; i < 7; i++)
		{
			switch(i)
			{
				case 0: 
					JButton bZoomIn = new JButton("Zoom in");
					pControls.add(bZoomIn);
					bZoomIn.addActionListener(new ActionL(ZOOM_IN));
					break;
				
				case 1:
					JButton bZoomOut = new JButton("Zoom out");
					pControls.add(bZoomOut);
					bZoomOut.addActionListener(new ActionL(ZOOM_OUT));
					break;
			
				case 2:
					JButton bArrowLeft = new JButton("←");
					pControls.add(bArrowLeft);
					bArrowLeft.addActionListener(new ActionL(MOVE_LEFT));
					break;
					
				case 3:
					JButton bArrowUp = new JButton("↑");
					pControls.add(bArrowUp);
					bArrowUp.addActionListener(new ActionL(MOVE_UP));
					break;
					
				case 4:
					JButton bArrowRight = new JButton("→");
					pControls.add(bArrowRight);
					bArrowRight.addActionListener(new ActionL(MOVE_RIGHT));
					break;
					
				case 5:
					JButton bArrowDown = new JButton("↓");
					pControls.add(bArrowDown);
					bArrowDown.addActionListener(new ActionL(MOVE_DOWN));
					break;
					
				case 6:
					JButton bChangeComplex = new JButton("Change complex");
					pControls.add(bChangeComplex);
					bChangeComplex.addActionListener(new ActionL(CHANGE_COMPLEX));
					break;
			}	
		}
		
		return pNorth;
	}
	
	class ActionL implements ActionListener
	{
		private int value;
		
		public ActionL(int value)
		{
			this.value = value;
		}	
		
		public void actionPerformed(ActionEvent e)
		{
			switch(value)
			{
				case ZOOM_IN:
					drawZone.setZoom(drawZone.getZoom() + 1);
					break;
				
				case ZOOM_OUT:
					drawZone.setZoom(drawZone.getZoom() - 1);
					break;
					
				case MOVE_LEFT:
					drawZone.setMoveX(drawZone.getMoveX() - 0.125);
					break;
					
				case MOVE_RIGHT:
					drawZone.setMoveX(drawZone.getMoveX() + 0.125);
					break;
					
				case MOVE_UP:
					drawZone.setMoveY(drawZone.getMoveY() - 0.125);
					break;
					
				case MOVE_DOWN:
					drawZone.setMoveY(drawZone.getMoveY() + 0.125);
					break;
					
				case CHANGE_COMPLEX:
					double real;
					String sReal;
					
					double imaginary;
					String sImaginary;
					
					sReal = tReal.getText();
					sImaginary = tImaginary.getText();
					
					if(sReal.equals("") || sImaginary.equals(""))
						JOptionPane.showMessageDialog(MandelbrotWindow.this, 
								"Enter a value!", "Invalid value", JOptionPane.ERROR_MESSAGE);

					else
					{
						real = Double.parseDouble(sReal);
						imaginary = Double.parseDouble(sImaginary);
						tReal.setText("" + real);
						tImaginary.setText("" + imaginary);
						drawZone.setC(new Complex(real, imaginary));
					}
					break;
					
				case SAVE_TO_FILE:
					try 
					{
						drawZone.saveToFile();
					} 
					
					catch (IOException ex) 
					{
						ex.printStackTrace();
					}
					break;
			}
			
			drawZone.repaint();
		}
	}
}
