package Lists;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_THRESHOLD = 0.75f;

    private Object[] data;
    private int capacity;
    private int size;

    private boolean checkThreshold() {
        float fillRatio = (float) size / capacity;
        return fillRatio >= GROW_THRESHOLD;
    }

    private Object[] getResizedData() {
        System.out.println("CustomArrayList " + this + " has been resized");
        this.capacity += this.capacity >> 1;
        return new Object[this.capacity];
    }

    public CustomArrayList(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.data = new Object[capacity];
        } else if (capacity == 0) {
            this.data = new Object[0];
            this.capacity = 0;
        } else {
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
    }

    public CustomArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.data = new Object[capacity];
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, this.size);
        Object[] tempData = checkThreshold() ? this.getResizedData() : new Object[this.capacity];
        System.arraycopy(this.data, 0, tempData, 0, index);
        tempData[index] = element;
        System.arraycopy(this.data, index, tempData, index + 1, this.size - index);
        this.data = tempData;
        this.size++;
    }

    public void add(T element) {
        if (checkThreshold()) {
            Object[] resizedData = this.getResizedData();
            System.arraycopy(this.data, 0, resizedData, 0, this.size);
            this.data = resizedData;
        }
        this.data[this.size] = element;
        this.size++;
    }


    public T remove(int index) {
        Objects.checkIndex(index, this.size);
        @SuppressWarnings("unchecked") T removeValue = (T) this.data[index];
        Object[] oldData = this.data;
        int newSize = this.size - 1;
        if (newSize > index)
            System.arraycopy(oldData, index + 1, oldData, index, newSize - index);
        this.size = newSize;
        oldData[this.size] = null;
        return removeValue;
    }

    @Override
    public String toString() {
        if (this.size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.data[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(", ");
            sb.append(this.data[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
