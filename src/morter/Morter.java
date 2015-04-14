package morter;

import java.lang.ProcessBuilder;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//http://examples.javacodegeeks.com/core-java/lang/processbuilder/java-lang-processbuilder-example/
public class Morter {
	public static void main(String[] args) throws InterruptedException
	{
		ProcessHandler ph = new ProcessHandler();
		System.out.println("Start");
		ph.start();
		TimeUnit.SECONDS.sleep(10);
		ph.stopThread();
		System.out.println("Done");
	}
	
	
}
