package data;

import javax.swing.JFileChooser;

public class DataAudio {

	public String getFilePath(JFileChooser chosenFile) {
		String filePath;
		filePath = chosenFile.getSelectedFile().getAbsolutePath();
		return filePath;
	}
	
}
