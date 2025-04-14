package buoi7.funtional;
import java.util.Random;
@FunctionalInterface
interface StringConcatenate {
    String autoGenerateOTP();
}
public class Main2 {
    public static void main(String[] args) {
        // Lambda expression để triển khai phương thức tự động tạo ra OTP
        StringConcatenate concat = () -> {
            Random random = new Random();
            return String.valueOf(random.nextInt(10000));  // Tạo OTP ngẫu nhiên trong phạm vi 0-9999
        };
        // Gọi phương thức autoGenerateOTP() và in kết quả
        System.out.println(concat.autoGenerateOTP());  // Output: Ví dụ: 6575
    }
}
