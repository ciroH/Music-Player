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

package controller;

import java.util.HashMap;
import javax.swing.JFileChooser;
import audio.AudioProcessing;
import data.DataAudio;
import entities.AudioFile;
import ui.Player;

public class PlaybackController {
	String filePath;
	int selectedLine = 0;
	public Player uiRefInstance;
	private AudioFile selectedFile = new AudioFile();
	private DataAudio fileManager = new DataAudio();
	private AudioProcessing audioManager = new AudioProcessing(selectedLine);
	private PlaylistController playlistControl;
	HashMap<Integer,String> playlist = new HashMap<>();
	
	public PlaybackController(Player playerReference) {
		uiRefInstance = playerReference; //References the active instance of ui.Player
		playlistControl = new PlaylistController(uiRefInstance,audioManager);
	}
	
	public int getSelectedLine() {
		return selectedLine;
	}


	public void setSelectedLine(int selectedLine) {
		this.selectedLine = selectedLine;
	}

	
	public AudioProcessing getAudioManager() {
		return audioManager;
	}


	public String openFile(JFileChooser fileChooser, int valueReturned) {
		String songInfo = "";
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			selectedFile.setPath(fileManager.getFilePath(fileChooser));
			songInfo = getSongTitle(selectedFile.getPath());
			songInfo +=	audioManager.fileStart(selectedFile);
		}
		return songInfo;
	}
	
	
	public String openFolder(JFileChooser filechooser, int valueReturned) {
		String folderPath = "";
		if (valueReturned == JFileChooser.APPROVE_OPTION) {
			folderPath = fileManager.getFolderPath(filechooser);
			playlist = fileManager.getFolderFileList(folderPath);
			playlistControl.loadPlaylist(playlist);
			
		}
		return folderPath;
	}
	
	
	public void pause(){
		audioManager.startPause();
	}
	

	public String getSongTitle(String path) {
		return fileManager.getTitle(path);
	}
	
}