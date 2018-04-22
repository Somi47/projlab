package GameLogic;

import java.util.ArrayList;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

/* Absztrakt mez�, melyen dolgok (Thing) lehetnek rajta.
 * T�bb t�pusa is lehet: kapcsol�, lyuk, padl�, dar�l� 
 */
public abstract class Field extends DebuggedClass {
	/* T�rolja a rajta l�v� dolgokat, a rakt�rat �s
	 * a szomsz�dait. 
	 */
	Thing thing;
	protected int x,y;
	protected Warehouse warehouse;
	protected Field neighbor[] = new Field[5];
	
	/* Mez� s�rl�d�sa
	 * Alapb�l 2, ha m�zes 5, ha olajas 0
	 * (ezt m�g �ll�tgathatjuk)
	 */
	protected int friction = 2;
	
	/* S�rl�d�s be�ll�t�sa */
	public void setFriction(int f) {
		friction = f;
	}
	
	/* S�rl�d�s lek�rdez�se */
	public int getFriction() {
		return friction;
	}
	
	/* Mez� koordin�t�inak be�ll�t�sa */
	public void setcoordinates(int X, int Y) {
		x = X;
		y = Y;
	}
	
	/* x koordin�ta lek�rdez�se */
	public int GetX() {
		return x+1;
	}
	
	/* y koordin�ta lek�rdez�se */
	public int GetY() {
		return y+1;
	}
	
	/* Dolog mez�re helyez�se. */
	public void Add(Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "Add(Thing t)");
		thing = t;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Dolog mez�r�l lev�tele. */
	public void Remove() {
		FunctionLogger.logFunctionCalled(toString(), "Remove()");
		if(thing != null)
			thing = null;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Rakt�r be�ll�t�sa. */
	public void SetWarehouse(Warehouse wh) {
		FunctionLogger.logFunctionCalled(toString(), "SetWarehouse(Warehouse wh)");
		warehouse = wh;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Adott ir�nyba szomsz�dos mez�k list�j�ba mez� felv�tele. */
	public void SetNeighbor(Direction dir, Field n) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(Direction dir, Field n)");
		neighbor[dir.ordinal()] = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Szomsz�dos mez�lista felt�lt�se. */
	public void SetNeighbor(ArrayList<Field> f) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(ArrayList<Field> f)");
		neighbor = (Field[])f.toArray();
		FunctionLogger.logFunctionReturnVoid();
	}
	
	/* Mez�n l�v� dolog lek�rdez�se. */
	public Thing GetThing() {
		FunctionLogger.logFunctionCalled(toString(), "GetThing()");
		return FunctionLogger.logFunctionReturn( thing );
	}
	
	/* Rakt�r lek�rdez�se */
	public Warehouse GetWarehouse() {
		FunctionLogger.logFunctionCalled(toString(), "GetWarehouse()");
		return FunctionLogger.logFunctionReturn( warehouse );
	}
	
	/* Adott ir�nyba l�v� mez� lek�rdez�se */
	public Field GetNeighbor(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor(Direction dir)");
		return FunctionLogger.logFunctionReturn( neighbor[dir.ordinal()] );
	}
	
	/* Szomsz�dos mez�lista lek�rdez�se */
/*	public ArrayList<Field> GetNeighbor() {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor()");
		return FunctionLogger.logFunctionReturn( new ArrayList<Field>() );
	}*/
	
	/* Mez�nek adott ir�nyba dolog �tk�zik.
	 * Megh�vja a dologra az �tk�ztet� f�ggv�nyt �s
	 * visszaadja ennek eredm�ny�t. 
	 */
	
	public boolean HitBy(Direction dir, Worker w, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(thing != null)
			return FunctionLogger.logFunctionReturn( thing.HitBy(dir, w, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
	
	public boolean HitBy(Direction dir, Box b, int force) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(thing != null)
			return FunctionLogger.logFunctionReturn( thing.HitBy(dir, b, force) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
