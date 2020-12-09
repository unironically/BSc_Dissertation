package main;

import antlr4.BNFLexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Class used to store, format and print ParseTree objects passed to the constructor.
 * @author Luke Bessant
 */
public class TreeHandler {

    /**
     * The ParseTree object holding the imported BNF specification structure.
     */
    private ParseTree tree;

    /**
     * Constructor for TreeHandler objects.
     * @param tree The ParseTree object to handle.
     */
    public TreeHandler(ParseTree tree) {
        this.tree = tree;
    }

    /**
     * Method used to print the ParseTree object passed to the constructor in 'pretty' format.
     */
    public String getFormattedString() {
        String formattedTree = descendAST(tree, new StringBuilder());
        return formattedTree;
    }

    /**
     * Recursive method to descend the abstract syntax tree created by the parser and print the tree nodes.
     * @param tree The ParseTree object which we traverse to find the leaves.
     * @param stringBuilder The StringBuilder object we add the text of the tree nodes to.
     * @return A String created with the StringBuilder representing the AST.
     */
    private String descendAST(ParseTree tree, StringBuilder stringBuilder) {
        int childCount = tree.getChildCount();
        if (childCount < 1) {
            return stringBuilder.append(handleToken(tree)).toString();
        }
        for (int i = 0; i < childCount; i++) descendAST(tree.getChild(i), stringBuilder);
        if (((RuleContext) tree).depth() == 2) stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    /**
     * Method to return a formatted String representing the current token.
     * @param tree The current tree node to handle and format.
     * @return The formatted String representation of the current token.
     */
    private String handleToken(ParseTree tree) {
        Token currentToken = (Token) tree.getPayload();
        RuleContext context = (RuleContext) tree.getParent().getParent();
        int tokenType = currentToken.getType();
        String tokenText = currentToken.getText()  + " ";
        if (tokenType == BNFLexer.BAR && context.depth() < 4) {
            return "\n\t" + tokenText;
        }
        return tokenText;
    }
}