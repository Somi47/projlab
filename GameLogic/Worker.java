//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : 6projlab
//  @ File Name : Worker.java
//  @ Date : 2018.03.17.
//  @ Author : Gy�ngy�si P�ter
//
//




public class Worker extends Thing implements Moveable {
	
	private String name;
	private int points;
	
	public void Die() {
	}
	
	public void AddPoint() {
	}
	
	public boolean Move(Direction dir) {
		return true;
	}
	
	public boolean HitBy(Direction dir, Box b) {
		return true;
	}
	
	public boolean HitBy(Direction dir, Worker w) {
		return true;
	}
}
