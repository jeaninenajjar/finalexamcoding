package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Student_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//FinalExam - Add some meaningful junit tests.
		assertTrue(RateDAL.getRate(750)==3.75);
		assertTrue(RateDAL.getRate(800)==3.5);
		assertTrue(RateDAL.getRate(700)==4.0);
		assertTrue(RateDAL.getRate(650)==4.5);
		assertTrue(RateDAL.getRate(600)==5.0);
		
		
		
	}

}
