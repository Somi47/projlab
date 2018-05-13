package GameLogic;

import GraphicApp.DrawablePit;
import GraphicApp.Program;
import Utility.FunctionLogger;

/* Mezõ típusú lyuk.
 * Tárolja, hogy nyitott vagy csukott állapotban van e. 
 */
public class Pit extends Field {

	private boolean open;
	
	public Pit()
	{
		if(Program.mf != null)
		{
			DrawablePit dp = new DrawablePit();
			dp.Setpit(this);
			dp.Setpriority(1);
			Program.mf.AddDrawable(dp);
		}
	}
	
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
	
	/* Dolog lyukra helyezése. */
	@Override
	public void Add(Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "Add(Thing t)");
		if(!isOpen())
			thing = t;
		else
			thing = null;
		FunctionLogger.logFunctionReturnVoid();
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
