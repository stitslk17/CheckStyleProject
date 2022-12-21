package ACheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageA.ACheck3;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class ACheck3BTest {


	@Test
	void vocabularyTest() throws IOException, CheckstyleException {
		ACheck3 check = new ACheck3();
		String file = "src/main/java/TestFiles/Vocabulary.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(495, check.count); 
	}
	
}
