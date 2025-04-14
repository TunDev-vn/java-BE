package buoi5;

public class Car {

    // đặc điểm
    private String hangSanXuat;
    private String model;
    private int nam;
    private String mau;

    // hành vi
    public void khoiDong(){
        System.out.println("O to: " + model + " khoi dong");
    }
    public void dung(){
        System.out.println("O to: " + model + " dung");
    }
    public void phanh(){
        System.out.println("O to: " + model + " phanh");
    }
    public void batCanGatNuoc(){
        System.out.println("O to: " + model + " bat can gat nuoc");
    }

}
