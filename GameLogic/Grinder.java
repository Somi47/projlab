package GameLogic;

import Utility.FunctionLogger;

/* Mezõ típusú daráló 
 * Tárolja a saját játékosát, akinek számolja a pontjait. 
 */
public class Grinder extends Field {
	
	private Worker player = new Worker();
	
	/* Daráló játékosának beálltása */
	public void SetPlayer(Worker p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPlayer(Worker p)");
		player = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Daráló játékosának lekérdezése */
	public Worker GetPlayer() {
		FunctionLogger.logFunctionCalled(toString(), "GetPlayer()");
		return FunctionLogger.logFunctionReturn( player );
	}

	/* Darálónak adott irányba doboz ütközik 
	 * Ütközteti az esetleg rajta lévõ dologgal, majd ha a
	 * doboz tolható, bedarálja azt és a saját játékosának pontot ad.
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
	
	/* Darálónak adott irányba munkás ütközik.
	 * Ha áll rajta valami, ütközteti vele.
	 */
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, w, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
