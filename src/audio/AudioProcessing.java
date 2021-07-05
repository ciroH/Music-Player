package audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

import entities.AudioFile;

public class AudioProcessing {
	Clip port;
	boolean streamIsPaused;
	public AudioProcessing(int selectedLine) {
		//Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo(); //returns IllegalArguentException if no mixer is found; i have to catch the error outside the constructor and return a JOptionPane in the view layer notifying the issue
		//for (Mixer.Info info : mixerInfo) System.out.println(info.getName()+" | "+info.getVendor());
		try {
//		Mixer defaultMixer = AudioSystem.getMixer(null);	//gets the default Mixer when using null as argument, so i don't need to use a Mixer.Info Array until i don't implement options for choosing a Mixer trough the GUI.
//		Line.Info[] lineInfo = defaultMixer.getTargetLineInfo();
		port = AudioSystem.getClip();
		port.close();
		} catch (LineUnavailableException e) { //catch also Mixer's exceptions and exceptions about the non-permission(OS level) of playing audio.
			//throw exception
			e.printStackTrace();
		}
		
	}
	
	public void fileStart(AudioFile fileToStart) {
		String filePath = fileToStart.getPath();
		try {
			InputStream input = new FileInputStream(filePath);
			InputStream bufferedInput = new BufferedInputStream(input);
			AudioInputStream song = AudioSystem.getAudioInputStream(bufferedInput);
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
			
			if(port.isOpen()) port.close(); //the Clip port may be already in use, so it has to be closed here if it's already open
			port.open(song);
			port.start(); //port.start is necessary; port.open doesn't start the stream by itself.
			streamIsPaused = false;
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
	
}
