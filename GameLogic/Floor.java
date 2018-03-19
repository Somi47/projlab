package GameLogic;

import Utility.FunctionLogger;

/* Mezõ típusú egyszerû padló osztály */
public class Floor extends Field {	
	
	/* Dolog adott irányba rá szeretne lépni.
	 * Meghívja a dologra az ütköztetõ függvényt, majd igazat ad vissza. 
	 */
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, w) );
		return FunctionLogger.logFunctionReturn( true );
	}
	
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, b) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
