import Lists.CustomArrayList;
import Sets.CustomHashSet;

import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayListTest = new CustomArrayList<>();
        System.out.println("Default capacity: " + arrayListTest.getCapacity());
        int removeIndex = 0;
        int addIndex = 4;
        arrayListTest.add(1);
        arrayListTest.add(2);
        arrayListTest.add(3);
        arrayListTest.add(4);
        arrayListTest.add(5);
        arrayListTest.add(6);
        arrayListTest.add(7);
        arrayListTest.add(8);
        arrayListTest.add(9);
        System.out.println("Current capacity: " + arrayListTest.getCapacity());
        System.out.println(arrayListTest);
        int removedValue = arrayListTest.remove(0);
        System.out.println("Removed element at index " + removeIndex + ": " + removedValue + "\n" + arrayListTest);
        arrayListTest.add(addIndex, removedValue);
        System.out.println("Added removed value (" + removedValue + ") at index " + addIndex + "\n" + arrayListTest);

        CustomHashSet<String> hashTest = new CustomHashSet<>();
        hashTest.put("Java");
        hashTest.put("C++");
        hashTest.put("Python");
        hashTest.put("Ruby");
        hashTest.put("Assembler");
        hashTest.put("C#");
        hashTest.put("C");
        hashTest.put("php");
        hashTest.put("Pascal");
        hashTest.put("Fortran");
        hashTest.put("Delphi");
        hashTest.put("HolyC");
        hashTest.put("Haskell");
        System.out.println("Set size: " + hashTest.size());
        for (String s: hashTest){
            System.out.print(s + " ");
        }
        System.out.println("\nAttempt to add Java: " + hashTest.put("Java"));
        System.out.println("Set contains string \"C++\": " + hashTest.contains("C++"));
        System.out.println("Attempt to remove something that is not in the set: " + hashTest.delete("Capybara"));
        System.out.println("Removing string \"C++\": " + hashTest.delete("C++"));
        System.out.println("Set size: " + hashTest.size());
        for (String s: hashTest){
            System.out.print(s + " ");
        }
    }
}