package GraphicApp;

import java.awt.Graphics;
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
	private Image imgPitOpen = null;
	private Image imgPitClosed = null;
	
	public DrawablePit()
	{
		if (imgPitOpen == null)
		{			
			try 
			{
				imgPitOpen = ImageIO.read(new File("pit.jpg"));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		if (imgPitClosed == null)
		{			
			try 
			{
				imgPitClosed = ImageIO.read(new File("pit_closed.jpg"));
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
		int x = pit.GetX() * mezo_meret;
		int y = pit.GetY() * mezo_meret;
		
		if(pit.isOpen())
			g.drawImage(imgPitOpen, x, y, mezo_meret, mezo_meret, null);
		else
			g.drawImage(imgPitClosed, x, y, mezo_meret, mezo_meret, null);
	}
	
	public Pit Getpit() { return pit; }
	public void Setpit(Pit p) { pit = p; }
}