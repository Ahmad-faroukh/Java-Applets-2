package Archive.DataStructureStuff;

public class TreeTest {
    public static void main(String[] args) {

        BinaryTree treeNode1 = new BinaryTree(1);
        BinaryTree treeNode2 = new BinaryTree(2);
        BinaryTree treeNode3 = new BinaryTree(3);
        BinaryTree treeNode4 = new BinaryTree(4);
        BinaryTree treeNode5 = new BinaryTree(5);

        // Note that treeNode1 is the tree root
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);

        BinaryTreeTraversal traversal = new BinaryTreeTraversal(treeNode1);


        System.out.print("Tree Height : ");
        System.out.println(traversal.height(treeNode1));

        System.out.print("The Second Level : ");
        traversal.printLevel(treeNode1,2);//prints the second level
        System.out.println("\b");

        System.out.print("invoiceController-Order : ");
        traversal.inOrder(treeNode1);
        System.out.println("\b");

        System.out.print("Pre-Order : ");
        traversal.preOrder(treeNode1);
        System.out.println("\b");

        System.out.print("Post-Order : ");
        traversal.postOrder(treeNode1);
        System.out.println("\b");

        System.out.print("Level Order : ");
        traversal.levelOrder(treeNode1);
        System.out.println("\b");

    }
}