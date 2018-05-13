package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Switch;

/**
 * A kapcsol� k�p�t megjelen�t� oszt�ly.
 */
public class DrawableSwitch extends Drawable
{
	/**
	 * A k�phez tartoz� kapcsol�.
	 */
	private Switch Switch;
	
	/**
	 * A kapcsol� k�pe.
	 */
	private Image imgSwitch = null;
	
	public DrawableSwitch()
	{
		if (imgSwitch == null)
		{			
			try 
			{
				imgSwitch = ImageIO.read(new File("switch.jpg"));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw(Graphics g)
	{
		int x = Switch.GetX() * mezo_meret;
		int y = Switch.GetY() * mezo_meret;
		
		g.drawImage(imgSwitch, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Switch Getswitch() { return Switch; }
	public void Setswitch(Switch s) { Switch = s; }
}