package morter;

import java.util.concurrent.TimeUnit;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ProcessHandler extends Thread{
	/**
	 *Spawns and manipulates a separate subprocess.
	 *
	 */

	public boolean running = false;
	
	private Process target_process;
	
	private static final Logger LOGGER = Logger.getLogger(ProcessHandler.class.getName());
	
	private BufferedWriter stdinWriter;
	
	private BufferedReader stdoutReader; //Reads stdout
	
	public void run(){
		
		running = true;
		
		ProcessBuilder pb = new ProcessBuilder("C:/Python27/python.exe");
		
		try {
			
			target_process = pb.start();
			
			stdoutReader = new BufferedReader(new InputStreamReader(target_process.getInputStream()));
			stdinWriter = new BufferedWriter(new OutputStreamWriter(target_process.getOutputStream()));
			
			while(running){
				dumpOutput();
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
	
	private void dumpOutput() throws IOException {
		/**
		 * @param target_process
		 */
		
		StringBuilder sb = new StringBuilder();
		
		try{
			String line = null;
			//while () != null && stdoutReader.) {
			//TODO read the output by the number of chars available.
			while (stdoutReader.ready() && (line = stdoutReader.readLine()) != null){
				sb.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e1) {	//Process isn't alive and we tried to read
			//Make sure the thread is stopped, not just the subprocess
			this.close();
			return;
		}
		
		System.out.print(sb.toString());
	}
	
	public void write(String input) throws IOException{
		System.out.println(input);
		stdinWriter.write(input);
		stdinWriter.flush();
	}
	
	public void close() throws IOException{
		System.out.println("Process Closed");
		running = false;
		stdoutReader.close();
		stdinWriter.close();
	}
	
	
}
