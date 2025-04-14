package buoi5.btvn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 Mô tả bài toán:
 Bạn sẽ xây dựng một chương trình Java có thể thực hiện các tác vụ phức tạp sau:
 1. Nhập một mảng các số nguyên.
 2. Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.
 3. Tìm và in ra các số nguyên tố có trong mảng.
 4. Sắp xếp mảng sao cho:
     o Các phần tử chẵn được sắp xếp theo thứ tự giảm dần.
     o Các phần tử lẻ được sắp xếp theo thứ tự tăng dần.
 5. Chia mảng thành 2 mảng con:
     o Mảng 1: Chứa tất cả các phần tử có giá trị nhỏ hơn hoặc bằng trung bình của mảng.
     o Mảng 2: Chứa tất cả các phần tử có giá trị lớn hơn trung bình của mảng.
 6. Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.
 7. Thêm một phần tử vào mảng:
     o Cho phép người dùng thêm một phần tử vào mảng tại vị trí chỉ định (index).
     o Nếu mảng đã đầy, tự động mở rộng mảng.
 8. Xoá một phần tử khỏi mảng:
    o Cho phép người dùng nhập vào một giá trị phần tử và xoá phần tử đó trong mảng.
 Yêu cầu:
 1. Nhập mảng: Bạn sẽ nhập một mảng các số nguyên từ bàn phím.
 2. Tìm số nguyên tố: Viết một hàm để kiểm tra xem một số có phải là số nguyên tố hay không, sau đó tìm và in ra tất cả các số nguyên tố trong mảng.
 3. Chia mảng thành hai mảng con:
     o Tính trung bình của mảng.
     o Duyệt qua các phần tử và chia chúng thành 2 mảng con: một mảng chứa các phần tử nhỏ hơn hoặc bằng trung bình, mảng còn lại chứa các phần tử lớn hơn trung bình.
 4. Thêm phần tử vào mảng: Bạn cần thêm một phần tử vào mảng tại chỉ định index. Nếu mảng đã đầy, mở rộng mảng tự động.
 5. Xoá phần tử khỏi mảng: Xoá một phần tử trong mảng nếu phần tử đó tồn tại.
 */
public class Bai3 {
// 5362
    public static int soLuongPhanTu = 0;
    public static int giaTriMoRongMacDinh = 10;
    public static void main(String[] args) {

//        int[] array = nhapThongTinMang();
        int[] array = {7,4,3,8,1,4,3};
        soLuongPhanTu = array.length;
        hienThi(array);

        boolean tiepTuc = true;
        do {
            System.out.println("\nNhap vao cac chuc nang muon su dung: ");
            System.out.println("2. Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.");
            System.out.println("3. Tìm và in ra các số nguyên tố có trong mảng.");
            System.out.println("4. Sắp xếp mảng");
            System.out.println("5. Chia mảng thành 2 mảng con");
            System.out.println("6. Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.");
            System.out.println("7. Thêm một phần tử vào mảng:");
            System.out.println("8. Xoá một phần tử khỏi mảng:");
            System.out.println("9. Thoat! ");
            int luaChon = new Scanner(System.in).nextInt();
            switch (luaChon){
                case 2:
                    tinhTong(array);
                    break;
                case 3:
                    hienThiCacSoNguyenTo(array);
                    break;
                case 4:
                    sapXepMang(array);
                    break;
                case 5:
                    System.out.println("Tinh nang chua phat trien");
                    break;
                case 6:
                    inPhanTuTrungLap(array);
                    break;
                case 7:
                    themPhanTu(array);
                    break;
                case 8:
                    xoaPhanTu(array);
                    break;
                case 9:
                    System.out.println("Thoat chuong trinh");
                    tiepTuc = false;
            }
        }while (tiepTuc);
    }

    public static void xoaPhanTu(int[] arr){
        System.out.println("Nhập vào phần tử muốn xóa: ");
        int data = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (arr[i] == data){
                for (int j = i; j < soLuongPhanTu ; j++) {
                    if (j != soLuongPhanTu - 1){
                        arr[j] = arr[j + 1];
                    }
                }
                soLuongPhanTu--;
            }

        }

        hienThi(arr);
    }
    public static void themPhanTu(int[] arr){
        System.out.println("Nhap vao vi tri muon thêm bắt đầu từ 1 : ");
        int index = new Scanner(System.in).nextInt();
        index = index - 1;
        System.out.println("Nhập vào dữ liệu muốn thêm: ");
        int data = new Scanner(System.in).nextInt();
        
        if (index >= arr.length){
            System.out.println("index khong hop le, index cần nhỏ hơn:  " + arr.length);
            return;
        }
        // số lượng phần tử của mảng vẫn đáp ứng
        if (soLuongPhanTu >= arr.length){
            // sốluowuowjng phần tử của mảng không đáp ứng
            int[] arrayCopy = arr;
            // mở rộng mảng
            arr = new int[arr.length + giaTriMoRongMacDinh];
            // copy dữ liệu mảng cũ sang mảng mới
            for (int i = 0; i < soLuongPhanTu; i++) {
                arr[i] = arrayCopy[i];
            }
        }
        // thêm phần tử
        themPhanTuVaoIndex(arr, index,data);
        hienThi(arr);
    }

    private static void themPhanTuVaoIndex(int[] arr, int index,int data) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
        soLuongPhanTu++;
    }

    public static void inPhanTuTrungLap(int []array) {
/*
        int []d = new int[soLuongPhanTu]; // 0 0 0 0 0 0 0
        for(int i = 0; i < soLuongPhanTu; i++){
            int ptu = array[i]; // 7 4 3 8 1
            d[i] = 1;
        }
        for(int i = 0; i < soLuongPhanTu; i++){
            int ptu = array[i]; // 7 4 3 8 1
            if(d[ptu]>=2){
                System.out.println("Số " + ptu + " lặp lại : " + d[ptu] + " lần");
                d[ptu] = 0;
            }
        }
  */
        System.out.println("Cac phan tu trùng lặp la: ");
        for(int i = 0; i < soLuongPhanTu; i++){
            int ptu = array[i];
            // kiem tra từ index = 0 cho đến index i. Xem phần tu đã được kiểm tra chưa
            boolean phanTuDaDuocKiemTra = false;
            for (int j = 0; j < i; j++) {
                if (array[j] == ptu){
                    phanTuDaDuocKiemTra = true;
                }
            }
            // neu phan tu da duoc kiem tra => bo qua
            if (phanTuDaDuocKiemTra){
                continue;
            }
            // đếm số lượng phần tử từ i cho đến cuối mảng
            int count = 0;
            for (int j = i; j < soLuongPhanTu ; j++) {
                if (array[j] != ptu){
                    continue;
                }
                count++;
            }
            // hiển thị
            if (count >= 2){
                System.out.print(ptu + " ");
            }
        }
    }

    public static void sapXepMang(int[] array){
        for (int i = 0; i < soLuongPhanTu; i++) {
            // sap xep cac so chan
            if (array[i] % 2 == 0){
                for (int j = i + 1; j < soLuongPhanTu; j++) {
                    // kiem tra neu cac so đằng sau là số chẵn và lớn hơn số hiện tại arr[i] => đổi chỗ
                    if (array[j] % 2 != 0 || array[i] > array[j]){
                        continue;
                    }
                    int term = array[i];
                    array[i] = array[j];
                    array[j] = term;
                }
            }else {
                for (int j = i + 1; j < soLuongPhanTu; j++) {
                    if (array[j] % 2 == 0 || array[i] < array[j]){
                        continue;
                    }
                    int term = array[i];
                    array[i] = array[j];
                    array[j] = term;
                }
            }
        }
        hienThi(array);
    }
    public static void hienThiCacSoNguyenTo(int[] arr){
        System.out.println("Danh sach so nguyen to: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (!laSoNguyenTo(arr[i]))
                continue;

            System.out.println(arr[i] + " ");
        }
    }
    public static void hienThi(int[] arr){
        System.out.println(" \n- Danh sach cac phan tu cua mang: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            System.out.print(arr[i] +  " ");
        }
    }
    public static boolean laSoNguyenTo(int data){
        if (data == 1){
            return false;
        }
        for (int i = 2; i < Math.sqrt(data); i++) {
            if (data % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void tinhTong(int[] arr){
        int tongChan = 0;
        int tongLe = 0;
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (arr[i] % 2 == 0){
                tongChan +=arr[i];
                continue;
            }
            tongLe +=arr[i];
        }
        System.out.println("Tong chan: " + tongChan);
        System.out.println("Tong le: " + tongLe);
    }
    public static int[] nhapThongTinMang(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so luong pha tu cua mang: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap vao phan tu mang thu: " + (i + 1));
            array[i] = scanner.nextInt();
            soLuongPhanTu++;
        }
        return array;
    }
}
