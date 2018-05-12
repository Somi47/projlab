package GraphicApp;

import GameLogic.Box;

/**
 * A doboz képét megjelenítõ osztály.
 */
public class DrawableBox extends Drawable
{
	/**
	 * A képhez tartozó doboz.
	 */
	private Box box;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Box Getbox() { return box; }
	public void Setbox(Box b) { box = b; }
}