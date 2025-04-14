package buoi9.demo1;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        // Set: chỉ chứa các phần tử duy nhất, không trùng nhau
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println("size: " + set.size());
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("Map: tập hợp các entry, moi entry có 2 thanh phan: key - value ");
        Map<Integer,String> mapIdName = new HashMap<Integer,String>(); //  tạo ra 1 map có key kiểu dữ liệu Integer, Value: kiểu dữ liệu String
        // Thêm phần tử vào map
        mapIdName.put(1,"Trung");
        mapIdName.put(2,"Tuan");
        mapIdName.put(3,"Cuong");
        mapIdName.put(4,"Minh");
        System.out.println("Truy cập phần tử của map, sử dụng key, vd: key = 1, value: " + mapIdName.get(1)); // Trung
        System.out.println("Lấy ra phần tử với key = 2, value = " + mapIdName.get(2)); // Tuan
        System.out.println("Duyệt map sử dụng entry: ");
        for (Map.Entry<Integer,String> entry : mapIdName.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        Map<Integer,String> mapHashTable = new Hashtable<>();
        /**
         Set<String>: generic
                tham số kiểu dữ liệu truyền vào
         */
//        Integer[] array = new Integer[10];
//        array[0] = 1;
//        array[1] = "a";
        Set<Integer> integers = new HashSet<>();
        ListDemo<Integer> integerListDemo = new ArrayListDemo<>();
        integerListDemo.add(1);
        integerListDemo.add(2);

        ListDemo<Integer> listDemo = new ArrayListDemo<>();
        listDemo.add(1);
        System.out.println("Lay ra phan tu: " + listDemo.get(0));

    }
}
