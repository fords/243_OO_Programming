/*
 * $RedactWriter.java
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/* redact writer redacts words by storing words in buffer character by character and matching with redacted words list
 * @author Zeyar Win
 */
public class RedactWriter extends Writer {
	Writer w;
	protected Collection<String> redactedWords;
	ArrayList<Character> arrayl = new ArrayList<Character>();

	public RedactWriter(Writer wr, Collection<String> redacts)
			throws IllegalArgumentException {
		w = wr;
		redactedWords = new ArrayList<String>();
		redactedWords.addAll(redacts);
	}
    /* write method tries to redact words by storing them in buffer
     * @param char
     * @return null
     */
	public void write(char c) throws IllegalArgumentException, IOException {
		if (!Character.isLetter(c)) {
			if (arraylIsRedacted(arrayl)) {

				for (int i = 0; i < arrayl.size(); i++) {
					w.write("X");
				}
				w.write(c);
				arrayl.clear();

			} else {
				Character[] chrarray = arrayl.toArray(new Character[0]);
				char[] s = new char[chrarray.length];
				for (int i = 0; i < chrarray.length; ++i)
					s[i] = chrarray[i];
				String word = new String(s);

				w.write(word);
				w.write(c);
				arrayl.clear();
			}
		} else {
			arrayl.add(c);
		}
	}
    /* close method flush and close
     * (non-Javadoc)
     * @see java.io.Writer#close()
     */
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		w.flush();
		w.close();
	}
    /* flush method writes and flush 
     * (non-Javadoc)
     * @see java.io.Writer#flush()
     */
	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		// write buffer
		// String[] strArray = new String[arrayl.size()];
		// arrayl.toArray(strArray);
		// for (int i = 0; i < strArray.length; i++) {
		// w.write(strArray[i]);
		// }
		Character[] chrarray = arrayl.toArray(new Character[0]);
		char[] s = new char[chrarray.length];
		for (int i = 0; i < chrarray.length; ++i)
			s[i] = chrarray[i];
		String word = new String(s);

		w.write(word);
		w.flush();
	}
    /*check words in ararylist are in words in redacted list
     * @param Arraylist
     * @return boolean
     */
	public boolean arraylIsRedacted(ArrayList<Character> ArrayList) {
		String test = "";
		for (int i = 0; i < ArrayList.size(); i++) {
			test += Character.toString(ArrayList.get(i));
		}
		//System.out.println(test);
		return redactedWords.contains(test);

	}
   /*getRedact words store given redacted list into variable name redactedWords
    *@param File
    *@return Collection<String>
    */
	public static Collection<String> getRedactWords(File redact)
			throws FileNotFoundException {
		Scanner in = new Scanner(redact);
		ArrayList<String> redactedWords = new ArrayList<String>();
		while (in.hasNextLine()) {
			String line = in.nextLine();
			redactedWords.add(line);
		}
		return redactedWords;

	}

	@Override
	/* check error when write
	 * (non-Javadoc)
	 * @see java.io.Writer#write(char[], int, int)
	 */
	public void write(char[] arg0, int arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		for (int i = arg1; i < arg2; i++) {
			w.write(arrayl.get(i));
		}
	}
}
