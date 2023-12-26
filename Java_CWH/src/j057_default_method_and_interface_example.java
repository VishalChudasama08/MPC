interface MyCamera{
    void takePhoto();
    void recordVideo();

    // private method ne default method ma use thay chhe
    private void greet(){
        System.out.println("Good Morning");
    }

    // jyare koy class ma interface ne implement kari dedhu hoy tyar pachhi jo, te interface ma koy method umervama aave,
    // to te implement careal class ma error aave chhe kem ke te pachhi add karel method ne defain karvi pade chhe, je thayel nathi hoti
    // tethi default method no use thay chhe, default key word lakahta te method implements karel nathi hoti te ni error aavti nathi
    // default vadi method na block of code ne pan interface maj kalisakay che, jyare biji method ma nahti lakhi sakatu
    // and default method ne implements class ma override kari sakay chhe
    // default method ne dayrect implements class na object this call kari sakay chhe.
    // run time me jo implementd class ma default class override thayel hoy to te run thay chhe, nahiter interface vadi dufault method run thay chhe
    default void record4KVideo(){ // this is a default method.
        greet();
        System.out.println("Recording 4K Video..." );
    }
}

interface MyWifi{
    String[] getNetWorks();
    void connectToNetwork(String network);
}

class MyCellPhone{
    void callNumber(int phoneNumber){
        System.out.println("Calling " + phoneNumber);
    }
    void pickCall(){
        System.out.println("Connecting... ");
    }
}

class MySmartPhone extends MyCellPhone implements MyWifi, MyCamera{
    public void takePhoto(){
        System.out.println("Taking Photo");
    }
    public void recordVideo(){
        System.out.println("Recording Video");
    }
//    public void record4KVideo(){ // if uncomment this code than run this method, not run interface method, this is overriding
//        System.out.println("Recording 4k Video");
//    }
    public String [] getNetWorks(){
        System.out.println("Getting List of Networks");
        String [] networkList = {"Harry", "Prashanth", "Anjali5G"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Conneting to " + network);
    }
}

public class j057_default_method_and_interface_example {
    public static void main(String[] args) {
        MySmartPhone ms = new MySmartPhone();
        ms.record4KVideo();
        // ms.greet(); // not allowed because this is a private method
        String[] ar = ms.getNetWorks();
        for (String item : ar) {
            System.out.println(item);
        }
    }
}
