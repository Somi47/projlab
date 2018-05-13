package GraphicApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Wall;

/**
 * A fal k�p�t megjelen�t� oszt�ly.
 */
public class DrawableWall extends Drawable
{
	/**
	 * A k�phez tartoz� fal.
	 */
	private Wall wall;
	
	/**
	 * A fal k�pe.
	 */
	private Image imgWall = null;
	
	public DrawableWall()
	{
		if (imgWall == null)
		{			
			try 
			{
				imgWall = ImageIO.read(new File("wall.jpg"));
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
	public void Draw()
	{
		int mezo_meret = 20;
		int x = wall.GetField().GetX() * mezo_meret;
		int y = wall.GetField().GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgWall, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Wall Getwall() { return wall; }
	public void Setwall(Wall w) { wall = w; }
}