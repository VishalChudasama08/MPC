public class j029_practise_set_6 {
    public static void main(String[] args) {
        //Q-1
        float[] marks = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        float sum = 0f;
        for (float element:marks) {
            sum = sum + element;
        }
        System.out.println("The value of sum is " + sum);
        System.out.println();

        //Q-2
        float[] m = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        float n = 45.12f;
        boolean v = false;
        for (float element:marks) {
            if(n == element){
                v = true;
                break;
            }
        }
        if (v) {
            System.out.println("Yes, this value is present on array");
        }
        else{
            System.out.println("Yes, this value is present on array");
        }
        System.out.println();

        //Q-3
        float[] marksp = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        float sump = 0f;
        for (float element:marksp) {
            sump += element;
        }
        System.out.println("The value of Average marks of physics is " + sump/marksp.length);
        System.out.println();

        //Q-4
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] mat2 = {{7, 8, 9}, {10, 11, 12}};
        int[][] result = {{0, 0, 0}, {0, 0, 0}};

        System.out.println("matrix sum is : ");
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

        //Q-5
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char element: c) {
            System.out.print(element + "\n");
        }
        int l = c.length;
        int mid = Math.floorDiv(l, 2); // Math.floatDiv dividend of two number and return only point less answer
        for (int i = 0; i <= mid; i++) {
            char temp = c[i];
            c[i] = c[l-i-1];
            c[l-i-1] = temp;
        }
        System.out.println("After Swapping array is :");
        for (char element: c) {
            System.out.print(element + "\n");
        }
        /*
        if this array length is even, then using this method[ swap |(x)| and |(x-l-1)| ] to swapping array values
               example array is a b c d e f
               And its index is 0 1 2 3 4 5
               then, length is 6 (its even number array), use method |(i)| and |(i-l-1)|, i is for loop variable
               l=6, mid=3 (using Math.floorDiv(length/2) ) and loop condition (i=0;i<=mid;i++)  =>
                    i=0 -> 0 and |0-6-1|=5 swap on [0] and [5] array value, here a f => f a
                    i=1 -> 1 and |1-6-1|=4 swap on [1] and [4] array value, here b e => e b
                    i=2 -> 2 and |2-6-1|=3 swap on [2] and [3] array value, here c d => d c
               The array is swayped. => f e d c b a

         if array length is odd numbe, then
               example array is a b c d e
               And its index is 0 1 2 3 4
               then, length is 5 (its odd number array), use method (mid-x) and (mid+x), x is integer variable, x=1
               l=5, x=1, m=2 (using Math.floorDiv(length/2) ) and loop condition (i=0; i<=mid-1; i++) =>
                    x=1 -> 2-1 and 2+1 swap on [1] and [3] array value, here b d => d b, x++;
                    i=1 -> 2-2 and 2+2 swap on [0] and [4] array value, here a e => e a, x++;
               The array is swayped. => e d c b a
        */
        System.out.println();

        //Q-6
        float[] findm = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        float max = Float.MIN_VALUE; // Float.MIN_VALUE => using to return float minimum value
        for (float element: findm) {
            if(element>max){
                max = element;
            }
        }
        System.out.println("In array maximum value is : " + max);
        System.out.println();

        //Q-7
        float[] findmin = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        float min = Float.MAX_VALUE; // Float.MAX_VALUE => using to return float maximum value
        for (float element: findmin) {
            if(element<min){
                min = element;
            }
        }
        System.out.println("In array minimum value is : " + min);
        System.out.println();

        //Q-8
        float[] sorting = {20.1f, 23.12f, 52.26f, 45.12f, 85.25f};
        for (int i = 0; i < sorting.length-1; i++) {
            if(sorting[i] > sorting[i+1]){
                float temp = sorting[i];
                sorting[i] = sorting[i+1];
                sorting[i+1] = temp;
            }
        }
        System.out.print("sorting = {");
        for (float element: sorting) {
            System.out.print(element + ", ");
        }
        System.out.println("}");
    }
}
