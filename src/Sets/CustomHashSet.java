package Sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashSet<T> implements Iterable<T> {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;

    private Object[] data;
    private int size;

    private class CustomIterator implements Iterator<T> {

        private int currentIndex = 0;
        private int elementsVisited = 0;

        @Override
        public boolean hasNext() {
            return this.elementsVisited < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            while (currentIndex < data.length && data[currentIndex] == null)
                currentIndex++;
            if(currentIndex >= data.length){
                throw new NoSuchElementException();
            }
            elementsVisited++;
            return (T) data[currentIndex++];
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (this.size >= this.data.length * LOAD_FACTOR) {
            System.out.println("Set " + this + " just got resized");
            int newSize = this.data.length * 2;
            Object[] newData = new Object[newSize];
            for (Object element : this.data) {
                if (element != null) {
                    int index = getIndex((T) element, newSize);
                    while (newData[index] != null) {
                        index = (index + 1) % newSize;
                    }
                    newData[index] = element;
                }
            }
            this.data = newData;
        }
    }

    private int getIndex(T element) {
        return getIndex(element, this.data.length);
    }

    private int getIndex(T element, int length) {
        return Math.abs(element.hashCode() % length);
    }

    public CustomHashSet() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean put(T element) {
        ensureCapacity();
        int index = getIndex(element);
        if (this.data[index] == null) {
            this.data[index] = element;
            this.size++;
            return true;
        } else if (data[index].equals(element)) {
            return false;
        } else {
            for (int i = index + 1; i != index; i = (i + 1) % this.data.length) {
                if (this.data[i] == null) {
                    this.data[i] = element;
                    this.size++;
                    return true;
                } else if (this.data[i].equals(element)) {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean contains(T element) {
        int index = getIndex(element);
        if (this.data[index] == null) {
            return false;
        } else if (this.data[index].equals(element)) {
            return true;
        } else {
            for (int i = index + 1; i != index; i = (i + 1) % this.data.length) {
                if (this.data[i] == null) {
                    return false;
                } else if (this.data[i].equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(T element) {
        int index = getIndex(element);
        if (this.data[index] == null) {
            return false;
        } else if (this.data[index].equals(element)) {
            this.data[index] = null;
            this.size--;
            return true;
        } else {
            for (int i = index + 1; i != index; i = (i + 1) % this.data.length) {
                if (this.data[i] == null) {
                    return false;
                } else if (this.data[i].equals(element)) {
                    this.data[i] = null;
                    this.size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }
}
