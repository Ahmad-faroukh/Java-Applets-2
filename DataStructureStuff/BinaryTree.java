package Archive.DataStructureStuff;

public class BinaryTree<E> {

    private E data = null;
    private BinaryTree<E> parent = null;
    private BinaryTree<E> left = null;
    private BinaryTree<E> right = null;

    public BinaryTree(E data) {
        this.data = data;
    }

    public void AddLeftChild(BinaryTree<E> left) {
        left.setParent(this);// assigns a parent to the inputted node
        this.setLeft(left);// adds the inputted node to the left side of the parent
    }

    public void AddRightChild(BinaryTree<E> right) {
        right.setParent(this);// assigns a parent to the inputted node
        this.setRight(right);// adds the inputted node to the right side of the parent
    }

    public void addParentToLeft(BinaryTree<E> parent) {
        this.setParent(parent);// adds the inputted node as a parent for the current node
        parent.setLeft(this);// adds the current parent to the left of the inputted node
    }

    public void addParentToRight(BinaryTree<E> parent) {
        this.setParent(parent);// adds the inputted node as a parent for the current node
        parent.setRight(this);// adds the current parent to the right of the inputted node
    }

    public BinaryTree<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<E> parent) {
        this.parent = parent;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}