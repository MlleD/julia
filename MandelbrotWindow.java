import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class MandelbrotWindow extends JFrame
{
	private JTextField tX;
	private JTextField tY;
	private DrawZone drawZone;

	public MandelbrotWindow(String title, int w, int h)
	{
		super(title);
		this.initializeMenu();
		this.initialize();
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	private void initialize()
	{		
		Container c = this.getContentPane();
		
		JPanel pNorth = this.createNorthPanel();
		c.add(pNorth, BorderLayout.NORTH);	
		
		JPanel pDrawZone = this.createDrawZone();
		c.add(pDrawZone, BorderLayout.CENTER);
		
	}
	
	private void initializeMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menuFichier = new JMenu("File");
		menuBar.add(menuFichier);
	}
	
	
	private JPanel createDrawZone()
	{
		JPanel pDrawZone = new JPanel(new BorderLayout());
		
		return pDrawZone;
	}
	
	private JPanel createNorthPanel()
	{
		JPanel pNorth = new JPanel();
		
		return pNorth;
	}

	abstract class ActionL implements ActionListener
	{
		
	}
}
