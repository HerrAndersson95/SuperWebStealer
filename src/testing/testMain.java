package testing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class testMain {

	public static void main(String[] args) {
//		System.out.println("start");
//		Thread t = new T_CounterTest();
//		t.start();
		try {
			Document doc = Jsoup.connect("http://kamera.mojt.net/time.txt").get();
			String content = doc.html();
			System.out.println(content);
			
			//String str = "qwerty-1qwerty-2 455 f0gfg 4";   
			String str = content;
		    str = str.replaceAll("[^-?0-9]+", " "); 
		    System.out.println(str);
		    List<String> times = Arrays.asList(str.trim().split(" "));
		    System.out.println(Arrays.asList(str.trim().split(" ")));
		    System.out.println("time is:" + times.get(1) + times.get(2) + times.get(3));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
//		  File file = fileChooser.getSelectedFile();
//		  String path = file.toPath().toString() + "\\";
//		  System.out.println(path);
//		}
	}

}
