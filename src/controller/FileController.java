package controller;

import javax.swing.JFileChooser;

import data.DataAudio;
import entities.AudioFile;

public class FileController {
	AudioFile selectedFile = new AudioFile();
	DataAudio fileManager = new DataAudio();
	String filePath;
	int selectedLine = 0;
	
	
	
	public int getSelectedLine() {
		return selectedLine;
	}


	public void setSelectedLine(int selectedLine) {
		this.selectedLine = selectedLine;
	}


	public void openFile(JFileChooser fileChooser) {
		int valueReturned = fileChooser.showOpenDialog(fileChooser);
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			//calls audio layer sending selectedFile, and starts playing the file
		}
	}
	
}
