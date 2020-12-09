package main;

/**
 * Class representing the nodes of a ReducedInputTree object.
 */
public class TreeNode {

    /**
     * TreeNodes for left and right children of the current TreeNode.
     */
    private TreeNode left, right;

    /**
     * TreeToken token for the current TreeNode.
     */
    private TreeToken token;

    /**
     * Constructor for TreeNode objects.
     * @param token TreeToken token of the current TreeNode.
     */
    public TreeNode(TreeToken token) {
        this.token = token;
    }

    /**
     * Method to get the TreeToken object of a TreeNode.
     * @return TreeToken object of the TreeNode.
     */
    public TreeToken getToken() {
        return token;
    }

    /**
     * Method to set the left child of a TreeNode.
     * @param left TreeNode object to add as a left child.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Method to set the right child of a TreeNode.
     * @param right TreeNode object to add as a right child.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Method to get the left TreeNode child of the current TreeNode.
     * @return TreeNode left child object.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Method to get the right TreeNode child of the current TreeNode.
     * @return TreeNode right child object.
     */
    public TreeNode getRight() {
        return right;
    }

}
