package com.coding.challenge.aconex.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.coding.challenge.aconex.service.KeyWordGenerator;


public class KeyWordGeneratorImplTest {
	
	private KeyWordGenerator keyWordGenerator;

	@Before
	public void before(){
		keyWordGenerator = new KeyWordGeneratorImpl();
	}
	
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void should_return_setof_constructed_words_keySet(){
		Set<String> constructedWords = keyWordGenerator.getKeyWords("2255");
		assertTrue(constructedWords.size()>0);
	}
	
	@Test
	public void should_return_empty_set_keySet(){
		Set<String> constructedWords = keyWordGenerator.getKeyWords("");
		assertTrue(!(constructedWords.size()>1));
	}
	
	@After
	public void after(){
		keyWordGenerator = null;
	}

}
