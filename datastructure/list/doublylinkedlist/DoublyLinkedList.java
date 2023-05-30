package datastructure.list.doublylinkedlist;

import datastructure.list.List;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(1);
        dll.add(3);
        dll.add(4);
        dll.add(2);
        dll.add(6);
        dll.add(7);
        System.out.println(dll.indexOf(3));
        dll.add(1, 10);
        System.out.println(dll.indexOf(10));
        System.out.println(dll.contains(10));
        dll.remove();
        System.out.println(dll.indexOf(10));
        System.out.println(dll.get(1));
    }

    public Node<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size / 2 < index + 1) {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        } else {
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }
        head = null;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (size == 0) {
            addFirst(value);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
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

        Node<E> newNode = new Node<>(value);
        Node<E> prevNode = search(index - 1);
        Node<E> nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }

    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node<E> headNode = head;
        E element = headNode.data;
        Node<E> headNext = head.next;

        head.data = null;
        head.next = null;

        if (headNext != null) {
            headNext.prev = null;
        }

        head = headNext;
        size--;

        if (size == 0) {
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return remove();
        }

        Node<E> deleteNode = search(index);
        E element = deleteNode.data;
        Node<E> prevNode = deleteNode.prev;
        Node<E> nextNode = deleteNode.next;

        prevNode.next = null;
        deleteNode.data = null;
        deleteNode.prev = null;
        deleteNode.next = null;

        if (nextNode != null) {
            nextNode.prev = null;
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        } else {
            tail = prevNode;
        }

        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;
        Node<E> x = head;

        do {
            if (value.equals(x.data)) {
                break;
            }
            prevNode = x;
            x = x.next;
        } while (x != null);

        if (x == null) {
            return false;
        }

        if (x.equals(head)) {
            remove();
            return true;
        } else {
            Node<E> nextNode = x.next;

            prevNode.next = null;
            x.data = null;
            x.prev = null;
            x.next = null;

            if (nextNode != null) {
                nextNode.prev = null;
                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            } else {
                tail = prevNode;
            }
        }

        size--;
        return true;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> target = search(index);
        target.data = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        Node<E> node = head;
        int index = 0;
        do {
            if (value.equals(node.data)) {
                return index;
            }
            node = node.next;
            index++;
        } while (node != null);

        return -1;
    }

    public int lastIndexOf(Object value) {
        Node<E> node = tail;
        int index = size - 1;
        do {
            if (value.equals(node.data)) {
                return index;
            }
            node = node.prev;
            index--;
        } while (node != null);

        return -1;
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
        Node<E> node = head;
        do {
            Node<E> nextNode = node.next;
            node.data = null;
            node.prev = null;
            node.next = null;
            node = nextNode;
        } while (node != null);
        head = tail = null;
        size = 0;
    }
}

class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}