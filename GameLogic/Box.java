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
	public boolean Move(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "Move(Direction dir)");
		boolean canMove = GetField().GetNeighbor(dir).HitBy(dir, this);
		if(canMove) {
			GetField().Remove();
			GetField().GetNeighbor(dir).Add(this);
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
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		boolean stucked = isStucked();
		if(stucked) {
			b.CheckStucked(dir);			
			return FunctionLogger.logFunctionReturn(false);
		}
		else {
			return FunctionLogger.logFunctionReturn(Move(dir));
		}
	}
	
	/* Doboznak adott irányba munkás ütközik.
	 * Ha a doboz be van ragadva hamissal, ha nincs, akkor, a mozgatás
	 * utáni mozgás eredényével tér vissza. 
	 */
	@Override
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		boolean stucked = isStucked();
		if(stucked) { 
			return FunctionLogger.logFunctionReturn(false);
		}
		else {
			return FunctionLogger.logFunctionReturn(Move(dir));
		}
	}
	
	/* A doboz beragadottságának ellenõrzése az adott irányba. 
	 */
	public void CheckStucked(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "CheckStucked(Direction dir)");
		if(dir == Direction.Left || dir == Direction.Right)
		{			
			boolean stuckedUp  =  true;
			Field upNeighbor = GetField().GetNeighbor(Direction.Up);
			if(upNeighbor != null)
			{
				if(upNeighbor.GetThing() != null)
				{
					stuckedUp = upNeighbor.GetThing().isStucked();
				}
			}
			
			boolean stuckedDown  =  true;
			Field downNeighbor = GetField().GetNeighbor(Direction.Down);
			if(downNeighbor != null)
			{
				if(downNeighbor.GetThing() != null)
				{
					stuckedUp = downNeighbor.GetThing().isStucked();
				}
			}
			
			if(stuckedUp || stuckedDown)
				SetStucked(true);
		}
		else // if(dir == Direction.Up || dir == Direction.Down)
		{
			boolean stuckedLeft  =  true;
			Field leftNeighbor = GetField().GetNeighbor(Direction.Left);
			if(leftNeighbor != null)
			{
				if(leftNeighbor.GetThing() != null)
				{
					stuckedLeft = leftNeighbor.GetThing().isStucked();
				}
			}
			
			boolean stuckedRight  =  true;
			Field rightNeighbor = GetField().GetNeighbor(Direction.Right);
			if(rightNeighbor != null)
			{
				if(rightNeighbor.GetThing() != null)
				{
					stuckedRight = rightNeighbor.GetThing().isStucked();
				}
			}
			
			
			if(stuckedLeft || stuckedRight)
				SetStucked(true);
		}
		FunctionLogger.logFunctionReturnVoid();
	}
	
}
