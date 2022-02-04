/*
 * 	 Music-Player: A .wav player.
 *   Copyright (C) 2022  Ciro Haskour
 
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License version 2, as published by
 *   the Free Software Foundation.
 
 *   You should have received a copy of the GNU General Public License along
 *   with this program; if not, write to the Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *   
 *   You can also contact the author of this program by sending an email at ciroh.jobs@gmail.com
 */

package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
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
	
	
	public HashMap<Integer,String> getFolderFileList(String folderPath) {	//TODO: fix loading bug
		HashMap<Integer,String> playlist = new HashMap<>();
		Integer fileKey = 0;
		File folder = new File(folderPath);
		File[] filesInFolder = folder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.toLowerCase().endsWith(".wav");
			}
		});
		
		for (File file : filesInFolder) {
			playlist.put(fileKey,file.getAbsolutePath());
			fileKey++;
		}
		return playlist;
	}
	
	@SuppressWarnings("unused")
	public String getImageRelativeToFile(String filePath) {
		StringBuilder imagePath = new StringBuilder(filePath);
		String imageName;
		int lastSlash = imagePath.lastIndexOf("/");
		
		
		
		return "";
	}
	
	
}