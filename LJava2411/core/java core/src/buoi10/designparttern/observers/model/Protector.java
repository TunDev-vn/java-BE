package buoi10.designparttern.observers.model;


import buoi10.designparttern.observers.LoginStatus;
import buoi10.designparttern.observers.User;

public class Protector implements Observer{
    @Override
    public void update(User user) {
        System.out.println("Thực hiện bảo vệ tài khoản ");
        if (user.getStatus().equals(LoginStatus.EXPIRED) || user.getStatus().equals(LoginStatus.INVALID)){
            System.out.println("User status không hợp lệ");
        }else {
            System.out.println("User status login hợp lệ");
        }
    }
}
