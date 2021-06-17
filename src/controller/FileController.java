package controller;

import javax.swing.JFileChooser;

import data.DataFile;
import entities.AudioFile;

public class FileController {
	AudioFile selectedFile = new AudioFile();
	DataFile fileManager = new DataFile();
	String filePath;
	
	public void openFile(JFileChooser fileChooser) {
		int valueReturned = fileChooser.showOpenDialog(fileChooser);
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			//calls audio layer sending selectedFile, and starts playing the file
		}
	}
	
}
