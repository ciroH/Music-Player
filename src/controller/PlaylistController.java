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
import java.util.Map;

import audio.AudioProcessing;
import entities.AudioFile;
import ui.Player;

public class PlaylistController {
	Player uiRefInstance;
	AudioProcessing audioManager;
	HashMap<Integer, String> playlist = new HashMap<>();
	int index = -1;
	
	
	public PlaylistController(Player player, AudioProcessing audio) {
		uiRefInstance = player;
		audioManager = audio;	
	}

	
	public void setPlayList(HashMap<Integer,String> playList) {
		this.playlist = playList;
	}
	
	public HashMap<Integer, String> getPlaylist() {
		return playlist;
	}

	public void resetIndex() {
		index = -1;
	}
	
	public void setPlaylist(HashMap<Integer, String> recievedHashMap) {
		if(this.playlist.isEmpty()) this.playlist = recievedHashMap;
		else {
			for (Map.Entry<Integer, String> element : recievedHashMap.entrySet()) {
				this.playlist.put(element.getKey(), element.getValue());
			}
		}
	}
	
	
	public void clearPlaylist(){
		playlist.clear();
	}
	
	
	public void loadPlaylist(HashMap<Integer, String> fileList) {
		if (fileList.size() > 0) {
			this.setPlayList(fileList);
			startPlaylist();
		}
		
	}
	
	
	public void startPlaylist() {	//TODO: Update Title and Picture
		AudioFile tempAudioFile = new AudioFile(); 
		resetIndex();
		index++;
		tempAudioFile.setPath(getPlaylist().get(index));
		audioManager.fileStart(tempAudioFile);
	}
	
}
