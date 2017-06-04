package org.tec.datastructures.AVLTree;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode root;

    public AVLTree(){
        this.root = null;
    }

    public AVLNode getRoot() {
        return root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, AVLNode node){
        if(node == null){
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

    public AVLNode getElement(T element){
        return this.getElement(element, this.root);
    }

    private AVLNode getElement(T element, AVLNode node){
        if(node == null){
            return null;
        } else if(node.getData().compareTo(element) == 0){
            return node;
        } else if(node.getData().compareTo(element) < 0){
            return this.getElement(element, node.getRight());
        } else{
            return this.getElement(element, node.getLeft());
        }
    }

    private int getBalanceFactor(AVLNode node){
        if(node == null){
            return -1;
        } else{
            return node.getBalanceFactor();
        }
    }

    public AVLNode leftRotation(AVLNode node){
        AVLNode aux = node.getLeft();
        node.setLeft(aux.getRight());
        aux.setRight(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    public AVLNode rightRotation(AVLNode node){
        AVLNode aux = node.getRight();
        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    public AVLNode doubleLeftRotation(AVLNode node){
        AVLNode aux;
        node.setLeft(this.rightRotation(node.getLeft()));
        aux = leftRotation(node);
        return aux;
    }

    public AVLNode doubleRightRotation(AVLNode node) {
        AVLNode aux;
        node.setRight(this.leftRotation(node.getRight()));
        aux = rightRotation(node);
        return aux;
    }

    public void insert(T data){
        AVLNode newNode = new AVLNode(data);

        if(this.root == null){
            this.root = newNode;
        } else{
            this.root = insert(newNode, this.root);
        }
    }

    private AVLNode insert(AVLNode newNode, AVLNode subTree){
        AVLNode newParent = subTree;

        if(newNode.getData().compareTo(subTree.getData()) < 0){
            if(subTree.getLeft() == null){
                subTree.setLeft(newNode);
            } else{
                subTree.setLeft(insert(newNode, subTree.getLeft()));
                if(getBalanceFactor(subTree.getLeft()) - getBalanceFactor(subTree.getRight()) == 2){
                    if(newNode.getData().compareTo(subTree.getLeft().getData()) < 0){
                        newParent = this.leftRotation(subTree);
                    } else{
                        newParent = this.doubleLeftRotation(subTree);
                    }
                }
            }
        } else if(newNode.getData().compareTo(subTree.getData()) > 0){
            if(subTree.getRight() == null){
                subTree.setRight(newNode);
            } else{
                subTree.setRight(insert(newNode, subTree.getRight()));
                if((getBalanceFactor(subTree.getRight()) - getBalanceFactor(subTree.getLeft()) == 2)){
                    if(newNode.getData().compareTo(subTree.getRight().getData()) > 0){
                        newParent = rightRotation(subTree);
                    } else{
                        newParent = doubleRightRotation(subTree);
                    }
                }
            }
        } else{
            System.out.println("Error: Node already exists");
        }

        if((subTree.getLeft() == null) && (subTree.getRight() != null)){
            subTree.setBalanceFactor(subTree.getRight().getBalanceFactor() + 1);
        } else if((subTree.getRight() == null) && (subTree.getLeft() != null)){
            subTree.setBalanceFactor(subTree.getLeft().getBalanceFactor() + 1);
        } else{
            subTree.setBalanceFactor(Math.max(this.getBalanceFactor(subTree.getLeft()), this.getBalanceFactor(subTree.getRight())) + 1);
        }
        return newParent;
    }

    public void remove(T element){
        this.root = this.remove(element, this.root);
    }

    public AVLNode remove(T element, AVLNode node){
        if(node == null){
            return null;
        } else{
            if(node.getData().compareTo(element) < 0){
                node.setRight(remove(element, node.getRight()));
            } else if(node.getData().compareTo(element) > 0){
                node.setLeft(remove(element, node.getLeft()));
            } else if(node.getLeft() == null){
                node = node.getRight();
            } else if(node.getRight() == null){
                node = node.getLeft();
            } else if(getBalanceFactor(node.getLeft()) > getBalanceFactor(node.getRight())){
                node = rightRotation(node);
                node.setLeft(remove(element, node.getLeft()));
            } else{
                node = leftRotation(node);
                node.setRight(remove(element, node.getRight()));
            }

            if(node != null){
                node.setBalanceFactor(getBalanceFactor(node.getLeft()) + getBalanceFactor(node.getRight()));
            }
        }
        return node;
    }

    public void printPreOrder(AVLNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder(AVLNode node){
        if(node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrder(node.getRight());
        }
    }

    public void printPostOrder(AVLNode node){
        if(node != null){
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

}
