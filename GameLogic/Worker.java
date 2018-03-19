package GameLogic;

import Utility.FunctionLogger;

/* Dolog típusú munkás.
 * Tárolja a nevét és a pontjait. 
 */
public class Worker extends Thing implements Moveable {
	
	private String name;
	private int points = 0;
	
	/* Munkás nevének beállítása */
	public void SetName(String n) {
		FunctionLogger.logFunctionCalled(toString(), "SetName(String n)");
		name = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás nevének lekérdezése */
	public String GetName() {
		FunctionLogger.logFunctionCalled(toString(), "GetName()");
		return FunctionLogger.logFunctionReturn( name );
	}
	
	/* Munkás pontjainak lekérdezése */
	public int GetPoints() {
		FunctionLogger.logFunctionCalled(toString(), "GetPoints()");
		return FunctionLogger.logFunctionReturn( points );
	}
	
	/* Munkás meghal.
	 * Törlõdik a mezõrõl és a raktár nyílvántartásából
	 */
	public void Die() {
		FunctionLogger.logFunctionCalled(toString(), "Die()");
		GetField().Remove();
		GetField().GetWarehouse().SetWorkerNumber(GetField().GetWarehouse().GetWorkerNumber()-1);
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás pontjainak növelése 1-el. */
	public void AddPoint() {
		FunctionLogger.logFunctionCalled(toString(), "AddPoint()");
		points++;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás adott irányba mozgatása.
	 * Ha mozoghat az adott irányba, akkor mezõváltás.
	 */
	public boolean Move(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "Move(Direction dir)");
		boolean canMove = GetField().GetNeighbor(dir).HitBy(dir, this);
		if(canMove) {
			GetField().Remove();
			GetField().GetNeighbor(dir).Add(this);
			return FunctionLogger.logFunctionReturn( true );
		}
		return FunctionLogger.logFunctionReturn( false );
	}
	
	/* Munkásnak adott irányba doboz ütközik.
	 * Ha a munkás nem mozoghat tovább az adott irányba meghal. 
	 */
	@Override
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		boolean canMove = Move(dir);
		canMove = FunctionLogger.askUserDecision("Tud-e mozogni?");
		if(!canMove)
			Die();
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Munkásnak adott irányba munkás ütközik.
	 * Hamissal tér vissza. 
	 */
	@Override
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( false );
	}
}
