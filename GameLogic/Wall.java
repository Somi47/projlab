package GameLogic;

import Utility.FunctionLogger;

/* Dologból típusú fal */
public class Wall extends Thing {

	/* Falnak adott irányba munkás megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( false );
	}
	
	/* Falnak adott irányba doboz megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		b.CheckStucked(dir);
		return FunctionLogger.logFunctionReturn( false );
	}
}
