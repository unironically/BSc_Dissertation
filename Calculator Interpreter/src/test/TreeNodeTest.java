package test;

import main.TreeNode;
import main.TreeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to encapsulate JUnit test cases for the TreeNode class.
 */
public class TreeNodeTest {

    /**
     * TreeNode object to use within the test cases.
     */
    private TreeNode node;

    /**
     * Method to initialise the TreeNode object to use in the test cases.
     */
    @BeforeEach
    public void setUp() {
        node = new TreeNode(new TreeToken("+"));
    }

    /**
     * Method to test the ability to get a string representation of the TreeToken of a TreeNode.
     */
    @Test
    public void testTreeNodeCreate() {
        assertEquals("+", node.getToken().toString(), "TreeNode.getValue() returned a wrong TreeNode value.");
    }

    /**
     * Method to test the ability to add a left and right TreeNode child to a TreeNode object.
     */
    @Test
    public void testAddChild() {
        node.setLeft(new TreeNode(new TreeToken("10.0")));
        node.setRight(new TreeNode(new TreeToken("20.0")));
        assertEquals("10.0", node.getLeft().getToken().toString(),
                "TreeNode.getLeft() returned a wrong value.");
        assertEquals("20.0", node.getRight().getToken().toString(),
                "TreeNode.getRight() returned a wrong value.");
    }

}
