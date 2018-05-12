package GraphicApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

/**
 * A Drawable-ket t�rol, akiknek van egy k�p�k 
 * �s egy priorit�suk ami megmondja
 *  hogy melyiket melyik mell� rajzoljuk.
 */
public class MainFrame extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	/**
	 * A p�lya alap panelja.
	 */
	private JPanel mapPanel;
	
	/**
	 * A rajzolhat� objektumok.
	 */
	private ArrayList<Drawable> drawables;
	
	/**
	 * Rajzolhat� objektum hozz�ad�sa.
	 * @param d Hozz�adand� rajzolhat� objektum.
	 */
	public void AddDrawable(Drawable d) 
	{
		drawables.add(d);
	}
	
	/**
	 * Minden objektum lerajzol�sa.
	 */
	public void DrawAll()
	{
		for(Drawable d : drawables)
			d.Draw();
	}
	
	/**
	 * J�t�k v�ge, az adott j�t�kos vesztett.
	 */
	public void gameLost() 
	{
		
	}
	
	/**
	 * J�t�k v�ge, az adott j�t�kos nyert.
	 */
	public void gameWon() 
	{ 
		
	}

	/**
	 * Rajzolhat� objektum elt�vol�t�sa.
	 * @param d Elv�vol�tand� rajzolhat� objektum.
	 */
	public void removeDrawable(Drawable d) 
	{
		drawables.remove(d);
	}

	/**
	 * A rajzolhat� objektumok rendez�se.
	 */
	public void sortDrawable() 
	{
		Collections.sort(drawables,new DrawableComparator());
	}
	
	/**
	 * Gomb lenyom�s�t figyel� f�ggv�ny.
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{

	}
	@Override
	public void keyReleased(KeyEvent e) 
	{

	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{

	}
	
	public JPanel GetmapPanel(){ return mapPanel; }
	public void SetmapPanel(JPanel mp) { mapPanel = mp ;}
	
	public ArrayList<Drawable> Getdrawables(){ return drawables; }
	public void Setdrawables(ArrayList<Drawable> d) { drawables = d ;}
}
