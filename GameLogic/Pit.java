package GameLogic;

import Utility.FunctionLogger;

/* Mez� t�pus� lyuk.
 * T�rolja, hogy nyitott vagy csukott �llapotban van e. 
 */
public class Pit extends Field {

	private boolean open;
	
	/* Nyitotts�gi �llapot be�ll�t�sa */
	public void SetOpen(boolean b) {
		FunctionLogger.logFunctionCalled(toString(), "SetOpen(boolean b))");
		open = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Nyitotts�gi �llapot lek�rdez�se */
	public boolean isOpen() {
		FunctionLogger.logFunctionCalled(toString(), "isOpen()");
		return FunctionLogger.logFunctionReturn( open );
	}
	
	/* Lyuknak adott ir�nyba munk�s �tk�zik.
	 * Ha van rajta dolog �tk�zteti vele. Ha r�l�phet �s
	 * nyitva van, meg�li a j�t�kost. 
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(open) 
		{
			w.Die();
		}
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Lyuknak adott ir�nyba doboz �tk�zik.
	 * Ha van rajta dolog �tk�zteti vele. Ha r�l�phet �s
	 * nyitva van, elpuszt�tja a dobozt. 
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
