package ClientSide;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SuperWebStealer2 {

	public static void main(String[] args) {
		try{
			String url = "http://kamera.mojt.net/";
			Document doc = Jsoup.connect(url).get();
			Elements img = doc.getElementsByTag("img");
			for(Element tmp : img){
				String src = tmp.absUrl("src");
				System.out.println("Picture found");
				System.out.println(src);
			}
		} catch (IOException e){
			System.out.println("ERROR: SOME THING FUCKED");
		}

	}
	
	public void downloadImg(String src){
		String folderPath = "";
        String folder = null;

        //Exctract the name of the image from the src attribute
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        System.out.println(name);

        try{
        	
        	URL url = new URL(src);
            InputStream in = url.openStream();

            OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath + name));

            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close();
            
        } catch (IOException e){
        	System.out.println("ERROR: Download derped out");
        }
        
	}

}
