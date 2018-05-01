package com.coding.challenge.aconex.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.DictionaryReader;

/**
 * Implementation of DictionaryReader
 * Provided method to read the Dictionary file
 * Passing Dictionary File path as parameter
 * Returns Set of dictionary words
 * Throws AconexException if No file present at the specified location.
 * 
 * @author sarelang
 *
 */
public class DictionaryReaderImpl implements DictionaryReader {

	/* (non-Javadoc)
	 * @see com.coding.challenge.aconex.service.DictionaryReader#readFile(java.lang.String)
	 */
	@Override
	public Set<String> readFile(String filePath) throws AconexException {
		if(!filePath.isEmpty()){
			try {
				Set<String> wordList=Files.lines(Paths.get(filePath)).collect(Collectors.toSet());
				return wordList;
			} catch (IOException e) {
				System.out.println("Unable to read Dictionary File ::"+e.getMessage());
				throw new AconexException("No file found at specified location");
			}
		}else{
			throw new AconexException("File path cannot be empty");
		}
	}

}
