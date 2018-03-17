package SkeletonApp;

import Utility.FunctionLogger;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hali, ez egy példa a FunctionLogger működésére:");
		
		FunctionLogger.logFunctionCalled("calledName1", "calledFunction1()");
			FunctionLogger.logFunctionCalled("calledName1/1", "calledFunction1/1()");
			FunctionLogger.logFunctionReturnVoid();
			FunctionLogger.logFunctionCalled("calledName1/2", "calledFunction1/2()");
			FunctionLogger.logFunctionRetrun("Down");
		FunctionLogger.logFunctionRetrun("Down");		
		FunctionLogger.logFunctionCalled("calledName2", "calledFunction2()");
			if( FunctionLogger.askUserDecision("Ládával ütközött?") ) {
				FunctionLogger.logFunctionCalled("calledName2/Láda", "calledFunction2/Láda()");
				FunctionLogger.logFunctionReturnVoid();
			}
			else {
				FunctionLogger.logFunctionCalled("calledName2/NemLáda", "calledFunction2/NemLáda()");
				FunctionLogger.logFunctionReturnVoid();
			}
		FunctionLogger.logFunctionReturnVoid();
	}
	
}
