package buoi8.baitap;

import java.util.*;
import java.util.stream.Collectors;

public class Company {

    private String tenCongTy;
    private String maSoThue;
    private Double doanhThuThang;

    private List<Employee> danhSachNhanVien = new ArrayList<>();

    public void nhapThongTinCongTy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên công ty: ");
        this.tenCongTy = scanner.nextLine();
        System.out.println("Nhập mã số thuế: ");
        this.maSoThue = scanner.nextLine();
        System.out.println("Nhập doanh thu tháng: ");
        this.doanhThuThang = scanner.nextDouble();
    }

    public void hienThiToanBoNhanVien(){
        System.out.println();
        System.out.println("=======Thông tin toàn bộ nhân viên trong công ty======");
        for(Employee employee : danhSachNhanVien){
            System.out.println("--------------------------");
            employee.hienThiThongTin();
            System.out.println("--------------------------");
        }
        System.out.println();
    }

    /**
     3.	Thêm, xóa thông tin một nhân sự
     o	Thêm: Cho phép thêm thông tin của một nhân viên mới hoặc trưởng phòng mới vào hệ thống.
     	Các thông tin cần nhập: Mã số nhân viên, họ tên, số điện thoại, số ngày làm việc, lương 1 ngày, chức vụ (giám đốc, trưởng phòng, nhân viên).
     */
    public void themNhaSu(){
        System.out.println("Thêm một nhân sự ");
        Employee employee = chonLoaiNhanVien();
        if (employee == null){
            return;
        }
        employee.nhapThongTin();
        danhSachNhanVien.add(employee);
    }

    public void tinhTongLuong(){
        System.out.println("Tính và hiển thị tổng lương của tất cả nhân viên công ty: ");
        double tong = 0;
        // duyệt toàn bộ danh sách nhân viên
        for (Employee employee : danhSachNhanVien){
            // tính tổng lương của từng nhân viên, và cộng lại
            System.out.println("Lương của nhân viên: " + employee.getMaMV() + " số ngày làm việc: " + employee.getSoNgayLamViec() + ", lương 1 ngày: " + employee.getLuongMotNgay() + " => tổng lương = " + employee.cachTinhLuongThang());
            /*
            ví java có tính đa hình, lên ở danhSachNhanVien nhân viên
            sẽ bao gồm cả staff, manager, director, mà mỗi
            class đều đã ghi đè lại hàm cachTinhLuongThang
            => khi runtime employee sẽ tự động được sử dụng
            cách tính lương tháng của các class đã ghi đè
             */
            tong+=employee.cachTinhLuongThang();
        }
        System.out.println("Tổng lương tháng của công ty là: " + tong);
    }
    /*
    Stream:
        là 1 kiểu dữ liệu liên tục, được phát triển từ java 8,
        khi sử dụng steam sẽ được thực hiện các thao tác với
        dữ liệu liên tục, có thể tạo ra được tập hợp các dữ liệu
        mới
     */
    public void tinhTongLuongC2(){
        double tong = this.danhSachNhanVien.stream() // biến array list thành kiểu dữ liệu stream
                .mapToDouble // biến list employee thành 1 list các số double bằng return
                        (employee -> {
            System.out.println("Lương của nhân viên: " + employee.getMaMV() + " số ngày làm việc: " + employee.getSoNgayLamViec() + " lương 1 ngày: " + employee.getLuongMotNgay() + " = " + employee.cachTinhLuongThang());
            return employee.cachTinhLuongThang();
        }).sum(); //  sử dụng hàm sum của stream để tính tổng tất cả các số
        System.out.println("Tổng lương tháng của công ty là: " + tong);
    }

    // c1
    public void timNhanVienCoLuongCaoNhat(){
        System.out.println("Duyệt danh sách nhân viên: ");
        double maxLuong = Double.MIN_VALUE;
        Employee employee = null;
        for (Employee e:danhSachNhanVien){
            // nếu không phải nhân viên thường => bỏ qua
            if (!(e instanceof Staff)){
                continue;
            }
            // nếu lương của nhân viên được duyệt > lương max hiện tại
            if (e.cachTinhLuongThang() > maxLuong){
                // gán data
                maxLuong = e.cachTinhLuongThang();
                employee = e;
            }
        }
        if (employee != null){
            System.out.println("Nhân viên có lương cao nhất là: ");
            employee.hienThiThongTin();
            return;
        }
        System.out.println("Không tìm thấy nhân viên");
    }

    /**
     c2: Sử dụng Stream, method referent
     Optional: là 1 class cung cấp sẵn các hàm để kiểm tra null hoặc tisnh tồn tại của object, thay cho việc
     phải sử dụng các biểu thực != null, === null....
     */
    public void timNhanVienCoLuongCaoNhatC2(){
        Optional<Employee> employeeOptional = danhSachNhanVien.stream() // biến danh sách thành Stream
                .max( // sử dụng hàm max để tìm ra phần tử có giá trị lớn nhất với điều kiện được tính bằng
                        Comparator.comparingDouble(Employee::cachTinhLuongThang) // sử dụng hàm cách tisnh lương để so sánh:
                        // sử dụng method referent thay cho lambda employee -> employee.cachTinhLuongThang()
                );
        if (employeeOptional.isPresent()){ // thay cho việc kiểm tra employeeOptional != null
            System.out.println("Nhân viên có lương cao nhất là: ");
            Employee employee = employeeOptional.get(); // lấy ra value object từ optional sử dụng hàm get
            employee.hienThiThongTin();
            return;
        }
        System.out.println("Không tìm thấy nhân viên");
    }

    /*
    c8: Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất
     */
    public void timTruongPhong(){
        System.out.println("Bắt đầu tìm trưởng phòng ");
        // duyệt danh sách nhân viên
        Manager managerTerm = null;
        List<Staff> staffTerm = null;
        Manager managerTarget = new Manager();
        managerTarget.setDanhSachNhanVien(new ArrayList<>());
        for (Employee employee : danhSachNhanVien){
            // nếu không phải trưởng phòng => bỏ qua
            if (!(employee instanceof Manager)){
                continue;
            }
            // nếu là trưởng phòng => tiếp tục xử lý
            managerTerm = (Manager) employee;
            // lấy danh sach nhân viên của quản lý đó
            staffTerm = managerTerm.getDanhSachNhanVien();
            // nếu danh sách nhân viên bằng null hoặc empty => bỏ qua
            if (staffTerm == null || staffTerm.isEmpty()){
                continue;
            }
            // nếu danh sách nhân viên > tổng số nhân viên đang kiểm tra
            if (staffTerm.size() > managerTarget.getDanhSachNhanVien().size()){
                // gán quản lý term đang kiểm tra cho quản lý đang cần tìm
                managerTarget = managerTerm;
            }
        }
        if (managerTarget.getMaMV() != null){
            System.out.println("Quản lý có số lượng nhân viên nhiều nhất: ");
            managerTarget.hienThiThongTin();
        }
    }

    /**
     9: Sắp xếp toàn bộ nhân viên trong công ty với thứ tự ABC
     */
    public void sapXepNhanVienTheoTen(){
        if (this.danhSachNhanVien == null || this.danhSachNhanVien.isEmpty()){
            System.out.println("Danh sách đang trống");
            return;
        }
        this.danhSachNhanVien
                .stream() // biến danh sách nhân viên thành stream
                .filter(data -> data != null && data.getHoTen() != null) // lọc bỏ những nhân viên bằng null hoặc nhập tên bằng null
                .sorted((employee1,employee2) -> employee1.getHoTen().compareTo(employee2.getHoTen())) // sắp xếp các nhân viên theo tên ABC
                .forEach(Employee::hienThiThongTin); // hiển thị từng phần tử trong danh sách nhân viên
    }

    /**
     10: Sắp xếp toàn bộ nhân viên trong công ty với lương giảm dần
     */
    public void sapXepNhanVienTheoLuongGiamDan() {
        if (this.danhSachNhanVien == null || this.danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sách đang trống");
            return;
        }

        this.danhSachNhanVien
                .stream() // biến danh sách nhân viên thành stream
                .filter(Objects::nonNull) // lọc bỏ những nhân viên null
                .sorted((employee1, employee2) -> {
                    // Lấy lương của nhân viên
                    Double luong1 = employee1.cachTinhLuongThang();
                    Double luong2 = employee2.cachTinhLuongThang();
                    // Sắp xếp lương giảm dần (lương cao hơn lên trước)
                    return Double.compare(luong2, luong1);
                })
                .forEach(Employee::hienThiThongTin); // hiển thị từng nhân viên
    }
    /*
    11: Tìm giám đốc có lượng cổ phiếu nhiều nhất
     */
    public void timGiamDoc(){
        if (this.danhSachNhanVien == null || this.danhSachNhanVien.isEmpty()){
            System.out.println("Danh sách đang trống");
            return;
        }
        Employee directorTarget = this.danhSachNhanVien
                .stream() // biến danh sách nhân viên thành stream
                .filter(employee -> { // duyệt từng nhân viên và lọc tìm ra giám đốc
                    if (!(employee instanceof Director)){ // nếu không phải giảm đốc => return false phần tử đó sẽ được loại bỏ
                        return false;
                    }
                    return true; // ngược lại return true => phần tử đó sẽ được giữ lại
                }).max(Comparator.comparing(data -> { // lọc các phần tử và tìm ra giám đóc có cổ phần cao nhất
                    Director director = (Director) data; // ép kiểu về giám đốc
                    return director.getCoPhan(); // trả về số lượng cổ phần, việc còn lại tự method max sẽ kiểm tra và trả về giám đóc có cổ phần lớn nhất
                })).orElse(null); // trường hợp xấu nhất không có nhân viên nào đáp ứng được điều kiện filter => trả về null
        // kiểm tra và hiển thị
        if (directorTarget != null){
            System.out.println("Giám đốc có cổ phần cao nhất: ");
            directorTarget.hienThiThongTin();
        }
    }
    /**
     12 : Hiển thị tổng thu nhập của từng giảm đốc
     */
    public void hienThiThuNhapGiamDoc(){
        if (this.danhSachNhanVien == null || this.danhSachNhanVien.isEmpty()){
            System.out.println("Danh sách đang trống");
            return;
        }
        this.danhSachNhanVien
                .stream() // biến danh sách nhân viên thành stream
                .filter(employee -> { // duyệt từng nhân viên và lọc tìm ra giám đốc
                    if (!(employee instanceof Director)){ // nếu không phải giảm đốc => return false phần tử đó sẽ được loại bỏ
                        return false;
                    }
                    return true; // ngược lại return true => phần tử đó sẽ được giữ lại
                }).forEach(employee -> {// duyệt và hiển thị thông tin từng giám đốc
                    Director director = (Director) employee; // ép kiểu về giáo đốc
                    System.out.println("Tổng thu nhập giám đốc: " + director.getHoTen() + " là: " + director.cachTinhLuongThang());
                });
    }

    private Employee chonLoaiNhanVien() {
        Employee employee = null;
        int luaChon= 0;
        System.out.println("Chọn chức vụ muốn thêm: ");
        System.out.println("1: Giám đốc");
        System.out.println("2: Quản lý");
        System.out.println("3: Nhân viên");
        System.out.println("4: Hủy");
        luaChon = nhapLuaChon();
        switch (luaChon){
            case 1:
                employee = new Director();
                break;
            case 2:
                employee = new Manager();
                break;
            case 3:
                employee = new Staff();
                break;
            case 4:
                System.out.println("Thoát");
                break;
            default:
                System.out.println("Không hợp lệ, đề nghị nhập lại");
                break;
        }
        return employee;
    }
    public static int nhapLuaChon(){
        try {
            int type = new Scanner(System.in).nextInt();
            return type;
        }catch (Exception e){
            System.out.println("Lỗi bạn đã nhập ký tự không phải số");
            return 1;
        }
    }

    /*
  o	Xóa: Cho phép xóa nhân viên hoặc trưởng phòng khỏi hệ thống.
     	Khi xóa trưởng phòng, cần phải ngắt liên kết giữa trưởng phòng đó và các nhân viên dưới quyền của họ.
     	Các nhân viên bị xóa trưởng phòng cần phải cập nhật lại thông tin trưởng phòng (có thể để là null nếu không có trưởng phòng).
     giải:
     b1) Nhập vào mã nhân viên muốn xóa:
     b2) Tìm nhân viên muốn xóa
     b3) nếu tìm thấy nhân viên cần xóa tiếp tục kiểm tra các trường hợp
          nếu
               == giám đốc => sử dụng hàm remove để xóa
               == nhân viên => sử dụng hàm remove để xóa
               == quản lý => trước khi xóa trường phòng
                            b1: Tìm hết danh sách nhân viên đang trực thuốc trưởng phòng đó
                            b2: Set toàn bộ thuộc tính trường phòng của nhân đo == null
                                sử dụng method: setTruongPhong(null)
                                => để giải phóng nhân viên đó khỏi trưởng phòng đã bị xóa
     */

    public void xoaNhanVien(){
        // b1 Nhập vào mã nhân viên muốn xóa:
        System.out.println("Nhập vào mã nhân viên: ");
        String maMvXoa = new Scanner(System.in).nextLine();
        // b2 tim kiem
        Employee employeeDelete = timKiemNhanVien(maMvXoa);
        if (employeeDelete == null){
            System.out.println("Không tìm thấy nhân viên với mã: " + maMvXoa);
            return;
        }
        // b3 xóa
        if (employeeDelete instanceof Director || employeeDelete instanceof Staff){
            this.danhSachNhanVien.remove(employeeDelete);
        }else if (employeeDelete instanceof Manager){
            xoaTruongPhongKhoiNhanVien(maMvXoa);
            // nếu là instanceof Manager => ép kiểu biến employeeDelete thành đối tượng kiểu Manager
            this.danhSachNhanVien.remove(employeeDelete);
        }
        System.out.println("Xóa nhân viên thành công");
    }

    /**
     2.	Phân bổ nhân viên vào trưởng phòng
     o	Cho phép nhập 1 mã nhân viên và mã trường phòng để thêm nhân viên đó vào cho trưởng phòng đó. Khi thêm sẽ update cả thông tin trưởng phòng quản lý cho nhân viên, và danh sách nhân viên của trưởng phòng
     o	Điều kiện: Mỗi nhân viên sẽ có 1 trưởng phòng quản lý (trừ giám đốc). Trưởng phòng sẽ quản lý một hoặc nhiều nhân viên.
     o	Cập nhật số lượng nhân viên dưới quyền cho trưởng phòng.
     giai:
        1) Phải biết đưa nhân viên nào ?, => yêu cầu nhập mã nhân viên
        2) Nhân viên đấy có tồn tại trong công ty không ? => kiểm tra xem có tồn tại nhân viên trong danhSachNhanVien không, nếu có => trả ra nhân viên
        3) Nhân viên đấy đã được đưa vào phòng nào chưa ? => kiểm tra thuộc tính truongPhong của nhân viên đấy có bằng null không, nếu == null => hợp lệ, ngược lại
        4) Đưa nhân viên đấy vào quản lý nào ? => yêu cầu nhập vào mã nhân viên của quản lý
        5) quản lý đấy có tồn tại trong hệ thống khôg ? => kiểm tra xem có tồn tại quản lý đó trong danhSachNhanVien không, nếu có => trả ra quản lý

        sau khi trả lơif được các câu hỏi này bắt đầu đưa nhân viên đó vào phòng
            b1) Thêm nhân viên đó vào danh sách nhân viên của quản lý bằng cách setQuanLy = quanLy đã tìm được ở trên
            b2) Thêm nhân viên đó vào trong danhSachNhanVien của quản lý
     */
    public void phanBoNhanVienVaoPhong(){
        System.out.println("Nhập vào mã nhân viên muốn đưa vào cho quản lý: ");
        String maNV = new Scanner(System.in).nextLine();
        // kiểm tra xem có tồn tại nhân viên trong danhSachNhanVien không, hoặc có tồn tại mã nhân viên đó, nhưng đó không phải là staff
        Employee employee = timKiemNhanVien(maNV);
        if (!(employee instanceof Staff)){
            System.out.println("Không tồn tại nhân viên với mã: " + maNV);
            return;
        }

        Staff staff = ((Staff) employee); // ép kiểu employee -> staff
        // Nhân viên đấy đã được đưa vào phòng nào chưa ?
        if (staff.getTruongPhong() != null){
            System.out.println("Nhân viên " + maNV + " đã được đưa vào cho quản lý " + staff.getTruongPhong().getMaMV());
            return;
        }
        System.out.println("Nhập vào mã nhân viên của quản lý: ");
        String maNVQuanLy = new Scanner(System.in).nextLine();
        Employee employeeManager = timKiemNhanVien(maNVQuanLy);
        // kiểm tra xem có tồn tại quản lý trong danhSachNhanVien không, hoặc có tồn tại mã nhân viên đó, nhưng đó không phải là quản lý
        if (!(employeeManager instanceof Manager)){
            System.out.println("Không tồn tại nhân viên với mã: " + maNV);
            return;
        }
        Manager manager = ((Manager) employeeManager);
        // Set quản lý cho nhân viên
        staff.setTruongPhong(manager);
        // Thêm nhân viên vào cho quản lý
        List<Staff> staffManager = manager.getDanhSachNhanVien();
        staffManager.add(staff);
    }

    private void xoaTruongPhongKhoiNhanVien(String maMvXoa) {
        // Lấy danh sách nhân viên trong manager, và set null director
        for (Employee employee: this.danhSachNhanVien){
            // Kiểm tra nếu không phải nhân viên => bỏ qua
            if (employee instanceof Director || employee instanceof Manager){
                continue;
            }
            // Nếu là nhân viên kiểm tra có thuộc về giám đốc không, ép kiểu về kiểu nhân viên
            Staff staff = ((Staff) employee);
            if (staff.getTruongPhong() != null && staff.getTruongPhong().getMaMV().equalsIgnoreCase(maMvXoa)){
                staff.setTruongPhong(null);
            }
        }
    }

    public Employee timKiemNhanVien(String maNV){
        for (Employee employee:this.danhSachNhanVien){
            if (maNV.equalsIgnoreCase(employee.getMaMV())){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<Employee> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public Double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(Double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }
}
