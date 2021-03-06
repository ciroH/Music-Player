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

package audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import entities.AudioFile;

public class AudioProcessing {
	Clip port;
	boolean streamIsPaused;
	int playListIndex = -1;
	AudioFile fileToStart = new AudioFile();
	
	public AudioProcessing(int selectedLine) {
		try {
		port = AudioSystem.getClip();
		port.close();
		} catch (LineUnavailableException e) { //catch also Mixer's exceptions and exceptions about the non-permission(OS level) of playing audio.
			//throw exception
			e.printStackTrace();
		}
		
	}

	
	public AudioFile getFileToStart() {
		return fileToStart;
	}


	public void setFileToStart(AudioFile fileToStart) {
		this.fileToStart = fileToStart;
	}


	public String fileStart(AudioFile fileToStart) {
		String filePath = fileToStart.getPath();
		String songFormat = "";
		try {
			InputStream input = new FileInputStream(filePath);
			InputStream bufferedInput = new BufferedInputStream(input);
			AudioInputStream song = AudioSystem.getAudioInputStream(bufferedInput);
			listenPort();
			
			if(port.isOpen()) port.close(); //the Clip port may be already in use, so it has to be closed here if it's already open
			streamIsPaused = false; //* TODO: fix streamIsPaused state when opening a new folder while playing a song.
			port.open(song);
			port.start(); //port.start is necessary; port.open doesn't start the stream by itself.
			//*
			//songFormat = getSongInfo(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return songFormat;
		
	}

	public void listenPort() {
		port.addLineListener(new LineListener() {
			
			@Override
			public void update(LineEvent le) {
				if(le.getType() == LineEvent.Type.STOP) {
					if(!streamIsPaused) {
					port.close();
					System.out.println("song finished; port closed.");
					//TODO: check on the playList if there's another song to play after this one.
					}
				}
				
			}
		});
	}
	
	public void startPause() {
		if (port.isActive()) {
			streamIsPaused = true;
			port.stop();
		} else {
			streamIsPaused = false;
			port.start();
		}
	}
	
	
	
	public void getSongInfo() {
	//	port.getFormat()
	}
	
}