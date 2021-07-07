package controller;

import javax.swing.JFileChooser;

import audio.AudioProcessing;
import data.DataAudio;
import entities.AudioFile;

public class PlaybackController {
	String filePath;
	int selectedLine = 0;
	AudioFile selectedFile = new AudioFile();
	DataAudio fileManager = new DataAudio();
	AudioProcessing audioManager = new AudioProcessing(selectedLine);
		
	
	public int getSelectedLine() {
		return selectedLine;
	}


	public void setSelectedLine(int selectedLine) {
		this.selectedLine = selectedLine;
	}

	
	public AudioProcessing getAudioManager() {
		return audioManager;
	}


	public void openFile(JFileChooser fileChooser, int valueReturned) {
		String songInfo = "";
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			songInfo = getSongTitle(songInfo);
			songInfo +=	audioManager.fileStart(selectedFile);

		}
	}
	
	public void pause(){
		audioManager.startPause();
	}
	

	public String getSongTitle(String path) {
		return fileManager.getTitle(path);
	}

}