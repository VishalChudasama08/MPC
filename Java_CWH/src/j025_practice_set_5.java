public class j025_practice_set_5 {
    public static void main(String[] args) {
        //Q-1
        for (int i = 4; i>0;i--){
            for (int j = 0; j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //Q-2
        int a = 0;
        int b = 0;
        int c = 5;
        while(a<2*c){
            if(a%2 == 0){
                b = b+a;
            }
            a++;
        }
        System.out.println("first five even sum is "+b); // 0+2+4+6+8

        //Q-3
        int  d = 5;
        for(int i = 1; i<=10; i++){
            System.out.printf("%d x %d = %d\n",d,i,d*i);
        }
        System.out.println();

        //Q-4
        int  e = 10;
        for(int i = 10; i>0; i--){
            System.out.printf("%d x %d = %d\n",e,i,e*i);
        }

        //Q-5
        int f = 5, g=1;
        for (int i = 1; i<6;i++){
            g *= i;
        }
        System.out.println("factorial is " + g);

        //Q-6
        int h = 5, k=1;
        int i = 1;
        while (i<6){
            k *= i;
            i++;
        }
        System.out.println("factorial is " + k);

        //Q-7
        int q=4;
        while (q>0){
            int j = 0;
            while (j<q){
                System.out.print("*");
                j++;
            }
            System.out.println();
            q--;
        }

        //Q-8
        //True

        //Q-9
        int w = 8;
        int s = 0;
        for(int t = 1; t<=10; t++){
            s += w*t;
        }
        System.out.println("sum is " + s);

        //Q-10
        //At least one

        //Q-11
        int b1 = 0;
        int c1 = 5;
        for(int a1 = 0; a1<2*c1; a1++){
            if(a1%2 == 0){
                b1 = b1+a1;
            }
        }
        System.out.println("first five even sum is "+b1); // 0+2+4+6+8
    }
}
