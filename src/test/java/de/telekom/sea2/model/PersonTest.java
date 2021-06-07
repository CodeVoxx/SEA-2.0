package de.telekom.sea2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
// direkter import einer Methode mit Classe 
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

public class PersonTest {

	private Person cut;

	@BeforeEach
	void setup() {
		cut = new Person();
	}

	@Test
	void setFirstname_test() {

		// Arrange
		cut.setFirstname("Gerd");

		// Act
		var result = cut.getFirstname();

		// Assert
		assertEquals("Gerd", result);

	}

	@AfterEach
	void teardown() {
		cut = null;
	}

}
