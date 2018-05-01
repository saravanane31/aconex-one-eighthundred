package com.coding.challenge.aconex.service;

import java.util.Set;

/**
 * The KeyWordGenerator interface provides method to get the <I>KeyWords</I>
 * @author sarelang
 *
 */
public interface KeyWordGenerator {

	/**
	 * Returns set of constructed words for the specified number based on the keyword.
	 * Passing number as Key 
	 * @param number
	 * @return	ConstructedWords
	 */
	Set<String> getKeyWords(String number);
}
