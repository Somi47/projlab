package GameLogic;

import Utility.FunctionLogger;

/* Mezõ típusú kapcsoló.
 * Tárolja a hozzá tartozó lyukat.  
 */
public class Switch extends Field {
	
	private Pit pit;
	
	/* Lyuk beállítása */
	public void SetPit(Pit p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPit(Pit p)");
		pit = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Lyuk lekérdezése */
	public Pit GetPit() {
		FunctionLogger.logFunctionCalled(toString(), "GetPit()");
		return FunctionLogger.logFunctionReturn( pit );
	}
	
	/* Kapcsolónak adott irányba munkás ütközik.
	 * Ha van rajta valami ütközteti vele. Ha ráléphet bezárja
	 * a hozzá tartozó lyukat.
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, w, force)) {
					pit.SetOpen(false);
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			pit.SetOpen(false);
			return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Kapcsolónak adott irányba doboz ütközik.
	 * Ha van rajta valami ütközteti vele. Ha ráléphet kinyitja
	 * a hozzá tartozó lyukat.
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		b.CheckStucked(dir);
		if(GetThing() != null)
			if(GetThing().HitBy(dir, b, force)) {
					pit.SetOpen(true);
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			pit.SetOpen(true);
			return FunctionLogger.logFunctionReturn( true );
	}
}
