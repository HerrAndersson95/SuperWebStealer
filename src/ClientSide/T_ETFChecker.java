package ClientSide;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class T_ETFChecker extends Thread {
	
	private String urlT;
	private String url;
	private SuperWebStealer sws;
	
	public T_ETFChecker(SuperWebStealer sws){
		this.urlT = "http://kamera.mojt.net/time.txt";
		this.url = "http://kamera.mojt.net/";
		this.sws = sws;
	}
	
	public void run(){
		
	}
	
	public String findTime(){
		String content = null;
		try {
			Document doc = Jsoup.connect("http://kamera.mojt.net/time.txt").get();
			content = doc.html();
			System.out.println(content);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			content = "ERROR: Find Time";
		}
		return content;
	}
}
