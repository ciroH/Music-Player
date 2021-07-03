package audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

import entities.AudioFile;

public class AudioProcessing {
	Clip port;
	public AudioProcessing(int selectedLine) {
		//Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo(); //returns IllegalArguentException if no mixer is found; i have to catch the error outside the constructor and return a JOptionPane in the view layer notifying the issue
		//for (Mixer.Info info : mixerInfo) System.out.println(info.getName()+" | "+info.getVendor());
		try {
		Mixer defaultMixer = AudioSystem.getMixer(null);	//gets the default Mixer when using null as argument, so i don't need to use a Mixer.Info Array until i don't implement options for choosing a Mixer trough the GUI.
		Line.Info[] lineInfo = defaultMixer.getTargetLineInfo();
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
		//	port.addLineListener(null);
			//TODO: add a LineListener to the clip port, in order to detect when a song finishes, to do a port.close()
			if(port.isOpen()) port.close();
			port.open(song); //find  a way of closing the Line/Clip that was open before this one
			port.start();
			//TOD0: try opening a .wav file, while having line xx uncommented; --> input.read(filePath.getBytes()); results in unsupported stream exception
			//TODO: try playing a song without calling port.start();
			//TODO: add a method that calls port.stop(), to pause the Stream;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
