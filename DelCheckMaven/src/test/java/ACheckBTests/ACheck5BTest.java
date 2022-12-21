package ACheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageA.ACheck5;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class ACheck5BTest {


	@Test
	void effortTest() throws IOException, CheckstyleException {
		ACheck5 check = new ACheck5();
		String file = "src/main/java/TestFiles/Difficulty.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(12870, check.count); 
	}
	
}
