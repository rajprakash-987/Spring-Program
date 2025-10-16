package com.nt.test;

import com.nt.comps.Bike;
import com.nt.factory.BikeFactory;

public class FactoryPatternTest {
	public static void main(String[] args) {
		Bike bike=BikeFactory.orderBike("Stanadard");
		bike.drive();
		
		Bike bike1=BikeFactory.orderBike("sports");
		bike1.drive();
		
		
		Bike bike2=BikeFactory.orderBike("electric");
		bike2.drive();
		
		Bike bike3=BikeFactory.orderBike("Bullet");
		bike3.drive();
	}
	

}
