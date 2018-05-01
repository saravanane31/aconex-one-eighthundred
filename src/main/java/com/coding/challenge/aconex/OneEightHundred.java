package com.coding.challenge.aconex;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.coding.challenge.aconex.constant.AconexException;
import com.coding.challenge.aconex.service.Dictionary;
import com.coding.challenge.aconex.service.DictionaryReader;
import com.coding.challenge.aconex.service.InputReader;
import com.coding.challenge.aconex.service.impl.DictionaryImpl;
import com.coding.challenge.aconex.service.impl.DictionaryReaderImpl;
import com.coding.challenge.aconex.service.impl.InputReaderImpl;



public class OneEightHundred {

	public static void main(String[] args) {
		
		OneEightHundred oneEightHundred = new OneEightHundred();
		
		if(args.length>=3){
			System.out.println("args length >= 3");
			if(args[0].equals("-d")){
				oneEightHundred.setInputFields(args[1], args[2]);
			}
		}else if(args.length==2){
			System.out.println("args length == 2");
			if(args[0].equals("-d")){
				oneEightHundred.setInputFields(args[1], null);
			}else{
				oneEightHundred.setInputFields(null, args[1]);
			}
		}else{
			
			oneEightHundred.setInputFields(null,null);
		}
	}
	
	public void setInputFields(String dictionaryFilePath, String inputFilePath){
		
		DictionaryReader dictionaryReader = new DictionaryReaderImpl();
		InputReader inputReader = new InputReaderImpl();
		Set<String> dictionaryWords = new HashSet<>();
		try {
			if(dictionaryFilePath!=null && !dictionaryFilePath.isEmpty()){
				dictionaryWords = dictionaryReader.readFile(dictionaryFilePath);
			}else{
				File file = new File(this.getClass().getClassLoader().getResource("Dictionary.txt").getFile());
				dictionaryWords = dictionaryReader.readFile(file.getAbsolutePath());
			}
			Dictionary dictionary = new DictionaryImpl(new ArrayList<String>(dictionaryWords));
			if(inputFilePath !=null && !inputFilePath.isEmpty()){
				Set<String> inputs = inputReader.readFile(inputFilePath);
				inputs.forEach(input -> System.out.println(input+" --> "+dictionary.getWords(input)));
			}else{
				 Scanner scanner = new Scanner(System.in);
				 System.out.println("Kindly Enter the Input numbers::");
			        while (scanner.hasNext()) {
			            String inputNumber = scanner.nextLine();
			            System.out.println(inputNumber+" --> "+dictionary.getWords(inputNumber));
			        }

			}
			
			
		} catch (AconexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
