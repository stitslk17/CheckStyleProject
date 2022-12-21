package BCheckTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPackageB.BCheck6;



public class BCheck6Test {
	
	int[] tokenTypes = new int[]{ TokenTypes.EXPR};
	 
	 @Test
	void beginTreeTest() {
		 BCheck6 mockExpression = mock(BCheck6.class);
		 DetailAST mockAST = mock(DetailAST.class);
		 BCheck6 expression = new BCheck6();
			mockExpression.beginTree(mockAST);
			verify(mockExpression, atLeastOnce()).beginTree(mockAST);
			expression.beginTree(mockAST);
			assertEquals(0, expression.count);
	}
	
	@Test
	void getDefaultTokensTest() {
		 BCheck6 expression = new BCheck6();
		assertArrayEquals(expression.getDefaultTokens(), tokenTypes);
	}
	
   @Test
   void visitTokenTest() {
		 BCheck6 mockExpression = mock(BCheck6.class);
		 DetailAST mockAST = mock(DetailAST.class);
		 BCheck6 expression = new BCheck6();
		mockExpression.visitToken(mockAST);
		verify(mockExpression, atLeastOnce()).visitToken(mockAST);
		expression.visitToken(mockAST);
		assertEquals(1, expression.count);
		
   }
   
   @Test
   void getAcceptableTokensTest() {
		 BCheck6 expression = new BCheck6();
		assertArrayEquals(expression.getAcceptableTokens(), tokenTypes);
   }
   
   @Test
   void getRequiredTokensTest() {
		 BCheck6 expression = new BCheck6();
		assertArrayEquals(expression.getRequiredTokens(), tokenTypes);
   }
   
   @Test
   void finishTreeTest() {
		 BCheck6 spyExpression = spy(BCheck6.class);
		 DetailAST mockAST = mock(DetailAST.class);
		 String message = "Total expressions found: 0 -LS";
		 doNothing().when(spyExpression).log(0, message);
		 spyExpression.finishTree(mockAST);
		 verify(spyExpression).finishTree(mockAST);
   }

}
