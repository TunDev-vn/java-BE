package buoi7.btvn.bai1;

public class Monkey extends Animal{
    @Override
    public void eat() {
        System.out.println("Monkey is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering.");
    }

    @Override
    public void action() {
        System.out.println("The monkey is climbing trees.");
    }

    @Override
    public void showInfo() {
        System.out.println("Monkey info: ");
        // gọi tới hàm show của cha
        super.showInfo();
    }

    @Override
    public void enterInfo() {
        System.out.println("Enter Monkey info: ");
        super.enterInfo();
    }
}
