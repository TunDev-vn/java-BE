package buoi7.demo4;

public class Main {
    public static void main(String[] args) {
        // c1: Tạo đối tượng thông qua class implements interface
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(1,2));;
        // c2: Tạo dối tượng thông qua class vô danh (Anonymous class)
        Calculator calculator1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(calculator1.add(1,2));
        // c3: sử dụng lambda expression
        /**
         Cú pháp (param..) -> body
         param: có thể có 1 hoặc nhiều hoặc không có param
         body: có thể là 1 khối lệnh hoặc là 1 câu lệnh
         */
        Calculator calculator2 = (a,b) -> a + b;
        System.out.println(calculator2.add(1,2));

    }
}
