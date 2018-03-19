package GameLogic;

import java.util.ArrayList;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Raktár
 * Tárolja a játékosok számát, pályát alkotó mezõket, 
 * és a pályán lévõ dobozokat. 
 */
public class Warehouse extends DebuggedClass {

	private int workerNumber = 1;
	private ArrayList<Field> fields = new ArrayList<Field>();
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	/* Munkásszám beállítása */
	public void SetWorkerNumber(int n) {
		FunctionLogger.logFunctionCalled(toString(), "SetWorkerNumber(int n)");
		workerNumber = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Mezõk listájának beállítása */
	public void SetFields(ArrayList<Field> f) {
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
	
	/* Mezõlista lekérdezése */
	public ArrayList<Field> GetFields(){
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
	
	/* Játék végének ellenõrzése. 
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
