/**
 *
 * @author Asheena
 */
package numberrangesummarizer;

import static org.testng.Assert.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;


public class TestMain {

	@Test// Test - Collect method takes in a string and produces a list
	public void collect() throws Exception{
		
		NumberRangeSummarizer method = new Main();
		Collection<Integer> testList = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
		String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> list = method.collect(input);
		assertArrayEquals(list.toArray(),testList.toArray());


	}

	@Test// Test - summarizeCollection class
	public void summarize() throws Exception{
		
		NumberRangeSummarizer method = new Main();
		String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31" ;
		String compare= "1, 3, 6-8, 12-15, 21-24, 31"; // The final result
		Collection<Integer> output = method.collect(input);
		String Result = method.summarizeCollection(output);
		assertEquals(compare, Result);
	}

	@Test // Test if sequential values are grouped
	public void sequential() throws Exception{

		NumberRangeSummarizer method = new Main();
		String input= "1,3,4,5,5,7,8,9,10,11" ;
		String compare= "1, 3-5, 7-11"; // The final result
		Collection<Integer> output = method.collect(input);
		String Result = method.summarizeCollection(output);
		assertEquals(Result, compare);

	}


	@Test// Test for duplication
	public void duplicate() throws Exception{

		NumberRangeSummarizer method = new Main();
		String input= "1,3,3,5,5,7,9,11,12,12,13,14,16" ;
		String compare= "1, 3, 5, 7, 9, 11-14, 16"; // The final result
		Collection<Integer> output = method.collect(input);
		String Result = method.summarizeCollection(output);
		assertEquals(Result, compare);

	}


	@Test // Test if input is not in order and still gives the correct output
	public void order() throws Exception{

		NumberRangeSummarizer method = new Main();
		String input= "1,11,5,4,5,9,8,7,10,3" ;
		String compare= "1, 3-5, 7-11"; // The final result
		Collection<Integer> output = method.collect(input);
		String Result = method.summarizeCollection(output);
		assertEquals(Result, compare);

	}

	@Test // Test if negative values
	public void negative() throws Exception{

		NumberRangeSummarizer method = new Main();
		String input= "-8,-6,-1,1,4,5,6,7,8,9,13" ;
		String compare= "-8, -6, -1, 1, 4-9, 13"; // The final result
		Collection<Integer> output = method.collect(input);
		String Result = method.summarizeCollection(output);
		assertEquals(Result, compare);

	}

	// Test if input is an empty String	
	@Test (expected= Exception.class)  
	public void NoInput() { 
		String input="";
		NumberRangeSummarizer method = new Main();
		Collection<Integer> output = method.collect(input);
		method.summarizeCollection(output);

	}
	
	// Test if letters are given as input
	@Test (expected=Exception.class)
	public void letters() throws Exception{

		String input="1,2,3,5,f,h,8,9";
		NumberRangeSummarizer method = new Main();
		Collection<Integer> output = method.collect(input);
		method.summarizeCollection(output);


	}

    private static class Main extends NumberRangeSummarizer {

        public Main() {
        }
    }


}// End of Class