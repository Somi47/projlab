package GraphicApp;

import java.awt.Graphics;
import java.awt.Image;

/**
 * A rajzolható objektumokat megvalósító absztrakt osztály.
 */
public abstract class Drawable 
{	
	/**
	 * A mezok merete pixelben.
	 */
	static int mezo_meret = 35;
	
	/**
	 * Az objektum prioritása.
	 */
	private int priority;
		
	/**
	 * A rajzolást megvalósító függvény.
	 */
	public abstract void Draw(Graphics g);
		
	public int Getpriority(){ return priority; }
	public void Setpriority(int p) { priority = p ;}
	
}
