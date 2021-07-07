package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatDarkLaf;

import controller.*;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

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
					frame.setResizable(false);
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
		PlaybackController playback = new PlaybackController();
		String fileInfo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(UIManager.getColor("text"), 2));
		infoPanel.setBounds(6, 42, 157, 167);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		JPanel coverPanel = new JPanel();
		coverPanel.setBounds(6, 6, 145, 114);
		infoPanel.add(coverPanel);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 132, 145, 29);
		infoPanel.add(titlePanel);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0, 0};
		gbl_titlePanel.rowHeights = new int[]{0, 0};
		gbl_titlePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_titlePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		
		JLabel songInfoLabel = new JLabel("New label");
		GridBagConstraints gbc_songInfoLabel = new GridBagConstraints();
		gbc_songInfoLabel.gridx = 0;
		gbc_songInfoLabel.gridy = 0;
		titlePanel.add(songInfoLabel, gbc_songInfoLabel);
		
		
		
		
		JPanel PlaylistPanel = new JPanel();
		PlaylistPanel.setBorder(new LineBorder(UIManager.getColor("text"), 2));
		PlaylistPanel.setBounds(175, 6, 261, 203);
		contentPane.add(PlaylistPanel);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(16, 221, 150, 30);
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
		btnPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playback.pause();
			}
		});
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
		OptionsPanel.setBorder(new LineBorder(UIManager.getColor("text"), 2));
		OptionsPanel.setBounds(6, 6, 157, 21);
		contentPane.add(OptionsPanel);
		OptionsPanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		OptionsPanel.add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuFile.setPreferredSize(new Dimension(45,25));
		
		JMenu menuSoundOut = new JMenu("Output");
		menuBar.add(menuSoundOut);
		menuSoundOut.setPreferredSize(new Dimension(60,25));
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title;
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("wav, flac, or mp3 file","wav", "flac", "mp3");
				fileChooser.setFileFilter(extensionFilter);
				int valueReturned = fileChooser.showOpenDialog(fileChooser);
				title = playback.openFile(fileChooser,valueReturned);
				updateSongDisplayedInfo(title);
				
				
			}
		});
		menuFile.add(mntmOpenFile);
		
		JMenuItem mntmOpenFolder = new JMenuItem("Open Folder");
		menuFile.add(mntmOpenFolder);
		
//		for (iterable_type iterable_element : iterable) {
			//changes selectedLine
		
		//for changing the selected Line, i should call new audioProcessing(selectedLine)
//		}
		
	}

	public void updateSongDisplayedInfo(String title) {
		String fileInfo;
		JLabel songInfoLabel;
		fileInfo = title;
		songInfoLabel = new JLabel(fileInfo);
	}
}
