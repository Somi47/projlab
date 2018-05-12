package GraphicApp;

import java.util.Comparator;

/**
 * Segédosztály a rajzolható objektumok 
 * prioritásának összehasonlításához.
 */
public class DrawableComparator implements Comparator<Drawable>
{
	/**
	 * Összehasonlítást végzõfüggvény.
	 * @param d1 Összehasonlítandó rajzolható objektum.
	 * @param d2 Összehasonlítandó rajzolható objektum.
	 * @return Összehasonlítás eredménye.
	 */
	@Override
	public int compare(Drawable d1, Drawable d2) 
	{
		return Integer.compare(d1.Getpriority(),d2.Getpriority());
	}

}
