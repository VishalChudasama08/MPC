public class j015_practice_set_3 {
    public static void main(String[] args) {
        //Q-1
        String name = "Chudasama Vishal";
        name = name.toLowerCase();
        System.out.println(name);

        //Q-2
        String name1 = "Hey My Name Is Vishal";
        name1 = name1.replace(' ', '_');
        System.out.println(name1);

        //Q-3
        String name2 = name1.replace("Vishal", "chudasama vishal");
        System.out.println(name2);

        //Q-4
        String name3 = "Hey My Name Is  Vishal";
        System.out.println(name3.indexOf("  "));
        System.out.println(name3.indexOf("   "));

        //Q-5
        String name4 = "indexOf() \n\tReturns the index within this string of the first occurrence of the specified substring. \nThe returned index is the smallest value k for which:";
        System.out.println(name4);
    }
}
