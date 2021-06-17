package controller;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.AudioFile;

public class FileController {
	AudioFile loadedFile;
	
	public void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("flac or mp3 file", "flac", "mp3");
		fileChooser.setFileFilter(extensionFilter);
		fileChooser.showOpenDialog(fileChooser);
	}
	
}
