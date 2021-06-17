package data;

import javax.swing.JFileChooser;

public class DataFile {

	public String getFilePath(JFileChooser chosenFile) {
		String filePath;
		filePath = chosenFile.getSelectedFile().getPath();
		return filePath;
	}
	
}
