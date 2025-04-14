package buoi7.btvn.bai1;

public class Elephant extends Animal{

    public void trumpet(){
        System.out.println("Elephant is trumpeting");
    }

    @Override
    public void eat() {
        System.out.println("Elephant is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting.");
    }

    @Override
    public void showInfo() {
        System.out.println("Elephant info: ");
        super.showInfo();
    }

    @Override
    public void action() {
        System.out.println("The elephant is spraying water.");
    }

    @Override
    public void enterInfo() {
        System.out.println("Enter Elephant info: ");
        // gọi tới hàm nhập thông tin của lớp cha
        super.enterInfo();
    }
}
