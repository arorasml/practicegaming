package com.game.battle.location;

public class Coordinate {

	private int xCoordinate;
	private char yCoordinate;

	/*
	 * Integer value of yCoordinate
	 */

	private int yCoordinateInt;

	public Coordinate() {
		super();
	}

	public Coordinate(int xCoordinate, char yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public Coordinate(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinateInt = yCoordinate;
	}

	// Compare two cells
	@Override
	public boolean equals(Object obj) {

		return (((Coordinate) obj).xCoordinate == this.xCoordinate
				&& ((Coordinate) obj).yCoordinate == this.yCoordinate);
	}

	public Coordinate findCellLocation(int xCoordinateVale, char yCoordinateValue) {
		return new Coordinate(xCoordinateVale, yCoordinateValue - 'A' + 1);
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public char getyCoordinate() {
		return yCoordinate;
	}

	public int getyCoordinateReplicated() {
		return yCoordinateInt;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setyCoordinate(char yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public void setyCoordinateReplicated(int yCoordinateReplicated) {
		this.yCoordinateInt = yCoordinateReplicated;
	}

	@Override
	public String toString() {
		return "Coordinate [xcoordinate=" + xCoordinate + ", ycoordinate=" + yCoordinate + "]";
	}

}
