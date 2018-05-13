package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Wall;

/**
 * A fal képét megjelenítõ osztály.
 */
public class DrawableWall extends Drawable
{
	/**
	 * A képhez tartozó fal.
	 */
	private Wall wall;
	
	/**
	 * A fal képe.
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
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw(Graphics g)
	{
		int x = wall.GetField().GetX() * mezo_meret;
		int y = wall.GetField().GetY() * mezo_meret;
		
		g.drawImage(imgWall, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Wall Getwall() { return wall; }
	public void Setwall(Wall w) { wall = w; }
}