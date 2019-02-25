package net.maxvalencio.task_5_collection_framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

/**
 * Unit test for CharactersCounterImpl
 */

public class CharactersCounterTest {
	
	private CharactersCounter counter = new CharactersCounterProxy();
	
	@Test
	public void count_correct() {
		StringBuilder actual = counter.count("hello world!");
		StringBuilder expected = new StringBuilder(); 
		expected.append("hello world!\n").		
				append("\"h\" - 1").append("\n"). 
				append("\"e\" - 1").append("\n").
				append("\"l\" - 3").append("\n"). 
				append("\"o\" - 2").append("\n").
				append("\" \" - 1").append("\n").
				append("\"w\" - 1").append("\n").
				append("\"r\" - 1").append("\n").
				append("\"d\" - 1").append("\n").
				append("\"!\" - 1").append("\n");
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void count_nullLine_correct() {  
	  counter.count(null);
	}
	
	@Test
	public void count_longLine_correct(){
		StringBuilder actual = counter.count("To be, or not to be, that is the question");
		StringBuilder expected = new StringBuilder(); 
		expected.append("To be, or not to be, that is the question\n"+
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
				"\"u\" - 1\n");
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	public void count_holdsInCashe_correct(){
		StringBuilder actual_1 = counter.count("To be, or not to be, that is the question");
		StringBuilder actual_2 = counter.count("To be");
		StringBuilder actual_3 = counter.count("hello world!");
		StringBuilder expected_1 = counter.count("To be, or not to be, that is the question");
		StringBuilder expected_3 = counter.count("hello world!");
		StringBuilder expected_2 = counter.count("To be");
		assertSame(expected_1, actual_1);
		assertSame(expected_2, actual_2);
		assertSame(expected_3, actual_3);
	}
}