package MAIN;

import java.util.Timer;



public class DDNS {
	Timer timer;
	public DDNS() {
	
	
	
	  timer = new Timer();
	  ddns_factory DDNS=new ddns_factory();
	  
      timer.schedule(DDNS, 0, 500000);

	}
	
	
	
public static void main(String[] args) {
	
	
	new DDNS();
	
	
	
	
}



}
