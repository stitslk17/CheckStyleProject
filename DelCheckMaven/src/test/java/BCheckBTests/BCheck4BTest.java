package BCheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageB.BCheck4;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class BCheck4BTest {


	@Test
	void minTest() throws IOException, CheckstyleException {
		BCheck4 check = new BCheck4();
		String file = "src/main/java/TestFiles/MinOperators.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(2, check.count); 
	}

	@Test
	void manyTest() throws IOException, CheckstyleException {
		BCheck4 check = new BCheck4();
		String file = "src/main/java/TestFiles/ManyOperators.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(48, check.count);
	}
	
}
