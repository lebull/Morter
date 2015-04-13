package morter;

import java.util.concurrent.TimeUnit;

public class ProcessHandler extends Thread{

	
	public ProcessHandler(){
		
	}
	
	public void run(){
		while(true){
			System.out.println("Tick");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
