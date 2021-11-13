package controller;

import java.util.HashMap;
import javax.swing.JFileChooser;
import audio.AudioProcessing;
import data.DataAudio;
import entities.AudioFile;
import ui.Player;

public class PlaybackController {
	String filePath;
	int selectedLine = 0;
	public Player uiRefInstance;
	private AudioFile selectedFile = new AudioFile();
	private DataAudio fileManager = new DataAudio();
	private AudioProcessing audioManager = new AudioProcessing(selectedLine);
	private PlaylistController playlistControl = new PlaylistController(uiRefInstance,audioManager);
	HashMap<Integer,String> playlist = new HashMap<>();
	
	public PlaybackController(Player playerReference) {
		uiRefInstance = playerReference; //References the active instance of ui.Player
	}
	
	public int getSelectedLine() {
		return selectedLine;
	}


	public void setSelectedLine(int selectedLine) {
		this.selectedLine = selectedLine;
	}

	
	public AudioProcessing getAudioManager() {
		return audioManager;
	}


	public String openFile(JFileChooser fileChooser, int valueReturned) {
		String songInfo = "";
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			songInfo = getSongTitle(selectedFile.getPath());
			songInfo +=	audioManager.fileStart(selectedFile);
		}
		return songInfo;
	}
	
	
	public String openFolder(JFileChooser filechooser, int valueReturned) {
		String folderPath = "";
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			folderPath = fileManager.getFolderPath(filechooser);
			playlist = fileManager.getFolderFileList(folderPath);
			audioManager.loadPlaylist(playlist);
		}
		return folderPath;
	}
	
	
	public void pause(){
		audioManager.startPause();
	}
	

	public String getSongTitle(String path) {
		return fileManager.getTitle(path);
	}
	
}