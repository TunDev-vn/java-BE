package buoi7.btvn.bai1;

import java.util.Objects;

public class Lion extends Animal {

    public void roar(){
        System.out.println("Lion is roaring");
    }

    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roaring.");
    }

    @Override
    public void action() {
        System.out.println("The lion is hunting.");
    }

    @Override
    public void showInfo() {
        System.out.println("Lion info: ");
        // gọi tới hàm show của cha
        super.showInfo();
    }

    @Override
    public void enterInfo() {
        System.out.println("Enter Lion info: ");
        super.enterInfo();
    }
}
