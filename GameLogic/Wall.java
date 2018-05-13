package GameLogic;

import GraphicApp.DrawableWall;
import GraphicApp.Program;
import Utility.FunctionLogger;

/* Dologb�l t�pus� fal */
public class Wall extends Thing {

	/* Param�ter n�lk�li konstruktor. */
	public Wall() {
		SetStucked(true);
		if(Program.mf != null)
		{
			DrawableWall dw = new DrawableWall();
			dw.Setwall(this);
			dw.Setpriority(2);
			Program.mf.AddDrawable(dw);
			drawable = dw;
		}
	}
	
	/* Falnak adott ir�nyba munk�s megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( false );
	}
	
	/* Falnak adott ir�nyba doboz megy.
	 * Hamist ad vissza.
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		return FunctionLogger.logFunctionReturn( false );
	}
}
