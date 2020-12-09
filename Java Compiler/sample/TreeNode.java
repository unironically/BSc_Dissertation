public class TreeNode {

    public String value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String value) {
        this(value, null, null);
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void printTree() {
        System.out.println(value);
        if (left != null) left.printTree();
        if (right != null) right.printTree();
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode("first");
        TreeNode second = new TreeNode("second");
        TreeNode root = new TreeNode("root", first, second);
        root.printTree();
    }

}