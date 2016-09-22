package ClientSide;

public class TimeTester {

	public static void main(String[] args) {
		SuperWebStealer sws = new SuperWebStealer("http://kamera.mojt.net/", "C:/Users/Joakim/Pictures/background/javaTesting/");
		sws.checkTimeStamp(20);
	}

}
