package TestEngine;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import org.junit.jupiter.api.Test;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.JavaParser.Options;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.*;

public class TestEngine {

		
	private AbstractCheck check;
	private String path;
	private DetailAST root;
	
	public TestEngine(String filePath, AbstractCheck check) {
		this.path = filePath;
		this.check = check;
	}
	

	public void walk() throws IOException, CheckstyleException {
			String filePath = path;
			File file = new File(filePath);
			FileText text = new FileText(file,"UTF-8");
			FileContents cont = new FileContents(text);
			
			if (check.isCommentNodesRequired()) {
				 root = JavaParser.parseFile(file, Options.WITH_COMMENTS);
			} else {
				 root = JavaParser.parse(cont);
			}
			
			this.check.configure(new DefaultConfiguration("Local"));
			this.check.contextualize(new DefaultContext());
			
			this.check.beginTree(root);
			iter(root);
			this.check.finishTree(root);
			
	
	}
	
	public void iter(DetailAST curNode) {
		int[] tokens = check.getDefaultTokens();
		 while (curNode != null) {
			 if (contains(tokens, curNode.getType())) {
					check.visitToken(curNode);
				}


			  DetailAST toVisit = curNode.getFirstChild();
			   while (curNode != null && toVisit == null) {
				   check.leaveToken(curNode);
			       toVisit = curNode.getNextSibling();
			       curNode = curNode.getParent();
			  }
			             curNode = toVisit;
		}
	}
	
	
	public boolean contains(int[] array, int key) {
	    for (final int i : array) {
	        if (i == key) {
	            return true;
	        }
	    }
	    return false;
	}

}
