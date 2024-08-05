import Lists.CustomArrayList;

import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> test = new CustomArrayList<>();
        System.out.println("Default capacity: " + test.getCapacity());
        int removeIndex = 0;
        int addIndex = 4;
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        System.out.println("Current capacity: " + test.getCapacity());
        System.out.println(test);
        int removedValue = test.remove(0);
        System.out.println("Removed element at index " + removeIndex + ": " + removedValue + "\n" + test);
        test.add(addIndex, removedValue);
        System.out.println("Added removed value (" + removedValue + ") at index " + addIndex + "\n" + test);
    }
}