package ClientSide;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class T_Linker extends Thread {
	
	private String link;
	private String savePath;
	
	public T_Linker(String link, String savePath){
		this.link = link;
		this.savePath = savePath;
	}
	public void run(){
		ArrayList<String> links = new ArrayList<String>();
		try{
			String url = link;
			Document doc = Jsoup.connect(url).get();
			Elements img = doc.getElementsByTag("img");
			for(Element tmp : img){
				String src = tmp.absUrl("src");
				System.out.println("Picture found");
				System.out.println(src);
				links.add(src);
			}
		} catch (IOException e){
			System.out.println("ERROR: SOME THING FUCKED");
		}
		
		for(int i = 0; i < links.size(); i++){
			Thread t = new T_Downloader(savePath, links.get(i));
			t.start();
		}
	}
}
