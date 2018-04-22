package GameLogic;

import java.util.ArrayList;

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
		FunctionLogger.logFunctionReturnVoid();
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
