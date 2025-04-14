package buoi9;

//import java.util.ArrayList;
//import java.util.List;

import buoi8.baitap.Employee;

import java.io.InterruptedIOException;
import java.util.Scanner;

/**
 Exception:
    các lỗi có thể sảy ra làm dán đoạn hoặc dừng chương trình, hoặc
    làm cho chương trình chạy sai khi phát triển chương gình java

 các lọai lỗi:
    + lỗi trong thời gian compile time: -> gọi là lỗi checked exception
        vd:
            sai syntax, thiếu thư viện...
    + lỗi trong thời điểm runtime: -> lỗi unchecked exception
        + lỗi sảy ra trong quá trình chương tình đã chạy
        vd: nullpoiter, chia cho 0, truy cập phần tử vượt quá index mảng, code sai logic
    + lỗi hệ thống -> gọi chung error
        lỗi jvm, lỗi máy ảo jvm
        stack overflow: lỗi do khai báo nhiều biến khiên quá tải vùng nhớ stack
        over heap: khai báo quá nhiều object quá tải vùng nhớ heap

 -------------------------------------------------------------------------------
* Cách sử lý exception:
    - try - catch
        cú pháp :
            try {
                // code logic devloper dự đoán có thể sảy ra lỗi
            } catch (ClassException e){
                // ClassException: class lỗi nằm trong cây tổ chứuc của các exception
                // code xử lý nếu thật sự có lỗi sảy ra
            }
    - finally
        cú pháp:
             try {
                 // code logic devloper dự đoán có thể sảy ra lỗi
             } catch (ClassException e){
                 // ClassException: class lỗi nằm trong cây tổ chứuc của các exception
                 // code xử lý nếu thật sự có lỗi sảy ra
             }finally {
                // khối lệnh bắt buộc phải đi vào dù có sảy ra exception hay không
            }
    - throw:
        cú pháp : throw new Tên class exception("message lỗi")
        định nghĩa: được sử dụng để chủ động ném ra 1 exception nếu nhà phát triển muốn
 vd: hàm nhapVaoSo()
    - throws:
        + cú pháp
            void methodName() throws ExceptionClassName {
                // logic xử lý của thân hàm
            }
        + định nghĩa:
            - được sử dụng trong phần khai báo của phương thúc, theo sau là tên class của các ngoại
            lệ có thể được bắn ra trong phương thức
            - mục đích:
                + dùng trong khai báo của phương thức, để chỉ ra rằng phương thứuc có thể ném ra một hoặc nhiều ngoại lệ (exception)
                + việc sử dụg throws không ném ra ngoại lệ, mà chỉ thông báo cho người sử dụng method đấy biết rằng
                sẽ có các ngoại lệ nào có thể sảy ra
        vd: method nhapVaoSo2
 * Các Tự tạo ra exception của riêng mình:
    + b1) tạo class đặt tên và có đuôi Exception
        vd: CustomValidateException
    + b2) cho kế thừa các loại class exception, để biến nó thành 1 exception
        vd: public class CustomValidateException extends Exception
        lưu ý:
            nếu kế thừa từ Exception => class đó sẽ là checked exception, tức là phải xử lý tại thời điểm compile time
            nếu kế thừa từ class RuntimeException => class đó là unchecked exception, tức là phải xử lý tại
                thời điểm run time
    + b3) Ghi đè lại các method, constructor có tham số, hoặc không tham số phù hợp với nghiệp vụ muốn tạo ra
        vd:
            ghi đè lại hàm getMessage, Constructor....
 vd: hàm nhapVaoSo3() và class CustomValidateException

 */
public class Main {

    public static void main(String[] args) {
        // code khi chưa xử lý lỗi
/*
        Employee employee = null;
        System.out.println(employee.getMaMV()); // có thể sảy ra lỗi NullPointerException
    */
        // code sau khi được xử lý lỗi sử dụng try catch, bắt đúng class lỗi nullpointer
        /*
        try {
            Employee employee = null;
            System.out.println(employee.getMaMV()); // có thể sảy ra lỗi NullPointerException
        }catch (NullPointerException e){
            System.out.println(" Đã sảy ra lỗi null pointer");
        }
        */
        // code sau khi được xử lý lỗi không bắt đúng lỗi của class => việc bắt lỗi trở lên vô nghĩa
        /*
        try {
            Employee employee = null;
            System.out.println(employee.getMaMV()); // có thể sảy ra lỗi NullPointerException
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(" Đã sảy ra lỗi null pointer");
        }
        */
        // code sau khi được xử lý lỗi sử dụng try catch, thay vì bắt đúng lỗi NullPointerException
        // nhưng sử dụng class của lớp cha vd: RuntimeException hoặc class ông : Exception hoặc to hơn nữa cũng được
        try {
            Employee employee = null;
            System.out.println(employee.getMaMV()); // sảy ra lỗi NullPointerException
        }catch (Exception e){
            System.out.println(" Đã sảy ra lỗi null pointer");
        }finally {
            System.out.println("Khối finally bắt buộc phải đi vào");
        }
        System.out.println("Đã chạy xong chương trình");
        System.out.println("Test throw");
        int n =0;
        try {
            n = nhapVaoSo(); // có thể bắn ra RuntimeException nếu nhập vào < 10
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Số nhập vào: " + n);
        System.out.println("Test throws");
        try {
            nhapVaoSo2(); // bắt buộc phải xử lý lỗi InterruptedIOException ở đây, vì method đã khai báo throws InterruptedIOException
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Test tự tạo ra exception: ");
        int n3 = 0;
        try {
             n3 = nhapVaoSo3();
        }catch (CustomValidateException e){
            System.out.println(e.getMessage());
        }
        System.out.println(n3);
    }

    public static int nhapVaoSo(){
        System.out.println("Nhập vào số < 10");
        int n = new Scanner(System.in).nextInt();
        if (n >= 10){
            // chủ động bắn ra RuntimeException
            throw new RuntimeException(" đã sảy ra lỗi Số nhập vào phải nhỏ hơn 10");
        }
        return n;
    };

    public static int nhapVaoSo2() throws InterruptedIOException{ // throws InterruptedIOException: khai báo rằng hàm này có thể bắn ra lỗi RuntimeException
        // cho người sử dụng hàm này chủ động nắm được
        System.out.println("Nhập vào số < 10");
        int n = new Scanner(System.in).nextInt();
        if (n >= 10){
            // chủ động bắn ra RuntimeException
            throw new InterruptedIOException("throws đã sảy ra lỗi Số nhập vào phải nhỏ hơn 10");
        }
        return n;
    }
    // // throws CustomValidateException: khai báo rằng hàm này có thể bắn ra lỗi CustomValidateException
    public static int nhapVaoSo3() throws CustomValidateException{
        // cho người sử dụng hàm này chủ động nắm được
        System.out.println("Nhập vào số < 10");
        int n = new Scanner(System.in).nextInt();
        if (n >= 10){
            // chủ động bắn ra RuntimeException
            throw new CustomValidateException("throws đã sảy ra lỗi Số nhập vào phải nhỏ hơn 10");
        }
        return n;
    }
}
