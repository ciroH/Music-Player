package data;


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
			title = (titleBuilder.substring(lastSlash)).substring(1);
		return title;
	}
}