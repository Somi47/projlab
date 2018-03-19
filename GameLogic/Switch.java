package GameLogic;

import Utility.FunctionLogger;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 6projlab
//  @ File Name : Switch.java
//  @ Date : 2018.03.17.
//  @ Author : Gy�ngy�si P�ter
//
//




public class Switch extends Field {
	
	private Pit pit;
	
	public void SetPit(Pit p) {
		FunctionLogger.logFunctionCalled(toString(), "SetPit(Pit p)");
		pit = p;
		FunctionLogger.logFunctionReturnVoid();
	}
	
	public Pit GetPit() {
		FunctionLogger.logFunctionCalled(toString(), "GetPit()");
		return FunctionLogger.logFunctionReturn( pit );
	}
	
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, w)) {
					pit.SetOpen(false);;
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			return FunctionLogger.logFunctionReturn( true );
		}
	
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(GetThing() != null)
			if(GetThing().HitBy(dir, b)) {
					pit.SetOpen(true);;
					return FunctionLogger.logFunctionReturn( true );
			}
			else
				return FunctionLogger.logFunctionReturn( false );
		else
			return FunctionLogger.logFunctionReturn( true );
	}
}
