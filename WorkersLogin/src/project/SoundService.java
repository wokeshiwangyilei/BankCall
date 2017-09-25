package project;

import java.net.MalformedURLException;

public class SoundService {
	public void play(String number, String windownum) throws MalformedURLException, InterruptedException {
		Playsound.Sound("D:\\project\\plese.wav");
		Thread.sleep(500);
		
		Playsound.Sound("D:\\project\\"+ number.charAt(0) + ".wav");
		Thread.sleep(500);

		for (int i = 1; i < number.length(); i++) {
			Playsound.Sound("D:\\project\\" + number.charAt(i) + ".wav");
			Thread.sleep(500);
		}
		
		Playsound.Sound("D:\\project\\num.wav");
		Thread.sleep(200);
		
		Playsound.Sound("D:\\project\\to.wav");
		Thread.sleep(300);
		
		for (int i = 11; i < windownum.length(); i++) {
			Playsound.Sound("D:\\project\\" + windownum.charAt(i) + ".wav");
			Thread.sleep(500);
		}
		
		Playsound.Sound("D:\\project\\handle.wav");
		Thread.sleep(30);
	}
}
