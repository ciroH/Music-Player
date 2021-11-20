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
	
	//TODO: move AudioProcessing loadPlaylist(), playlistStart(), playListIndex, and playlist to PlaylistController
	
	public void loadPlaylist(HashMap<Integer, String> fileList) {
		if (fileList.size() > 0) {
			this.setPlayList(fileList);
			startPlaylist();
		}
		
	}
	
	
	public void startPlaylist() {
		AudioFile tempAudioFile = new AudioFile(); 
		resetIndex();
		index++;
		tempAudioFile.setPath(getPlaylist().get(index));
		audioManager.fileStart(tempAudioFile);
	}
	
}
