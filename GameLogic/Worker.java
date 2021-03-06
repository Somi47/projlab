package GameLogic;

import GraphicApp.DrawableWorker;
import GraphicApp.Program;
import Utility.FunctionLogger;

/* Dolog típusú munkás.
 * Tárolja a nevét és a pontjait. 
 */
public class Worker extends Thing implements Moveable {
	
	private String name;
	private int points = 0;
	private int Force = 6;
	
	public Worker()
	{
		if(Program.mf != null)
		{
			DrawableWorker dw = new DrawableWorker();
			dw.Setworker(this);
			dw.Setpriority(2);
			Program.mf.AddDrawable(dw);
			drawable = dw;
		}
	}
	
	/* Munkás erejének beállítása */
	public void setForce(int f) {
		Force = f;
	}
	
	/* Munkás erejének lekérdezése */
	public int getForce() {
		return Force;
	}
	
	/* Munkás mézet tesz a mezőre amin áll, azaz növeli a súrlódását */
	public void dropHoney() {
		GetField().setFriction(5);
	}
	
	/* Munkás olajat tesz a mezőre amin áll, azaz csökkenti a súrlódását */
	public void dropOil() {
		GetField().setFriction(0);
	}
	
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
		GetField().GetWarehouse().SetWorkerNumber(GetField().GetWarehouse().GetWorkerNumber()-1);
		GetField().GetWarehouse().GetWorkers().remove(this);
		GetField().Remove();
		
		if(Program.mf != null)
		{
			Program.mf.removeDrawable(drawable);
		}
		
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás pontjainak növelése 1-el. */
	public void AddPoint() {
		FunctionLogger.logFunctionCalled(toString(), "AddPoint()");
		points++;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás pontjainak beállítása. */
	public void SetPoints(int p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPoint()");
		points = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Munkás adott irányba mozgatása.
	 * Ha mozoghat az adott irányba, akkor mezõváltás.
	 */
	public boolean Move(Direction dir, int force) {
		FunctionLogger.logFunctionCalled(toString(), "Move(Direction dir)");
		boolean canMove;
		if(GetField().GetNeighbor(dir) != null )
			canMove = GetField().GetNeighbor(dir).HitBy(dir, this, force);
		else
			canMove = false;
		if(canMove) {
			GetField().Remove();
			GetField().GetNeighbor(dir).Add(this);
			SetField(GetField().GetNeighbor(dir));
			return FunctionLogger.logFunctionReturn( true );
		}
		return FunctionLogger.logFunctionReturn( false );
	}
	
	/* Munkásnak adott irányba doboz ütközik.
	 * Ha a munkás nem mozoghat tovább az adott irányba meghal. 
	 */
	@Override
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		boolean canMove = Move(dir, force);
		//canMove = FunctionLogger.askUserDecision("Tud-e mozogni?");
		if(!canMove)
			Die();
		return FunctionLogger.logFunctionReturn( true );
	}
	
	/* Munkásnak adott irányba munkás ütközik.
	 * Hamissal tér vissza. 
	 */
	@Override
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		return FunctionLogger.logFunctionReturn( false );
	}
}
