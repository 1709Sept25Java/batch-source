package com.revature.building;

public class Circle implements Shape{

	public Circle() {
		super();
	}
	
	public Circle(Number radius) {
		this();
		this.radius = radius;
	}
	
	private Number radius;
	
	public Number getRadius() {
		return this.radius;
	}
	
	public void setRadius(Number radius) {
		this.radius = radius;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Number calculateArea() {
		Double r = this.radius.doubleValue();
		return Math.PI * r * r;
	}

	@Override
	public Number calculatePerimeter() {
		
		return Math.PI * 2 * this.radius.doubleValue();
	}

}
