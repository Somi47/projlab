package GraphicApp;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import GameLogic.Direction;
import GameLogic.Warehouse;

/**
 * A Drawable-ket tárol, akiknek van egy képük 
 * és egy prioritásuk ami megmondja
 *  hogy melyiket melyik mellé rajzoljuk.
 */
public class MainFrame extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	/**
	 * A pálya alap panelja.
	 */
	private JPanel mapPanel;
	
	/**
	 * A rajzolható objektumok.
	 */
	private ArrayList<Drawable> drawables;
	
	/**
	 * A Warehouse.
	 */
	private Warehouse wh;	
	
	/**
	 * A MainFrame konstruktora.
	 * @param wh A warehouse.
	 */
	public MainFrame(Warehouse wh)
	{
		this.wh = wh;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("csatornapatkanyok");
	
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		setLayout(new BorderLayout());
		setSize(800, 600);
		setResizable(false);
		
		mapPanel = new JPanel();
		add(mapPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Rajzolható objektum hozzáadása.
	 * @param d Hozzáadandó rajzolható objektum.
	 */
	public void AddDrawable(Drawable d) 
	{
		drawables.add(d);
	}
	
	/**
	 * Minden objektum lerajzolása.
	 */
	public void DrawAll()
	{
		for(Drawable d : drawables)
			d.Draw();
	}
	
	/**
	 * Játék vége, az adott játékos vesztett.
	 */
	public void gameLost() 
	{
		
	}
	
	/**
	 * Játék vége, az adott játékos nyert.
	 */
	public void gameWon() 
	{ 
		
	}

	/**
	 * Rajzolható objektum eltávolítása.
	 * @param d Elvávolítandó rajzolható objektum.
	 */
	public void removeDrawable(Drawable d) 
	{
		drawables.remove(d);
	}

	/**
	 * A rajzolható objektumok rendezése.
	 */
	public void sortDrawable() 
	{
		Collections.sort(drawables,new DrawableComparator());
	}
	
	/**
	 * Gomb lenyomását figyelõ függvény.
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keycode = e.getKeyCode();
		
		switch(keycode)
		{
			case KeyEvent.VK_W: wh.GetWorkers().get(0).Move(Direction.Up, wh.GetWorkers().get(0).getForce()); break;
			case KeyEvent.VK_S: wh.GetWorkers().get(0).Move(Direction.Down, wh.GetWorkers().get(0).getForce()); break;
		}
	
		if(wh.GetWorkerNumber() == 2)
		{
			switch(keycode)
			{
				case KeyEvent.VK_UP: wh.GetWorkers().get(1).Move(Direction.Up, wh.GetWorkers().get(0).getForce()); break;
				case KeyEvent.VK_DOWN: wh.GetWorkers().get(1).Move(Direction.Down, wh.GetWorkers().get(0).getForce()); break;
			}
		}
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
