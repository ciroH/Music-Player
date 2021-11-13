package controller;

import audio.AudioProcessing;
import ui.Player;

public class PlaylistController {
	Player uiRefInstance;
	AudioProcessing audioManager;
	
	
	public PlaylistController(Player player, AudioProcessing audio) {
		uiRefInstance = player;
		audioManager = audio;
	}
	
	
}
