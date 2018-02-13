package com.in28minutes.junit.business;

import java.util.List;

import com.in28minutes.junit.business.exception.DifferentCurrenciesException;
import com.in28minutes.junit.model.Amount;
import com.in28minutes.junit.model.Product;

/**
 * 
 * @author vkalyana
 *
 */
public interface ClientBO {

	/**
	 * Get client products total sum
	 * @param products
	 * @return
	 * @throws DifferentCurrenciesException
	 */
	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}