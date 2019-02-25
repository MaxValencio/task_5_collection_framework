package net.maxvalencio.task_5_collection_framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

/**
 * Unit test for ProxyCharFrequencyImpl
 */

public class ProxyCharFrequencyImplTest {
	
	private CharFrequency charFrequency = new ProxyCharFrequencyImpl(new CharFrequencyImpl());
	
	@Test
	public void calculateCharFrequency_correct() {
		String actual = charFrequency.calculateCharFrequency("hello world!");
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
		String actual = charFrequency.calculateCharFrequency(null);
		String expected = "Error!!! Line = null, the line cannot be null.";
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateCharFrequency_LongLine_correct(){
		String actual = charFrequency.calculateCharFrequency("To be, or not to be, that is the question");
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
		String actual = charFrequency.calculateCharFrequency("hello world!");
		String expected = charFrequency.calculateCharFrequency("hello world!");
		assertTrue(expected == actual);
	}
	
	@Test
	public void CalculateCharFrequency_manyInvocations_correct(){
		String firstInvocation = charFrequency.calculateCharFrequency("To be, or not to be, that is the question");
		String secondInvocation = charFrequency.calculateCharFrequency("To be");
		String thirdInvocation = charFrequency.calculateCharFrequency("hello world!");
		String fourthInvocation = charFrequency.calculateCharFrequency("To be, or not to be, that is the question");
		String fifthInvocation = charFrequency.calculateCharFrequency("hello world!");
		String sixthInvocation = charFrequency.calculateCharFrequency("To be");
		String seventhInvocation = charFrequency.calculateCharFrequency("To be, or not to be, that is the question");
		assertTrue(seventhInvocation == firstInvocation && seventhInvocation == fourthInvocation);
		assertTrue(secondInvocation == sixthInvocation);
		assertTrue(thirdInvocation == fifthInvocation);
	}
}