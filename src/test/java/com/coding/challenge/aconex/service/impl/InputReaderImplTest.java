package com.coding.challenge.aconex.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.InputReader;

public class InputReaderImplTest {
	
	private InputReader inputReader;

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void before(){
		inputReader = new InputReaderImpl();
	}
	
	@Test
	public void should_read_file() throws AconexException{
		File file = new File(this.getClass().getClassLoader().getResource("Input.txt").getFile());
		Set<String> inputs = inputReader.readFile(file.getAbsolutePath());
		assertTrue(inputs.size()>0);
	}
	
	@Test(expected=AconexException.class)
	public void should_throw_AconexException() throws AconexException{
		String filePath ="";
		inputReader.readFile(filePath);
	}
	
	
	@After
	public void after(){
		inputReader = null;
	}

}
