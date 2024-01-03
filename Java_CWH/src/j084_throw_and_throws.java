class NegativeRadiusException extends Exception{
    @Override
    public String getMessage(){ // if throwing this exception tha print this message
        return "Radius can not be negative";
    }
}
public class j084_throw_and_throws {
    public static double area(int r) throws NegativeRadiusException {
        // throws no use method ma thay chhe.
        // koy method Exception produce kar ti hoy tyare throws key word and
        // tena pachi Exception name lakhay tethi jya method call karel hoy tya tene try-catch thi hendal kari sakay
        if(r<0){ // radius koy divasha negative na hoy tethi jo user radius negative enter kari dye tyare
            // aa Exception throw kare, aa ritnu exception java ma default (ArrayIndexOutOfBoundsException, ArithmeticException)
            // ni jem pelathi defain karel nathi tethi Exception class no use karine NegativeRadiusException name nu Exception banavel chhe
            throw new NegativeRadiusException();
        }
        double result = Math.PI * r * r;
        return result;
    }
    public static int divide(int a, int b) throws Exception{
        int result = a/b;
        return result;
    }
    public static void main(String[] args) {
        try {
            int c = divide(6, 0); // divide() method Exception throw kari shake chhe,
            System.out.println(c);
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            double a = area(-1);
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
