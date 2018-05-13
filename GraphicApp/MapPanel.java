package GraphicApp;

import java.awt.Graphics;

import javax.swing.JPanel;


public class MapPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(Program.mf == null)
			return;
		
		Program.mf.DrawAll(g);
	}
}
