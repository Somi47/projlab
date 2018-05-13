package GameLogic;

import GraphicApp.DrawableSwitch;
import GraphicApp.Program;
import Utility.FunctionLogger;

/* Mez� t�pus� kapcsol�.
 * T�rolja a hozz� tartoz� lyukat.  
 */
public class Switch extends Field {
	
	private Pit pit;
	
	public Switch()
	{
		if(Program.mf != null)
		{
			DrawableSwitch ds = new DrawableSwitch();
			ds.Setswitch(this);
			ds.Setpriority(1);
			Program.mf.AddDrawable(ds);
		}
	}
	
	/* Lyuk be�ll�t�sa */
	public void SetPit(Pit p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPit(Pit p)");
		pit = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Lyuk lek�rdez�se */
	public Pit GetPit() {
		FunctionLogger.logFunctionCalled(toString(), "GetPit()");
		return FunctionLogger.logFunctionReturn( pit );
	}
	
	/* Kapcsol�nak adott ir�nyba munk�s �tk�zik.
	 * Ha van rajta valami �tk�zteti vele. Ha r�l�phet bez�rja
	 * a hozz� tartoz� lyukat.
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
	
	/* Kapcsol�nak adott ir�nyba doboz �tk�zik.
	 * Ha van rajta valami �tk�zteti vele. Ha r�l�phet kinyitja
	 * a hozz� tartoz� lyukat.
	 */
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
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
