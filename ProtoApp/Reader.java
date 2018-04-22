package ProtoApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import GameLogic.Box;
import GameLogic.Direction;
import GameLogic.Field;
import GameLogic.Floor;
import GameLogic.Grinder;
import GameLogic.Pit;
import GameLogic.Switch;
import GameLogic.Wall;
import GameLogic.Warehouse;
import GameLogic.Worker;

public class Reader {
	Writer w;
	String filename;
	int workers_set = 0;
	
	public Reader(Writer _w, String _filename) {
		w = _w;
		filename = _filename;
	}
	
	public void ReadFile()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));			
		    String line = br.readLine();
		    
		    while (line != null) {
		        ProcessLine(line);
		        line = br.readLine();
		    }
		    
		    br.close();
		}
		catch(IOException e) {
			System.out.println("Error reading file!");
		}
	}
	
	private void ProcessLine(String line)
	{
		String line_coma_nospace = line.replace(", ", ",");
		String line_coma_nospace_noopenbrace = line_coma_nospace.replace("(", ",");
		String line_coma_nospace_nobrace = line_coma_nospace_noopenbrace.replace(")", "");
		String[] tokens = line_coma_nospace_nobrace.split(",");
		
		if(tokens == null || tokens.length <= 0)
		{
			System.out.println("Processing line failed: \"" + line + "\" Skipped!");
			return;
		}
		
		String command = tokens[0];
		/**/ if(command.equalsIgnoreCase("loadWarehouse"))
			LoadWarehouse(tokens);
		else if(command.equalsIgnoreCase("placeField"))
			PlaceFields(tokens);
		else if(command.equalsIgnoreCase("placeThing"))
			PlaceThing(tokens);
		else if(command.equalsIgnoreCase("setWorker"))
			SetWorker(tokens);
		else if(command.equalsIgnoreCase("Step"))
			Step(tokens);
		else if(command.equalsIgnoreCase("dropHoney"))
			DropHoney(tokens);
		else if(command.equalsIgnoreCase("dropOil"))
			DropOil(tokens);
		else if(command.equalsIgnoreCase("listWorkers"))
			ListWorkers(tokens);
		else if(command.equalsIgnoreCase("listBoxes"))
			ListBoxes(tokens);
		else if(command.equalsIgnoreCase("listFields"))
			ListFields(tokens);
		else if(command.equalsIgnoreCase("listWalls"))
			ListWalls(tokens);
		else
		{
			System.out.println("Uknown command: \"" + command + "\" in line: \"" + line + "\" Skipped!");
			return;
		}			
	}
	
	private void LoadWarehouse(String[] tokens)
	{
		if(tokens.length != 4)
		{
			System.out.println("Wrong parameter count for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		int x           = Integer.parseInt(tokens[1]);
		int y           = Integer.parseInt(tokens[2]);
		int playercount = Integer.parseInt(tokens[3]);
		
		w.GetData().SetWarehouse(new Warehouse(x, y, playercount));
	}
	
	private void PlaceFields(String[] tokens)
	{
		if(tokens.length < 4)
		{
			System.out.println("Wrong parameter count for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		Warehouse wh = w.GetData() == null ? null : w.GetData().GetWarehouse();
		if(wh == null)
		{
			System.out.println("Warehouse not initialized before processing command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		String type = tokens[1];
		/**/ if(type.equalsIgnoreCase("floor") && tokens.length == 5)
		{
			Floor created = new Floor();
			
			int x        = Integer.parseInt(tokens[2]);
			int y        = Integer.parseInt(tokens[3]);
			int friction = Integer.parseInt(tokens[4]);
			
			created.setFriction(friction);
			wh.AddField(created, x, y);
			w.GetData().AddField(created, "floor");
		}
		else if(type.equalsIgnoreCase("switch") && tokens.length == 5)
		{
			Switch created = new Switch();
			
			int x        = Integer.parseInt(tokens[2]);
			int y        = Integer.parseInt(tokens[3]);
			int friction = Integer.parseInt(tokens[4]);
			
			created.setFriction(friction);
			wh.AddField(created, x, y);
			w.GetData().AddField(created, "switch");
		}
		else if(type.equalsIgnoreCase("pit") && tokens.length == 5)
		{
			Pit created = new Pit();
			
			int x        = Integer.parseInt(tokens[2]);
			int y        = Integer.parseInt(tokens[3]);
			int open_int = Integer.parseInt(tokens[4]);
			
			boolean open_bool = open_int == 1 ? true : false;
			
			created.SetOpen(open_bool);
			wh.AddField(created, x, y);
			w.GetData().AddField(created, "pit");
		}
		else if(type.equalsIgnoreCase("grinder") && tokens.length == 4)
		{
			Grinder created = new Grinder();
			
			int x = Integer.parseInt(tokens[2]);
			int y = Integer.parseInt(tokens[3]);
			
			wh.AddField(created, x, y);
			w.GetData().AddField(created, "grinder");
		}
		else
		{
			System.out.println("Wrong parameter count or type for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
	}
	
	private void PlaceThing(String[] tokens)
	{
		if(tokens.length != 4)
		{
			System.out.println("Wrong parameter count for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		Warehouse wh = w.GetData() == null ? null : w.GetData().GetWarehouse();
		if(wh == null)
		{
			System.out.println("Warehouse not initialized before processing command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		int x = Integer.parseInt(tokens[2]);
		int y = Integer.parseInt(tokens[3]);
		Field field = wh.GetFields()[x][y];
		if(field == null)
		{
			System.out.println("No Field found while processing command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		String type = tokens[1];
		/**/ if(type.equalsIgnoreCase("worker"))
		{
			Worker created = new Worker();
			field.Add(created);
			created.SetField(field);
			w.GetData().AddWorker(created);
		}
		else if(type.equalsIgnoreCase("box"))
		{
			Box created = new Box();
			field.Add(created);
			created.SetField(field);
			w.GetData().AddBox(created);
		}
		else if(type.equalsIgnoreCase("wall"))
		{
			Wall created = new Wall();
			field.Add(created);
			created.SetField(field);
			w.GetData().AddWall(created);
		}
	}
	
	private void SetWorker(String[] tokens)
	{
		if(tokens.length != 5)
		{
			System.out.println("Wrong parameter count for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		ArrayList<Worker> workers = w.GetData() == null ? null : w.GetData().GetWorkers();
		if(workers == null || workers.size() <= workers_set)
		{
			System.out.println("Worker not found while processing command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		
		Worker worker = workers.get(workers_set++);
		
		int force = Integer.parseInt(tokens[3]);
		int points = Integer.parseInt(tokens[4]);
		
		worker.SetName(tokens[1]);
		// worker.SetColor(tokens[1]); TODO ez még nincs
		worker.setForce(force);
		worker.SetPoints(points);
	}
	
	private void Step(String[] tokens)
	{
		if(tokens.length != 3)
		{
			System.out.println("Wrong parameter count for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		String dir = new String(tokens[2]);
		if(!dir.equals("right") && !dir.equals("left") && !dir.equals("up") && !dir.equals("down"))
		{
			System.out.println("Wrong direction for command: \"" + tokens[0] + "\" Skipped!");
			return;
		}
		for(Worker w : w.GetData().GetWorkers())
			if(w.GetName().equals(tokens[1]))
			{
				if(tokens[2].equals("up"))
					w.Move(Direction.Up, w.getForce());
				if(tokens[2].equals("down"))
					w.Move(Direction.Down, w.getForce());
				if(tokens[2].equals("right"))
					w.Move(Direction.Right, w.getForce());
				if(tokens[2].equals("left"))
					w.Move(Direction.Left, w.getForce());
				return;
			}
		System.out.println("Wrong worker name for command: \"" + tokens[0] + "\" Skipped!");
	}
	
	private void DropHoney(String[] tokens)
	{
		
	}
	
	private void DropOil(String[] tokens)
	{
		
	}
	
	private void ListWorkers(String[] tokens)
	{
		w.ListWorkers();
	}
	
	private void ListBoxes(String[] tokens)
	{
		w.ListBoxes();
	}
	
	private void ListFields(String[] tokens)
	{
		w.ListFields();
	}
	
	private void ListWalls(String[] tokens)
	{
		w.ListWalls();
	}
}
