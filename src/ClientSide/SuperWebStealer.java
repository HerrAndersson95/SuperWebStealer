package ClientSide;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SuperWebStealer {
	
	private String link;
	private String savePath;

	public SuperWebStealer(String link, String savePath){
		this.link = link;
		this.savePath = savePath;
	}
	
	public void checkETFSite(){
		Thread etf = new T_ETFChecker(this);
		etf.start();
	}
	
	public void checkTimeStamp(int min){
		Thread timeCheck = new T_timeCheck(min, link, savePath);
		timeCheck.start();
	}
	
	public void startDownload(){
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
			//initDownload(links.get(i));
		}
	}
	private void initDownload(String url){
		Thread t = new T_Downloader(savePath, url);
		t.start();
	}
	
	public void setSavePath(String path){
		savePath = path;
	}
	public void setLink(String url){
		link = url;
	}
}
