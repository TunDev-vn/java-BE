package buoi10.designparttern.observers;


import buoi10.designparttern.observers.model.Logger;
import buoi10.designparttern.observers.model.Mailer;
import buoi10.designparttern.observers.model.Protector;

public class Client {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        // add các observer vào theo giõi thay đổi của account
        accountService.attach(new Logger());
        accountService.attach(new Mailer());
        accountService.attach(new Protector());

        System.out.println("Đề nghị login: ");
        accountService.login();
        System.out.println("Thay đổi trạng thái: ");
        accountService.changeStatus();
    }
}
