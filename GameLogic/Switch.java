package GameLogic;

import Utility.FunctionLogger;

/* Mez� t�pus� kapcsol�.
 * T�rolja a hozz� tartoz� lyukat.  
 */
public class Switch extends Field {
	
	private Pit pit;
	
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
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, w)) {
					pit.SetOpen(false);;
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Kapcsol�nak adott ir�nyba doboz �tk�zik.
	 * Ha van rajta valami �tk�zteti vele. Ha r�l�phet kinyitja
	 * a hozz� tartoz� lyukat.
	 */
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, b)) {
					pit.SetOpen(true);;
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			return FunctionLogger.logFunctionReturn( true );
	}
}
