package com.sdb.tdd;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sdb.entity.SoftwareDevelopmentBook;

public class CalculateDiscountTest {

	public static final String SOFTWARE_DEVELOPMENT_BOOK_I = "Clean Code (Robert Martin, 2008)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_II = "The Clean Coder (Robert Martin, 2011)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_III = "Clean Architecture (Robert Martin, 2017)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_IV = "Test Driven Development by Example (Kent Beck, 2003)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_V = "Working Effectively With Legacy Code (Michael C. Feathers, 2004)";
	CalculateDiscount calculateDiscount = new CalculateDiscount();

	@Test
	public void initializeToBuyBook() {
		assertNotNull(calculateDiscount);
	}

	@Test
	public void buyingOneBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		double discount = 0.0;
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		sdbList.add(sdbFirstI);
		assertEquals(50.0, calculateDiscount.getTotalPrice(discount, sdbList));
	}

	@Test
	public void buyingTwoCopiesOfDifferentBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		double discount = 5;
		sdbList.add(sdbFirstI);
		sdbList.add(sdbSecI);
		assertEquals(95.0, calculateDiscount.getTotalPrice(discount, sdbList));
	}

	@Test
	public void buyingThreeCopiesOfDifferentBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		SoftwareDevelopmentBook sdbThirdI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		double discount = 10;
		sdbList.add(sdbFirstI);
		sdbList.add(sdbSecI);
		sdbList.add(sdbThirdI);
		assertEquals(135, calculateDiscount.getTotalPrice(discount, sdbList));
	}

}
