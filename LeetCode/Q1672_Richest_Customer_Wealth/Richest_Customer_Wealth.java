package Q1672_Richest_Customer_Wealth; // solution from java dsa by kunal v13
// https://leetcode.com/problems/richest-customer-wealth/description/

public class Richest_Customer_Wealth {
    public static void main(String[] args) {
        int [][] arr = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(arr));
    }
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int [] row: accounts) {
            int wealth = 0;
            for (int column: row) wealth += column;
            if (!(max > wealth)) max = wealth;
        }
        return max;
    }
}
