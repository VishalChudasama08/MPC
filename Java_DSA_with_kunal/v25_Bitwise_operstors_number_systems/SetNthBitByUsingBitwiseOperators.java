package v25_Bitwise_operstors_number_systems;

public class SetNthBitByUsingBitwiseOperators {
    public static void main(String[] args) {
        int n = 8; // 1000 = 8 here, 3rd bit is 0 now set 1  (OR operator)
        int l = 15; // 1111 = 15 here, 3rd bit is 1 now set 1 (OR operator)
        int bit = 3;

        System.out.print("1000 set bit number "+bit+" => ");
        setNthBit(n, bit-1); // change
        System.out.print("1111 set bit number "+bit+" => ");
        setNthBit(l, bit-1); // not change

        System.out.println();

        System.out.print("1000 reset bit number "+bit+" => ");
        resetNthBit(n, bit-1); // not change
        System.out.print("1111 reset bit number "+bit+" => ");
        resetNthBit(l, bit-1); // change
    }
    // hare set nth bit means if nth bit is 0 then set 1, if nth bit is 1 then set 1
    // (Like OR operator: 1 1 = 1, 0 1 = 1, 1 0 = 1, 0 0 = 0)
    private static void setNthBit(int n, int v) {
        int number = 0, size = Integer.SIZE, bit, flag = 0;

        for (int i = size - 1; i >= 0; i--) {
            bit = (n >> i) & 1;
            if (bit == 1 && flag == 0) {
                flag = 1;
            }
            if (flag == 1 && i == v) {
                number = 1 + (number * 10);
            } else {
                number = bit + (number * 10);
            }
        }
        System.out.println(number);
    }
    private static void resetNthBit(int n, int v) {
        int number = 0, size = Integer.SIZE, bit, flag = 0;

        for (int i = size - 1; i >= 0; i--) {
            bit = (n >> i) & 1;
            if (bit == 1 && flag == 0) {
                flag = 1;
            }
            if (flag == 1 && i == v) {
                number = (number * 10);
            } else {
                number = bit + (number * 10);
            }
        }
        System.out.println(number);
    }
}
