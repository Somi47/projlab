package GraphicApp;

import GameLogic.Grinder;

/**
 * A daráló képét megjelenítõ osztály.
 */
public class DrawableGrinder extends Drawable
{
	/**
	 * A képhez tartozó daráló.
	 */
	private Grinder grinder;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Grinder Getgrinder() { return grinder; }
	public void Setgrinder(Grinder g) { grinder = g; }
}