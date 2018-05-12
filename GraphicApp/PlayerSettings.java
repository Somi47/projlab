package GraphicApp;

import javax.swing.*;

import GameLogic.Worker;

/**
 * A Beállítások menüt valósítja meg.
 * Megadhatjuk a játékos(ok) nevét, erejét.
 */
public class PlayerSettings 
{
	/**
	 * Az alapértelmezett szín kijelzésére szolgáló címke.
	 */	
	private JLabel colour;
	
	/**
	 * Az tolóerõ megadására szolgáló szövegdoboz.
	 */	
	private JTextField force;
	
	/**
	 * A név megadására szolgáló szövegdoboz.
	 */	
	private JTextField name;
	
	/**
	 * A beállítások alap panelje.
	 */	
	private  JPanel settingsPanel;
	
	/**
	 * A játékos beállítása.
	 * @param w Beállítandó játékos.
	 */
	public void SetWorker(Worker w)
	{
		
	}
	
	public JLabel Getcolour(){ return colour; }
	public void Setcolour(JLabel cl) { colour = cl ;}
	
	public JTextField Getforce(){ return force; }
	public void Setforce(JTextField f) { force = f ;}
	
	public JTextField Getname(){ return name; }
	public void Setname(JTextField n) { name = n ;}
	
	public JPanel GetsettingsPanel(){ return settingsPanel; }
	public void SetsettingsPanel(JPanel sp) { settingsPanel = sp ;}
}