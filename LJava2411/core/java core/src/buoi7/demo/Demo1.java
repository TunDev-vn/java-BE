package buoi7.demo;

public class Demo1 {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        shape1.draw();  // Output: Drawing a circle.

        Shape shape2 = new Rectangle();
        shape2.draw();  // Output: Drawing a rectangle.
    }
}
// Giao diện Shape với phương thức trừu tượng
interface Shape {
    void draw();
}
// Lớp con Circle triển khai giao diện Shape
class Circle implements Shape {
    // Cung cấp chi tiết triển khai cho phương thức draw()
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}
// Lớp con Rectangle triển khai giao diện Shape
class Rectangle implements Shape {
    // Cung cấp chi tiết triển khai cho phương thức draw()
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

