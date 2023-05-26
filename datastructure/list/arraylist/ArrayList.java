package datastructure.list.arraylist;

import datastructure.list.List;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        System.out.println(array);
    }
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private int size;
    private Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        int array_capacity = array.length;

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if (size == array_capacity) {
            this.array = Arrays.copyOf(array, array_capacity * 2);
            return;
        }

        if (size < array_capacity / 2) {
            this.array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, array_capacity / 2));
        }
    }

    public void addLast(E value) {
        if (size == array.length) {
            resize();
        }

        array[size] = value;
        size++;
    }

    public void addFirst(E value) {
        add(0, value);
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
        if (index == size) {
            addLast(value);
        } else {
            if (size == array.length) {
                resize();
            }
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[index];

        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }

        array[size] = null;
        size--;
        resize();

        return item;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index > -1) {
            remove(index);
        } else {
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) > -1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            };
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size - 1; i > -1; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }

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
        for (int to = size, i = size = 0; i < to; i++) {
            array[i] = null;
        }

        resize();
    }
}
