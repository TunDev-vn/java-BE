package buoi10.btvn;

import java.util.Objects;
import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private double point;

    public void enterInfo(){
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap id: ");
//        this.id = sc.nextLine();
        System.out.println("Nhap ten: ");
        this.name = sc.nextLine();
        System.out.println("Nhap diem: ");
        this.point = sc.nextDouble();
    }

    public void showInfo(){
        System.out.println(this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(point, student.point) == 0 &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }

    public Student() {
    }

    public Student(String id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
