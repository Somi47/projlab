package GameLogic;

import Utility.FunctionLogger;

/* Dologból típusú fal */
public class Wall extends Thing {

	/* Paraméter nélküli konstruktor. */
	public Wall() {
		SetStucked(true);
	}
	
	/* Falnak adott irányba munkás megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( false );
	}
	
	/* Falnak adott irányba doboz megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		return FunctionLogger.logFunctionReturn( false );
	}
}
