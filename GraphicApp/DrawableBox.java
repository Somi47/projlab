package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Box;

/**
 * A doboz k�p�t megjelen�t� oszt�ly.
 */
public class DrawableBox extends Drawable
{
	/**
	 * A k�phez tartoz� doboz.
	 */
	private Box box;
	
	/**
	 * A doboz k�pe.
	 */
	private Image imgBox = null;
	
	public DrawableBox() 
	{
		if (imgBox == null)
		{
			try 
			{
				imgBox = ImageIO.read(new File("box.jpg"));
			}
			catch(IOException e)
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
		int x = box.GetField().GetX() * mezo_meret;
		int y = box.GetField().GetY() * mezo_meret;
		
		g.drawImage(imgBox, x, y, mezo_meret, mezo_meret, null);

	}
	
	public Box Getbox() { return box; }
	public void Setbox(Box b) { box = b; }
}