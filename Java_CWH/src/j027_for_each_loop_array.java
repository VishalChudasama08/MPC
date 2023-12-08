public class j027_for_each_loop_array {
    public static void main(String[] args) {
        int[] marks = {10, 11, 12, 13, 14, 15};
        System.out.println(marks.length); // array length

        System.out.println();
        //print array value
        for (int i = 0; i<marks.length;i++){
            System.out.println(marks[i]);
        }
        System.out.println();
        //reverse print array value
        for (int i=marks.length-1;i>=0;i--){
            System.out.println(marks[i]);
        }

        System.out.println();
        //for each loop
        for (int element : marks) { // element -> you can write any variable, marks -> array object
            System.out.println(element);
        }
    }
}
