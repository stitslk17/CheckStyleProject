package BCheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageB.BCheck3;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class BCheck3BTest {


	@Test
	void noTest() throws IOException, CheckstyleException {
		BCheck3 check = new BCheck3();
		String file = "src/main/java/TestFiles/NoLoop.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(0, check.count); 
	}

	@Test
	void manyTest() throws IOException, CheckstyleException {
		BCheck3 check = new BCheck3();
		String file = "src/main/java/TestFiles/ManyLoops.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(3, check.count);
	}
	
	@Test
	void nestedTest() throws IOException, CheckstyleException {
		BCheck3 check = new BCheck3();
		String file = "src/main/java/TestFiles/NestedLoops.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(4, check.count);
	}
	
}
