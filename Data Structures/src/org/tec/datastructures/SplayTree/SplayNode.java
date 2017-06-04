package org.tec.datastructures.SplayTree;

public class SplayNode<T extends Comparable>{
    private T data;
    private SplayNode left;
    private SplayNode right;

    public SplayNode(T data){
        this(data, null, null);
    }

    public SplayNode(T data, SplayNode left, SplayNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SplayNode getLeft() {
        return left;
    }

    public void setLeft(SplayNode left) {
        this.left = left;
    }

    public SplayNode getRight() {
        return right;
    }

    public void setRight(SplayNode right) {
        this.right = right;
    }
}
