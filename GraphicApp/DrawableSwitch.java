package GraphicApp;

import GameLogic.Switch;

/**
 * A kapcsoló képét megjelenítõ osztály.
 */
public class DrawableSwitch extends Drawable
{
	/**
	 * A képhez tartozó kapcsoló.
	 */
	private Switch Switch;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Switch Getswitch() { return Switch; }
	public void Setswitch(Switch s) { Switch = s; }
}