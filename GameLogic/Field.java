package GameLogic;

import java.util.ArrayList;

import Utility.DebuggedClass;
import Utility.FunctionLogger;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 6projlab
//  @ File Name : Field.java
//  @ Date : 2018.03.17.
//  @ Author : Gy�ngy�si P�ter
//
//




public abstract class Field extends DebuggedClass {
	
	Thing thing;
	protected Warehouse warehouse;
	protected Field neighbor[] = new Field[5];

	public void Add(Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "Add(Thing t)");
		thing = t;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public void Remove() {
		FunctionLogger.logFunctionCalled(toString(), "Remove()");
		if(thing != null)
			thing = null;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public void SetWarehouse(Warehouse wh) {
		FunctionLogger.logFunctionCalled(toString(), "SetWarehouse(Warehouse wh)");
		warehouse = wh;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public void SetNeighbor(Direction dir, Field n) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(Direction dir, Field n)");
		neighbor[dir.ordinal()] = n;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public void SetNeighbor(ArrayList<Field> f) {
		FunctionLogger.logFunctionCalled(toString(), "SetNeighbor(ArrayList<Field> f)");
		neighbor = (Field[])f.toArray();
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public Thing GetThing() {
		FunctionLogger.logFunctionCalled(toString(), "GetThing()");
		return FunctionLogger.logFunctionReturn( thing );
	}
	
	public Warehouse GetWarehouse() {
		FunctionLogger.logFunctionCalled(toString(), "GetWarehouse()");
		return FunctionLogger.logFunctionReturn( warehouse );
	}
	
	public Field GetNeighbor(Direction dir) {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor(Direction dir)");
		return FunctionLogger.logFunctionReturn( neighbor[dir.ordinal()] );
	}
	
/*	public ArrayList<Field> GetNeighbor() {
		FunctionLogger.logFunctionCalled(toString(), "GetNeighbor()");
		return FunctionLogger.logFunctionReturn( new ArrayList<Field>() );
	}*/
	
	public boolean HitBy(Direction dir, Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Thing t)");
		if(thing != null)
			return FunctionLogger.logFunctionReturn( thing.HitBy(dir, t) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
