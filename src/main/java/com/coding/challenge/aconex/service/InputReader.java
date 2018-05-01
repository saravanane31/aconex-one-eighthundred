package com.coding.challenge.aconex.service;

import java.util.Set;

import com.coding.challenge.aconex.constant.AconexException;

/**
 * The InputReader interface provides method to read the Input file
 * @author sarelang
 *
 */
public interface InputReader {

	/**
	 * Returns the set of PhoneNumbers from the specified Input file
	 * Passing Input file path as parameter
	 * Throws AconexException if No file present at the specified location.
	 * 
	 * @param filePath
	 * @return	PhoneNumbers
	 * @throws AconexException
	 */
	Set<String> readFile(String filePath) throws AconexException;
}
