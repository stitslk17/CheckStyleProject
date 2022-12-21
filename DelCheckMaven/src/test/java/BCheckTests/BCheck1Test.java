package BCheckTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPackageB.BCheck1;




public class BCheck1Test {
	int[] tokenTypes =  {TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.SINGLE_LINE_COMMENT};



	@Test
	void beginTreeTest() { 
		BCheck1 spyComments = spy(BCheck1.class);
		DetailAST mockAST = mock(DetailAST.class);
			spyComments.beginTree(mockAST);
			verify(spyComments, atLeastOnce()).beginTree(mockAST);
	}
	@Test
	void getDefaultTokensTest() {
		BCheck1 comments = new BCheck1();
		assertArrayEquals(comments.getDefaultTokens(), tokenTypes);
	}

	@Test
	void visitTokenSingleTest() {
		BCheck1 spyComments = spy(BCheck1.class);
		DetailAST mockAST = mock(DetailAST.class);
		doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
		spyComments.visitToken(mockAST);
		verify(spyComments, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void visitTokenBlockTest() {
		BCheck1 spyComments = spy(BCheck1.class);
		DetailAST mockAST = mock(DetailAST.class);
		doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();
		spyComments.visitToken(mockAST);
		verify(spyComments, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		BCheck1 comments = new BCheck1();
		assertArrayEquals(comments.getAcceptableTokens(), tokenTypes);
	}

	@Test
	void getRequiredTokensTest() {
		BCheck1 comments = new BCheck1();
		assertArrayEquals(comments.getRequiredTokens(), tokenTypes);
	}

	@Test
	void finishTreeTest() {
		BCheck1 spyComments = spy(BCheck1.class);
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total comments found: 0 -LS";
		doNothing().when(spyComments).log(0, message);
		spyComments.finishTree(mockAST);
		verify(spyComments).finishTree(mockAST);
	}
	
	@Test
	void isCommentNodesRequiredTest() {
		BCheck1 comments = new BCheck1();
		assertTrue(comments.isCommentNodesRequired());
	}

}
