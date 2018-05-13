package GraphicApp;

import java.awt.Image;

/**
 * A rajzolható objektumokat megvalósító absztrakt osztály.
 */
public abstract class Drawable 
{
	/**
	 * A megjelenítendõ kép.
	 */
	private Image img;
	
	/**
	 * Az objektum prioritása.
	 */
	private int priority;
	
	/**
	 * A rajzolást megvalósító függvény.
	 */
	public void Draw()
	{
		
	}
	
	Image Getimg(){ return img; }
	void Setimg(Image i) { img = i ;}
	
	public int Getpriority(){ return priority; }
	public void Setpriority(int p) { priority = p ;}
	
}
