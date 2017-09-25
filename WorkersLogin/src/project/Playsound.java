package project;

import java.applet.*;
import java.net.*;

public class Playsound {

	public static void Sound(String fileName) throws MalformedURLException{
		URL u=new URL("file:"+fileName);
		AudioClip a=Applet.newAudioClip(u);
				a.play();
	}
}
