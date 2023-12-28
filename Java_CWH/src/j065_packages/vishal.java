package classes.all; // this is not error if you run using terminal pawershell,

// jo package lakhati vadhate <package classes.all;> aari te package na name ma . no use kariye to,
// aama classes folder bane teni ander all name nu folder bane chhe
// tuk ma classe folder ni under all folder

// PS D:\Happy_Coding\With_Github\MPC\Java_CWH\src\j065_packages> javac -d . vishal.java
// aa line run kar ta, vishal.java file ni class file bane chhe
// ( -d . ) aa lakha vathi te class file vishal.java file aapel package na name na folder ni ander bane chhe,
// ( -d . ) na hoy to class file orignal file (vishal.java) hoy tej folder ma bani jay chhe

// vishal.java file na name ma jo vishal ni jagyaye *.java lakhiye to te folder (vishal.java file jya chhe te) ni badhij java file compile thay jay chhe and teni class file te files na package mujab folder bani tema aavi jay chhe

// javac -d . vishal.java ==> -d pachhi je . chhe te ni jagyaye jo kay lakhiye to te name na folder ni under run thay
// tukma . etle aa folder ma em

public class vishal {
    public void method() {
        System.out.println("vishal.jav file Run");
    }

    public static void main(String[] args) {
    }
}