package com.nt.factory;

import com.nt.comps.Bike;
import com.nt.comps.BulletBike;
import com.nt.comps.ElectricBike;
import com.nt.comps.SportsBike;
import com.nt.comps.StandardBike;

public class BikeFactory {
	public static Bike orderBike(String type) {
		Bike bike=null;
		if(type.equalsIgnoreCase("Stanadard"))
			bike=new StandardBike();
		else if(type.equalsIgnoreCase("sports"))
			bike=new SportsBike();
		else if(type.equalsIgnoreCase("electric"))
			bike=new ElectricBike();
		else if(type.equalsIgnoreCase("Bullet"))
			bike=new BulletBike();
		else
			throw new IllegalArgumentException("invalid bike type");
		
		return bike;
		
	}

}
