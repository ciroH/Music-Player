package controller;

import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import audio.AudioProcessing;
import data.DataAudio;
import entities.AudioFile;

public class PlaybackController {
	String filePath;
	int selectedLine = 0;
	private AudioFile selectedFile = new AudioFile();
	private DataAudio fileManager = new DataAudio();
	private AudioProcessing audioManager = new AudioProcessing(selectedLine);
	HashMap<Integer,String> playlist = new HashMap<>();
	
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
			audioManager.loadPlayList(playlist);
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