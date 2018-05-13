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
			writer.println("(Field) " + data.GetFields().get(f) + " " + (f.GetX() + 1) + " " + (f.GetY() + 1) + " " + f.getFriction());
		writer.println("--------");
	}
	
	public void ListWorkers()
	{
		for(Worker w : data.GetWorkers())
			if(w.GetField().GetThing() == w && w.GetField().GetWarehouse().GetWorkers().contains(w))
				writer.println("(Worker) " + w.GetName() + " " + (w.GetField().GetX() + 1) + " " + (w.GetField().GetY() + 1) + " " + w.GetPoints());
		writer.println("--------");
	}
	
	public void ListBoxes()
	{
		for(Box b : data.GetWarehouse().GetBoxes())
			writer.println("(Box) " + (b.GetField().GetX() + 1) + " " + (b.GetField().GetY() + 1) + " " + !b.isStucked());
		writer.println("--------");
	}
	
	public void ListWalls()
	{
		for(Wall w : data.GetWalls())
			writer.println("(Wall) " + (w.GetField().GetX() + 1) + " " + (w.GetField().GetY() + 1));
		writer.println("--------");
	}
	
	public void Close()
	{
		if(writer!=null)
			writer.close();
	}
}
