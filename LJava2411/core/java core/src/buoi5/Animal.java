package buoi5;

public class Animal {

    // Đặc điểm
    private String ten;
    private int tuoi;
    private String mauLong;
    private int soChan;
    private String gioiTinh;
    // constructor khởi tạo
    public Animal(String ten){
        // khởi tạo giá trị bằng constructor thay getter, setter
        this.ten = ten;
    }
    public Animal(){

    }

    // Hanh vi
    public void an(){
        System.out.println(ten + " đang ăn " );
    }
    public void diLai(){
        System.out.println(ten + " đang đi đi bằng " + soChan + " chan");
    }

    // getter setter:
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        // kiểm tra tên có hợp lệ không

        // kiểm tra tên có bị null
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getMauLong() {
        return mauLong;
    }

    public void setMauLong(String mauLong) {
        this.mauLong = mauLong;
    }

    public int getSoChan() {
        return soChan;
    }

    public void setSoChan(int soChan) {
        this.soChan = soChan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
