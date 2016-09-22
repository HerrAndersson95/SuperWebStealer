package ClientSide;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class T_timeCheck extends Thread{
	
	private int interval;
	private String link;
	private String sP;
	
	public T_timeCheck(int min, String link, String sP){
		this.interval = min;
		this.link = link;
		this.sP = sP;
	}
	public void run(){
		while(true){
			Thread linker = new T_Linker(link, sP);
			linker.start();
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		    System.out.println(sdf.format(cal.getTime()));
			try {
				sleep(interval*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("ERROR: timeCheck sleep failed");
			}
		}
	}
}
