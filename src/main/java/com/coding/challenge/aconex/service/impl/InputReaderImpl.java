package com.coding.challenge.aconex.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.InputReader;

/**
 * Implementation of InputReader
 * Provided method to read the Input file
 * Passing Input File path as parameter
 * Returns Set of Input words
 * Throws AconexException if No file present at the specified location.
 * @author sarelang
 *
 */
public class InputReaderImpl implements InputReader {

	/* (non-Javadoc)
	 * @see com.coding.challenge.aconex.service.InputReader#readFile(java.lang.String)
	 */
	@Override
	public Set<String> readFile(String filePath) throws AconexException {
		try {
			Set<String> wordList=Files.lines(Paths.get(filePath)).collect(Collectors.toSet());
			return wordList;
		} catch (IOException e) {
			System.out.println("Unable to read input File ::"+e.getMessage());
			throw new AconexException("No file found at specified location");
		}
		
	}
}
