package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunctionLogger {
	private static boolean createLog = true;	
	private static int tabCount = 0;
	
	
	public static void createLog(boolean cl)
	{
		createLog = cl;
	}
	
	// Prints the function call in a formatted way.
	public static void logFunctionCalled(String calledName, String calledFunction) {
		if(!createLog)
			return;			
		
		printTabs();
		System.out.println(calledName+"."+calledFunction);
		++tabCount;
	}
	
	public static void logFunctionReturnVoid() {
		if(!createLog)
			return;
		
		--tabCount;
	}
	
	// Prints the function return in a formatted way. Returns with the parameter for easier use.
	public static <T> T logFunctionReturn(T valueReturned) {
		if(!createLog)
			return valueReturned;
		
		--tabCount;
		printTabs();
		if(valueReturned != null)
			System.out.println("return: "+valueReturned.toString());
		return valueReturned;
	}
	
	// Asks for a decision from the user in a formatted way.
	public static boolean askUserDecision(String question) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) { // Until we get a valid input.
			printTabs();
			System.out.print(question+" (T/F): ");
			
			String input = "";
			try {
				input = br.readLine();
			} catch (IOException e) {
				continue;
			}
			
			if(input.toLowerCase().equals("t")) {
				return true;
			}
			else if(input.toLowerCase().equals("f")){
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
