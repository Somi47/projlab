package GameLogic;

import Utility.FunctionLogger;

/* Mezõ típusú lyuk.
 * Tárolja, hogy nyitott vagy csukott állapotban van e. 
 */
public class Pit extends Field {

	private boolean open;
	
	/* Nyitottsági állapot beállítása */
	public void SetOpen(boolean b) {
		FunctionLogger.logFunctionCalled(toString(), "SetOpen(boolean b))");
		open = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Nyitottsági állapot lekérdezése */
	public boolean isOpen() {
		FunctionLogger.logFunctionCalled(toString(), "isOpen()");
		return FunctionLogger.logFunctionReturn( open );
	}
	
	/* Lyuknak adott irányba munkás ütközik.
	 * Ha van rajta dolog ütközteti vele. Ha ráléphet és
	 * nyitva van, megöli a játékost. 
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(open) 
		{
			w.Die();
		}
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Lyuknak adott irányba doboz ütközik.
	 * Ha van rajta dolog ütközteti vele. Ha ráléphet és
	 * nyitva van, elpusztítja a dobozt. 
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		b.CheckStucked(dir);
		if(GetThing() != null)
			if(GetThing().HitBy(dir, b, force))
				if(open) {
					b.Destroy();
					return FunctionLogger.logFunctionReturn( true );
				}
				else
					return FunctionLogger.logFunctionReturn( true );
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			if(open)
			{
				b.Destroy();
			}
			return FunctionLogger.logFunctionReturn( true );
	}
}
