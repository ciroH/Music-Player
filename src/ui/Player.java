package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class Player extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player frame = new Player();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Player() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(6, 42, 157, 167);
		contentPane.add(infoPanel);
		
		JPanel PlaylistPanel = new JPanel();
		PlaylistPanel.setBounds(175, 6, 261, 203);
		contentPane.add(PlaylistPanel);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(6, 221, 160, 30);
		contentPane.add(controlPanel);
		GridBagLayout gbl_controlPanel = new GridBagLayout();
		gbl_controlPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_controlPanel.rowHeights = new int[]{0, 0};
		gbl_controlPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_controlPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		controlPanel.setLayout(gbl_controlPanel);
		
		JButton btnPrevious = new JButton("⏮︎");
		btnPrevious.setPreferredSize(new Dimension(43, 24));
		btnPrevious.setMaximumSize(new Dimension(43, 24));
		btnPrevious.setMinimumSize(new Dimension(43, 24));
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrevious.gridx = 0;
		gbc_btnPrevious.gridy = 0;
		controlPanel.add(btnPrevious, gbc_btnPrevious);
		
		JButton btnPlayPause = new JButton("⏯︎");
		btnPlayPause.setPreferredSize(new Dimension(43, 24));
		btnPlayPause.setMaximumSize(new Dimension(43, 24));
		btnPlayPause.setMinimumSize(new Dimension(43, 24));
		btnPlayPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnPlayPause = new GridBagConstraints();
		gbc_btnPlayPause.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlayPause.gridx = 1;
		gbc_btnPlayPause.gridy = 0;
		controlPanel.add(btnPlayPause, gbc_btnPlayPause);
		
		JButton btnNext = new JButton("⏭︎");
		btnNext.setPreferredSize(new Dimension(43, 24));
		btnNext.setMaximumSize(new Dimension(43, 24));
		btnNext.setMinimumSize(new Dimension(43, 24));
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.gridx = 2;
		gbc_btnNext.gridy = 0;
		controlPanel.add(btnNext, gbc_btnNext);
		
		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setBounds(6, 6, 157, 21);
		contentPane.add(OptionsPanel);
	}
}
