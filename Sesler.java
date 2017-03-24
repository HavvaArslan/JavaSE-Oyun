package Proje;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sesler extends Thread {
	
	public void run(){
		while(true){
			 try {
				    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("arkaplan.wav").getAbsoluteFile());
				    Clip clip = AudioSystem.getClip();
				    clip.open(audioInputStream);
				    clip.start();
				    Thread.sleep(15330);
				} catch(Exception ex) {
				    System.out.println("Ses oynatýlamadý");
				    ex.printStackTrace();
				}
			}
	}
	public static void muzikCal()
	{
	    try {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("carp.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	} catch(Exception ex) {
	    System.out.println("Ses oynatýlamadý.");
	    ex.printStackTrace();
	}

	}

	public static void muzikCalKayýp()
	{
	    try {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("yanma.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	} catch(Exception ex) {
	    System.out.println("Ses oynatýlamadý.");
	    ex.printStackTrace();
	}

	}

}
