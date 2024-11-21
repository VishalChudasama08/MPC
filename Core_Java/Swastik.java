class Swastik {
    public static void swastikPattern(){
        System.out.println("Swastik pattern");
        for (int j = 1; j < 12; j++){
            for (int k = 1; k < 32; k++) {
                if ((k > 16) && (j==1)){
                    System.out.print("#");
                } else if ((k==1 || k==16) && (j!=6) && !(j>6)){
                    System.out.print("#");
                } else if(j==6){
                    System.out.print("#");
                } else if ((k==16 || k==31) && (j!=11) && (j>6)) {
                    System.out.print("#");
                } else if (j==11 && (k<17 || k==31)) {
                    System.out.print("#");
                } else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        swastikPattern();
    }
}

//#              ################
//#              #
//#              #
//#              #
//#              #
//###############################
//               #              #
//               #              #
//               #              #
//               #              #
//################              #