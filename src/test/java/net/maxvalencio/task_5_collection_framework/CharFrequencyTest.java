package net.maxvalencio.task_5_collection_framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

/**
 * Unit test for ProxyCharFrequencyImpl
 */

public class CharFrequencyTest {
	
	private CharFrequency uniqCharacters = new ProxyCharFrequencyImpl();
	
	@Test
	public void calculateCharFrequency_correct() {
		String actual = uniqCharacters.calculateCharFrequency("hello world!");
		String expected = "hello world!\n" +
						  "\"h\" - 1\n" +
						  "\"e\" - 1\n" +
						  "\"l\" - 3\n" +
						  "\"o\" - 2\n" +
						  "\" \" - 1\n" +
						  "\"w\" - 1\n" +
						  "\"r\" - 1\n" +
						  "\"d\" - 1\n" +
						  "\"!\" - 1\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateCharFrequency_nullLine_correct() {
		String actual = uniqCharacters.calculateCharFrequency(null);
		String expected = "Error!!! Line = null, the line cannot be null.";
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateCharFrequency_LongLine_correct(){
		String actual = uniqCharacters.calculateCharFrequency("To be, or not to be, that is the question");
		String expected = "To be, or not to be, that is the question\n"+
						  "\"T\" - 1\n" +
						  "\"o\" - 5\n" +
						  "\" \" - 9\n" +
						  "\"b\" - 2\n" +
						  "\"e\" - 4\n" +
						  "\",\" - 2\n" +
						  "\"r\" - 1\n" +
						  "\"n\" - 2\n" +
						  "\"t\" - 6\n" +
						  "\"h\" - 2\n" +
						  "\"a\" - 1\n" +
						  "\"i\" - 2\n" +
						  "\"s\" - 2\n" +
						  "\"q\" - 1\n" +
						  "\"u\" - 1\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateCharFrequency_isCacheInvoked_correct() {
		String firstInvocation = uniqCharacters.calculateCharFrequency("hello world!");
		String actual = uniqCharacters.calculateCharFrequency("hello world!");
		String expected ="";	
		Map <String,String> cache = ((ProxyCharFrequencyImpl)uniqCharacters).getCache();
		for (Map.Entry<String, String> entry : cache.entrySet()) {
		expected = entry.getValue();
		}
		assertTrue(expected == actual && expected == firstInvocation);
	}
	
	@Test
	public void getCache_correct() {
		uniqCharacters.calculateCharFrequency("hello world!");
		uniqCharacters.calculateCharFrequency("hello world!");
		String actual = ((ProxyCharFrequencyImpl)uniqCharacters).getCache().toString();
		String expected = "{hello world!=hello world!\n" +
						  "\"h\" - 1\n" +
						  "\"e\" - 1\n" +
						  "\"l\" - 3\n" +
						  "\"o\" - 2\n" +
						  "\" \" - 1\n" +
						  "\"w\" - 1\n" +
						  "\"r\" - 1\n" +
						  "\"d\" - 1\n" +
						  "\"!\" - 1\n}";
		assertEquals(expected, actual);
	}
	
	@Test
	public void getCache_manyInvocationsCalculateCharFrequency_correct(){
		uniqCharacters.calculateCharFrequency("To be, or not to be, that is the question");
		uniqCharacters.calculateCharFrequency("To be");
		uniqCharacters.calculateCharFrequency("hello world!");
		uniqCharacters.calculateCharFrequency("To be, or not to be, that is the question");
		uniqCharacters.calculateCharFrequency("hello world!");
		String actual = ((ProxyCharFrequencyImpl)uniqCharacters).getCache().toString();
		String expected = "{hello world!=hello world!\n" +
						  "\"h\" - 1\n" +
						  "\"e\" - 1\n" +
						  "\"l\" - 3\n" +
						  "\"o\" - 2\n" +
						  "\" \" - 1\n" +
						  "\"w\" - 1\n" +
						  "\"r\" - 1\n" +
						  "\"d\" - 1\n" +
						  "\"!\" - 1\n"+
						  ", To be=To be\n" +
						  "\"T\" - 1\n" +
						  "\"o\" - 1\n" +
						  "\" \" - 1\n" +
						  "\"b\" - 1\n" +
						  "\"e\" - 1\n" +
						  ", To be, or not to be, that is the question=To be, or not to be, that is the question\n"+
						  "\"T\" - 1\n" +
						  "\"o\" - 5\n" +
						  "\" \" - 9\n" +
						  "\"b\" - 2\n" +
						  "\"e\" - 4\n" +
						  "\",\" - 2\n" +
						  "\"r\" - 1\n" +
						  "\"n\" - 2\n" +
						  "\"t\" - 6\n" +
						  "\"h\" - 2\n" +
						  "\"a\" - 1\n" +
						  "\"i\" - 2\n" +
						  "\"s\" - 2\n" +
						  "\"q\" - 1\n" +
						  "\"u\" - 1\n}";
		assertEquals(expected, actual);
	}
}