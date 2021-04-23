// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import junit.framework.TestCase;
import org.junit.Test;

public class StringCodeTest extends TestCase {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	// Need test cases for stringIntersect
	@Test
	public void testIntersect1(){
		//basic tests
		assertTrue(StringCode.stringIntersect("abc","bca",2));
		assertTrue(!StringCode.stringIntersect("abc","bca",3));
		assertTrue(StringCode.stringIntersect("blaabc","abcdef",3));
		for(int len=0; len<27;len++)
			assertTrue(StringCode.stringIntersect("abcdefghijklmnopqrstuvwxyz","abcdefghijklmnopqrstuvwxyz",len));
	}
	@Test
	public void testIntersect2(){
		//tests with 0 len and empty strings
		assertTrue(!StringCode.stringIntersect("","",1));
		assertTrue(StringCode.stringIntersect("","",0));
		assertTrue(StringCode.stringIntersect("","abc",0));
		assertTrue(!StringCode.stringIntersect("abc","",1));
		assertTrue(StringCode.stringIntersect("blabla","test",0));

	}

}
