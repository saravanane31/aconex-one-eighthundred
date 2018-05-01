package com.coding.challenge.aconex.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.Dictionary;
import com.coding.challenge.aconex.service.DictionaryReader;

public class DictionaryImplTest {
	
	DictionaryReader dictionaryReader;
	private Set<String> dictionaryWords = new HashSet<>();
	private Dictionary dictionary;
	
	@Before
	public void before() throws AconexException{
		this.dictionaryReader =  new DictionaryReaderImpl();
		this.dictionaryWords = dictionaryReader.readFile(getClass().getClassLoader().getResource("Dictionary.txt").getPath().substring(1));
		this.dictionary= new DictionaryImpl(new ArrayList<String>(dictionaryWords));
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void should_return_result_set(){
		List<String> list = new ArrayList<String>(Arrays.asList("2255.63"));
		
		
		for(String number:list){
			Set<String> result = dictionary.getWords(number);
			assertTrue(result.size()>0);
		}
		
	}
	
	@Test
	public void should_contain_word_from_getWords(){
		Set<String> result = dictionary.getWords("2255.63");
		assertTrue(result.contains("CALLME"));
	}
	
	@Test
	public void should_return_empty_set_getWords(){
		Set<String> result = dictionary.getWords("123456789");
		assertTrue(!(result.size()>0));
	}
	
	

}
