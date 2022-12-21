package MyPackageB;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;
import java.util.Arrays;
 
public class BCheck5 extends AbstractCheck {
//mVariable, mAge, mStudentID
 
    private static final String CATCH_MSG = "Total operands found: ";
    public int count = 0;
    int[] OPERANDS = new int[]{ TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BYTE, 
            TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_INT, 
            TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_DOUBLE, 
            TokenTypes.IDENT, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, 
            TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL};
 
    @Override
    public int[] getDefaultTokens() {
        return OPERANDS;
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
        //count = 0;
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