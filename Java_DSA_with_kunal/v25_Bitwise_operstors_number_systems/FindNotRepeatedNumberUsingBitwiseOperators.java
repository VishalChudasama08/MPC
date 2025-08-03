package v25_Bitwise_operstors_number_systems;

public class FindNotRepeatedNumberUsingBitwiseOperators {
    public static void main(String[] args) {
        int [] arr = {1,5,7,3,4,8,5,1,3,7,4}; // here only 8 is one time another all in 2 times
        System.out.println(findUnique(arr,arr.length, 2)); // find number that only one time another all are repeat two time
        int [] arr2 = {4, 1, 5, 1, 7, 3, 7, 4, 8, 5, 1, 3, 3, 5, 7, 4}; // find number that only one time another all are repeat three time
        System.out.println(findUnique(arr2,arr2.length, 3));
    }
    public static int findUnique(int [] arr, int length, int repeat){
        int size = Integer.SIZE; // mostly size = 32 (32 bits) in same old system integer is word on 16bit
        int result=0;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if(((arr[j] >> i) & 1) == 1){ // right shift answer to get last bit
                    // ex. ((5 >> 1) & 1) => ((101 >> 1) & 1) => (10 & 1) => (10 & 01) => 00 => 0
                    // ex. ((5 >> 2) & 1) => ((101 >> 2) & 1) => (1 & 1) => 1
                    // ((arr[j] >> i) & 1) right shift then => remove right size number work in binary
                    // AND (&) => if number is 1 then answer is 1 else 0
                    sum++;
                }
            }
            if((sum % repeat) != 0){
                result = result | (1 << i); // left shift with then OR (|) => both value is 0 then result 0 else 1
            }
        }
        return result;
    }
}
