import java.io.*;


public class Nuke2 {

	public static void main(String[] args) throws Exception {
		BufferedReader keyboard;
		String inputLine;
	    keyboard = new BufferedReader(new InputStreamReader(System.in));
		// System.out.print("Please enter t ");
	    // System.out.flush();        /* Make sure the line is printed immediately. */
	    System.out.println("Put it back!");
	    inputLine = keyboard.readLine();
	    String firstString, remainingString;
	    firstString=inputLine.substring(0, 1);
	    remainingString=inputLine.substring(2);
	    System.out.print(firstString+remainingString);
	}

}
