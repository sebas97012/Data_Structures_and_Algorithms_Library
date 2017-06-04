package org.tec.datastructures.BinaryTree;

public class BinaryNode<T extends Comparable<T>>{
    private T data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(){
    }

    public BinaryNode(T data){
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode left, BinaryNode right){
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

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
