package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;

/**
 * A rajzolhat� objektumokat megval�s�t� absztrakt oszt�ly.
 */
public abstract class Drawable 
{	
	/**
	 * A mezok merete pixelben.
	 */
	static int mezo_meret = 35;
	
	/**
	 * Az objektum priorit�sa.
	 */
	private int priority;
		
	/**
	 * A rajzol�st megval�s�t� f�ggv�ny.
	 */
	public abstract void Draw(Graphics g);
		
	public int Getpriority(){ return priority; }
	public void Setpriority(int p) { priority = p ;}
	
}
