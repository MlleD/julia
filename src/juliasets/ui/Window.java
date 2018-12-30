package juliasets.ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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

import juliasets.core.Complex;


/**
 * Classe mettant en oeuvre l'interface graphique.
 * 
 * @author Adrien Cavalieri
 * @author Dorothée Huynh
 * @version 1.0
 */
public class Window extends JFrame
{
	private DrawZone drawZone; // Déclaration de la zone de dessin de la fenêtre.
	
	private JTextField tReal;
	private JTextField tImaginary;
	private JTextField tMaxIter;
	
	private static final int ZOOM_IN = 0;
	private static final int ZOOM_OUT = 1;
	
	private static final int MOVE_LEFT = 2;
	private static final int MOVE_UP = 3;
	private static final int MOVE_RIGHT = 4;
	private static final int MOVE_DOWN = 5;
	
	private static final int CHANGE_COMPLEX = 6;
	private static final int CHANGE_MAX_ITER = 7;
	
	private static final int SAVE_TO_FILE = 8;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param title Titre de la fenêtre
	 * @param width Largeur de la fenêtre
	 * @param height Hauteur de la fenêtre
	 */
	public Window(String title, int width, int height)
	{
		super(title); // Ajout du titre de la fenêtre.
		this.initializeMenu();
		this.initialize();
		this.setSize(width, height); // Définition de la taille de la fenêtre.
		this.setLocationRelativeTo(null); // Centrer la fenêtre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // Afficher la fenêtre.
		this.setResizable(false); // Interdire le redimensionnement de la fenêtre.
	}
	
	private void initialize()
	{		
		Container c = this.getContentPane();
		
		JPanel pDrawZone = this.createDrawZone();
		c.add(pDrawZone, BorderLayout.CENTER);
		
		JPanel pNorth = this.createNorthPanel();
		c.add(pNorth, BorderLayout.NORTH);	
		
	}
	
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
		save.addActionListener(new ActionListenerJuliaSetsWindow(SAVE_TO_FILE));
	}

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
	
	private JPanel createNorthPanel()
	{
		// Création du panneau nord.
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		
		// Création du panneau pour les champs de texte du nombre complexe.
		JPanel pTextFields = new JPanel(new GridLayout(2, 2, 2, 2));
		pTextFields.setBorder(BorderFactory.createTitledBorder("Complex"));
		pNorth.add(pTextFields, BorderLayout.WEST);
		
		// Création des étiquettes associées aux champs de texte du nombre complexe.
		JLabel lR = new JLabel("Real part");
		pTextFields.add(lR);
		
		JLabel lI = new JLabel("Imaginary part");
		pTextFields.add(lI);
		
		// Création des champs de texte du nombre complexe.
		tReal = new JTextField();
		tReal.setText("" + DrawZone.getDefaultComplex().getReal());
		pTextFields.add(tReal);
			
		tImaginary = new JTextField();
		tImaginary.setText("" + DrawZone.getDefaultComplex().getImaginary());
		pTextFields.add(tImaginary);
		
		// Création du panneau pour les contrôles additionnels.
		JPanel pMisc = new JPanel(new GridLayout(2, 2, 2, 2));
		pMisc.setBorder(BorderFactory.createTitledBorder("Miscellaneous"));
		pNorth.add(pMisc, BorderLayout.EAST);
		
		// Création de l'étiquette associée au nombre maximum d'itérations.
		JLabel lMaxIter = new JLabel("Max iterations");
		pMisc.add(lMaxIter);
		
		// Création du champ de texte du nombre maximum d'itérations.
		tMaxIter = new JTextField("" + drawZone.getMaxIter(), 10);
		pMisc.add(tMaxIter);
		
		// Création du panneau pour les contrôles.
		JPanel pControls = new JPanel(new FlowLayout());
		pControls.setBorder(BorderFactory.createTitledBorder("Controls"));
		pNorth.add(pControls, BorderLayout.CENTER);
		
		// Création des boutons et associations aux écouteurs.
		for(int i = 0; i < 8; i++)
		{
			switch(i)
			{
				case 0: 
					JButton bZoomIn = new JButton("Zoom in");
					pControls.add(bZoomIn);
					bZoomIn.addActionListener(new ActionListenerJuliaSetsWindow(ZOOM_IN));
					break;
				
				case 1:
					JButton bZoomOut = new JButton("Zoom out");
					pControls.add(bZoomOut);
					bZoomOut.addActionListener(new ActionListenerJuliaSetsWindow(ZOOM_OUT));
					break;
			
				case 2:
					JButton bArrowLeft = new JButton("\u2190");
					pControls.add(bArrowLeft);
					bArrowLeft.addActionListener(new ActionListenerJuliaSetsWindow(MOVE_LEFT));
					break;
					
				case 3:
					JButton bArrowUp = new JButton("\u2191");
					pControls.add(bArrowUp);
					bArrowUp.addActionListener(new ActionListenerJuliaSetsWindow(MOVE_UP));
					break;
					
				case 4:
					JButton bArrowRight = new JButton("\u2192");
					pControls.add(bArrowRight);
					bArrowRight.addActionListener(new ActionListenerJuliaSetsWindow(MOVE_RIGHT));
					break;
					
				case 5:
					JButton bArrowDown = new JButton("\u2193");
					pControls.add(bArrowDown);
					bArrowDown.addActionListener(new ActionListenerJuliaSetsWindow(MOVE_DOWN));
					break;
					
				case 6:
					JButton bChangeComplex = new JButton("Change complex");
					pControls.add(bChangeComplex);
					bChangeComplex.addActionListener(new ActionListenerJuliaSetsWindow(CHANGE_COMPLEX));
					break;
					
				case 7:
					JButton bChangeMaxIter = new JButton("Change max iterations");
					pControls.add(bChangeMaxIter);
					bChangeMaxIter.addActionListener(new ActionListenerJuliaSetsWindow(CHANGE_MAX_ITER));
					break;
			}	
		}
		
		return pNorth;
	}
	
	private class ActionListenerJuliaSetsWindow implements ActionListener
	{
		private int value;
		
		public ActionListenerJuliaSetsWindow(int value)
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
							
					try 
					{
						Double.valueOf(sReal);
						Double.valueOf(sImaginary);
				    } 
					
					catch (NumberFormatException ex) 
					{
						JOptionPane.showMessageDialog(Window.this, 
								"Enter a value!", "Invalid value", JOptionPane.ERROR_MESSAGE);
				    }
					
					finally
					{
						real = Double.parseDouble(sReal);
						imaginary = Double.parseDouble(sImaginary);
						tReal.setText("" + real);
						tImaginary.setText("" + imaginary);
						drawZone.setC(new Complex(real, imaginary));
					}

					break;
					
				case CHANGE_MAX_ITER:
					int maxIter;
					String sMaxIter;
					
					sMaxIter = tMaxIter.getText();
							
					try 
					{
						Integer.valueOf(sMaxIter);
				    } 
					
					catch (NumberFormatException ex) 
					{
						JOptionPane.showMessageDialog(Window.this, 
								"Enter a value!", "Invalid value", JOptionPane.ERROR_MESSAGE);
				    }
					
					finally
					{
						maxIter = Integer.parseInt(sMaxIter);
						tMaxIter.setText("" + maxIter);
						drawZone.setMaxIter(maxIter);
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
