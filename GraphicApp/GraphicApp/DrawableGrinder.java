package GraphicApp;

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
	private Grinder grinder1;
	private Grinder grinder2;
	
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
	public void Draw()
	{
		int mezo_meret = 20;
		int x1 = grinder1.GetX() * mezo_meret;
		int y1 = grinder1.GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgGrinder1, x1, y1, mezo_meret, mezo_meret, null);
		
		int x2 = grinder2.GetX() * mezo_meret;
		int y2 = grinder2.GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgGrinder2, x2, y2, mezo_meret, mezo_meret, null);
	}
	
	public Grinder Getgrinder() { return grinder1; }
	public void Setgrinder(Grinder g) { grinder1 = g; } 
}