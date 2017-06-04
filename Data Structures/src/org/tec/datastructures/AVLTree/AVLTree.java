package org.tec.datastructures.AVLTree;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode root;

    public AVLTree(){
        this.root = null;
    }

    public AVLNode getRoot() {
        return root;
    }
    
    /**
     * Metodo que verifica si un elemento se encuentra dentro del arbol
     * @param data Elemento que se desea verificar si esta dentro del arbol
     * @return True si se encuentra, false en caso contrario
     */
    public boolean contains(T data) {
        return this.contains(data, this.root);
    }


    /**
     * Metodo recursivo que verifica si un elemento se encuentra dentro del arbol
     * @param element Elemento que se desea verificar si esta dentro del arbol
     * @param node BNode3 actual
     * @return True si se encuentra, false en caso contrario
     */
    private boolean contains(T element, AVLNode node){
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

    /**
     * Metodo para obtener un elemento del arbol
     * @param element
     * @return
     */
    public AVLNode getElement(T element){
        return this.getElement(element, this.root);
    }

    /**
     * Metodo recursivo para obtener un elemento del arbol
     * @param element Elemento que se desea obtener
     * @param node BNode3 actual en el recorrido
     * @return Se retorna el nodo con el elemento deseado
     */
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

    /**
     * Metodo para obtener el factor de balance de un nodo AVL
     * @param node BNode3 al que se le desea obtener el factor de balance
     * @return El factor de balance del nodo ingresado
     */
    private int getBalanceFactor(AVLNode node){
        if(node == null){
            return -1;
        } else{
            return node.getBalanceFactor();
        }
    }

    /**
     * Rotacion simple izquierda
     * @param node BNode3 que se desea balancear
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
    public AVLNode leftRotation(AVLNode node){
        AVLNode aux = node.getLeft();
        node.setLeft(aux.getRight());
        aux.setRight(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    /**
     * Rotacion simple derecha
     * @param node BNode3 que se desea balancear
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
    public AVLNode rightRotation(AVLNode node){
        AVLNode aux = node.getRight();
        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    /**
     * Rotacion doble izquierda
     * @param node BNode3 que se desea balancear
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
    public AVLNode doubleLeftRotation(AVLNode node){
        AVLNode aux;
        node.setLeft(this.rightRotation(node.getLeft()));
        aux = leftRotation(node);
        return aux;
    }

    /**
     * Rotacion doble derecha
     * @param node BNode3 que se desea balancear
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
    public AVLNode doubleRightRotation(AVLNode node) {
        AVLNode aux;
        node.setRight(this.leftRotation(node.getRight()));
        aux = rightRotation(node);
        return aux;
    }

    /**
     * Metodo para insertar un nuevo elemento en el arbol
     * @param data Dato que se desea insertar
     */
    public void insert(T data){
        AVLNode newNode = new AVLNode(data); //Se crea un nuevo nodo con el dato ingresado

        if(this.root == null){ //Caso en el que el arbol esta vacio
            this.root = newNode;
        } else{ //Caso en el que el arbol no esta vacio
            this.root = insert(newNode, this.root);
        }
    }

    /**
     * Metodo recursivo para insertar un nuevo nodo en el arbol de manera balanceada
     * @param newNode Nuevo nodo a insertar
     * @param subTree Subarbol
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
    private AVLNode insert(AVLNode newNode, AVLNode subTree){
        AVLNode newFather = subTree;

        if(newNode.getData().compareTo(subTree.getData()) < 0){
            if(subTree.getLeft() == null){
                subTree.setLeft(newNode);
            } else{
                subTree.setLeft(insert(newNode, subTree.getLeft()));
                if(getBalanceFactor(subTree.getLeft()) - getBalanceFactor(subTree.getRight()) == 2){
                    if(newNode.getData().compareTo(subTree.getLeft().getData()) < 0){
                        newFather = this.leftRotation(subTree);
                    } else{
                        newFather = this.doubleLeftRotation(subTree);
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
                        newFather = rightRotation(subTree);
                    } else{
                        newFather = doubleRightRotation(subTree);
                    }
                }
            }
        } else{
            System.out.println("BNode3 duplicado");
        }

        if((subTree.getLeft() == null) && (subTree.getRight() != null)){
            subTree.setBalanceFactor(subTree.getRight().getBalanceFactor() + 1);
        } else if((subTree.getRight() == null) && (subTree.getLeft() != null)){
            subTree.setBalanceFactor(subTree.getLeft().getBalanceFactor() + 1);
        } else{
            subTree.setBalanceFactor(Math.max(this.getBalanceFactor(subTree.getLeft()), this.getBalanceFactor(subTree.getRight())) + 1);
        }
        return newFather;
    }

    /**
     * Metodo para eliminar un elemento del arbol
     * @param element Elemento a eliminar
     */
    public void remove(T element){
        this.root = this.remove(element, this.root);
    }

    /**
     * Metodo auxiliar para eliminar el elemento ingresado del arbol
     * @param element Elemento que se desea eleminar
     * @param node BNode3 actual
     * @return BNode3 correspondiente segun el resultado del balanceo
     */
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

    /**
     * Metodo para imprimir el arbol en pre-orden
     * @param node
     */
    public void printPreOrder(AVLNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en orden
     * @param node
     */
    public void printInOrder(AVLNode node){
        if(node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrder(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en postorden
     * @param node
     */
    public void printPostOrder(AVLNode node){
        if(node != null){
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

}
