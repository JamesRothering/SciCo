//todo: use tdd to develop code to assign next sequence to file
package com.scico;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BackEndTest{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testBackEndCreation() {
                BackEndTest aTest = new BackEndTest(3); //instantiate with an arbitrary number 
		assertEquals(3, aTest.getNextFileId()); // which must match
	}
	
//	
}
