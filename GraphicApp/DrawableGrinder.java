package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Grinder;

/**
 * A daráló képét megjelenítõ osztály.
 */
public class DrawableGrinder extends Drawable
{
	/**
	 * A képekhez tartozó darálók.
	 */
	private Grinder grinder;
	
	/**
	 * A darálók képei.
	 */
	private Image imgGrinder1 = null;
	private Image imgGrinder2 = null;
	
	public DrawableGrinder()
	{
		if (imgGrinder1 == null)
		{
			try 
			{
				imgGrinder1 = ImageIO.read(new File("grinder_orange.jpg"));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		if (imgGrinder2 == null)
		{
			try 
			{
				imgGrinder2 = ImageIO.read(new File("grinder_green.jpg"));
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
		int x1 = grinder.GetX() * mezo_meret;
		int y1 = grinder.GetY() * mezo_meret;
		
		if(grinder.GetPlayer() == grinder.GetWarehouse().GetWorkers().get(0))
			g.drawImage(imgGrinder1, x1, y1, mezo_meret, mezo_meret, null);
		else
			g.drawImage(imgGrinder2, x1, y1, mezo_meret, mezo_meret, null);
	}
	
	public Grinder Getgrinder() { return grinder; }
	public void Setgrinder(Grinder g) { grinder = g; } 
}