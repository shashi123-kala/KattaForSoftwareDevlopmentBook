package com.sdb.tdd;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sdb.constants.SoftwareDevlopmentBooksConstants;
import com.sdb.entity.SoftwareDevelopmentBook;
import com.sdb.entity.SoftwareDevelopmentBookSetDiscount;

public class CalculateDiscountTest {

	CalculateDiscount calculateDiscount;
	

	@BeforeEach
	public void setup() {
		List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevlopmentBooksConstants.TWO_BOOKS, SoftwareDevlopmentBooksConstants.FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevlopmentBooksConstants.THREE_BOOKS, SoftwareDevlopmentBooksConstants.TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevlopmentBooksConstants.FOUR_BOOKS, SoftwareDevlopmentBooksConstants.TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevlopmentBooksConstants.FIVE_BOOKS, SoftwareDevlopmentBooksConstants.TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
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
		assertEquals(145, calculateDiscount.getTotalPrice(sdbList));
	}

}
