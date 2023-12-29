package folder.folderl1.folderl2;

class Base {
    protected int protectedint = 5;
    int defaultint = 10;
    private int privateint = 15;
}

public class question_3 {
    public static void main(String[] args) {
        System.out.println("This java file class file is in folder/folderl1/folderl2");
        Base b = new Base();
        System.out.println(b.protectedint);
    }
}
/*
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j067_practise_set_12>
 * javac -d . question_3.java
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j067_practise_set_12>
 * java folder/folderl1/folderl2/question_3
 * This java file class file is in folder/folderl1/folderl2
 */