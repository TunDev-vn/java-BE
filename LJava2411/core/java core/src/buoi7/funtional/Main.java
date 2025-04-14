package buoi7.funtional;
@FunctionalInterface
interface Calculator{
    // Phương thức trìu tượng duy nhất
    int add(int a,int b);
    /**
     các phương thức default và static
     là hợp lệ trong functional interface
     */
    default int subtract(int a,int b){
        return a-b;
    }
    static int multiply(int a,int b){
        return a*b;
    }
}

/**
 như bình thường với cac interface khác
 sẽ có một class con triển khai interface
 */
class CalculatorImpl implements Calculator{
    // triển khai method abstract
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
public class Main {
    public static void main(String[] args) {
        // cách 1 sử dụng class được đính nghĩa thông thường
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(1,2));
        // cách 2 sử dụng anonymous classes
        Calculator calculator2 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(calculator2.add(1,2));
        // Cách 3 sử dụng Lambda Expression
        Calculator calculator3 = (a,b) -> a + b;
        System.out.println(calculator3.add(1,2));
    }
}
