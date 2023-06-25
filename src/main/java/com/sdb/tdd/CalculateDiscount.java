package com.sdb.tdd;

import java.util.List;

public class CalculateDiscount {

	public double getTotalPrice(double dis, List<String> sdbList) {
		double amtAfterDis = 0.00;
		if (sdbList.size() == 1) {
			amtAfterDis = 50 - (50 * (dis / 100));
		} else if (sdbList.size() == 2) {
			double count = 2 * 50.00;
			amtAfterDis = count - (count * (dis / 100));

		} else if (sdbList.size() == 3) {
			double count = 3 * 50.00;
			amtAfterDis = count - (count * (dis / 100));

		}
		return amtAfterDis;
	}

}
