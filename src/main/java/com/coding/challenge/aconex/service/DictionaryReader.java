package com.coding.challenge.aconex.service;

import java.util.Set;

import com.coding.challenge.aconex.constant.AconexException;

/**
 * The DictionaryReader interface provides method to read the Dictionary file 
 * @author sarelang
 *
 */
public interface DictionaryReader {

	/**
	 * Returns set of dictionary words from the specified Dictionary File
	 * Passing Dictionary File path as parameter
	 * Throws AconexException if No file present at the specified location. 
	 * 
	 * @param filePath
	 * @return	Dictionary Words
	 * @throws AconexException
	 */
	Set<String> readFile(String filePath) throws AconexException;
}
