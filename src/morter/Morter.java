package morter;

import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//http://examples.javacodegeeks.com/core-java/lang/processbuilder/java-lang-processbuilder-example/
public class Morter {

	public static void main(String[] args) throws InterruptedException,
			IOException {
		ProcessBuilder pb = new ProcessBuilder("ping", "www.google.com", "-n", "3");
		System.out.println("Run echo command");
		Process process = pb.start();
		int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
		System.out.println("Echo Output:\n" + output(process.getInputStream()));	
	}
	
	private static String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}

}
