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




public abstract class Field {
	
	private Thing thing[0..1];
	private Warehouse warehouse;
	private Field neighbor;

	public enum Direction {
		Up,
		Down,
		Left,
		Right;
	}
	
	
	public void Add(Thing t) {
	}

	public void Remove(Thing t) {
	}
	
	public Field GetNeighbour(Direction dir) {
	}
	
	public boolean HitBy(Direction dir, Thing t) {
	}
	
	public Thing GetThing() {
	}
}