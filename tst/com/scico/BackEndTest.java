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
		BackEnd aTest = new BackEnd(3); //instantiate with an arbitrary number 
		assertEquals(3, getNextFileId()); // which must match
	}

}
