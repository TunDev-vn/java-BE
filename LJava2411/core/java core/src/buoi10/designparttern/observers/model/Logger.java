package buoi10.designparttern.observers.model;


import buoi10.designparttern.observers.User;

public class Logger implements Observer{
    @Override
    public void update(User user) {
        System.out.println("Ghi log user với thông tin: " + user.toString());
    }
}
