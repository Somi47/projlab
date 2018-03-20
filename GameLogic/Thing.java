package GameLogic;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Mez�n l�v� dolgokat reprezent�lja.
 * T�rolja, hogy be vannak-e ragadva �s a mez�t
 * amin a dolog �ll.
 */
public abstract class Thing extends DebuggedClass {
	
	private boolean stucked = false;
	private Field field;

	/* Dolog mez�j�nek be�ll�t�sa */
	public void SetField(Field f) {
		FunctionLogger.logFunctionCalled(toString(), "SetField(Field f)");
		field = f;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog mez�j�nek lek�rdez�se. */
	public Field GetField() {
		FunctionLogger.logFunctionCalled(toString(), "GetField()");
		return FunctionLogger.logFunctionReturn( field );
	}
	
	/* Dolog beragadotts�g�nak be�ll�t�sa */
	public void SetStucked(boolean b) {
		FunctionLogger.logFunctionCalled(toString(), "SetStucked(boolean b)");
		stucked = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog beragadotts�g�nak lek�rdez�se. */
	public boolean isStucked() {
		FunctionLogger.logFunctionCalled(toString(), "isStucked()");
		return FunctionLogger.logFunctionReturn( stucked );
	}
	
	/* Dolognak adott ir�nyb�l egy munk�s �tk�zik.
	 * Alapb�l igazt ad vissza. 
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Dolognak adott ir�nyb�l egy m�sik doboz �tk�zik.
	 * Alapb�l igazt ad vissza. 
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		return FunctionLogger.logFunctionReturn( true );
	}
}
