package GameLogic;

import Utility.FunctionLogger;


/* Moveable-bõl leszármazõ doboz osztály */
public class Box extends Thing implements Moveable{
	
	/* Doboz elpusztítása.
	 * Lekérdezi a mezõt, amelyiken a doboz áll, majd törli 
	 * a fieldrõl és a raktárból. 
	 * */
	public void Destroy() {
		FunctionLogger.logFunctionCalled(toString(), "Destroy()");
		GetField().Remove();
		GetField().GetWarehouse().RemoveBox(this);
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
		
		boolean canMove = GetField().GetNeighbor(dir).HitBy(dir, this, force);
		if(canMove) {
			GetField().Remove();
			GetField().GetNeighbor(dir).Add(this);
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
	@Override
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		boolean stucked = isStucked();
		if(stucked) {
			b.CheckStucked(dir);			
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
	public void CheckStucked(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "CheckStucked(Direction dir)");
		if(dir == Direction.Left || dir == Direction.Right)
		{			
			boolean stuckedUp  =  true;
			Field upNeighbor = null;
			if(GetField().GetNeighbor(Direction.Up)!= null)
				upNeighbor = GetField().GetNeighbor(Direction.Up).GetNeighbor(Direction.Up);

			if(upNeighbor != null)
			{
				if(upNeighbor.GetThing() != null)
				{
					stuckedUp = upNeighbor.GetThing().isStucked();
				}
			}
			
			boolean stuckedDown  =  true;
			Field downNeighbor = null;
			if(GetField().GetNeighbor(Direction.Down)!= null)
				downNeighbor = GetField().GetNeighbor(Direction.Down).GetNeighbor(Direction.Down);
			if(downNeighbor != null)
			{
				if(downNeighbor.GetThing() != null)
				{
					stuckedUp = downNeighbor.GetThing().isStucked();
				}
			}
			
			if(stuckedUp || stuckedDown || upNeighbor ==null || downNeighbor == null )
				SetStucked(true);
		}
		else // if(dir == Direction.Up || dir == Direction.Down)
		{
			boolean stuckedLeft  =  true;
			Field leftNeighbor = null;
			if(GetField().GetNeighbor(Direction.Left)!= null)
				leftNeighbor = GetField().GetNeighbor(Direction.Left).GetNeighbor(Direction.Left);
			if(leftNeighbor != null)
			{
				if(leftNeighbor.GetThing() != null)
				{
					stuckedLeft = leftNeighbor.GetThing().isStucked();
				}
			}
			
			boolean stuckedRight  =  true;
			Field rightNeighbor = null;
				if(GetField().GetNeighbor(Direction.Right)!= null)
					rightNeighbor = GetField().GetNeighbor(Direction.Right).GetNeighbor(Direction.Right);
			if(rightNeighbor != null)
			{
				if(rightNeighbor.GetThing() != null)
				{
					stuckedRight = rightNeighbor.GetThing().isStucked();
				}
			}
			
			
			if(stuckedLeft || stuckedRight || rightNeighbor == null || leftNeighbor == null )
				SetStucked(true);
		}
		FunctionLogger.logFunctionReturnVoid();
	}
	
}
