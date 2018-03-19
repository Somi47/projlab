package GameLogic;

import Utility.FunctionLogger;

/* Mez� t�pus� egyszer� padl� oszt�ly */
public class Floor extends Field {	
	
	/* Dolog adott ir�nyba r� szeretne l�pni.
	 * Megh�vja a dologra az �tk�ztet� f�ggv�nyt, majd igazat ad vissza. 
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
