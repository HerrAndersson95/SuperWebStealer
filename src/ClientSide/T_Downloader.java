package ClientSide;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class T_Downloader extends Thread{
	
	private String save;
	private String link;
		
	public T_Downloader (String save, String link){
		this.save = save;
		this.link = link;
	}
	
	public void run(){
		int index = link.lastIndexOf('/');
		String name = link.substring(index+1);
		System.out.println(name);

        Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy_HH;mm;ss");
        String time = sdf.format(cal.getTime());
        try{	
        	URL url = new URL(link);
            InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(save + time + name));
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
