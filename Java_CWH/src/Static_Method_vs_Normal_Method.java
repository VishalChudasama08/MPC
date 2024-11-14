// 1. Definition: Static methods use 'static' keyword; normal methods do not.
class MyClass {

    int instanceVar = 10;    // Instance variable
    static int staticVar = 20;  // Static variable

    // Normal method: Belongs to instance, no 'static' keyword
    void normalMethod() {
        System.out.println("This is a normal method.");
    }

    // Static method: Belongs to class, uses 'static' keyword
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // 3. Data Access: Normal method accessing instance and static variables
    void accessVariablesInNormalMethod() {
        System.out.println("Instance variable: " + instanceVar);  // Accessible
        System.out.println("Static variable: " + staticVar);      // Accessible
    }

    // 3. Data Access: Static method accessing only static variables
    static void accessVariablesInStaticMethod() {
        // System.out.println("Instance variable: " + instanceVar); // ERROR: Cannot access instance variable
        System.out.println("Static variable: " + staticVar);      // Accessible
    }

    // 5. Polymorphism: Normal method supports runtime polymorphism (overriding)
    void displayMessage() {
        System.out.println("Message from MyClass");
    }

    // 5. Polymorphism: Static method demonstrates method hiding
    static void showStaticMessage() {
        System.out.println("Static message from MyClass");
    }
}

class SubClass extends MyClass {
    // Overriding the normal method
    @Override
    void displayMessage() {
        System.out.println("Message from SubClass");
    }

    // Hiding the static method
    static void showStaticMessage() {
        System.out.println("Static message from SubClass");
    }
}

public class Static_Method_vs_Normal_Method { // chatGPT
    public static void main(String[] args) {
        // 2. Access: Normal methods require create an objects, static methods do not require create an objects
        MyClass obj = new MyClass();
        obj.normalMethod();         // Access normal method to need object
        MyClass.staticMethod();     // Access static method to not need object

        // 3. Data Access demonstration
        obj.accessVariablesInNormalMethod();   // Can access both instance and static variables
        MyClass.accessVariablesInStaticMethod();  // Can access only static variables

        // 5. Polymorphism: Method overriding in normal methods
        MyClass parent = new SubClass();
        parent.displayMessage();  // Calls SubClass method (overriding)
        // 5. Polymorphism: Method hiding in static methods
        MyClass.showStaticMessage();   // Calls static method in MyClass
        SubClass.showStaticMessage();  // Calls static method in SubClass
    }
}
