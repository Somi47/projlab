package GraphicApp;

import Utility.FunctionLogger;

public class Program {
	public static void main(String[] args) 
	{
		FunctionLogger.createLog(false);
		Menu menu = new Menu();
		menu.setVisible( true );
	}
}
