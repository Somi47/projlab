package GameLogic;

import java.util.ArrayList;
import java.util.Random;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Raktár
 * Tárolja a játékosok számát, pályát alkotó mezőket, 
 * és a pályán lévő dobozokat. 
 */
public class Warehouse extends DebuggedClass {

	private int workerNumber = 1;
	private Field[][] fields;
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private ArrayList<Worker> workers = new ArrayList<Worker>();
	
	
	/* Harom parameteres konstruktor */
	public Warehouse(int x, int y, int wn){
		fields = new Field[x][y];
		SetWorkerNumber(wn);
	}
	
	/* Mezõ felvétele a raktárba */
	public void AddField(Field f, int x, int y) {
		fields[x][y] = f;
		
		if(x == 0)
			f.SetNeighbor(Direction.Left,null);
		
		if(x == fields.length-1)
			f.SetNeighbor(Direction.Right,null);
		
		if(y == 0)
			f.SetNeighbor(Direction.Up,null);
		
		if(x == fields[0].length-1)
			f.SetNeighbor(Direction.Down,null);
		
		if(x >= 1 && fields[x-1][y] != null)
		{
			f.SetNeighbor(Direction.Left,fields[x-1][y]);
			fields[x-1][y].SetNeighbor(Direction.Right,f);
		}
		
		if(x < fields.length-1 && fields[x+1][y] != null)
		{
			f.SetNeighbor(Direction.Right,fields[x+1][y]);
			fields[x+1][y].SetNeighbor(Direction.Left,f);
		}
		
		if(y < fields[0].length-1 && fields[x][y+1] != null)
		{
			f.SetNeighbor(Direction.Down,fields[x][y+1]);
			fields[x][y+1].SetNeighbor(Direction.Up,f);
		}
		
		if(y >= 1 && fields[x][y-1] != null)
		{
			f.SetNeighbor(Direction.Up,fields[x][y-1]);
			fields[x][y-1].SetNeighbor(Direction.Down,f);
		}
		
		f.setcoordinates(x, y);
	}
	
	/* Munkásszám beállítása */
	public void SetWorkerNumber(int n) {
		FunctionLogger.logFunctionCalled(toString(), "SetWorkerNumber(int n)");
		workerNumber = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Mezők mártixának beállítása */
	public void SetFields(Field[][] f) {
		FunctionLogger.logFunctionCalled(toString(), "SetFields(ArrayList<Field> f)");
		fields = f;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dobozok listájának beállítása */
	public void SetBoxes(ArrayList<Box> b) {
		FunctionLogger.logFunctionCalled(toString(), "SetBoxes(ArrayList<Box> b)");
		boxes = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munk�sok listájának beállítása */
	public void SetWorkers(ArrayList<Worker> w) {
		FunctionLogger.logFunctionCalled(toString(), "SetWorkers(ArrayList<Worker> w)");
		workers = w;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkások számának lekérdezése */
	public int GetWorkerNumber() {
		FunctionLogger.logFunctionCalled(toString(), "GetWorkerNumber()");
		return FunctionLogger.logFunctionReturn( workerNumber );
	}
	
	/* Dobozlista lekérdezése */
	public ArrayList<Box> GetBoxes(){
		FunctionLogger.logFunctionCalled(toString(), "GetBoxes()");
		return FunctionLogger.logFunctionReturn( boxes );
	}
	
	/* Munk�slista lekérdezése */
	public ArrayList<Worker> GetWorkers(){
		FunctionLogger.logFunctionCalled(toString(), "GetWorkers()");
		return FunctionLogger.logFunctionReturn( workers );
	}
	
	/* Mezőmátrix lekérdezése */
	public Field[][] GetFields(){
		FunctionLogger.logFunctionCalled(toString(), "GetFields()");
		return FunctionLogger.logFunctionReturn( fields );
	}
	
	/* Adott doboz a dobozlistából törlése */
	public void RemoveBox(Box b) {
		FunctionLogger.logFunctionCalled(toString(), "RemoveBox(Box b)");
		boxes.remove(b);
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Raktár iniciálizálása */
	public void Initialize() {
		FunctionLogger.logFunctionCalled(toString(), "Initialize()");
		if(workerNumber != 1 && workerNumber != 2)
		{
			FunctionLogger.logFunctionReturnVoid();
			return;
		}
		
		int y = fields.length;
		int x = fields[0].length;
		
		if( x != 10 || y != 10)
		{
			FunctionLogger.logFunctionReturnVoid();
			return;
		}
		
		// körben a fal létrehozása
		// felső sor
		for(int i = 0; i < x; ++i)
		{
			Floor floor = new Floor();
			floor.Add(new Wall());
			AddField(floor, 0, i);
		}
		
		// alsó sor
		for(int i = 0; i < x; ++i)
		{
			Floor floor = new Floor();
			floor.Add(new Wall());
			AddField(floor, y-1, i);
		}
		
		// bal oszlop
		for(int i = 1; i < y - 1; ++i)
		{
			Floor floor = new Floor();
			floor.Add(new Wall());
			AddField(floor, i, 0);
		}
		
		// jobb oszlop
		for(int i = 1; i < y - 1; ++i)
		{
			Floor floor = new Floor();
			floor.Add(new Wall());
			AddField(floor, i, x-1);
		}
		
		// közbülső falak
		Floor floor;
		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 1, 3);

		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 2, 3);

		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 3, 1);
		
		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 3, 6);
		
		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 3, 7);
		
		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 4, 7);
		
		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 5, 3);

		floor = new Floor();
		floor.Add(new Wall());
		AddField(floor, 6, 3);
		
		// üres mezők, amiken rendom doboz lehet
		CreateFloorRandomBox(1, 1);
		CreateFloorRandomBox(1, 4);
		CreateFloorRandomBox(1, 5);
		CreateFloorRandomBox(1, 6);
		CreateFloorRandomBox(1, 8);
		
		CreateFloorRandomBox(2, 1);
		CreateFloorRandomBox(2, 2);
		CreateFloorRandomBox(2, 4);
		CreateFloorRandomBox(2, 5);
		CreateFloorRandomBox(2, 6);
		CreateFloorRandomBox(2, 7);
		
		CreateFloorRandomBox(3, 2);
		CreateFloorRandomBox(3, 4);
		CreateFloorRandomBox(3, 5);
		
		CreateFloorRandomBox(4, 1);
		CreateFloorRandomBox(4, 2);
		CreateFloorRandomBox(4, 3);
		CreateFloorRandomBox(4, 7);
		CreateFloorRandomBox(4, 8);
		
		CreateFloorRandomBox(5, 1);
		CreateFloorRandomBox(5, 2);
		CreateFloorRandomBox(5, 4);
		CreateFloorRandomBox(5, 5);
		CreateFloorRandomBox(5, 6);
		CreateFloorRandomBox(5, 7);
		CreateFloorRandomBox(5, 8);
		
		CreateFloorRandomBox(6, 2);
		CreateFloorRandomBox(6, 4);
		CreateFloorRandomBox(6, 5);
		CreateFloorRandomBox(6, 6);
		CreateFloorRandomBox(6, 7);
		CreateFloorRandomBox(6, 8);

		CreateFloorRandomBox(7, 1);
		CreateFloorRandomBox(7, 2);
		CreateFloorRandomBox(7, 3);
		CreateFloorRandomBox(7, 4);
		CreateFloorRandomBox(7, 5);
		CreateFloorRandomBox(7, 6);
		CreateFloorRandomBox(7, 7);
		CreateFloorRandomBox(7, 8);

		CreateFloorRandomBox(8, 1);
		CreateFloorRandomBox(8, 2);
		CreateFloorRandomBox(8, 3);
		CreateFloorRandomBox(8, 4);
		CreateFloorRandomBox(8, 5);
		CreateFloorRandomBox(8, 6);
		CreateFloorRandomBox(8, 7);
		CreateFloorRandomBox(8, 8);
		
		// switches and pits
		Pit pit1 = new Pit();
		AddField(pit1, 3, 3);

		Pit pit2 = new Pit();
		AddField(pit2, 3, 8);
		
		Switch switch1 = new Switch();
		switch1.SetPit(pit1);
		AddField(switch1, 1, 7);
		
		Switch switch2 = new Switch();
		switch2.SetPit(pit2);
		AddField(switch2, 6, 1);
		
		// Workers and grinders
		Worker worker1 = new Worker();
		floor = new Floor();
		floor.Add(worker1);
		AddField(floor, 4, 4);
		workers.add(worker1);
		
		Grinder grinder1 = new Grinder();
		AddField(grinder1, 1, 2);
		
		if(workerNumber == 2)
		{
			Worker worker2 = new Worker();
			floor = new Floor();
			floor.Add(worker2);
			AddField(floor, 4, 5);
			workers.add(worker2);
			
			Grinder grinder2 = new Grinder();
			AddField(grinder2, 2, 8);
		}
		
		FunctionLogger.logFunctionReturnVoid();
	}
	
	private void CreateFloorRandomBox(int x, int y)
	{
		Random rand = new Random();
		
		Floor floor = new Floor();
		if(rand.nextInt(5) == 0)
		{
			Box box = new Box();
			floor.Add(box);
			boxes.add(box);
		}
			
		AddField(floor, x, y);
	}
	
	/* Játék végének ellenőrzése.
	 * Ha elfogytak a munkások vagy a dobozok, vagy
	 * minden doboz beragadt akkor vége a játéknak.  
	 */
	public void CheckEndGame() {
		FunctionLogger.logFunctionCalled(toString(), "CheckEndGame()");
		if(workerNumber == 0)
			EndGame();
		
		if(boxes.isEmpty())
			EndGame();
		
		for(Box b : boxes)
			if(!b.isStucked()) {
				FunctionLogger.logFunctionReturnVoid();
				return;
			}
		
		EndGame();
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Játék vége */
	public void EndGame() {
		FunctionLogger.logFunctionCalled(toString(), "EndGame()");
		FunctionLogger.logFunctionReturnVoid();
	}	
}
