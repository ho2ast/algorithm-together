package datastructure.list.singlylinkedlist;

import datastructure.list.List;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.add(7);
        singlyLinkedList.add(5, 6);
        singlyLinkedList.remove();

        System.out.println(singlyLinkedList);
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> prevNode = search(index - 1);
        Node<E> nextNode = prevNode.next;

        Node<E> newNode = new Node<>(value);

        prevNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);

        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(E value) {
        if (size == 0) {
            addFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public E remove() {
        Node<E> headNode = head;

        if (headNode == null) {
            throw new NoSuchElementException();
        }

        E element = headNode.value;

        Node<E> nextNode = headNode.next;

        head.value = null;
        head.next = null;

        head = nextNode;
        size--;

        if (size == 0) {
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            return remove();
        }

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index - 1);
        Node<E> node = prevNode.next;
        E element = node.value;

        prevNode.next = node.next;

        if (prevNode.next == null) {
            tail = prevNode;
        }

        node.next = null;
        node.value = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> node = head;

        while (node != null) {
            if (value.equals(node.value)) {
                hasValue = true;
                break;
            }
            prevNode = node;
            node = node.next;
        }

        if (node == null) {
            return false;
        }

        if (node.equals(head)) {
            remove();
            return true;
        } else {
            prevNode.next = node.next;
            if (prevNode.next == null) {
                tail = prevNode;
            }
            node.next = null;
            node.value = null;
            size--;
            return true;
        }
    }

    @Override
    public E get(int index) {
        return search(index).value;
    }

    @Override
    public void set(int index, E value) {
        Node<E> node = search(index);
        node.value = value;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for (Node<E> node = head; node != null; node = node.next) {
            if (value.equals(node.value)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> nextNode = node.next;
            node.value = null;
            node.next = null;
            node = nextNode;
        }
        head = tail = null;
        size = 0;
    }
}

class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }
}
