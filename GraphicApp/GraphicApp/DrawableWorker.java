package GraphicApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Worker;

/**
 * A munkás képét megjelenítõ osztály.
 */
public class DrawableWorker extends Drawable
{
	/**
	 * A képekhez tartozó munkások.
	 */
	private Worker worker1;
	private Worker worker2;
	
	/**
	 * A játékosok képei.
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
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{
		int mezo_meret = 20;
		int x1 = worker1.GetField().GetX() * mezo_meret;
		int y1 = worker1.GetField().GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgPlayer1, x1, y1, mezo_meret, mezo_meret, null);
		
		int x2 = worker2.GetField().GetX() * mezo_meret;
		int y2 = worker2.GetField().GetY() * mezo_meret;
		
		Getimg().getGraphics().drawImage(imgPlayer2, x2, y2, mezo_meret, mezo_meret, null);
	}
	
    public Worker Getworker() { return worker1; }
	public void Setworker(Worker w) { worker1 = w; }
	
}
