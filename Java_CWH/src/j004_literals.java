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

/*
 📦 Summary Table (Java Primitives – Fixed Sizes)
    Type	    Size	    Default	    Min Value	                 Max Value
    byte	    1 byte	    0	        -128	                     127
    short	    2 byte	    0	        -32,768	                     32,767
    int	        4 byte	    0	        -2,147,483,648	             2,147,483,647
    long	    8 byte	    0L	        -9,223,372,036,854,775,808	 9,223,372,036,854,775,807
    float	    4 byte	    0.0f	    ±1.4e-45	                 ±3.4e+38
    double	    8 byte	    0.0d	    ±4.9e-324	                 ±1.8e+308
    char	    2 byte	    '\u0000'	0	                         65,535
    boolean	    ~1 byte	    false	    false	                     true

 🧠 Notes:
    Any primitives in java default value is not NULL.
    char default value is '\u0000'. It's a valid character, just invisible (non-printable).

 */