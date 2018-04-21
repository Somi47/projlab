package GameLogic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;


public class Writer {
	
	private HashMap<Field,String> fields = new HashMap<>();
	private ArrayList<Worker> workers = new ArrayList<>();
	private ArrayList<Box> boxes = new ArrayList<>();
	private ArrayList<Wall> walls = new ArrayList<>();
	
	private PrintWriter writer;
	
	public Writer(String outputfile)
	{
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
	
	public void AddField(Field f,String fieldtype)
	{
		fields.put(f, fieldtype);
	}
	
	public void AddWorker(Worker w)
	{
		if(workers.size() < 2)
		workers.add(w);
	}
	
	public void AddBox(Box b)
	{
		boxes.add(b);
	}
	
	public void AddWall(Wall w)
	{
		walls.add(w);
	}
	
	public void ListFields()
	{
		for(Field f : fields.keySet())
			writer.println("(Field) " + fields.get(f) + " " + f.GetX() + " " + f.GetY() + " " + f.getFriction());
		writer.println("--------");
	}
	
	public void ListWorkers()
	{
		for(Worker w : workers)
			if(w.GetField().GetThing() == w)
				writer.println("(Worker) " + w.GetName() + " " + w.GetField().GetX() + " " + w.GetField().GetY() + " " + w.GetPoints());
		writer.println("--------");
	}
	
	public void ListBoxes()
	{
		for(Box b : boxes)
			writer.println("(Box) " + b.GetField().GetX() + " " + b.GetField().GetY() + " " + !b.isStucked());
		writer.println("--------");
	}
	
	public void ListWalls()
	{
		for(Wall w : walls)
			writer.println("(Wall) " + w.GetField().GetX() + " " + w.GetField().GetY());
		writer.println("--------");
	}
	
	public void Close()
	{
		if(writer!=null)
			writer.close();
	}
}
