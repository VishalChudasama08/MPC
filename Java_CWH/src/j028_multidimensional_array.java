import java.sql.SQLOutput;

public class j028_multidimensional_array {
    public static void main(String[] args) {
        int [][] flats; // 2D Array
        flats = new int[3][4];
        flats[0][0] = 101;
        flats[0][1] = 102;
        flats[0][2] = 103;
        flats[0][3] = 104;
        flats[1][0] = 201;
        flats[1][1] = 202;
        flats[1][2] = 203;
        flats[1][3] = 204;
        flats[2][0] = 301;
        flats[2][1] = 302;
        flats[2][2] = 303;
        flats[2][3] = 304;

        // Displaying the 2D array
        System.out.println("Printing a 2D Array using for loop");
        for (int i = 0; i <flats.length; i++) {
            for (int j = 0; j < flats[i].length; j++) {
                System.out.println(flats[i][j]);
            }
            System.out.println();
        }
    }
}
