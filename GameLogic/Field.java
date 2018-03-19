package GameLogic;

import java.util.ArrayList;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Absztrakt mezõ, melyen dolgok (Thing) lehetnek rajta.
 * Több típusa is lehet: kapcsoló, lyuk, padló, daráló 
 */
public abstract class Field extends DebuggedClass {
	/* Tárolja a rajta lévõ dolgokat, a raktárat és
	 * a szomszédait. 
	 */
	Thing thing;
	protected Warehouse warehouse;
	protected Field neighbor[] = new Field[5];

	/* Dolog mezõre helyezése. */
	public void Add(Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "Add(Thing t)");
		thing = t;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog mezõrõl levétele. */
	public void Remove() {
		FunctionLogger.logFunctionCalled(toString(), "Remove()");
		if(thing != null)
			thing = null;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Raktár beállítása. */
	public void SetWarehouse(Warehouse wh) {
		FunctionLogger.logFunctionCalled(toString(), "SetWarehouse(Warehouse wh)");
		warehouse = wh;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Adott irányba szomszédos mezõk listájába mezõ felvétele. */
	public void SetNeighbor(Direction dir, Field n) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(Direction dir, Field n)");
		neighbor[dir.ordinal()] = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Szomszédos mezõlista feltöltése. */
	public void SetNeighbor(ArrayList<Field> f) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(ArrayList<Field> f)");
		neighbor = (Field[])f.toArray();
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Mezõn lévõ dolog lekérdezése. */
	public Thing GetThing() {
		FunctionLogger.logFunctionCalled(toString(), "GetThing()");
		return FunctionLogger.logFunctionReturn( thing );
	}
	
	/* Raktár lekérdezése */
	public Warehouse GetWarehouse() {
		FunctionLogger.logFunctionCalled(toString(), "GetWarehouse()");
		return FunctionLogger.logFunctionReturn( warehouse );
	}
	
	/* Adott irányba lévõ mezõ lekérdezése */
	public Field GetNeighbor(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor(Direction dir)");
		return FunctionLogger.logFunctionReturn( neighbor[dir.ordinal()] );
	}
	
	/* Szomszédos mezõlista lekérdezése */
/*	public ArrayList<Field> GetNeighbor() {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor()");
		return FunctionLogger.logFunctionReturn( new ArrayList<Field>() );
	}*/
	
	/* Mezõnek adott irányba dolog ütközik.
	 * Meghívja a dologra az ütköztetõ függvényt és
	 * visszaadja ennek eredményét. 
	 */
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(thing != null)
			return FunctionLogger.logFunctionReturn( thing.HitBy(dir, w) );
		return FunctionLogger.logFunctionReturn( true );
	}
	
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(thing != null)
			return FunctionLogger.logFunctionReturn( thing.HitBy(dir, b) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
