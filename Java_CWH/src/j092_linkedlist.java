import java.util.LinkedList;

public class j092_linkedlist {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        /*
         * LInkedList is class, it is present on java.util.
         * <Integer> this use to say LInkedList is store integer value only
         * l1 is LInkedList<> class object
         * use LInkedList<> class to perform many tasks like
         * add it nodeNumber, get node value, add another node, replace value, get nodeNumber,
         * and many more
         * goto (https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/LinkedList.html) for more information
         */

        l1.add(2);
        // add(nodeNumberNumber, value) use add() method to add value on a LInkedList
        // if you add on 1 nodeNumber like l1.add(1, 5) than this set on nodeNumber 1 value 5
        // else add on last of a list
        // and already existing value goto next nodeNumber value automatically
        l1.add(3);
        l1.add(1, 5); // add on nodeNumber 1 value 5
        l1.addFirst(4); // add on a first element
        l1.add(5);
        l1.addLast(8); // add on last element

        l2.add(10);
        l2.add(11);
        l2.add(12);

        l2.set(2, 18); // set() method replace value at provided nodeNumber
        // here replace 12 with 18

        l1.addAll(l2); // addAll(nodeNumberValue, LInkedList) add another LInkedList on this LInkedList.
        // default adds on
        // last nodeNumber to continue

        for (int i = 0; i < l1.size(); i++) { // find length of LInkedList than use size() method
            System.out.print(l1.get(i)); // use get() method to get LInkedList value at nodeNumber
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(l1.getFirst()); // get a first element in an LInkedList
        System.out.println(l1.getLast()); // get a last element in an LInkedList

        System.out.println(l1.clone()); // return clone object

        // System.out.println(l1.nodeNumberOf(8)); // return nodeNumber of value at provided nodeNumber
        System.out.println(l1.indexOf(88)); // if not present than return -1

        System.out.println(l1.lastIndexOf(5)); // return last of nodeNumber value
        // most use, if two sem values present on a LInkedList than 2nd value nodeNumber
        // find use
        // lastnodeNumberOf() method

        l1.remove(7); // remove element at provided nodeNumber
        l1.removeFirst(); // remove first element
        l1.removeLast(); // remove last element
        for (int i = 0; i < l1.size(); i++) { // find length of LInkedList than use size() method
            System.out.print(l1.get(i)); // use get() method to get LInkedList value at nodeNumber
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(l1.subList(2, 4)); // return 2 to 4 nodeNumber values as an object

        System.out.println(l1.contains(8)); // return true if value exists on LInkedList
        System.out.println(l1.contains(88));

        l1.clear(); // delete LInkedList
    }
}
