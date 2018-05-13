package GraphicApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Box;

/**
 * A doboz képét megjelenítõ osztály.
 */
public class DrawableBox extends Drawable
{
	/**
	 * A képhez tartozó doboz.
	 */
	private Box box;
	
	/**
	 * A doboz képe.
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
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{
		int mezo_meret = 20;
		int x = box.GetField().GetX() * mezo_meret;
		int y = box.GetField().GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgBox, x, y, mezo_meret, mezo_meret, null);

	}
	
	public Box Getbox() { return box; }
	public void Setbox(Box b) { box = b; }
}