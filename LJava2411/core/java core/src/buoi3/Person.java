package buoi3;

public class Person {
    public int tuoi;

    public static void main(String[] args) {
        Person cuong = new Person();
        cuong.tuoi = 1;
        thayDoiTuoi(cuong);
        System.out.println(cuong.tuoi); // 11

        Person cuong2 = new Person();
        cuong2.tuoi = 1;
        thayDoiTuoi2(cuong2);
        System.out.println(cuong2.tuoi); // 1
    }

    public static void thayDoiTuoi(Person cuongCopy){
        cuongCopy.tuoi = cuongCopy.tuoi + 10;
    }
    public static void thayDoiTuoi2(Person cuong2Copy){
        cuong2Copy = new Person();
        cuong2Copy.tuoi = cuong2Copy.tuoi + 10;
    }
}
