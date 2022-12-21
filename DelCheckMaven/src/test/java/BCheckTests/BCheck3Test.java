package BCheckTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPackageB.BCheck3;



public class BCheck3Test {
	
	int[] tokenTypes = {TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE};

	 @Test
	void beginTreeTest() {
		 BCheck3 spyLoopingStatements = spy(new BCheck3());
		 DetailAST mockAST = mock(DetailAST.class);
			spyLoopingStatements.beginTree(mockAST);
			verify(spyLoopingStatements, atLeastOnce()).beginTree(mockAST);

	}
	
	@Test
	void getDefaultTokensTest() {
		 BCheck3 loopingStatements = new BCheck3();
		assertArrayEquals(loopingStatements.getDefaultTokens(), tokenTypes);
	}
	
  @Test
  void visitTokenTest() {
		 BCheck3 spyLoopingStatements = spy(new BCheck3());
		 DetailAST mockAST = mock(DetailAST.class);
		spyLoopingStatements.visitToken(mockAST);
		verify(spyLoopingStatements, atLeastOnce()).visitToken(mockAST);
		
  }
  
  @Test
  void getAcceptableTokensTest() {
		 BCheck3 loopingStatements = new BCheck3();
		assertArrayEquals(loopingStatements.getAcceptableTokens(), tokenTypes);
  }
  
  @Test
  void getRequiredTokensTest() {
		 BCheck3 loopingStatements = new BCheck3();
		assertArrayEquals(loopingStatements.getRequiredTokens(), tokenTypes);
  }
  
  @Test
  void finishTreeTest() {
		 BCheck3 spyLoopingStatements = spy(new BCheck3());
		 DetailAST mockAST = mock(DetailAST.class);
  		String message = "Total loops found: 0 -LS";
		doNothing().when(spyLoopingStatements).log(0, message);
		spyLoopingStatements.finishTree(mockAST);
		verify(spyLoopingStatements).finishTree(mockAST);
  }
}