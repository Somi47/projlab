package GraphicApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GameLogic.Warehouse;
import GameLogic.Worker;

/**
 * A játék fõ menüjét valósítja meg
 * amivel elindíthatjuk a játékot 
 * egy vagy kétjátékos módban.
 */
public class Menu extends JFrame
{
	private static final long serialVersionUID = 1L;

	/**
	 * A menü hátterét valósítja meg
	 *  ezen helyezkednek el a gombok.
	 */
	private JPanel  menuPanel;
	
	/**
	 * Egyjátékos mód kiválasztása.
	 */
	private JButton player1Button;
	
	/**
	 * Kétjátékos mód kiválasztása.
	 */
	private JButton player2Button;
	
	/**
	 * A Menu konstruktora.
	 */
	public Menu()
	{		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("csatornapatkanyok");
	
		setFocusTraversalKeysEnabled(false);
		setLayout(new BorderLayout());
		setSize(800, 600);
		setResizable(false);
		
		menuPanel = new JPanel();
		add(menuPanel, BorderLayout.CENTER);
	}	
	
	/**
	 * Kilépés a játékból.
	 */
	public void Exit()
	{
		
	}
	
	/**
	 * Új játék indítása.
	 */
	public void NewGame()
	{
		
	}
	
	/**
	 * Játékos(ok) beállítása.
	 * @param w Beállítandó játékos.
	 */
	public void SetWorker(Worker w)
	{
		
	}

	
	/**
	 * A Menu osztályhoz tartozó belsõ osztály (inner class)
	 *  player1Button gomb eseményfigyelõ osztálya.
	 */
	public class player1ButtonActionListener implements ActionListener
	{
		/**
		 * Eseménykezelõ függvény.
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Warehouse wh = new Warehouse(20, 20, 1);  
			MainFrame frame = new MainFrame(wh);
			frame.setVisible( true );
		}

	}
	
	
	/**
	 * A Menu osztályhoz tartozó belsõ osztály (inner class)
	 *  player2Button gomb eseményfigyelõ osztálya.
	 */
	public class player2ButtonActionListener implements ActionListener
	{
		/**
		 * Eseménykezelõ függvény.
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Warehouse wh = new Warehouse(20, 20, 2);
			MainFrame frame = new MainFrame(wh);
			frame.setVisible( true );
		}

	}
	
	public JPanel GetmenuPanel(){ return menuPanel; }
	public void SetmenuPanel(JPanel mp) { menuPanel = mp ;}
	
	public JButton Getplayer1Button(){ return player1Button; }
	public void Setplayer1Button(JButton pb) { player1Button = pb ;}
	
	public JButton Getplayer2Button(){ return player2Button; }
	public void Setplayer2Button(JButton pb) { player2Button = pb ;}
	
}
