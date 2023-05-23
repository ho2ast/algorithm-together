package datastructure.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();

        heap.add(3);
        heap.add(10);
        heap.add(2);
        heap.add(5);
        heap.add(15);
        heap.add(43);
        heap.add(28);
        heap.add(33);
        heap.add(39);

        Object[] array1 = heap.toArray();

        for (Object a : array1) {
            System.out.println(a);
        }

        while (heap.size > 0) {
            System.out.println(heap.remove());
        }

    }

    private final Comparator<? super E> comparator;
    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];

        for (int i = 1; i < array.length; i++) {
            newArray[i] = array[i];
        }

        this.array = null;
        this.array = newArray;
    }

    private void add(E value) {
        if (size + 1 == array.length) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int index, E value) {
        if (comparator == null) {
            siftUpComparable(index, value);
            return;
        }

        siftUpComparator(index, value, comparator);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int index, E value, Comparator<? super E> comparator) {

        while (index > 1) {
            int parentIndex = getParent(index);
            Object parentValue = array[parentIndex];

            // value 가 부모 값보다 크거나 같으면 종료.
            if (comparator.compare(value, (E) parentValue) >= 0) {
                break;
            }

            array[index] = parentValue;
            index = parentIndex;
        }

        array[index] = value;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int index, E value) {
        Comparable<? super E> comp = (Comparable<? super E>) value;
        while (index > 1) {
            int parentIndex = getParent(index);
            Object parentValue = array[parentIndex];

            // value 가 부모 값보다 크거나 같으면 종료.
            if (comp.compareTo((E) parentValue) >= 0) {
                break;
            }

            array[index] = parentValue;
            index = parentIndex;
        }

        array[index] = comp;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (array[1] == null) {
            throw new NoSuchElementException();
        }

        E result = (E) array[1];
        E target = (E) array[size];

        siftDown(1, target);
        return result;
    }

    public void siftDown(int index, E target) {
        if (comparator == null) {
            siftDownComparable(index, target);
            return;
        }

        siftDownComparator(index, target, comparator);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int index, E target, Comparator<? super E> comparator) {
        array[index] = null;
        size--;

        int parent = index;
        int child;

        // 자식의 인덱스보다 사이즈가 작다는 것은 자식이 없다는 의미
        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);

            // 왼쪽 자식 값
            Object childValue = array[child];
            // 오른쪽 자식이 없고, 왼쪽 자식이 오른쪽 자식값 보다 크다면 교체
            // 자식 값 중 작은 값과 교환
            if (right <= size && comparator.compare((E) childValue, (E) array[right]) > 0) {
                child = right;
                childValue = array[child];
            }

            // 자식 값보다 크거나 같으면 종료
            if (comparator.compare(target, (E) childValue) <= 0) {
                break;
            }

            array[parent] = childValue;
            parent = child;
        }

        array[parent] = target;

        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int index, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[index] = null;
        size--;

        int parent = index;
        int child;

        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);

            Object childValue = array[child];

            if (right <= size && ((Comparable<? super E>) childValue).compareTo((E) array[right]) > 0) {
                child = right;
                childValue = array[child];
            }

            if (comp.compareTo((E) childValue) <= 0) {
                break;
            }

            array[parent] = childValue;
            parent = child;
        }

        array[parent] = comp;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size + 1);
    }
}
