package com.sdb.tdd;

public class CalculateDiscount {
	
	public double getTotalPrice(double dis) {
		double amtAfterDis = 0.00;
		amtAfterDis = 50 - (50 * (dis / 100));
		return amtAfterDis;
	}


}
