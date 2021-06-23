package audio;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

import entities.AudioFile;

public class audioProcessing {
	
	public audioProcessing(int selectedLine) {
	
		//Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo(); //returns IllegalArguentException if no mixer is found; i have to catch the error outside the constructor and return a JOptionPane in the view layer notifying the issue
		//for (Mixer.Info info : mixerInfo) System.out.println(info.getName()+" | "+info.getVendor());
		try {
		Mixer defaultMixer = AudioSystem.getMixer(null);	//gets the default Mixer when using null as argument, so i don't need to use a Mixer.Info Array until i don't implement options for choosing a Mixer trough the GUI.
		Line.Info[] lineInfo = defaultMixer.getTargetLineInfo();
		Line line = defaultMixer.getLine(lineInfo[selectedLine]);
		line.open(); //find  a way of closing the line that was open before this one
		} catch (LineUnavailableException e) { //catch also Mixer's exceptions and exceptions about the non-permission(OS level) of playing audio.
			//throw exception
			e.printStackTrace();
		}
		
	}
	
	public void filePlay(AudioFile fileToPlay) {
	
		String filePath = fileToPlay.getPath();
//		InputStream inputStr = new FileInputStream(filePath);
		// https://docs.oracle.com/javase/8/docs/technotes/guides/sound/programmer_guide/contents.html
		
	}
	
}
