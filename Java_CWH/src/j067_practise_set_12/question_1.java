package calc; // use package calc to creating calc folder and in this folder creat .class file on compile time

class Calculator {
    public void calculator(int a, int b) {
        System.out.println("Your result is : " + a + b);
    }
}

class ScCalculator {
    public void calculator(int a, int b) {
        System.out.println("Your result is : " + Math.sin(a + b));
    }
}

class HyCalculator {
    public void calculator(int a, int b) {
        System.out.println("Your result is : " + a + b);
        System.out.println("Your result is : " + Math.sin(a + b));
    }
}

public class question_1 {
    public static void main(String[] args) {
        System.out.println("I am Main method");
    }
}

/*
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j067_practise_set_12>
 * javac -d . question_1.java
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j067_practise_set_12>
 * java calc/question_1 <note:- use foldername/filename to run this>
 * I am Main method
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j067_practise_set_12>
 */
