package GraphicApp;

import javax.swing.*;

import GameLogic.Worker;

/**
 * A Be�ll�t�sok men�t val�s�tja meg.
 * Megadhatjuk a j�t�kos(ok) nev�t, erej�t.
 */
public class PlayerSettings 
{
	/**
	 * Az alap�rtelmezett sz�n kijelz�s�re szolg�l� c�mke.
	 */	
	private JLabel colour;
	
	/**
	 * Az tol�er� megad�s�ra szolg�l� sz�vegdoboz.
	 */	
	private JTextField force;
	
	/**
	 * A n�v megad�s�ra szolg�l� sz�vegdoboz.
	 */	
	private JTextField name;
	
	/**
	 * A be�ll�t�sok alap panelje.
	 */	
	private  JPanel settingsPanel;
	
	/**
	 * A j�t�kos be�ll�t�sa.
	 * @param w Be�ll�tand� j�t�kos.
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