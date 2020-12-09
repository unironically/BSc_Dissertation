package main;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Class for creating reduced syntax trees from ANTLR-generated syntax trees, which we can then use to convert an
 * expression to stack code.
 */
public class ReducedInputTree {

    /**
     * TreeNode root of the ReducedInputTree object.
     */
    private TreeNode root;

    /**
     * Constructor to invoke the method to reduce the ANTLR tree and initialise the root.
     * @param tree ParseTree generated by ANTLR to be reduced.
     */
    public ReducedInputTree(ParseTree tree) {
        this.root = reduce(tree);
    }

    /**
     * Method to get the root of the ReducedInputTree object.
     * @return TreeNode root of the tree.
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Recursive method to generated a reduced input tree from the ANTLR-generated tree of a user's expression input
     * by skipping redundant inner nodes.
     * @param tree ParseTree generated by ANTLR to be reduced.
     * @return TreeNode representing the root of the current sub-tree.
     */
    private TreeNode reduce(ParseTree tree) {
        String className = tree.getClass().getCanonicalName();
        int childCount = tree.getChildCount();
        if ((className.endsWith("ExpressionContext") || className.endsWith("CommandContext")) && childCount > 1) {
            TreeToken newToken = new TreeToken(tree.getChild(1).getText());
            TreeNode currentNode = new TreeNode(newToken);
            currentNode.setLeft(reduce(tree.getChild(0)));
            currentNode.setRight(reduce(tree.getChild(2)));
            return currentNode;
        } else if (className.endsWith("TermContext") || className.endsWith("ExpressionContext")) {
            return reduce(tree.getChild(Math.floorDiv(childCount, 2)));
        }
        TreeToken newToken = new TreeToken(tree.getText());
        return new TreeNode(newToken);
    }

}