import java.util.Scanner;

class InvalidInputException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid Input Exception: Please Enter valid symbol";
    }
}

class OverOfMaxSizeNumberException extends Exception{
    @Override
    public String getMessage(){
        return "Please Enter Less than 8000";
    }
}

class OverOfMaxSizeMultiplicationException extends Exception{
    @Override
    public String getMessage(){
        return "Multiplication Result Number Size Overflow Exception: You Result Number is Bigger Than 999999, It is not allowed (Because My Calculator Display is Possible only 6 Digit Dispelling ☻)";
    }
}
class Calculator {
    double a, b;
    String s;
    public void setNumber() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number & Symbol You wont to Calculate, Example:- 8 + 2");
        System.out.print("Enter: ");
        this.a = sc.nextDouble();
        this.s = sc.next();
        this.b = sc.nextDouble();
        if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){ // if a user Enters any other symbol than throw this exception
            throw new InvalidInputException();
        }
        if (this.a > 8000 || this.b > 8000){ // if a user enters this.a or this.b number is bigger than 8000 than throw this exception
            throw new OverOfMaxSizeNumberException();
        }
    }
    public double addition(){
        if (s.equals("+")){
            return a+b;
        }
        else{
            return 0;
        }
    }
    public double subtraction(){
        if (s.equals("-")){
            return a-b;
        }
        else{
            return 0;
        }
    }
    public double multiplication() throws OverOfMaxSizeMultiplicationException{
        if (s.equals("*")){
            double result = a*b;
            if(result > 999999){ // if result is bigger than 999999 than throw this exception, like 4567 * 6789
                throw new OverOfMaxSizeMultiplicationException();
            }
            return result;
        }
        else{
            return 0;
        }
    }
    public double division() throws Exception{
        if (s.equals("/")){
            /*
             * if (s.equals("/")){
             *      return a/b;
             * }
             * I Am not understand I enter this.b value 0 but this is not throws exception
             * This return Infinity
             * in this reason I insert if(this.b != 0) and else block code
             */
            if(this.b == 0){
                return a/b;
            }
            else {
                throw new ArithmeticException();
            }
        }
        else{
            return 0;
        }
    }
    public double di() throws Exception{
        return 7/0;
    }
}
public class j087_exercise_6_custom_calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        try {
            cal.setNumber();
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            if(cal.s.equals("+")){
                System.out.println(cal.addition());
            } else if(cal.s.equals("-")){
                System.out.println(cal.subtraction());
            } else if(cal.s.equals("*")){
                try{
                    System.out.println(cal.multiplication());
                }
                catch (OverOfMaxSizeMultiplicationException e){
                    System.out.println(e);
                }
            } else if(cal.s.equals("/")){
                try {
                    System.out.println(cal.division());
                }
                catch (Exception e){
                    System.out.println(e);
                }
            } else {
                throw new InvalidInputException();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            System.out.println(cal.di());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
