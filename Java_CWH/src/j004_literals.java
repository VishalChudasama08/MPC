public class j004_literals {
    public static void main(String[] args) {
        byte a = 127;
        short b = 32767;
        int c = 2147483647; // byte, short and int it is integer literals
        //long d = 9223372036854775807;
        long d = 9223372036854775807L; // long literals, use L or l on long value
        //float e = 340282346638528860000000000000000000000; //this line showing error
        float e = 340282356779729999999999999999999999999F; // float literals, use F or f on float value
        double f = 12.12d; // use D or d on double value (it is optional)
        //44501477170144022721148195934182639518696390927032912960468522194496444440421538910330590478162701758282983178260792422137401728773891892910553144148156412434867599762821265346585071045737627442980259622449029037796981144446145705102663115100318287949527959668236039986479250965780342141637013812613333119898
        boolean h = true;
        char g = 'G';
        System.out.println(a);
        String str = "Vishal";
        System.out.println(str);
    }
}