package ACheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageA.ACheck2;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class ACheck2BTest {


	@Test
	void vocabularyTest() throws IOException, CheckstyleException {
		ACheck2 check = new ACheck2();
		String file = "src/main/java/TestFiles/Vocabulary.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(31, check.count); 
	}
	
}
