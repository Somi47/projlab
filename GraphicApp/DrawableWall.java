package GraphicApp;

import GameLogic.Wall;

/**
 * A fal képét megjelenítõ osztály.
 */
public class DrawableWall extends Drawable
{
	/**
	 * A képhez tartozó fal.
	 */
	private Wall wall;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Wall Getwall() { return wall; }
	public void Setwall(Wall w) { wall = w; }
}