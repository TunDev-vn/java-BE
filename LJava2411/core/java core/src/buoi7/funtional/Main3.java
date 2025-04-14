package buoi7.funtional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        // Mục tiêu chỉ in ra các số chẵn trong list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //c1 áp dụng anonymous class triển khai functional interface
        Predicate<Integer> predicateFilter = new Predicate<Integer>() {
            @Override
            public boolean test(Integer data) {
                return data % 2 == 0;
            }
        };
        System.out.println("áp dụng anonymous class triển khai functional interface ");
        numbers.stream().filter(predicateFilter).forEach(n -> System.out.print(n + " "));
        //c2 áp dụng lambda để lọc các số chẵn và in ra
        System.out.println();
        System.out.println("áp dụng lamda để lọc các số chẵn và in ra ");
        numbers.stream()
                .filter(n -> n % 2 == 0)  // áp dụng lambda Chỉ lấy số chẵn thay cho anonymous class
                .forEach(n -> System.out.print(n + " "));  // In ra mỗi số chẵn
    }
}
