package MyPackageB;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;
import java.util.Arrays;
 
public class BCheck3 extends AbstractCheck {
//mVariable, mAge, mStudentID
 
    private static final String CATCH_MSG = "Total loops found: ";
    public int count = 0;
    int[] LOOPS = new int[]{TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE};
 
    @Override
    public int[] getDefaultTokens() {
        return LOOPS;
    }
    
    @Override
    public void visitToken(DetailAST aAST) {
    	count ++;
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
}