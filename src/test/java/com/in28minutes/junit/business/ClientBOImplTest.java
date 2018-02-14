/**
 * 
 */
package com.in28minutes.junit.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.in28minutes.junit.business.exception.DifferentCurrenciesException;
import com.in28minutes.junit.model.Amount;
import com.in28minutes.junit.model.AmountImpl;
import com.in28minutes.junit.model.Currency;
import com.in28minutes.junit.model.Product;
import com.in28minutes.junit.model.ProductImpl;
import com.in28minutes.junit.model.ProductType;

/**
 * @author vkalyana
 *
 */
 class ClientBOImplTest {

	 ClientBO clientBO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	 void setUp() throws Exception {
		clientBO = new ClientBOImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	 void tearDown() throws Exception {
		clientBO = null;
	}

	@DisplayName("Should return default Amount when no products shared")
	@Test
	 void testAmountZero() {
		List<Product> prodList = new ArrayList<Product>();
		try {
			Amount actualAmount = clientBO.getClientProductsSum(prodList);
			Assertions.assertAll("collections",
					() -> Assertions.assertEquals(new BigDecimal(0), actualAmount.getValue(), "Default amount is not valid"),
					() -> Assertions.assertEquals(Currency.EURO, actualAmount.getCurrency(), "Default currency is not valid"));
			
		} catch (DifferentCurrenciesException e) {
			e.printStackTrace();
		}
		
	}
	
	@DisplayName("should throw exception when multiple currency products are not allowed")
	@Test
	void testMultipleCurrencyProductsNotAllowed(){
		Product product1 = new ProductImpl(1, "Home Loan", ProductType.LOAN, new AmountImpl(new BigDecimal(100000), Currency.INDIAN_RUPEE));
		Product product2 = new ProductImpl(1, "Home Loan", ProductType.LOAN, new AmountImpl(new BigDecimal(100000), Currency.EURO));
		
		List<Product> prodList = new ArrayList<>();
		prodList.add(product1);
		prodList.add(product2);
		
		Throwable assertThrowable = Assertions.assertThrows(DifferentCurrenciesException.class, 
				() -> clientBO.getClientProductsSum(prodList));
		
		Assertions.assertEquals("Multiple currency products are not allowed.", assertThrowable.getMessage());
		
	}
	
	@DisplayName("should throw exception when multiple currency products are not allowed")
	@Test
	void testMultipleProductsWithSameCurrency(){
		Product product1 = new ProductImpl(1, "Home Loan", ProductType.LOAN, new AmountImpl(new BigDecimal(100000), Currency.EURO));
		Product product2 = new ProductImpl(1, "Home Loan", ProductType.LOAN, new AmountImpl(new BigDecimal(100000), Currency.EURO));
		
		List<Product> prodList = new ArrayList<>();
		prodList.add(product1);
		prodList.add(product2);
		
		try {
			Amount actualAmount = clientBO.getClientProductsSum(prodList);
			Assertions.assertAll("Collections",
					 () -> Assertions.assertEquals(200000, actualAmount.getValue().intValue()),
					 () -> Assertions.assertEquals(Currency.EURO, actualAmount.getCurrency()));
		} catch (DifferentCurrenciesException e) {
			e.printStackTrace();
		}
		
	}

}
