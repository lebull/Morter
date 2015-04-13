package morter;

import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//http://examples.javacodegeeks.com/core-java/lang/processbuilder/java-lang-processbuilder-example/
public class Morter {

	public static void main(String[] args) throws InterruptedException, IOException{
		
		ProcessBuilder pb = new ProcessBuilder("echo", "This is a ProcessBuilder Example from JCG");
		System.out.println("Running echo command");
		Process process = pb.start();
		

	}

}
