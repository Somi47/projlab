package GameLogic;

import Utility.FunctionLogger;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 6projlab
//  @ File Name : Thing.java
//  @ Date : 2018.03.17.
//  @ Author : Gy�ngy�si P�ter
//
//




public abstract class Thing {

	private boolean stucked;
	private Field field;

	public void SetField(Field f) {
		FunctionLogger.logFunctionCalled(toString(), "SetField(Field f)");
		field = f;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public Field GetField() {
		FunctionLogger.logFunctionCalled(toString(), "GetField()");
		return FunctionLogger.logFunctionReturn( field );
	}
	
	public void SetStucked(boolean b) {
		FunctionLogger.logFunctionCalled(toString(), "SetStucked(boolean b)");
		stucked = b;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public boolean isStucked() {
		FunctionLogger.logFunctionCalled(toString(), "isStucked()");
		return FunctionLogger.logFunctionReturn( stucked );
	}
	
	public boolean HitBy(Direction dir, Thing t) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Thing t)");
		return FunctionLogger.logFunctionReturn( true );
	}
}
