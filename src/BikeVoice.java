import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BikeVoice {
	Clip myclip;
	
	public void setFile(String soundname) {
		try {
			File file = new File(soundname);
			AudioInputStream mysound = AudioSystem.getAudioInputStream(file);
			myclip= AudioSystem.getClip();
			myclip.open(mysound);
		}
		catch(Exception e) {
			
		}
	}
	public void soundefectplay() {
		myclip.setFramePosition(0);
		myclip.start();
	}
}
