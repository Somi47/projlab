package GameLogic;

import GraphicApp.Drawable;
import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Mezõn lévõ dolgokat reprezentálja.
 * Tárolja, hogy be vannak-e ragadva és a mezõt
 * amin a dolog áll.
 */
public abstract class Thing extends DebuggedClass {
	protected Drawable drawable;
	
	private boolean stucked = false;
	private Field field;

	/* Dolog mezõjének beállítása */
	public void SetField(Field f) {
		FunctionLogger.logFunctionCalled(toString(), "SetField(Field f)");
		field = f;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog mezõjének lekérdezése. */
	public Field GetField() {
		FunctionLogger.logFunctionCalled(toString(), "GetField()");
		return FunctionLogger.logFunctionReturn( field );
	}
	
	/* Dolog beragadottságának beállítása */
	public void SetStucked(boolean b) {
		FunctionLogger.logFunctionCalled(toString(), "SetStucked(boolean b)");
		stucked = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog beragadottságának lekérdezése. */
	public boolean isStucked() {
		FunctionLogger.logFunctionCalled(toString(), "isStucked()");
		return FunctionLogger.logFunctionReturn( stucked );
	}
	
	/* Dolognak adott irányból egy munkás ütközik.
	 * Alapból igazt ad vissza. 
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Dolognak adott irányból egy másik doboz ütközik.
	 * Alapból igazt ad vissza. 
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		return FunctionLogger.logFunctionReturn( true );
	}
}
