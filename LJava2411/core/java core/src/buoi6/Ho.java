package buoi6;

public class Ho extends Animal {

    private String loaiThit;

    public void sanMoi(){
        System.out.println("Ho san moi");
    }

    @Override //  ghi đè lại phương thức của lớp cha
    public void diChuyen() {
        System.out.println("Ho di chuyển nhanh");
    }
}
