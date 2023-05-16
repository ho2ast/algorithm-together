package datastructure.tree.binarysearchtree;

import java.util.Comparator;

public class BinarySearchTree<E> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(7);
        tree.add(8);
        tree.add(1);

        System.out.println(tree);
    }

    private Node<E> root;
    private int size;
    private final Comparator<? super E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    public boolean add(E value) {
        if (comparator == null) {
            return addUsingComparable(value) == null;
        }
        return addUsingComparator(value, comparator) == null;
    }

    private E addUsingComparator(E value, Comparator<? super E> comp) {
        Node<E> current = root;

        if (current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;

        do {
            currentParent = current;
            compResult = comp.compare(value, current.value);

            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }
        } while (current != null);

        Node<E> newNode = new Node<E>(value, currentParent);
        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }
        size++;
        return null;
    }

    private E addUsingComparable(E value) {
        Node<E> current = root;

        if (current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;

        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue = (Comparable<? super E>) value;

        int compResult;

        do {
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }
        } while (current != null);

        Node<E> newNode = new Node<E>(value, currentParent);

        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }

        size++;
        return null;
    }
}

class Node<E> {
    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    Node(E value) {
        this(value, null);
    }

    Node(E value, Node<E> parent) {
        this.value = value;
        this.parent = parent;
        this.right = null;
        this.left = null;
    }
}
