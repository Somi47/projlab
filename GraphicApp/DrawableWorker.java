package GraphicApp;

import GameLogic.Worker;

/**
 * A munk�s k�p�t megjelen�t� oszt�ly.
 */
public class DrawableWorker extends Drawable
{
	/**
	 * A k�phez tartoz� munk�s.
	 */
	private Worker worker;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Worker Getworker() { return worker; }
	public void Setworker(Worker w) { worker = w; }
}
