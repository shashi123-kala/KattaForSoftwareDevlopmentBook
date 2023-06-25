package com.sdb.tdd;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sdb.entity.SoftwareDevelopmentBook;
import com.sdb.entity.SoftwareDevelopmentBookSetDiscount;

public class CalculateDiscountTest {

	CalculateDiscount calculateDiscount;
	public static final int FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS = 5;
	public static final int TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS = 10;
	public static final int TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS = 20;
	public static final int TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS = 25;

	@BeforeEach
	public void setup() {
		List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(2, FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(3, TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(4, TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(5, TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		calculateDiscount = new CalculateDiscount(byDifferentCopiesDiscountList);
	}

	@Test
	public void initializeToBuyBook() {
		assertNotNull(calculateDiscount);
	}

	@Test
	public void buyingOneBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		calculateDiscount.Add(sdbFirstI);
		assertEquals(50.0, calculateDiscount.getTotalPrice(sdbList));
	}

	@Test
	public void buyingTwoCopiesOfDifferentBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		calculateDiscount.Add(sdbFirstI);
		calculateDiscount.Add(sdbSecI);
		assertEquals(95.0, calculateDiscount.getTotalPrice(sdbList));
	}

	@Test
	public void buyingThreeCopiesOfDifferentBook() {
		List<SoftwareDevelopmentBook> sdbList = new ArrayList<>();
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		SoftwareDevelopmentBook sdbThirdI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		calculateDiscount.Add(sdbFirstI);
		calculateDiscount.Add(sdbSecI);
		calculateDiscount.Add(sdbThirdI);
		assertEquals(135, calculateDiscount.getTotalPrice(sdbList));
	}

}
