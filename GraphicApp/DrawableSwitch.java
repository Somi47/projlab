package GraphicApp;

import GameLogic.Switch;

/**
 * A kapcsol� k�p�t megjelen�t� oszt�ly.
 */
public class DrawableSwitch extends Drawable
{
	/**
	 * A k�phez tartoz� kapcsol�.
	 */
	private Switch Switch;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Switch Getswitch() { return Switch; }
	public void Setswitch(Switch s) { Switch = s; }
}