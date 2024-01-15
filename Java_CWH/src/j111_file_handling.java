import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class j111_file_handling {
    public static void main(String[] args) {
        // create new file
        /*
        File myFile = new File("j111file.txt"); // file name
        try {
            myFile.createNewFile(); // create new file
        } catch(IOException e){
            System.out.println("Unable to create this file");
            e.printStackTrace();
        }

        // write in file
        try {
            FileWriter fileWriter = new FileWriter("j111file.txt");
            fileWriter.write("This is the First File\nThis File Write Using Java FileHandling"); // write in file
            fileWriter.close(); // close file
        } catch(IOException e){
            e.printStackTrace();
        }


        // Reading a file
        File myFile = new File("j111file.txt"); // file name
        try {
            Scanner sc = new Scanner(myFile); // use Scanner class to read file
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        */

        // file delete
        File myFile = new File("j111file.txt"); // file name
        if(myFile.delete()){ // use .delete() method to delete file
            System.out.println("I have deleted: " + myFile.getName()); // use .getName() to get file name
        }
        else {
            System.out.println("Some problem occurred while deleting the file");
        }
    }
}
