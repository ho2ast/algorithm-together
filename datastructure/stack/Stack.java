package datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E>, Cloneable{

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.peek());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.search(3));
        System.out.println(s.search(2));
    }
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
        }

        int arrayCapacity = array.length;

        if (size == arrayCapacity) {
            int newCapacity = size * 2;
            array = Arrays.copyOf(array, newCapacity);
            return;
        }

        if (size < arrayCapacity / 2) {
            int newCapacity = (arrayCapacity / 2);
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }

    @Override
    public E push(E item) {
        if (size == array.length) {
            resize();
        }

        array[size] = item;
        size++;

        return item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E element = (E) array[size - 1];
        array[size - 1] = null;

        size--;
        resize();

        return element;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E element = (E) array[size - 1];

        return element;
    }

    @Override
    public int search(Object value) {
        if (value == null) {
            for (int i = size - 1; i > -1; i--) {
                if (array[i] == null) {
                    return size - i;
                }
            }
        } else {
            for (int i = size - 1; i > -1; i--) {
                if (value.equals(array[i])) {
                    return size - i;
                }
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
        resize();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Object clone() throws CloneNotSupportedException {
        Stack<?> cloneStack = (Stack<?>) super.clone();

        cloneStack.array = new Object[size];

        System.arraycopy(array, 0, cloneStack.array, 0, size);
        return cloneStack.array;
    }
}
