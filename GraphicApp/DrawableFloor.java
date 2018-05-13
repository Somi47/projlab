package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Floor;

/**
 * A padl� k�p�t megjelen�t� oszt�ly.
 */
public class DrawableFloor extends Drawable
{
	/**
	 * A k�phez tartoz� padl�.
	 */
	private Floor floor;
	
	/**
	 * A padl� k�pe.
	 */
	private Image imgFloor = null;
	
	public DrawableFloor()
	{
		if (imgFloor == null)
		{
			try
			{
				imgFloor = ImageIO.read(new File("field.jpg"));
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
		int x = floor.GetX() * mezo_meret;
		int y = floor.GetY() * mezo_meret;
		
		g.drawImage(imgFloor, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Floor Getfloor() { return floor; }
	public void Setfloor(Floor f) { floor = f; }
}