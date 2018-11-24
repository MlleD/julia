import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawZone extends JPanel
{
	private int x;
	private int y;
	
	public DrawZone(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}

