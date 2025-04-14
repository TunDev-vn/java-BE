package buoi10.designparttern.observers.model;


import buoi10.designparttern.observers.User;

public class Mailer implements Observer{
    @Override
    public void update(User user) {
        System.out.println("Gửi email tới user thông báo đã đăng nhập: " + user.getEmail());
    }
}
