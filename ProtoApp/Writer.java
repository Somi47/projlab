package ProtoApp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import GameLogic.Box;
import GameLogic.Field;
import GameLogic.Wall;
import GameLogic.Worker;


public class Writer {
	private ProtoData data;	
	private PrintWriter writer;
	
	public Writer(ProtoData _data, String outputfile)
	{
		data = _data;
		try 
		{
			writer = new PrintWriter(outputfile, "UTF-8");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ProtoData GetData()
	{
		return data;
	}
	
	public void ListFields()
	{
		for(Field f : data.GetFields().keySet())
			writer.println("(Field) " + data.GetFields().get(f) + " " + f.GetX() + " " + f.GetY() + " " + f.getFriction());
		writer.println("--------");
	}
	
	public void ListWorkers()
	{
		for(Worker w : data.GetWorkers())
			if(w.GetField().GetThing() == w)
				writer.println("(Worker) " + w.GetName() + " " + w.GetField().GetX() + " " + w.GetField().GetY() + " " + w.GetPoints());
		writer.println("--------");
	}
	
	public void ListBoxes()
	{
		for(Box b : data.GetBoxes())
			writer.println("(Box) " + b.GetField().GetX() + " " + b.GetField().GetY() + " " + !b.isStucked());
		writer.println("--------");
	}
	
	public void ListWalls()
	{
		for(Wall w : data.GetWalls())
			writer.println("(Wall) " + w.GetField().GetX() + " " + w.GetField().GetY());
		writer.println("--------");
	}
	
	public void Close()
	{
		if(writer!=null)
			writer.close();
	}
}
