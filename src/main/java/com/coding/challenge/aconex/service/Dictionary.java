package com.coding.challenge.aconex.service;

import java.util.Set;

/**
 * The Dictionary interface provides method to get the dictionary words for the user input(@param)
 * @author sarelang
 *
 */
public interface Dictionary {

	/**
	 * Returns the set of dictionary words for the specified user input
	 * It will return Empty HashSet<> if the input number contains any other character other than 2-9.
	 * @param number PhoneNumber as Parameter
	 * @return set of dictionary words 
	 */
	Set<String> getWords(String number);
}
