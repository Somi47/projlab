package GameLogic;

import GraphicApp.DrawableGrinder;
import GraphicApp.Program;
import Utility.FunctionLogger;

/* Mez� t�pus� dar�l� 
 * T�rolja a saj�t j�t�kos�t, akinek sz�molja a pontjait. 
 */
public class Grinder extends Field {
	
	private Worker player = new Worker();
	
	public Grinder()
	{
		if(Program.mf != null)
		{
			DrawableGrinder dg = new DrawableGrinder();
			dg.Setgrinder(this);
			dg.Setpriority(1);
			Program.mf.AddDrawable(dg);
		}
	}
	
	/* Dar�l� j�t�kos�nak be�llt�sa */
	public void SetPlayer(Worker p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPlayer(Worker p)");
		player = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dar�l� j�t�kos�nak lek�rdez�se */
	public Worker GetPlayer() {
		FunctionLogger.logFunctionCalled(toString(), "GetPlayer()");
		return FunctionLogger.logFunctionReturn( player );
	}

	/* Dar�l�nak adott ir�nyba doboz �tk�zik 
	 * �tk�zteti az esetleg rajta l�v� dologgal, majd ha a
	 * doboz tolhat�, bedar�lja azt �s a saj�t j�t�kos�nak pontot ad.
	 * */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, b, force)) {
				b.Destroy();
				player.AddPoint();
				return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
		{
			b.Destroy();
			player.AddPoint();
		}
			return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Dar�l�nak adott ir�nyba munk�s �tk�zik.
	 * Ha �ll rajta valami, �tk�zteti vele.
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, w, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
