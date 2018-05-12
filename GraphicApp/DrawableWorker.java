package GraphicApp;

import GameLogic.Worker;

/**
 * A munkás képét megjelenítõ osztály.
 */
public class DrawableWorker extends Drawable
{
	/**
	 * A képhez tartozó munkás.
	 */
	private Worker worker;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Worker Getworker() { return worker; }
	public void Setworker(Worker w) { worker = w; }
}
