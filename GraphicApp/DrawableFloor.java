package GraphicApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Floor;

/**
 * A padló képét megjelenítõ osztály.
 */
public class DrawableFloor extends Drawable
{
	/**
	 * A képhez tartozó padló.
	 */
	private Floor floor;
	
	/**
	 * A padló képe.
	 */
	private Image imgFloor = null;
	
	public DrawableFloor()
	{
		if (imgFloor == null)
		{
			try
			{
				imgFloor = ImageIO.read(new File("floor.jpg"));
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
	public void Draw()
	{
		int mezo_meret = 20;
		int x = floor.GetX() * mezo_meret;
		int y = floor.GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgFloor, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Floor Getfloor() { return floor; }
	public void Setfloor(Floor f) { floor = f; }
}