package data;

import java.util.Iterator;

import javax.swing.JFileChooser;

public class DataAudio {

	public String getFilePath(JFileChooser chosenFile) {
		String filePath;
		filePath = chosenFile.getSelectedFile().getAbsolutePath();
		return filePath;
	}
	


	public String getTitle(String path) {
		String title;
		StringBuilder titleBuilder = new StringBuilder(path);
		int lastSlash;
		
			lastSlash = titleBuilder.lastIndexOf("/");
			title = titleBuilder.substring(lastSlash); //Exception in thread "AWT-EventQueue-0" java.lang.StringIndexOutOfBoundsException: start -1, end 0, length 0
			title += "\n";
			//TODO:Check behavior when opening a broken .wav file
			//TODO:Delete first element of title
			//TODO:Fix JLabel not displaying the title.
		return title;
	}
}