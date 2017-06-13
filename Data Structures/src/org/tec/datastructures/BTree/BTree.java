package org.tec.datastructures.BTree;

public class BTree<Key extends Comparable<Key>> {
    private int order;
    private Node root;
    private int height;
    private int n;

    private static final class Node {
        private int m;
        private Entry[] children;

        private Node(int k, int order) {
            m = k;
            children = new Entry[order];
        }
    }

    private static class Entry {
        private Comparable key;
        private Node next;

        public Entry(Comparable key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * Initializes the tree.
     */
    public BTree(int order) {
        root = new Node(0, order);
        this.order = order;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    /**
     * Returns the height of this B-tree
     *
     * @return the height of this B-tree
     */
    public int height() {
        return height;
    }

    public void put(Key key) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, height);
        n++;
        if (u == null) return;

        Node t = new Node(2, order);
        t.children[0] = new Entry(root.children[0].key, root);
        t.children[1] = new Entry(u.children[0].key, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, int ht) {
        int j;
        Entry t = new Entry(key, null);

        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }

        else {
            for (j = 0; j < h.m; j++) {
                if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
                    Node u = insert(h.children[j++].next, key, ht - 1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i - 1];
        h.children[j] = t;
        h.m++;
        if (h.m < order) return null;
        else return split(h);
    }

    private Node split(Node h) {
        Node t = new Node(order / 2, order);
        h.m = order / 2;
        for (int j = 0; j < order / 2; j++)
            t.children[j] = h.children[order / 2 + j];
        return t;
    }

    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + "\n");
            }
        } else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + ")\n");
                s.append(toString(children[j].next, ht - 1, indent + "     "));
            }
        }
        return s.toString();
    }

    private boolean less(Comparable c, Comparable c2) {
        return c.compareTo(c2) < 0;
    }

    private boolean eq(Comparable c, Comparable c2) {
        return c.compareTo(c2) == 0;
    }
}
