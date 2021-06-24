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
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			//calls audio layer sending selectedFile, and starts playing the file
		}
	}
	
}
