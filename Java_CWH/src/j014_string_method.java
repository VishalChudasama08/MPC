public class j014_string_method {
    public static void main(String[] args) {
        String name = "Vishal";
        System.out.println(name);

        int length  = name.length(); // .length() return string length
        System.out.println(length);

        String lname = name.toLowerCase();
        System.out.println(lname);

        String uname = name.toUpperCase();
        System.out.println(uname);

        String sname = name.substring(2); // .substring() use to star index number string return
        System.out.println(sname);

        String saname = name.substring(2,5); // start 2 and end 5 index
        System.out.println(saname);

        String rname = name.replace('V', 'G');
        System.out.println(rname);

        String raname = name.replace("shal", "ta");
        System.out.println(raname);

        System.out.println(name.startsWith("Vi"));
        System.out.println(name.startsWith("Gi"));

        System.out.println(name.endsWith("al"));
        System.out.println(name.endsWith("ta"));

        System.out.println(name.charAt(2)); // return index number character

        System.out.println(name.indexOf('s')); //return index number

        System.out.println(name.lastIndexOf('l'));

        System.out.println(name.equals("Vishal"));
        System.out.println(name.equals("vishal"));
        System.out.println(name.equals("vita"));

        System.out.println(name.equalsIgnoreCase("ViShAl"));
        System.out.println(name.equalsIgnoreCase("vita"));

        String newstring = "    Hey There!    ";
        System.out.println(newstring);

        String trimstring = newstring.trim(); // .trim() clear starting and ending spase
        System.out.println(trimstring);

    }
}
