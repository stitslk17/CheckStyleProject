package BCheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageB.BCheck2;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class BCheck2BTest {


	@Test
	void noTest() throws IOException, CheckstyleException {
		BCheck2 check = new BCheck2();
		String file = "src/main/java/TestFiles/NoComment.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(0, check.count); 
	}

	@Test
	void manyTest() throws IOException, CheckstyleException {
		BCheck2 check = new BCheck2();
		String file = "src/main/java/TestFiles/ManyComments.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(3, check.count);
	}
	
	@Test
	void mixedTest() throws IOException, CheckstyleException {
		BCheck2 check = new BCheck2();
		String file = "src/main/java/TestFiles/MixedComments.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(7, check.count);
	}
	
}
