package GraphicApp;

import GameLogic.Box;

/**
 * A doboz k�p�t megjelen�t� oszt�ly.
 */
public class DrawableBox extends Drawable
{
	/**
	 * A k�phez tartoz� doboz.
	 */
	private Box box;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Box Getbox() { return box; }
	public void Setbox(Box b) { box = b; }
}