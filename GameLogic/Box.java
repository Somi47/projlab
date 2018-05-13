package GameLogic;

import GraphicApp.DrawableBox;
import GraphicApp.Program;
import Utility.FunctionLogger;


/* Moveable-bõl leszármazõ doboz osztály */
public class Box extends Thing implements Moveable{
	
	public Box()
	{
		if(Program.mf != null)
		{
			DrawableBox db = new DrawableBox();
			db.Setbox(this);
			db.Setpriority(0);
			Program.mf.AddDrawable(db);
			drawable = db;
		}
	}
	
	/* Doboz elpusztítása.
	 * Lekérdezi a mezõt, amelyiken a doboz áll, majd törli 
	 * a fieldrõl és a raktárból. 
	 * */
	public void Destroy() {
		FunctionLogger.logFunctionCalled(toString(), "Destroy()");
		GetField().Remove();
		GetField().Remove();
		GetField().GetWarehouse().RemoveBox(this);
		
		if(Program.mf != null)
		{
			Program.mf.removeDrawable(drawable);
		}
		
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Doboz adott irányba mozgatása 
	 * Visszaaja hogy a doboz elmozdult-e. A szomszédos mezõn 
	 * álló dologgal ütközteti a dobozt. Ha mozoghat, a szomszédos
	 * mezõre lépteti.
	 */
	public boolean Move(Direction dir, int force) {
		FunctionLogger.logFunctionCalled(toString(), "Move(Direction dir)");
		if(force<0)
			return FunctionLogger.logFunctionReturn(false);
		boolean canMove;

		if(GetField().GetNeighbor(dir) != null )
			canMove = GetField().GetNeighbor(dir).HitBy(dir, this, force);
		else
			canMove = false;
		if(canMove) {
			GetField().Remove();
			GetField().GetNeighbor(dir).Add(this);
			if(GetField().GetNeighbor(dir).GetThing()!=null)
				SetField(GetField().GetNeighbor(dir));
			return FunctionLogger.logFunctionReturn(true);
		}
		return FunctionLogger.logFunctionReturn(false);
	}
	
	/* Doboznak adott irányba másik doboz ütközik.
	 * Visszaadja, hogy a másik doboz mozoghat-e az adott irányba.
	 * Ha be van ragadva hamissal, ha nincs, elmozgatja a dobozt az adott irányba,
	 * ha mozoghat arra igazzal tér vissza. 
	 */
	
	/* Doboz mezőjének beállítása */
	@Override
	public void SetField(Field f) {
		FunctionLogger.logFunctionCalled(toString(), "SetField(Field f)");
		super.SetField(f);
		CheckStucked();
		if(isStucked())
			for(Box b: GetField().GetWarehouse().GetBoxes())
				b.CheckStucked();
		FunctionLogger.logFunctionReturnVoid();
	}
	
	@Override
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		boolean stucked = isStucked();
		if(stucked) {
			return FunctionLogger.logFunctionReturn(false);
		}
		else {
			return FunctionLogger.logFunctionReturn(Move(dir, force - GetField().getFriction()));
		}
	}
	
	/* Doboznak adott irányba munkás ütközik.
	 * Ha a doboz be van ragadva hamissal, ha nincs, akkor, a mozgatás
	 * utáni mozgás eredényével tér vissza. 
	 */
	@Override
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		boolean stucked = isStucked();
		if(stucked) { 
			return FunctionLogger.logFunctionReturn(false);
		}
		else {
			return FunctionLogger.logFunctionReturn(Move(dir, force - GetField().getFriction()));
		}
	}
	
	/* A doboz beragadottságának ellenõrzése az adott irányba. 
	 */
	public void CheckStucked() {		
		FunctionLogger.logFunctionCalled(toString(), "CheckStucked(Direction dir)");
		
		for(int i = 0 ; i < 4 ; i++)
		{
			if(	(GetField().GetNeighbor(Direction.values()[i]) == null 
					|| (GetField().GetNeighbor(Direction.values()[i]) != null && GetField().GetNeighbor(Direction.values()[i]).GetThing() != null && GetField().GetNeighbor(Direction.values()[i]).GetThing().isStucked()))
					&& (GetField().GetNeighbor(Direction.values()[(i+1)>3?0:(i+1)]) == null 
					|| (GetField().GetNeighbor(Direction.values()[(i+1)>3?0:(i+1)]) != null && GetField().GetNeighbor(Direction.values()[(i+1)>3?0:(i+1)]).GetThing() != null && GetField().GetNeighbor(Direction.values()[(i+1)>3?0:(i+1)]).GetThing().isStucked()))
				)
				SetStucked(true);
		}
		
		FunctionLogger.logFunctionReturnVoid();
	}
	
}
