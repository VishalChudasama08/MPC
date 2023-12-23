import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;

class Library{
    private String [] books = {
            "A Fine Balance by Rohinton Mistry",
            "A Suitable Boy by Vikram Seth",
            "A Thousand Splendid Suns by Khaled Hosseini",
            "An Era of Darkness by Shashi Tharoor",
            "Arthashastra by Chanakya",
            "Chanakya's Chant by Ashwin Sanghi",
            "Discovery of India by Jawaharlal Nehru",
            "English, August by Upamanyu Chatterjee",
            "Godan by Munshi Premchand",
            "Half Girlfriend by Chetan Bhagat",
            "I too had a Love Story by Ravinder Singh",
            "In Custody by Anita Desai",
            "India After Gandhi by Ramachandra Guha",
            "Interpreter of Maladies by Jhumpa Lahiri",
            "Jaya: An Illustrated Retelling of the Mahabharata by Devdutt Pattanaik",
            "Kai Chand The Sar-e-Aasman by Shamsur Rahman Faruqi",
            "Kane and Abel by Jeffrey Archer",
            "Karma Cola by Gita Mehta",
            "Kite Runner by Khaled Hosseini",
            "Malgudi Days by R.K. Narayan",
            "Maximum City by Suketu Mehta",
            "Midnight's Children by Salman Rushdie",
            "My Experiments with Truth by Mahatma Gandhi",
            "Namesake by Jhumpa Lahiri",
            "Nine Lives by William Dalrymple",
            "One Night at the Call Center by Chetan Bhagat",
            "Palace of Illusions by Chitra Banerjee Divakaruni",
            "Parva by S.L. Bhyrappa",
            "Q&A (Slumdog Millionaire) by Vikas Swarup",
            "Rag Darbari by Shrilal Shukla",
            "Shantaram by Gregory David Roberts",
            "Sita by Devdutt Pattanaik",
            "Swami and Friends by R.K. Narayan",
            "The Argumentative Indian by Amartya Sen",
            "The Blue Umbrella by Ruskin Bond",
            "The Dark Holds No Terrors by Shashi Tharoor",
            "The Glass Palace by Amitav Ghosh",
            "The Great Indian Novel by Shashi Tharoor",
            "The God of Small Things by Arundhati Roy",
            "The Immortals of Meluha by Amish Tripathi",
            "The Inheritance of Loss by Kiran Desai",
            "The Lowland by Jhumpa Lahiri",
            "The Palace of Illusions by Chitra Banerjee Divakaruni",
            "The Room on the Roof by Ruskin Bond",
            "The Shiva Trilogy by Amish Tripathi",
            "The White Tiger by Aravind Adiga",
            "Train to Pakistan by Khushwant Singh",
            "Two States by Chetan Bhagat",
            "Untouchable by Mulk Raj Anand",
            "Wings of Fire by A.P.J. Abdul Kalam"
    };

    public Library() {
        System.out.println("*** Welcome To Online Library ***");
    }

    public void addBook(String newBook){
        this.books = Arrays.copyOf(this.books, this.books.length + 1); // use for existing array add new length
        this.books[this.books.length - 1] = newBook; // add newBook on last index
        Arrays.sort(this.books); // sorting alphabetically array value
        System.out.println("Added New \"" + newBook +"\" Book on Library");
    }

    public void issueBook(String bookname){
        int i = 0,n = 0;
        boolean t = false;
        for (String element : this.books) {
            if (Objects.equals(element, bookname)){ // comparing, return true if both are sem Otherwise, false is returned.
                n = i;
                t = true;
            }
            i++;
        }
        if(t){
            String[] newBooks = new String[this.books.length - 1];
            int newIndex = 0;
            for (int j = 0; j < this.books.length; j++) {
                if (j != n){
                    newBooks[newIndex] = this.books[j]; // input values on new array, without n number index value
                    newIndex++;
                }
            }
            this.books = newBooks; // replace array
            System.out.println("Issueing \"" + bookname + "\" Successfully");
        }
    }
    public void showAvailableBooks(){
        int i = 1;
        System.out.println("Total " + this.books.length + " Books in Library");
        for (String element : this.books) {
            System.out.println("(" + i + ") " + element);
            i++;
        }
    }
}
public class j051_exercise_4_online_library {
    public static void main(String[] args) {
        /*
            "The Namesake by Jhumpa Lahiri",
            "Train to Pakistan by Khushwant Singh",
            "The Guide by R.K. Narayan",
         */
        Library lib = new Library();
        boolean v = true;
//        int taskNumber;
        String book, newBook;
        while (v){
            System.out.println("1. Show All Available Books");
            System.out.println("2. Issue Books");
            System.out.println("3. Return or add new book");
            System.out.print("Enter Number To perform Task : ");
            Scanner scan = new Scanner(System.in);
            int taskNumber;
//            try {
                taskNumber = Integer.parseInt(scan.nextLine()); // converting string to integer because
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                continue;  // Restart the loop
//            }
            switch (taskNumber){
                case 1 -> lib.showAvailableBooks();
                case 2 -> {
                    System.out.print("Enter Book Name: ");
                    book = scan.nextLine();
                    lib.issueBook(book);
                }
                case 3 -> {
                    System.out.print("Enter Book Name: ");
                    newBook = scan.nextLine();
                    lib.addBook(newBook);
                }
                default -> {
                    System.out.print("Enter valid Number");
                }
            }
        }

//        l.showAvailableBooks();
//        l.addBook("The Guide by R.K. Narayan");
//        l.showAvailableBooks();
//        l.issueBook("The Blue Umbrella by Ruskin Bond");
    }
}
