package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunctionLogger {
	private static int tabCount = 0;
	
	// Prints the function call in a formatted way.
	public static void logFunctionCalled(String calledName, String calledFunction) {
		printTabs();
		System.out.println(calledName+"."+calledFunction);
		++tabCount;
	}
	
	public static void logFunctionReturnVoid() {
		--tabCount;
	}
	
	// Prints the function return in a formatted way. Returns with the parameter for easier use.
	public static <T> T logFunctionRetrun(T valueReturned) {
		--tabCount;
		printTabs();
		System.out.println("return: "+valueReturned.toString());
		return valueReturned;
	}
	
	// Asks for a decision from the user in a formatted way.
	public static boolean askUserDecision(String question) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) { // Until we get a valid input.
			printTabs();
			System.out.print(question+" (Yes/No): ");
			
			String input = "";
			try {
				input = br.readLine();
			} catch (IOException e) {
				continue;
			}
			
			if(input.toLowerCase().equals("yes")) {
				return true;
			}
			else if(input.toLowerCase().equals("no")){
				return false;
			}
			// else: We did not get a valid answer.			
		}
	}
	
	// Prints the tabs according to the calling depth.
	private static void printTabs() {
		for(int i=0; i<tabCount; ++i)
			System.out.print('\t');
	}
	
}
