package GraphicApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GameLogic.Warehouse;
import GameLogic.Worker;

/**
 * A j�t�k f� men�j�t val�s�tja meg
 * amivel elind�thatjuk a j�t�kot 
 * egy vagy k�tj�t�kos m�dban.
 */
public class Menu extends JFrame
{
	private static final long serialVersionUID = 1L;

	/**
	 * A men� h�tter�t val�s�tja meg
	 *  ezen helyezkednek el a gombok.
	 */
	private JPanel  menuPanel;
	
	/**
	 * Egyj�t�kos m�d kiv�laszt�sa.
	 */
	private JButton player1Button;
	
	/**
	 * K�tj�t�kos m�d kiv�laszt�sa.
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
	 * Kil�p�s a j�t�kb�l.
	 */
	public void Exit()
	{
		
	}
	
	/**
	 * �j j�t�k ind�t�sa.
	 */
	public void NewGame()
	{
		
	}
	
	/**
	 * J�t�kos(ok) be�ll�t�sa.
	 * @param w Be�ll�tand� j�t�kos.
	 */
	public void SetWorker(Worker w)
	{
		
	}

	
	/**
	 * A Menu oszt�lyhoz tartoz� bels� oszt�ly (inner class)
	 *  player1Button gomb esem�nyfigyel� oszt�lya.
	 */
	public class player1ButtonActionListener implements ActionListener
	{
		/**
		 * Esem�nykezel� f�ggv�ny.
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
	 * A Menu oszt�lyhoz tartoz� bels� oszt�ly (inner class)
	 *  player2Button gomb esem�nyfigyel� oszt�lya.
	 */
	public class player2ButtonActionListener implements ActionListener
	{
		/**
		 * Esem�nykezel� f�ggv�ny.
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
