import java.util.Scanner;

// extends Exception class to create you own exception
// program ma koy pan exception aave and try-catch headal karine,
// catch block ma te exception print kariye (je variable ma hoy chhe) tyare
// exception nu name and message print thay chhe
// jo divide by zero ni Arithmetic Exception hoy to ==> java.lang.ArithmeticException: / by zero
// print thay chhe, jema " / by zero" te message chhe and
// "java.lang.ArithmeticException:" ae exception nu name chhe,
// ahi ArithmeticException ae java ma pelathij hoy chhe tethi aa rite name aave chhe
// jo aapde Exception class ne exteds kari ye tyare aapde aa message aapdirite lakhi sahkiye chhiye and
// extends carela class nu name ej exception nu name thay chhe
// aahi aa program na output ma "MyException:  I am getMessage() I am toString()"
// MyException exception nu name chhe and "I am getMessage()" ae message chhe
// and "I am toString()" ae vadhara (extra) ni information chhe je aapde toString() method no use karine umeri sakiye chhiye
class MyException extends Exception{
    @Override
    public String toString(){ // use toString() method to add more extra information, this is print with an exception message
        // this method is present on Exception class, in this line this method is overridden
        return super.toString() + " I am toString()";
        // call super (Exception) class toString() method
        // this method return <toString() return value> + " I am toString()";
    }
    @Override
    public String getMessage(){
        return " I am getMessage()";
    }
}
public class j083_exception_class {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        a = sc.nextInt();
        if(a<99){
            try {
                 throw new MyException(); // using throw key-word manually Throw any exception
                // koy pan Exception, aapdi jate aapde koy pan Exception throw karavi sakiye chhi ye

                // throw new ArithmeticException("This is an Arithmetic Exception"); // using throw key-word manually Throw Arithmetic Exception
                //  na braket ma koy pan message lakhi sakay chhe, (ahi te message "This is an Arithmetic Exception" chhe)
                // je Exception class na getMessage() method return kare chhe
            }
            catch(Exception e){
                e.printStackTrace(); // program ma kay line ma Exception aay vu te print kari aape chhe
                // te error nathi, and sovthi chhe le run thay chhe, aakho program run thay jay pachhi, te print tha ychhe

                System.out.println(e.getMessage());
                System.out.println(e.toString());
                System.out.println(e); // jya re pan khali Exception na variable (ahi te e chhe) ne
                // print kar vama aave tyare toString() method call thay chhe
                // too print kar ti vakhate e.toString() karo ke na karo toString() method to call thavanij chhe
                // ahi super class ni method ne override karel chhe tethi te override mrhtod run thay chhe


            }
        }
    }
}
