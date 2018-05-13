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
import Utility.FunctionLogger;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Program
{

	public static MainFrame mf = null;
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
		FunctionLogger.createLog(false);
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Program window = new Program();
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
	public Program()
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
		
		JPanel menu_upper_panel = new JPanel();
		menu_upper_panel.setBackground(new Color(255, 165, 0));
		frame.getContentPane().add(menu_upper_panel, BorderLayout.NORTH);
		menu_upper_panel.setLayout(new BoxLayout(menu_upper_panel, BoxLayout.Y_AXIS));
		
		JLabel lblKillerShokoban = new JLabel("Killer Sokoban");
		lblKillerShokoban.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblKillerShokoban.setHorizontalAlignment(SwingConstants.CENTER);
		lblKillerShokoban.setFont(new Font("DialogInput", Font.BOLD, 34));
		menu_upper_panel.add(lblKillerShokoban);
		
		JLabel lblByCsatornapatkanyok = new JLabel("by csatornapatkanyok");
		lblByCsatornapatkanyok.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblByCsatornapatkanyok.setHorizontalAlignment(SwingConstants.CENTER);
		lblByCsatornapatkanyok.setFont(new Font("DialogInput", Font.BOLD, 14));
		menu_upper_panel.add(lblByCsatornapatkanyok);
		
		JPanel menu_content_panel = new JPanel();
		menu_content_panel.setBackground(new Color(218, 165, 32));
		frame.getContentPane().add(menu_content_panel, BorderLayout.CENTER);
		menu_content_panel.setLayout(new BoxLayout(menu_content_panel, BoxLayout.X_AXIS));
		
		JPanel menu_1p_panel = new JPanel();
		menu_1p_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				menu_1p_panel.setBackground(new Color(0, 191, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_1p_panel.setBackground(new Color(0, 153, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Warehouse wh = new Warehouse(10, 10, 1);  
				MainFrame mainframe = new MainFrame(wh);
				Program.mf = mainframe;
				wh.Initialize();
				mainframe.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		menu_1p_panel.setBackground(new Color(0, 153, 204));
		menu_content_panel.add(menu_1p_panel);
		menu_1p_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("1 Player");
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 39));
		menu_1p_panel.add(lblNewLabel);
		
		JPanel menu_2p_panel = new JPanel();
		menu_2p_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_2p_panel.setBackground(new Color(51, 204, 0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_2p_panel.setBackground(new Color(51, 102, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Warehouse wh = new Warehouse(10, 10, 2);
				MainFrame mainframe = new MainFrame(wh);
				Program.mf = mainframe;
				wh.Initialize();
				mainframe.setVisible(true);
				frame.setVisible(false);
			}
		});
		menu_2p_panel.setBackground(new Color(51, 102, 0));
		menu_content_panel.add(menu_2p_panel);
		
		JLabel lblNewLabel_1 = new JLabel("2 Player");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 39));
		menu_2p_panel.add(lblNewLabel_1);
		
		JPanel menu_exit_panel = new JPanel();
		menu_exit_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_exit_panel.setBackground(new Color(255, 204, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_exit_panel.setBackground(new Color(255, 165, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Exit();				
			}
		});
		
		menu_exit_panel.setBackground(new Color(255, 165, 0));
		frame.getContentPane().add(menu_exit_panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("Exit");
		lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 39));
		menu_exit_panel.add(lblNewLabel_2);
	}

	
	public JPanel GetmenuPanel(){ return menuPanel; }
	public void SetmenuPanel(JPanel mp) { menuPanel = mp ;}
	
	public JButton Getplayer1Button(){ return player1Button; }
	public void Setplayer1Button(JButton pb) { player1Button = pb ;}
	
	public JButton Getplayer2Button(){ return player2Button; }
	public void Setplayer2Button(JButton pb) { player2Button = pb ;}
}
