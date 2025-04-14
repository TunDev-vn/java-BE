package buoi7;

import buoi7.btvn.bai1.Animal;
import buoi7.btvn.bai1.Lion;
import buoi7.demo2.IManagerAnimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        // c1: Sử dụng lambda
        integers = integers.stream().filter(data -> data % 2 == 0).collect(Collectors.toList());
        // C2 sử dụng anonymous class
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        integers.stream().filter(predicate).collect(Collectors.toList());
        // c1
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        // c2
        Collections.sort(integers, (o1,o2) -> o2 - o1);
    }
}
