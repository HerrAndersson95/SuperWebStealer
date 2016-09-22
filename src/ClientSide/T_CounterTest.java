package ClientSide;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class T_CounterTest extends Thread{
	
	public T_CounterTest(){
	}
	public void run(){
		while(true){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hej");
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		    System.out.println( sdf.format(cal.getTime()) );
		}
	}	
}


