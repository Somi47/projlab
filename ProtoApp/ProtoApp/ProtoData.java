package ProtoApp;

import java.util.ArrayList;
import java.util.HashMap;

import GameLogic.Box;
import GameLogic.Field;
import GameLogic.Wall;
import GameLogic.Warehouse;
import GameLogic.Worker;

public class ProtoData {

	private Warehouse wh;
	private HashMap<Field,String> fields = new HashMap<>();
	private ArrayList<Worker> workers = new ArrayList<>();
	private ArrayList<Wall> walls = new ArrayList<>();
	

	public void SetWarehouse(Warehouse _wh)
	{
		wh = _wh;
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
	
	public void AddWall(Wall w)
	{
		walls.add(w);
	}
	
	public Warehouse GetWarehouse()
	{
		return wh;
	}
	
	public HashMap<Field,String> GetFields()
	{
		return fields;
	}
	
	public ArrayList<Worker> GetWorkers()
	{
		return workers;
	}

	public ArrayList<Wall> GetWalls()
	{
		return walls;
	}
}
