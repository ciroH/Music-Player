package data;


import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;

import javax.swing.JFileChooser;

public class DataAudio {

	public String getFilePath(JFileChooser chosenFile) {
		String filePath;
		filePath = chosenFile.getSelectedFile().getAbsolutePath();
		return filePath;
	}
	
	
	public String getFolderPath(JFileChooser chosenFolder) {
		
		return getFilePath(chosenFolder);
	}
	

	public String getTitle(String path) {
		String title;
		StringBuilder titleBuilder = new StringBuilder(path);
		int lastSlash;
		
			lastSlash = titleBuilder.lastIndexOf("/");
			title = (titleBuilder.substring(lastSlash)).substring(1);
		return title;
	}
	
	
	public LinkedList<String> getFolderFileList(String folderPath) {
		LinkedList<String> playlist = new LinkedList<String>();
		File folder = new File(folderPath);
		File[] filesInFolder = folder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.toLowerCase().endsWith(".wav");
			}
		});
		for (File file : filesInFolder) {
			playlist.add(file.getAbsolutePath());
		}
		return playlist;
	}
	
}