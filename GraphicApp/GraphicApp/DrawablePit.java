package GraphicApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Pit;

/**
 * A lyuk k�p�t megjelen�t� oszt�ly.
 */
public class DrawablePit extends Drawable
{
	/**
	 * A k�phez tartoz� lyuk.
	 */
	private Pit pit;
	
	/**
	 * A lyuk k�pe.
	 */
	private Image imgPit = null;
	
	public DrawablePit()
	{
		if (imgPit == null)
		{			
			try 
			{
				if (pit.isOpen()) imgPit = ImageIO.read(new File("pit.jpg"));
					else imgPit = ImageIO.read(new File("pit_closed.jpg"));
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
		int x = pit.GetX() * mezo_meret;
		int y = pit.GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgPit, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Pit Getpit() { return pit; }
	public void Setpit(Pit p) { pit = p; }
}