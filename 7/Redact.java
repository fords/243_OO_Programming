/*
 * $Redact.java
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;


/*  redact main method reads input file and redact some words and save in output file
 *  @author Zeyar Win
 * */
public class Redact {
	public Redact() {
	}

	public static void main(String[] args) throws IOException {
		File redact = new File(args[0]);
		File input = new File(args[1]);
		File output = new File(args[2]);

		
		RedactWriter rw = new RedactWriter(new FileWriter(output),RedactWriter.getRedactWords(redact));
		DataInputStream in = new DataInputStream(new FileInputStream(input));
		
		try {
			while (true) {
				char a=(char) in.readByte();
				
				rw.write(a);
			
			}
		} catch (IOException e) {
			
		}
		rw.close();
		
	}

	
		

}
