interface MyCamera1{
    void takePhoto();
    void recordVideo();
    default void record4KVideo(){ // this is a default method.
        System.out.println("Recording 4K Video..." );
    }
}

interface MyWifi1{
    void connectToNetwork(String network);
}

class MyCellPhone1{
    void callNumber(int phoneNumber){
        System.out.println("Calling " + phoneNumber);
    }
    void pickCall(){
        System.out.println("Connecting... ");
    }
}

class MySmartPhone1 extends MyCellPhone1 implements MyWifi1, MyCamera1{
    public void takePhoto(){
        System.out.println("Taking Photo");
    }
    public void recordVideo(){
        System.out.println("Recording Video");
    }
    public String [] getNetWorks(){
        System.out.println("Getting List of Networks");
        String [] networkList = {"Harry", "Prashanth", "Anjali5G"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Conneting to " + network);
    }
}

public class j059_polymorphism {
    public static void main(String[] args) {
        // polymorphism is like 1 material many uses (a vashtu dhana badha use)
        MyCamera1 cam = new MySmartPhone1(); // this is polymorphism, use interface to make object
        // this line sem as dynamic method dispatch,
        // but this line uses interface to make an object
        // this object access only MyCamera1 methods

        cam.record4KVideo();
        cam.takePhoto();
        cam.recordVideo();
        // cam.callNumber(5858); // not allowed, because this method is not a member of MyCamera1
    }
}
