package Archive.Tree;

public class Node_BT<E> {
    E data ;
    Node_BT<E> parent;
    Node_BT<E> right;
    Node_BT<E> left;

    public Node_BT(E data) {
        this.data = data;
    }

    public Node_BT<E> getParent() {
        return parent;
    }

    public void setParent(Node_BT<E> parent) {
        this.parent = parent;
    }

    public Node_BT<E> getRight() {
        return right;
    }

    public void setRight(Node_BT<E> right) {
        this.right = right;
    }

    public Node_BT<E> getLeft() {
        return left;
    }

    public void setLeft(Node_BT<E> left) {
        this.left = left;
    }

    public void addParent(Node_BT newNode){
        this.setParent(newNode);
    }

    public void addToRight(Node_BT newNode){
        this.setRight(newNode);
        newNode.setParent(this);
    }

    public void addToLeft(Node_BT newNode){
        this.setLeft(newNode);
        newNode.setParent(this);
    }
}