public class j096_date_and_time {
    public static void main(String[] args) {
        // j094 and j095 hashing and hashset it is a searching method
        // like /10 type searching method
        // use hashset to make fast searching on big array type data

        // calculate 1 january 1970 to this time,
        // and this is used a long data type
        System.out.println(System.currentTimeMillis());
        // get time in milliseconds
        System.out.println(System.currentTimeMillis()/1000);
        // get in seconds
        System.out.println(System.currentTimeMillis()/1000/60);
        // get in minits
        System.out.println(System.currentTimeMillis()/1000/60/60);
        // get in hour
        System.out.println(System.currentTimeMillis()/1000/60/60/24);
        // get in day
        System.out.println(System.currentTimeMillis()/1000/60/60/24/356);
        // get in year
    }
}
