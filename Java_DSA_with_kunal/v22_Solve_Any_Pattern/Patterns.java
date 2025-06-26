package v22_Solve_Any_Pattern;

public class Patterns {
    public static void main(String[] args) { // v means that was done my self
        System.out.println("Pattern 1:- ");
        pattern1(5);
        System.out.println("\nPattern 2:- ");
        pattern2(5);
        System.out.println("\nPattern 3:- ");
        pattern3(5);
        System.out.println("\nPattern 4:- ");
        pattern4(5);
        System.out.println("\nPattern 5:- ");
        pattern5(4);
        pattern5v(9);
        System.out.println("\nPattern 6:- ");
        pattern6v(5);
        System.out.println("\nPattern 7:- ");
        pattern7v(5);
        System.out.println("\nPattern 8:- ");
        pattern8v(5);
        System.out.println("\nPattern 9:- ");
        pattern9v(5);
        System.out.println("\nPattern 10:- ");
        pattern10v(5);
        pattern10(5);
        System.out.println("\nPattern 11:- ");
        pattern11v(5);
        System.out.println("\nPattern 12:- ");
        pattern12v(10);
    }
    static void pattern1(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(j+1 + " ");
            }
            System.out.println();
        }
    }
    static void pattern5v(int n){ // by v
        for (int i = 0; i <= n; i++) {
            if(i > n/2 + 1){
                for (int j = 0; j <= n - i ; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int j = 0; j < i ; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
    static void pattern5(int n) { // by kunal v22 32:58
        for (int row = 0; row < n*2; row++) {
            int totalColInRow = row > n ? n*2-row : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6v(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(col < n-row-1){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void pattern7v(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 1; col <= n; col++) {
                if(col<=row){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void pattern8v(int n){
        for (int row = 0; row < n; row++) {
            int totalColumn = n*2-1;
            for (int col = 0; col < totalColumn; col++) {
                if((col + row) < n-1){
                    System.out.print(" ");
                } else if(col<n) {
                    System.out.print("*");
                } else if (!(totalColumn-col < n-row)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static void pattern9v(int n){
        for (int row = 0; row < n; row++) {
            int totalColumn = n*2-1;
            for (int col = 0; col < totalColumn; col++) {
                if(col < row){
                    System.out.print(" ");
                } else if(col < n){
                    System.out.print("*");
                } else if (col < totalColumn-row){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern10v(int n){
        for (int row = 0; row < n; row++) {
            int totalColumn = n*2-1;
            for (int col = 0; col < totalColumn; col++) {
//                if()
                if((col + row) < n-1){
                    System.out.print(" ");
                } else if(col<n) {
                    if(row%2 == 0 && col%2 == 0){
                        System.out.print("*");
                    } else if(!(row%2 == 0) && !(col%2 == 0)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else if (!(totalColumn-col < n-row)){
                    if(row%2 == 0 && col%2 == 0){
                        System.out.print("*");
                    } else if(!(row%2 == 0) && !(col%2 == 0)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static void pattern10(int n){
        System.out.println();
        int i,j,sp=n;
        for(i=1;i<=5;i++) {
            for(j=1;j<sp;j++) {
                System.out.print(" ");
            }
            sp--;
            for(j=1;j<=i;j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void pattern11v(int n){
        int maxWidth = (n*2)-1;
        for (int i = 0; i < maxWidth; i++) {
            if(i < n){
                for (int j = n; j > i; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print(" *");
                }
            } else {
                for (int j = n; j < i+2; j++) {
                    System.out.print(" ");
                }
                for (int j = i; j < maxWidth; j++) {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
    static void pattern12v(int n){
        int a = 1;
        for (int i = 0; i < n-1; i++) {
            int b = 2;
            for (int j = 0; j < n; j++) {
                if(i < 5){
                    if(i >= j){
                        System.out.print("*");
                    } else if(i < n-a && j < n-a){
                        System.out.print("#");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    if(j <= n-b-a+6){
                        System.out.print("*");
                    } else if(i < n-a && j < n-a){
                        System.out.print("#");
                    } else {
                        System.out.print("$");
                    }
                }
                b++;
            }
            a++;
            System.out.println();
        }
    }
}
