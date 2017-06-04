package org.tec.datastructures.SplayTree;

public class SplayTree<T extends Comparable> {
    private SplayNode root;

    public SplayTree() {
        this.root = null;
    }

    public SplayNode getRoot() {
        return this.root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, SplayNode node){
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

    public boolean insert(T data) {
        if (this.root == null) {
            this.root = new SplayNode(data);
            return true;
        }
        else
             return this.insert(data, this.root);
    }

    private boolean insert(T element, SplayNode node) {
        SplayNode newNode = new SplayNode(element); //Se crea el nuevo nodo a ser insertado
        if (node.getData().compareTo(element) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                splay(element);
                return true;
            } else {
                return insert(element, node.getLeft());
            }
        } else if (node.getData().compareTo(element) < 0) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                splay(element);
                return true;
            } else
                return insert(element, node.getRight());
        } else if(element == node.getData());
        this.root = splay(element);
        return false;
    }

    public boolean remove(T element){
        if (root == null) {
            return false;
        }

        SplayNode newTree;
        splay(element);

        if (root.getData().compareTo(element) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            }else {
                SplayNode aux = root.getRight();
                root = root.getLeft();
                root = splay(root, element);
                root.setRight(aux);
            }
            return true;
        } else {
            return false;
        }
    }

    public SplayNode search(T element) {
        splay(element);

        if(root.getData().compareTo(element) == 0){
            return this.root;
        } else{
            return null;
        }
    }

    private SplayNode splay(T element){
        if(this.root != null) {
            root = splay(root, element);
            return root;
        } else{
            return null;
        }
    }

    private SplayNode splay(SplayNode node, T element) {
        if (node == null){
            return null;
        }

        int cmp1 = element.compareTo(node.getData());

        if (cmp1 < 0) {
            if (node.getData() == null) {
                return node;
            }

            int cmp2 = element.compareTo(node.getLeft().getData());

            if (cmp2 < 0) {
                node.getLeft().setLeft(splay(node.getLeft().getLeft(), element));
                node = rotateRight(node);
            } else if (cmp2 > 0) {
                node.getLeft().setRight(splay(node.getLeft().getRight(), element));
                if (node.getLeft().getRight() != null)
                    node.setLeft(rotateLeft(node.getLeft()));
            }
            if (node.getLeft() == null) {
                return node;
            } else{
                return rotateRight(node);
            }
        }

        else if (cmp1 > 0) {
            if (node.getRight() == null) {
                return node;
            }

            int cmp2 = element.compareTo(node.getRight().getData());
            if (cmp2 < 0) {
                node.getRight().setLeft(splay(node.getRight().getLeft(), element));
                if (node.getRight().getLeft() != null)
                    node.setRight(rotateRight(node.getRight()));
            }
            else if (cmp2 > 0) {
                node.getRight().setRight(splay(node.getRight().getRight(), element));
                node = rotateLeft(node);
            }

            if (node.getRight() == null) return node;
            else                 return rotateLeft(node);
        }

        else return node;
    }

    private SplayNode rotateRight(SplayNode node){
        SplayNode temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }

    private SplayNode rotateLeft(SplayNode node){
        SplayNode temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }

    public void printPreOrder(SplayNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder(SplayNode node){
        if(node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrder(node.getRight());
        }
    }

    public void printPostOrder(SplayNode node){
        if(node != null){
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }
}