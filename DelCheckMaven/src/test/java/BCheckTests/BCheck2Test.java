package BCheckTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPackageB.BCheck2;



public class BCheck2Test {
	 int[] tokenTypes =  {TokenTypes.COMMENT_CONTENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	 /*
	 String[] commentBlock = {"hello world"};
	 
	 @Spy
	 BCheck2 spyCommentLines = spy(new BCheck2());
	 
	 @Mock
	 DetailAST mockAST = mock(DetailAST.class);
	 BCheck2 mockCommentLines = mock(BCheck2.class);
	 BCheck2 commentLines = new BCheck2();*/
	 
	 
	 @Test
	void beginTreeTest() {
		 BCheck2 spyCommentLines = spy(new BCheck2());
		 DetailAST mockAST = mock(DetailAST.class);
			spyCommentLines.beginTree(mockAST);
			verify(spyCommentLines, atLeastOnce()).beginTree(mockAST);
	}
	 
	
	@Test
	void getDefaultTokensTest() {
		 BCheck2 commentLines = new BCheck2();
		assertArrayEquals(commentLines.getDefaultTokens(), tokenTypes);
	}
	
	
   @Test
   void visitTokenSingleCommentTest() {
		 BCheck2 spyCommentLines = spy(new BCheck2());
		 DetailAST mockAST = mock(DetailAST.class);
		 doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
		 spyCommentLines.visitToken(mockAST);
		 verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
		
		
   }
   
   @Test
   void visitTokenBlockCommentTest() {
		 BCheck2 spyCommentLines = spy(new BCheck2());
		 DetailAST mockAST = mock(DetailAST.class);
		 doReturn("/*a*/").when(mockAST).getText();
		 doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();

		 doReturn(mockAST).when(mockAST).findFirstToken(TokenTypes.BLOCK_COMMENT_END);
		 doReturn(1).when(mockAST).getLineNo();
		 spyCommentLines.visitToken(mockAST);
		 verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
   }
   
   @Test
   void getAcceptableTokensTest() {
		 BCheck2 commentLines = new BCheck2();
		assertArrayEquals(commentLines.getAcceptableTokens(), tokenTypes);
   }
   
   @Test
   void getRequiredTokensTest() {
		 BCheck2 commentLines = new BCheck2();
		 assertArrayEquals(commentLines.getRequiredTokens(), tokenTypes);
   }
   
   
   @Test
   void finishTreeTest() {
		 BCheck2 spyCommentLines = spy(new BCheck2());
		 DetailAST mockAST = mock(DetailAST.class);
		 String message = "Total comment lines found: 0 -LS";
		 doNothing().when(spyCommentLines).log(0, message);
		 spyCommentLines.finishTree(mockAST);
		 verify(spyCommentLines).finishTree(mockAST);
	
   }
   
   @Test
   void isCommentNodesRequiredTest() {
		 BCheck2 commentLines = new BCheck2();
   	assertTrue(commentLines.isCommentNodesRequired());
   }
}