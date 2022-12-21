package ACheckBTests;
import static org.junit.jupiter.api.Assertions.*;
import MyPackageA.ACheck1;
import TestEngine.TestEngine;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

class ACheck1BTest {


	@Test
	void lengthTest() throws IOException, CheckstyleException {
		ACheck1 check = new ACheck1();
		String file = "src/main/java/TestFiles/Length.java";
		TestEngine b = new TestEngine(file,check);
		b.walk();
		assertEquals(100, check.count); 
	}
	
}
