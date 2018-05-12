package GraphicApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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

		}

	}
	
	public JPanel GetmenuPanel(){ return menuPanel; }
	public void SetmenuPanel(JPanel mp) { menuPanel = mp ;}
	
	public JButton Getplayer1Button(){ return player1Button; }
	public void Setplayer1Button(JButton pb) { player1Button = pb ;}
	
	public JButton Getplayer2Button(){ return player2Button; }
	public void Setplayer2Button(JButton pb) { player2Button = pb ;}
	
}
