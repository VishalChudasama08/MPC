import java.util.ArrayDeque;

public class j093_arraydeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        // ArrayDeque is java class present on java.util
        // Deque is Array. use to add and remove an element on the first and last side
        // for more information goto -> https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html

        d.add(20); // use add() method to Insert an element at the end of deque
        d.add(30);
        d.add(40);
        // d.addAll(d1); // addAll() add another deque at the end of deque

        d.addFirst(10); // add an element at first in deque
        d.addLast(50); // add an element at last in deque, it is sem as add() method

        System.out.println(d.getFirst()); // get a first element
        System.out.println(d.getLast()); // get a last element

        Integer [] arrayd = d.toArray(new Integer[0]); // convert on an array
        for (int i = 0; i < arrayd.length; i++) { // using for loop print array elements
            System.out.print(arrayd[i]);
            System.out.print(", ");
        }
        System.out.println();

        d.offer(60); // add an element at the end of deque
        d.offerFirst(5); // add an element at first of deque
        d.offerLast(70); // add an element at the end of deque, sem as offer() method

        System.out.println(d.peek()); // return an element at first of deque
        System.out.println(d.peekFirst()); // return an element at first of deque
        System.out.println(d.peekLast()); // return an element at the end of deque
        // Note: use peek to only return an element not remove an element, if not exit than return null
        System.out.println();

        System.out.println(d.poll()); // return and remove an element at first of deque
        System.out.println(d.pollFirst());// return and remove an element at first of deque,
        // this returns 10 because 5 is removed
        System.out.println(d.pollLast());// return and remove an element at the end of deque
        // Note: use a poll() methods than this is return an element and remove this element also
        System.out.println();

        System.out.println(d.pop()); // return and remove an element at first of deque

        d.push(80); // add an element at a first

        for (int i = 0; i < d.size(); i++) { // .size() get deque size
            System.out.print( (d.toArray())[i] ); // directly print, d.toArray() convert in array
            // and it with use [i] print it, it mins (d.toArray()) this is new array and [i] is its index
            // and System.out.print() print it
            System.out.print(", ");
        }
        System.out.println();

        d.add(70);
        d.add(60);
        d.add(90);
        System.out.println(d.remove()); // remove and return first an element
        System.out.println(d.remove(50)); // add argument than if remove than return true else false
        System.out.println(d.removeFirst()); // remove and return first an element
        System.out.println(d.removeFirstOccurrence(30)); // if remove it than return true else false

        System.out.println(d.removeLast()); // remove and return last an element
        System.out.println(d.removeLastOccurrence(60)); // if remove it than return true else false

        for (int i = 0; i < d.size(); i++) {
            System.out.print( (d.toArray())[i] );
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(d.isEmpty()); // return true if in deque not any element, else false

        d.clear(); // remove / delete all element on deque
        System.out.println(d.isEmpty()); // return true if in deque not any element, else false
        System.out.println(d.peek()); // return an element at first of deque, return null if not exist
        System.out.println(d.poll()); // return and remove an element at first of deque, return null if not exist
    }
}
