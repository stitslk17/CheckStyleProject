package BCheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageB.BCheck6;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class BCheck6BTest {


	@Test
	void noTest() throws IOException, CheckstyleException {
		BCheck6 check = new BCheck6();
		String file = "src/main/java/TestFiles/NoExpression.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(0, check.count); 
	}

	@Test
	void manyTest() throws IOException, CheckstyleException {
		BCheck6 check = new BCheck6();
		String file = "src/main/java/TestFiles/ManyExpressions.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(3, check.count);
	}
	
}
