package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Worker;

/**
 * A munk�s k�p�t megjelen�t� oszt�ly.
 */
public class DrawableWorker extends Drawable
{
	/**
	 * A k�pekhez tartoz� munk�sok.
	 */
	private Worker worker;
	
	/**
	 * A j�t�kosok k�pei.
	 */
	private Image imgPlayer1 = null;
	private Image imgPlayer2 = null;
	
	public DrawableWorker()
	{
		if (imgPlayer1 == null)
		{			
			try 
			{
				imgPlayer1 = ImageIO.read(new File("player_orange.png"));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		if (imgPlayer2 == null)
		{			
			try 
			{
				imgPlayer2 = ImageIO.read(new File("player_green.png"));
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
		int x1 = worker.GetField().GetX() * mezo_meret;
		int y1 = worker.GetField().GetY() * mezo_meret;
		
		if(worker == worker.GetField().GetWarehouse().GetWorkers().get(0))
			g.drawImage(imgPlayer1, x1, y1, mezo_meret, mezo_meret, null);
		else
			g.drawImage(imgPlayer2, x1, y1, mezo_meret, mezo_meret, null);
	}
	
    public Worker Getworker() { return worker; }
	public void Setworker(Worker w) { worker = w; }
	
}
