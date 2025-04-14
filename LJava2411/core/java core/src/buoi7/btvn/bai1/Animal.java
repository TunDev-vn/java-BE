package buoi7.btvn.bai1;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;

    public abstract void eat();

    public abstract void makeSound();
    public void run(){
        System.out.println("Animal running");
    }

    public int run(String ten){
        System.out.println(ten + " is running");
        return 0;
    }

    public int run(String ten1,String ten2){
        return 0;
    }

    public void showInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

    public abstract void action();

    public void enterInfo(){
        System.out.println("Name: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Age: ");
        this.age = new Scanner(System.in).nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
