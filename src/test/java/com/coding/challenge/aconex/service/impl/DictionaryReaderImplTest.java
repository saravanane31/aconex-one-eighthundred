package com.coding.challenge.aconex.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.DictionaryReader;

public class DictionaryReaderImplTest {
	
	private DictionaryReader dictionaryReader;

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Before
	public void before(){
		dictionaryReader = new DictionaryReaderImpl();
	}
	
	@Test
	public void should_read_file() throws AconexException{
		
			String filePath=getClass().getClassLoader().getResource("Dictionary.txt").getPath().toString();
			Set<String> dictionaryWord = dictionaryReader.readFile(filePath);
			assertTrue(dictionaryWord.size()>0);
	}
	
	@Test(expected=AconexException.class)
	public void should_throw_AconexException() throws AconexException{
		String filePath ="";
		dictionaryReader.readFile(filePath);
	}
	
	@After
	public void after(){
		dictionaryReader = null;
	}
}
