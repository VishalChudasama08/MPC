package v25_Bitwise_operstors_number_systems;

public class NumberSystem {
    public static void main(String[] args) {
        // Decimal  Octal  Hexa  Binary
        //      0     0     0     0
        //      1     1     1     1
        //      2     2     2     10
        //      3     3     3     11
        //      4     4     4     100
        //      5     5     5     101
        //      6     6     6     110
        //      7     7     7     111
        //      8     10    8     1000
        //      9     11    9     1001
        //      10    12    A     1010
        //      11    13    B     1011
        //      12    14    C     1100
        //      13    15    D     1101
        //      14    16    E     1110
        //      15    17    F     1111
        //      16    20    10    10000
        //      17    21    12    10001
        //      18    22    13    10010
        //      19    23    14    10011
        //      20    24    15    10100
        //      21    25    16    10101
        //      22    26    17    10110
        //      23    27    18    10111
        //      24    30    19    11000
        //      25    31    1A    11001
        //      26    32    1B    11010
        //      27    33    1C    11011
        //      28    34    1D    11100
        //      29    35    1E    11101
        //      30    36    1F    11110
        //      31    37    20    11111
        //      32    40    21    100000
        int binary = 100, decimal = 8, octal = 10;
        System.out.println("BinaryToDecimal "+binary+" => " + BinaryToDecimal(binary));
        System.out.println("DecimalToBinary "+decimal+" => " + DecimalToBinary(decimal));

        System.out.println("DecimalToOctal "+decimal+" => " + DecimalToOctal(decimal));
        System.out.println("OctalToDecimal "+octal+" => " + OctalToDecimal(octal));

        System.out.println("BinaryToOctal "+binary+" => " + BinaryToOctal(binary));
        System.out.println("OctalToBinary "+octal+" => " + OctalToBinary(octal));
    }
    private static int BinaryToDecimal(int binary) {
        int decimal = 0, base = 1;
        while (binary > 0) {
            int last_digit = binary % 10;
            binary /= 10;
            decimal += last_digit * base;
            base *= 2;
        }
        return decimal;
    }
    private static int DecimalToBinary(int decimal) {
        int binary = 0, base = 1;
        while (decimal > 0) {
            int last_digit = decimal % 2;
            decimal /= 2;
            binary += last_digit * base;
            base *= 10;
        }
        return binary;
    }

    private static int DecimalToOctal(int decimal) {
        int octal = 0, base = 1;
        while (decimal > 0) {
            int last_digit = decimal % 8;
            decimal /= 8;
            octal += last_digit * base;
            base *= 10;
        }
        return octal;
    }
    private static int OctalToDecimal(int octal) {
        int decimal = 0, base = 1;
        while (octal > 0) {
            int last_digit = octal % 10;
            octal /= 10;
            decimal += last_digit * base;
            base *= 8;
        }
        return decimal;
    }

    private static int BinaryToOctal(int binary) {
        return DecimalToOctal(BinaryToDecimal(binary));
    }
    private static int OctalToBinary(int octal) {
        return DecimalToBinary(OctalToDecimal(octal));
    }
}
