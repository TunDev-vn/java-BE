package buoi9;

// tạo ra 1 exception
public class CustomValidateException extends Exception{

    public CustomValidateException(){
        super("Sảy ra lỗi input nhập vào không hợp lệ"); // truyền message vào lớp cha, để hiển thị khi sảy ra lỗi
    }
    public CustomValidateException(String message){ // cho phép truyền message từ ngoài vào
        super(message);
    }

    @Override
    public String getMessage() {
        System.out.println("Đây là class CustomValidateException");
        return super.getMessage();
    }
}
