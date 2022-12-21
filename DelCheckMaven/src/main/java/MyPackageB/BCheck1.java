package MyPackageB;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;
import java.util.Arrays;
 
public class BCheck1 extends AbstractCheck {
//mVariable, mAge, mStudentID
 
    private static final String CATCH_MSG = "Total comments found: ";
    
    public int count = 0;
 
    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.BLOCK_COMMENT_BEGIN, TokenTypes.SINGLE_LINE_COMMENT};
    }
    
    @Override
    public void visitToken(DetailAST aAST) {
        count++;
    }
    
    @Override
    public void beginTree(DetailAST aAST) {
        count = 0;
    }
    
    @Override
    public void finishTree(DetailAST aAST) {
        log(aAST.getLineNo(), CATCH_MSG + count + " -LS");
    }

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		 return getDefaultTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getDefaultTokens();
	}
	
	@Override
	public boolean isCommentNodesRequired()
	{
		return true;
	}
}