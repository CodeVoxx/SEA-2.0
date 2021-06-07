package de.telekom.Sea2.together;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.telekom.sea2.together.Together;

public class TogetherTest {

	private Together cut;

	@BeforeEach
	void setup() {
		cut = new Together();
	}

	@Test
	void join_test() {

		// Arrange
		Together<String, String> cut = new Together<String, String>();
		
	// Act
	boolean result = cut.join("Erika", "Hans");

	// Assert
	assertEquals(true, result);
		}
	
	
	@Test
	void toString_test() {
	//Arrange

		Together<String, String> cut = new Together<String, String>();
	//Act
		boolean result = cut.join("Erika", "Hans");
		var result2 = cut.toString();
		System.out.println(result2);
		//Assert
		assertEquals("Erika, Hans", result2);	
	}
	
	@Test
	void hasCode_Test() {
		//Arrange
		Together<String, String> cut = new Together<String, String>();
		//Act
		boolean result = cut.join("Erika", "Hans");
		var result2 = cut.hashCode();
		System.out.println(result2);
		//Assert
		assertEquals(69465136, result2);		
	}
	
	
	@Test
	void equals_test() {
		// Arrange
		Together<String, String> cut = new Together<String, String>();
		// Act
		boolean result = cut.join("Erika", "Hans");
		Together<String, String> cut1 = new Together<String, String>();
		boolean result1 = cut1.join("Erika", "Hans");
		boolean result2 = cut.equals(cut1);
		System.out.println("Equals: " + result2);
		// Assert
		assertEquals(true, result2);
	}
	
	@Test
	void split_test() {
		// Arrange
		Together<String, String> cut = new Together<String, String>();
		// Act
		boolean result = cut.split();
		// Assert
		assertEquals(null, cut.getT());
		assertEquals(null, cut.getU());
	}
	@Test
	void joinTest2 () {
		// Arrange
		Together<Object, Object> cut =  new Together<Object, Object>();
		Together<Object, Object> toGethera =  new Together<Object, Object>();
		Together<Object, Object> toGetherb =  new Together<Object, Object>();
		// Act
		boolean resulta = toGethera.join("Hans", "Gross");
		boolean resultb = toGetherb.join("Petra", "Klein");
		boolean result	= cut.join(toGethera, toGetherb);
		// Assert
		assertEquals (resulta, true);
		assertEquals (resultb, true);
		assertEquals (result, true);
	}
	@AfterEach
	void teardown() {
		cut = null;
	}

	
}
	


