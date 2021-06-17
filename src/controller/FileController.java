package controller;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.AudioFile;

public class FileController {
	AudioFile loadedFile = new AudioFile();
	String filePath;
	
	public void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("flac or mp3 file", "flac", "mp3");
		fileChooser.setFileFilter(extensionFilter);
		int valueReturned = fileChooser.showOpenDialog(fileChooser);
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getPath();
			loadedFile.setPath(filePath);
		}
	}
	
}
