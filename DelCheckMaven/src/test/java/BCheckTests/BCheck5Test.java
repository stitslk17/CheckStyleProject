package BCheckTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPackageB.BCheck5;



public class BCheck5Test {
	
	int[] tokenTypes = new int[]{ TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BYTE, 
            TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_INT, 
            TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_DOUBLE, 
            TokenTypes.IDENT, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, 
            TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL};

	 
	 @Test
	void beginTreeTest() {

		 BCheck5 mockOperands = mock(BCheck5.class);
		 DetailAST mockAST = mock(DetailAST.class);
		 BCheck5 operands = new BCheck5();
			mockOperands.beginTree(mockAST);
			operands.beginTree(mockAST);
			assertEquals(0, operands.count);
	}
	
	@Test
	void getDefaultTokensTest() {
		 BCheck5 operands = new BCheck5();
		assertArrayEquals(operands.getDefaultTokens(), tokenTypes);
	}
	
  @Test
  void visitTokenTest() {

		 BCheck5 mockOperands = mock(BCheck5.class);
		 DetailAST mockAST = mock(DetailAST.class);
		mockOperands.visitToken(mockAST);
		verify(mockOperands, atLeastOnce()).visitToken(mockAST);

		 BCheck5 operands = new BCheck5();
		 operands.visitToken(mockAST);
		assertEquals(1, operands.count);
		
  }
  
  @Test
  void getAcceptableTokensTest() {
		 BCheck5 operands = new BCheck5();
		assertArrayEquals(operands.getAcceptableTokens(), tokenTypes);
  }
  
  @Test
  void getRequiredTokensTest() {
		 BCheck5 operands = new BCheck5();
		assertArrayEquals(operands.getRequiredTokens(), tokenTypes);
  }
  
  @Test
  void finishTreeTest() {
		 BCheck5 spyOperands = spy(new BCheck5());
		 DetailAST mockAST = mock(DetailAST.class);
  		String message = "Total operands found: 0 -LS";
		doNothing().when(spyOperands).log(0, message);
		spyOperands.finishTree(mockAST);
		verify(spyOperands).finishTree(mockAST);
  }

}


