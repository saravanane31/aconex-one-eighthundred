package com.coding.challenge.aconex.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.coding.challenge.aconex.service.KeyWordGenerator;

/**
 * Implementation of KeyWordGenerator Interface
 * Initialize the keywords as key value pair
 * @author sarelang
 *
 */
public class KeyWordGeneratorImpl implements KeyWordGenerator{

	private static final Map<Character, Set<Character>> KEYWORD = new HashMap<Character, Set<Character>>();
	
	static {
		KEYWORD.put('2', new HashSet<Character>(Arrays.asList('A', 'B', 'C')));
		KEYWORD.put('3', new HashSet<Character>(Arrays.asList('D', 'E', 'F')));
		KEYWORD.put('4', new HashSet<Character>(Arrays.asList('G', 'H', 'I')));
		KEYWORD.put('5', new HashSet<Character>(Arrays.asList('J', 'K', 'L')));
		KEYWORD.put('6', new HashSet<Character>(Arrays.asList('M', 'N', 'O')));
		KEYWORD.put('7', new HashSet<Character>(Arrays.asList('P', 'Q', 'R', 'S')));
		KEYWORD.put('8', new HashSet<Character>(Arrays.asList('T', 'U', 'V')));
		KEYWORD.put('9', new HashSet<Character>(Arrays.asList('W', 'X', 'Y', 'Z')));
    }

	
	/**
	 * Returns set of constructed words for the specified number based on the keyword.
	 * @param number
	 * @return ConstructedWords
	 */
	private Set<String> getKeyword(String number) {
		Set<String> words = new HashSet<String>(Collections.singletonList(""));
        for (char digit : number.toCharArray()) {
        	Set<String> newWords = new HashSet<String>();
        	for (String word : words) {
            	for (char charValue : KEYWORD.get(digit)) {
                    newWords.add(word + charValue);
                }
            }
            words = newWords;
        }
        return words;
    }


	/* (non-Javadoc)
	 * @see com.coding.challenge.aconex.service.KeyWordGenerator#getKeyWords(java.lang.String)
	 */
	public Set<String> getKeyWords(String number) {
		return getKeyword(number);
	}
}
