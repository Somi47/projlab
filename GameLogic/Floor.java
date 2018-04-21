package GameLogic;

import Utility.FunctionLogger;

/* Mezõ típusú egyszerû padló osztály */
public class Floor extends Field {	
	
	/* Dolog adott irányba rá szeretne lépni.
	 * Meghívja a dologra az ütköztetõ függvényt, majd igazat ad vissza. 
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, w, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
	
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		b.CheckStucked(dir);
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, b, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
