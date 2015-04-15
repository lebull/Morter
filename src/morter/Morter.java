package morter;

import java.lang.ProcessBuilder;

import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;

//http://examples.javacodegeeks.com/core-java/lang/processbuilder/java-lang-processbuilder-example/
public class Morter {
	public static void main(String[] args) throws InterruptedException
	{
		String input_line;
		
		Scanner scan = new Scanner(System.in);
		
		ProcessHandler subprocess = new ProcessHandler();
		subprocess.start();
		
		try {
		
			while(true){
				System.out.print(">>");
				input_line = scan.nextLine();
				if(input_line == "java quit"){
					System.out.println("Done");
					break;
				}
				
				subprocess.write(input_line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			subprocess.join();
			scan.close();
		}
		
		
		
	
		//You don't have to go home, but you can't stay here.
		try {
			subprocess.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
}
