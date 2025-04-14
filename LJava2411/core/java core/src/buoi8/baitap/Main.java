package buoi8.baitap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        int type = 0;
        do {
            System.out.println("Nhập các chức năng: ");
            System.out.println("1: Nhap thong tin cong ty");
            System.out.println("2: Phân bổ nhân viên vào trưởng phòng");
            System.out.println("3: Thêm, một nhân sự");
            System.out.println("4: xóa thông tin mot nhat su");
            System.out.println("5: Hien thi danh sach nhan vien");
            System.out.println("6: Tính và xuất tổng lương cho toàn bộ công ty");
            System.out.println("7: Tìm nhân viên thường có lương cao nhất");
            System.out.println("8: Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
            System.out.println("9: Sắp xếp toàn bộ nhân viên trong công ty với thứ tự ABC");
            System.out.println("10: Sắp xếp toàn bộ nhân viên trong công ty với lương giảm dần");
            System.out.println("11 : Tìm giám đốc có lượng cổ phiếu nhiều nhất");
            System.out.println("12 : Hiển thị tổng thu nhập của từng giảm đốc");
            System.out.println("13: Thoat");
            type = getType();
            switch (type) {
                case 1:
                    company.nhapThongTinCongTy();
                    break;
                case 2:
                    company.phanBoNhanVienVaoPhong();
                    break;
                case 3:
                    company.themNhaSu();
                    break;
                case 4:
                    company.xoaNhanVien();
                    break;
                case 5:
                    company.hienThiToanBoNhanVien();
                    break;
                case 6:
                    company.tinhTongLuong();
                    break;
                case 7:
                    company.timNhanVienCoLuongCaoNhat();
                    break;
                case 8:
                    company.timTruongPhong();
                    break;
                case 9:
                    company.sapXepNhanVienTheoTen();
                    break;
                case 10:
                    company.sapXepNhanVienTheoLuongGiamDan();
                    break;
                case 11:
                    company.timGiamDoc();
                    break;
                case 12:
                    company.hienThiThuNhapGiamDoc();
                    break;
                case 13:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Bạn nhập chức năng không đúng, đề nghị nhập lại");
                    type = 1;
            }
        }while (type != 13);
    }

    public static int getType(){
        try {
            int type = new Scanner(System.in).nextInt();
            return type;
        }catch (Exception e){
            System.out.println("Lỗi bạn đã nhập ký tự không phải số");
            return 1;
        }
    }
}
