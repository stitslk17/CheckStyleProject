package ACheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageA.ACheck4;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class ACheck4BTest {


	@Test
	void difficultyTest() throws IOException, CheckstyleException {
		ACheck4 check = new ACheck4();
		String file = "src/main/java/TestFiles/Difficulty.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(26, check.count); 
	}
	
}
