import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private DrawZone drawZone;

	public MandelbrotWindow(String title, int w, int h)
	{
		super(title);
		this.initializeMenu();
		this.initialize();
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
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
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem save = new JMenuItem("Save to .png");
		fileMenu.add(save);
	}
	
	
	private JPanel createDrawZone()
	{
		JPanel pDrawZone = new JPanel(new BorderLayout());
		
		return pDrawZone;
	}
	
	private JPanel createNorthPanel()
	{
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		pNorth.setBorder(BorderFactory.createTitledBorder("Complex"));
		
		JPanel pTextFieds = new JPanel(new GridLayout(2, 2, 5, 5));
		pNorth.add(pTextFieds, BorderLayout.CENTER);
		
		JLabel lR = new JLabel("Real part");
		pTextFieds.add(lR);
		
		JLabel lI = new JLabel("Imaginary part");
		pTextFieds.add(lI);
		
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
