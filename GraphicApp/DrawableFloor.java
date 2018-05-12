package GraphicApp;

import GameLogic.Floor;

/**
 * A padló képét megjelenítõ osztály.
 */
public class DrawableFloor extends Drawable
{
	/**
	 * A képhez tartozó padló.
	 */
	private Floor floor;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Floor Getfloor() { return floor; }
	public void Setfloor(Floor f) { floor = f; }
}