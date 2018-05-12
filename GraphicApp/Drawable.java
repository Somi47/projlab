package GraphicApp;

import java.awt.Image;

/**
 * A rajzolhat� objektumokat megval�s�t� absztrakt oszt�ly.
 */
public abstract class Drawable 
{
	/**
	 * A megjelen�tend� k�p.
	 */
	private Image img;
	
	/**
	 * Az objektum priorit�sa.
	 */
	private int priority;
	
	/**
	 * A rajzol�st megval�s�t� f�ggv�ny.
	 */
	public void Draw()
	{
		
	}
	
	Image Getimg(){ return img; }
	void Setimg(Image i) { img = i ;}
	
	public int Getpriority(){ return priority; }
	public void Setpriority(int p) { priority = p ;}
	
}
