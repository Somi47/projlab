package ProtoApp;

import Utility.FunctionLogger;

public class Program {

	public static void main(String[] args) 
	{
		FunctionLogger.createLog(false);		
		int testcount = args.length;
		for(int i = 0; i < testcount; ++i)
		{
			ProtoData data = new ProtoData();
			Writer w = new Writer(data,"test_outputs\\" + args[i]);
			Reader r = new Reader(w,"test_inputs\\" + args[i]);
			r.ReadFile();
			w.Close();
		}
	}
}
