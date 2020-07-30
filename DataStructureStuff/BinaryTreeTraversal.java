package Archive.DataStructureStuff;

class BinaryTreeTraversal {

    BinaryTree treeNode;

    public BinaryTreeTraversal(BinaryTree treeNode) {
        this.treeNode = treeNode;
    }

    // Inorder (Left, Node, Right)
    void inOrder(BinaryTree root) {
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getData() + "-");
        inOrder(root.getRight());
    }

    // Pre-order (node, Left, Right)
    void preOrder(BinaryTree root) {
        if (root == null)
            return;
        System.out.print(root.getData() + "-");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //Post-order (Left, Right, node)
    void postOrder(BinaryTree root) {
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + "-");
    }

    //find the height of the tree (how many levees starting from the root)
     int height(BinaryTree root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        if (leftHeight > rightHeight)
            return (leftHeight + 1);
        else return (rightHeight + 1);
    }

    //prints out the contents of an inputted level
     void printLevel(BinaryTree root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getData() + "-");
        else if (level > 1) {
            printLevel(root.getLeft(), level - 1);
            printLevel(root.getRight(), level - 1);
        }
    }

    //prints the contents of a tree in ascending order
    void levelOrder(BinaryTree root) {
        int temp = this.height(root);

        for (int i = 0; i < temp; i++)
            printLevel(root, i + 1);
        System.out.println("\b");
    }
}