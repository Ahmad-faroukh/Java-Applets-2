package Archive.Tree;

import java.util.ArrayList;

class Node<E> {
    Node<E> parent ;
    ArrayList<Node<E>> children = new ArrayList<>();
    E data;

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public ArrayList<Node<E>> getChildren() {
        return children;
    }

    public void setChild(Node<E> child) {
        children.add(child);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void addChild(Node<E> child){
        this.setChild(child);
        child.setParent(this);
    }

    public void addParent(Node<E> parent){
        this.setParent(parent);
        parent.setChild(this);
    }

    public boolean isRoot(){
        return (parent==null);
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }
}