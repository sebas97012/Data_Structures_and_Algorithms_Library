package org.tec.datastructures.BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryNode root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, BinaryNode node){
        if(node == null){ //Si el arbol esta vacio
            return false;
        } else if(node.getData().compareTo(element) == 0) {
            return true;
        } else if (node.getData().compareTo(element) > 0){
            return contains(element, node.getLeft());
        } else if (node.getData().compareTo(element) < 0){
            return contains(element, node.getRight());
        } else{
            return false;
        }
    }

    public BinaryNode findMin(){
        return findMin(this.root);
    }

    private BinaryNode findMin(BinaryNode binaryNode){
        if(binaryNode == null){
            return null;
        } else if(binaryNode.getLeft() == null){
            return binaryNode;
        } else{
            return findMin(binaryNode.getLeft());
        }
    }

    public void insert(T element){
        this.root = this.insert(element, this.root);
    }

    private BinaryNode insert(T element, BinaryNode current){
        if(current == null){
            return new BinaryNode(element, null, null);
        } else if(current.getData().compareTo(element) > 0){
            current.setLeft(this.insert(element, current.getLeft()));
        } else if(current.getData().compareTo(element) < 0){
            current.setRight(this.insert(element, current.getRight()));
        }
        return current;
    }

    public void remove(T element){
        this.root = remove(element, this.root);
    }

    private BinaryNode remove(T element, BinaryNode node){
        if(node == null){
            return node;
        }
        if(node.getData().compareTo(element) > 0){
            node.setLeft(remove(element, node.getLeft()));
        } else if(node.getData().compareTo(element) < 0){
            node.setRight(remove(element, node.getRight()));
        } else if(node.getLeft() != null && node.getRight() != null){
            node.setData(findMin(node.getRight()).getData());
            T nodeData = (T) node.getData();
            node.setRight(remove(nodeData, node.getRight()));
        } else{
            node = node.getLeft() != null ? node.getLeft(): node.getRight();
        }
        return node;
    }

    public void printPreOrder(BinaryNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder(BinaryNode node){
        if(node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrder(node.getRight());
        }
    }

    public void printPostOrder(BinaryNode node){
        if(node != null){
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

}