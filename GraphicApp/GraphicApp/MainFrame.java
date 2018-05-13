package GraphicApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import GameLogic.Direction;
import GameLogic.Warehouse;

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
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
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
		setLocationRelativeTo(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setBounds(100, 100, (int) width-200, (int) height-200);
		
		mapPanel = new JPanel();
		add(mapPanel, BorderLayout.CENTER);
	}
	
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
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_ESCAPE)
		{
			exit_dialog ex_dia = new exit_dialog();
			ex_dia.setLocationRelativeTo(null);
			ex_dia.setVisible(true);
			
		}
		
		switch(keycode)
		{
			case KeyEvent.VK_W: wh.GetWorkers().get(0).Move(Direction.Up, wh.GetWorkers().get(0).getForce()); break;
			case KeyEvent.VK_S: wh.GetWorkers().get(0).Move(Direction.Down, wh.GetWorkers().get(0).getForce()); break;
			case KeyEvent.VK_A: wh.GetWorkers().get(0).Move(Direction.Left, wh.GetWorkers().get(0).getForce()); break;
			case KeyEvent.VK_D: wh.GetWorkers().get(0).Move(Direction.Right, wh.GetWorkers().get(0).getForce()); break;
			case KeyEvent.VK_Q: wh.GetWorkers().get(0).dropHoney(); break;
			case KeyEvent.VK_E: wh.GetWorkers().get(0).dropOil(); break;
			
		}
	
		if(wh.GetWorkerNumber() == 2)
		{
			switch(keycode)
			{
				case KeyEvent.VK_UP: wh.GetWorkers().get(1).Move(Direction.Up, wh.GetWorkers().get(0).getForce()); break;
				case KeyEvent.VK_DOWN: wh.GetWorkers().get(1).Move(Direction.Down, wh.GetWorkers().get(0).getForce()); break;
				case KeyEvent.VK_LEFT: wh.GetWorkers().get(0).Move(Direction.Left, wh.GetWorkers().get(0).getForce()); break;
				case KeyEvent.VK_RIGHT: wh.GetWorkers().get(0).Move(Direction.Right, wh.GetWorkers().get(0).getForce()); break;
				case KeyEvent.VK_SHIFT: wh.GetWorkers().get(0).dropHoney(); break;
				case KeyEvent.VK_CONTROL: wh.GetWorkers().get(0).dropOil(); break;

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
