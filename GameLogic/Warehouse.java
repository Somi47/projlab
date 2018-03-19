package GameLogic;

import java.util.ArrayList;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Rakt�r
 * T�rolja a j�t�kosok sz�m�t, p�ly�t alkot� mez�ket, 
 * �s a p�ly�n l�v� dobozokat. 
 */
public class Warehouse extends DebuggedClass {

	private int workerNumber = 1;
	private ArrayList<Field> fields = new ArrayList<Field>();
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	/* Munk�ssz�m be�ll�t�sa */
	public void SetWorkerNumber(int n) {
		FunctionLogger.logFunctionCalled(toString(), "SetWorkerNumber(int n)");
		workerNumber = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Mez�k list�j�nak be�ll�t�sa */
	public void SetFields(ArrayList<Field> f) {
		FunctionLogger.logFunctionCalled(toString(), "SetFields(ArrayList<Field> f)");
		fields = f;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dobozok list�j�nak be�ll�t�sa */
	public void SetBoxes(ArrayList<Box> b) {
		FunctionLogger.logFunctionCalled(toString(), "SetBoxes(ArrayList<Box> b)");
		boxes = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munk�sok sz�m�nak lek�rdez�se */
	public int GetWorkerNumber() {
		FunctionLogger.logFunctionCalled(toString(), "GetWorkerNumber()");
		return FunctionLogger.logFunctionReturn( workerNumber );
	}
	
	/* Dobozlista lek�rdez�se */
	public ArrayList<Box> GetBoxes(){
		FunctionLogger.logFunctionCalled(toString(), "GetBoxes()");
		return FunctionLogger.logFunctionReturn( boxes );
	}
	
	/* Mez�lista lek�rdez�se */
	public ArrayList<Field> GetFields(){
		FunctionLogger.logFunctionCalled(toString(), "GetFields()");
		return FunctionLogger.logFunctionReturn( fields );
	}
	
	/* Adott doboz a dobozlist�b�l t�rl�se */
	public void RemoveBox(Box b) {
		FunctionLogger.logFunctionCalled(toString(), "RemoveBox(Box b)");
		boxes.remove(b);
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Rakt�r inici�liz�l�sa */
	public void Initialize() {
		FunctionLogger.logFunctionCalled(toString(), "Initialize()");
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* J�t�k v�g�nek ellen�rz�se. 
	 * Ha elfogytak a munk�sok vagy a dobozok, vagy
	 * minden doboz beragadt akkor v�ge a j�t�knak. 
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
	
	/* J�t�k v�ge */
	public void EndGame() {
		FunctionLogger.logFunctionCalled(toString(), "EndGame()");
		FunctionLogger.logFunctionReturnVoid();
	}	
}
