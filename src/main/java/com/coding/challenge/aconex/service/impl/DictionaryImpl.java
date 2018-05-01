package com.coding.challenge.aconex.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.coding.challenge.aconex.constant.AconexConstant;
import com.coding.challenge.aconex.service.Dictionary;
import com.coding.challenge.aconex.service.KeyWordGenerator;


/**
 * Implementation of Dictionary Interface.
 * Reads the Dictionary words and put it into List.
 * @author sarelang
 *
 */
public class DictionaryImpl implements Dictionary {
	
	private final KeyWordGenerator keyWordGenerator = new KeyWordGeneratorImpl();
	
	private  final List<String> dictionary;
	
	/**
	 * Constructs the Dictionary Implementation.
	 * Passing the List of Dictionary words as constructor parameter
	 * 
	 * @param dictionaryWords
	 */
	public DictionaryImpl(List<String> dictionaryWords) {
		this.dictionary = dictionaryWords;
	}
	
	/* 
	 * * (non-Javadoc)
	 * @see com.coding.challenge.aconex.service.Dictionary#getWords(java.lang.String)
	 */
	public Set<String> getWords(String number) {
		dictionary.replaceAll(String::toUpperCase);
		Set<String> dictionarySet = new HashSet<>(dictionary);
		number = cleanNumber(number);
		if(!number.matches("[2-9]+"))
			return new HashSet<>();
		return keyWordGenerator.getKeyWords(number).stream().filter(key -> dictionarySet.contains(key)).collect(Collectors.toSet());
	}
	
	/**
	 * Remove all the white spaces and punctuation from the specified number
	 * 
	 * @param number
	 * @return 
	 */
	private String cleanNumber(String number){
		// Remove all white spaces.
        number = number.replaceAll( "\\p{Z}", AconexConstant.EMPTY);

        // Remove all punctuation.
        number = number.replaceAll( "\\p{P}", AconexConstant.EMPTY);
        
       return number;
	}

}
