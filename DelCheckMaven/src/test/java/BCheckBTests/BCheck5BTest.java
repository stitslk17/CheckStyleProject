package BCheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageB.BCheck5;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class BCheck5BTest {


	@Test
	void minTest() throws IOException, CheckstyleException {
		BCheck5 check = new BCheck5();
		String file = "src/main/java/TestFiles/MinOperands.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(1, check.count); 
	}

	@Test
	void manyTest() throws IOException, CheckstyleException {
		BCheck5 check = new BCheck5();
		String file = "src/main/java/TestFiles/ManyOperands.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(13, check.count);
	}
	
}
