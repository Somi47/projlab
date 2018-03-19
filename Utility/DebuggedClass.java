package Utility;

public class DebuggedClass {
	private String dbgName;

	public void SetDbgName(String s) {
		dbgName = s;
	}
	
	public String GetDbgName() {
		return dbgName;
	}
	
	@Override
	public String toString() {
		return GetDbgName();
	}
}
