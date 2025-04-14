package buoi7.demo;

public class Demo2 {
    public static void main(String[] args) {
        // Tạo đối tượng Dog và Cat
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        // Gọi phương thức sound() cho từng đối tượng
        myDog.sound();  // Output: Woof!
        myCat.sound();  // Output: Meow!
    }
}
// Định nghĩa Interface Animal
interface Animal {
    // Phương thức trừu tượng (không có thân hàm)
    // Mỗi loài động vật sẽ tạo ra âm thanh khác nhau
    void sound();
}

// Lớp Dog triển khai interface Animal
class Dog implements Animal {
    // bắt buộc cung cấp triển khai cho phương thức sound()
    public void sound() {
        System.out.println("Woof!");
    }
}

// Lớp Cat triển khai interface Animal
class Cat implements Animal {
    // bắt buộc cung cấp triển khai cho phương thức sound()
    public void sound() {
        System.out.println("Meow!");
    }
}



