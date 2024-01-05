import java.util.ArrayList;
import java.util.Arrays;

public class j091_arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        /*
        *  ArrayList is class, it is present on java.util.
        * <Integer> this use to sey Array is store integer value only
        * l1 is ArrayList<> class object
        * use ArrayList<> class to perform many tasks like
        * add it index, get array value, add another array, replace value, get index, and many more
        * goto (https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html) for more information
        */

        l1.add(2);
        // add(indexNumber, value) use add() method to add value on an array
        // if you add on 1 index like l1.add(1, 5) than this set on index 1 value 5
        // else add on last of a list
        // and already existing value goto next index value automatically
        l1.add(3);
        l1.add(1, 5); // add on index 1 value 5
        l1.addFirst(4); // add on a first element
        l1.add(5);
        l1.addLast(8); // add on last element

        l2.add(10);
        l2.add(11);
        l2.add(12);

        l2.set(2, 18); // set() method replace value at provided index
        // here replace 12 with 18

        l1.addAll(l2); // addAll(indexValue, array) add another array on this array. default adds on last index to continue

        for (int i = 0; i < l1.size(); i++) { // find length of array than use size() method
            System.out.print(l1.get(i)); // use get() method to get array value at index
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(l1.getFirst()); // get a first element in an array
        System.out.println(l1.getLast()); // get a last element in an array

        System.out.println(l1.clone()); // return clone object

        System.out.println(l1.indexOf(8)); // return index of value at provided index
        System.out.println(l1.indexOf(88)); // if not present than return -1

        System.out.println(l1.lastIndexOf(5)); // return last of index value
        // most use, if two sem values present on an array than 2nd value index find use lastIndexOf() method

        l1.remove(7); // remove element at provided index
        l1.removeFirst(); // remove first element
        l1.removeLast(); // remove last element
        for (int i = 0; i < l1.size(); i++) { // find length of array than use size() method
            System.out.print(l1.get(i)); // use get() method to get array value at index
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(l1.subList(2, 4)); // return 2 to 4 index values as an object

        System.out.println(l1.contains(8)); // return true if value exists on array
        System.out.println(l1.contains(88));

        l1.clear(); // delete array
     }
}
