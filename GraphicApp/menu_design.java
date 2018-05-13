package GraphicApp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import GameLogic.Warehouse;
import GameLogic.Worker;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_design
{

	private JFrame frame;
	
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
		frame.dispose();
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
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					menu_design window = new menu_design();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu_design()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, (int) width-200, (int) height-200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblKillerShokoban = new JLabel("Killer Sokoban");
		lblKillerShokoban.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblKillerShokoban.setHorizontalAlignment(SwingConstants.CENTER);
		lblKillerShokoban.setFont(new Font("DialogInput", Font.BOLD, 34));
		panel.add(lblKillerShokoban);
		
		JLabel lblByCsatornapatkanyok = new JLabel("by csatornapatkanyok");
		lblByCsatornapatkanyok.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblByCsatornapatkanyok.setHorizontalAlignment(SwingConstants.CENTER);
		lblByCsatornapatkanyok.setFont(new Font("DialogInput", Font.BOLD, 14));
		panel.add(lblByCsatornapatkanyok);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(218, 165, 32));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_3.setBackground(new Color(0, 191, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(0, 153, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Warehouse wh = new Warehouse(20, 20, 1);  
				MainFrame mainframe = new MainFrame(wh);
				mainframe.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		panel_3.setBackground(new Color(0, 153, 204));
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("1 Player");
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 39));
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(51, 204, 0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(51, 102, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Warehouse wh = new Warehouse(20, 20, 2);
				MainFrame mainframe = new MainFrame(wh);
				mainframe.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_4.setBackground(new Color(51, 102, 0));
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("2 Player");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 39));
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(255, 204, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(255, 165, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Exit();				
			}
		});
		
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		panel_2.setBackground(new Color(255, 165, 0));
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("Exit");
		lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 39));
		panel_2.add(lblNewLabel_2);
	}

	
	public JPanel GetmenuPanel(){ return menuPanel; }
	public void SetmenuPanel(JPanel mp) { menuPanel = mp ;}
	
	public JButton Getplayer1Button(){ return player1Button; }
	public void Setplayer1Button(JButton pb) { player1Button = pb ;}
	
	public JButton Getplayer2Button(){ return player2Button; }
	public void Setplayer2Button(JButton pb) { player2Button = pb ;}
}
