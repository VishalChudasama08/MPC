// In Java, the final keyword can be used in various contexts such as variables, methods, and classes.
// Here's a breakdown of how it works in each scenario:

/*
 * [1] Final Variables: Once assigned, their value cannot be changed.
 * [2] Final Methods: Cannot be overridden by subclasses.
 * [3] Final Classes: Cannot be subclassed.
 * [4] Final Parameters: Parameter value cannot be modified within the method.
 */
public class FinalKeyword {

    /* ******************
     [2] Final Methods:
     When a method is marked as final, it cannot be overridden by subclasses.
     */
    // Final Methods example
    class Parent {
        final void display() {
            System.out.println("This is a final method in Parent class.");
        }
    }

    class Child extends Parent {
        // The following would cause an error:
        // void display() {
        //    System.out.println("Cannot override final method.");
        // }
    }

    /* ******************
     [4] Final with Parameters:
     You can declare method parameters as final, meaning the parameter cannot be reassigned within the method.
     */
    void show(final int speed) {
        // speed = 120; // This will cause an error because speed is final
        System.out.println("Speed: " + speed);
    }

    public static void main(String[] args) {
        /* ******************
         [1] Final Variables:
         A variable declared with final cannot be reassigned once initialized.
         */
        final int MAX_VALUE = 100;
        // MAX_VALUE = 200; // This will result in a compile-time error.

        System.out.println("Final Variable MAX_VALUE: " + MAX_VALUE);

        /* ******************
         Final Instance Variables:
         Must be initialized either when declared or in the constructor.
         */
        // Example (Instance Variable)
        class Example {
            final int MAX_SPEED;

            Example() {
                MAX_SPEED = 120; // Can be initialized in the constructor
                System.out.println("Final Instance Variable MAX_SPEED: " + MAX_SPEED);
            }
        }

        Example example = new Example(); // Final instance variable usage

        // [2] Final Method example
        FinalKeyword fk = new FinalKeyword();
        Child child = fk.new Child();
        child.display(); // Calls the final method from the Parent class

        // [4] Final Parameter example
        fk.show(80); // Calls method with final parameter
    }
}

/* ******************
 [3] Final Classes:
 A class declared as final cannot be subclassed.
 */
final class Vehicle {
    void show() {
        System.out.println("This is a final class.");
    }
}

// The following will cause an error:
// class Car extends Vehicle { } // Error: Cannot inherit from final class

