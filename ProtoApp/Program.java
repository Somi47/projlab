package ProtoApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public static void main(String[] args) 
	{
		/* Test tokenize
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
			String line	= br.readLine();
			
			String line_coma_nospace = line.replace(", ", ",");
			String line_coma_nospace_noopenbrace = line_coma_nospace.replace("(", ",");
			String line_coma_nospace_nobrace = line_coma_nospace_noopenbrace.replace(")", "");
			String[] tokens = line_coma_nospace_nobrace.split(",");
			for(int i = 0; i<tokens.length; ++i)
				System.out.println(tokens[i]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

		int testcount = 1;
		for(int i = 1; i <= testcount; ++i)
		{
			ProtoData data = new ProtoData();
			Writer w = new Writer(data,"test_outputs\\" + (args.length>1?args[1]:args[0].concat("_out"))  + ".txt");
			Reader r = new Reader(w,"test_inputs\\" +  args[0] + ".txt");
			r.ReadFile();
			w.Close();
		}
	}
}
