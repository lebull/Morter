package morter;

import java.util.concurrent.TimeUnit;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessHandler extends Thread{

	public boolean running = false;
	
	private Process target_process;
	
	private static final Logger LOGGER = Logger.getLogger(ProcessHandler.class.getName());
	
	/*
	public ProcessHandler(){
		
	}
	*/
	
	public void run(){
		
		running = true;
		
		ProcessBuilder pb = new ProcessBuilder("ping", "www.google.com", "-n", "3");
		
		System.out.println("Run echo command");
		Process target_process;
		try {
			target_process = pb.start();
			
			while(running){
				//System.out.println("Tick");
				showOutput(target_process);
				TimeUnit.MILLISECONDS.sleep(100);
			}
			
			target_process.waitFor();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//If there is problem with the thread
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// If the thread ends prematurely
			e.printStackTrace();
		} finally {
			this.onStop();
		}
	}
	
	public void onStop(){
		
	}
	
	private void showOutput(Process target_process) throws IOException {
		InputStream inputStream = target_process.getInputStream();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			//while ((line = br.readLine()) != null && br.) {
			//TODO read the output by the number of chars available.
			while (/*bleh*/)
				sb.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e1) {
			//Process isn't alive and we tried to read
			//Make sure the thread is stopped, not just the subprocess
			this.stopThread();
			return;
		} finally {
			System.out.println("Closed");
			br.close();
		}
		

		
		System.out.println(sb.toString());
	}
	
	public void stopThread(){
		running = false;
	}
	
	
}
