package GraphicApp;

import java.util.Comparator;

/**
 * Seg�doszt�ly a rajzolhat� objektumok 
 * priorit�s�nak �sszehasonl�t�s�hoz.
 */
public class DrawableComparator implements Comparator<Drawable>
{
	/**
	 * �sszehasonl�t�st v�gz�f�ggv�ny.
	 * @param d1 �sszehasonl�tand� rajzolhat� objektum.
	 * @param d2 �sszehasonl�tand� rajzolhat� objektum.
	 * @return �sszehasonl�t�s eredm�nye.
	 */
	@Override
	public int compare(Drawable d1, Drawable d2) 
	{
		return Integer.compare(d1.Getpriority(),d2.Getpriority());
	}

}
