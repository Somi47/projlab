package GameLogic;

import Utility.FunctionLogger;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 6projlab
//  @ File Name : Floor.java
//  @ Date : 2018.03.17.
//  @ Author : Gy�ngy�si P�ter
//
//




public class Floor extends Field {
	
	
	public boolean HitBy(Direction dir, Worker w) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Worker w)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, w) );
		return FunctionLogger.logFunctionReturn( true );
	}
	
	public boolean HitBy(Direction dir, Box b) {
		FunctionLogger.logFunctionCalled(toString(), "HitBy(Direction dir, Box b)");
		if(GetThing() != null)
			return FunctionLogger.logFunctionReturn( GetThing().HitBy(dir, b) );
		return FunctionLogger.logFunctionReturn( true );
	}
}
