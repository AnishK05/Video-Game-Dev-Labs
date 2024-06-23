package gameB;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music extends Thread //We do this because the music needs to run in a separate thread.
{
	//Java is bad at music
	//Native java does not play mp3 or mp4 files 
	//Java will play .wav (wave) files
	//If you have an mp file, you have to convert it to a .wav file before using it in java.
	
	File file; //File is a class that java uses to work with files
	AudioInputStream audioStream; //audio input stream
	Clip clip; //Clip is a class that java uses to work with audio files and actually play the file.
	
	@Override //Good programming practice - this tells java that the methods in thread are being overridden by the ones below.
	public void run() //Need this with the thread
	{
		try 
		{
			file = new File ("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/RR2.wav");
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) //The | is an "or" symbol. With catch statements, you only need one |, not ||.
		{
			e.printStackTrace();
		}
	}
	
	
}


